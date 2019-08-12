package com.example.videoclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraX;
import androidx.camera.core.Preview;
import androidx.camera.core.PreviewConfig;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.VideoCaptureConfig;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.Manifest;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.protobuf.ByteString;
import com.tinder.scarlet.Scarlet;
import com.tinder.scarlet.Stream;
import com.tinder.scarlet.WebSocket;
import com.tinder.scarlet.messageadapter.protobuf.ProtobufMessageAdapter;
import com.tinder.scarlet.websocket.okhttp.OkHttpClientUtils;
import com.tinder.scarlet.lifecycle.android.AndroidLifecycle;

import java.io.File;
import java.nio.file.Files;

import okhttp3.OkHttpClient;

@SuppressLint("RestrictedApi")
public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE_PERMISSIONS = 10;
    private static final String TAG = "VideoClient";
    private long updateCount = 0;

    private String[] REQUIRED_PERMISSIONS = new String[] {Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO};

    private VideoCapture videoCapture;
    private boolean setup = false;
    private TextView output;
    private WebSocketInterface webSocketInterface;

    // Background threads based on
    // https://github.com/googlesamples/android-Camera2Basic/blob/master/Application/src/main/java/com/example/android/camera2basic/Camera2BasicFragment.java#L652
    /**
     * Thread for running tasks that shouldn't block the UI.
     */
    private HandlerThread backgroundThread;

    /**
     * A {@link Handler} for running tasks in the background.
     */
    private Handler backgroundHandler;

    /**
     * Starts a background thread and its {@link Handler}.
     */
    private void startBackgroundThread() {
        backgroundThread = new HandlerThread("VideoCapture");
        backgroundThread.start();
        backgroundHandler = new Handler(backgroundThread.getLooper());
        backgroundHandler.post(periodicCaptureUpload);
    }

    /**
     * Stops the background thread and its {@link Handler}.
     */
    private void stopBackgroundThread() {
        backgroundThread.quitSafely();
        try {
            backgroundThread.join();
            backgroundThread = null;
            backgroundHandler = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void startCamera() {
        // We get an error if we try to record a video without a preview
        // This preview just discards updates
        PreviewConfig previewConfig = new PreviewConfig.Builder().build();
        Preview preview = new Preview(previewConfig);
        preview.setOnPreviewOutputUpdateListener(output -> { /* No-op */ });

        VideoCaptureConfig videoCaptureConfig = new VideoCaptureConfig.Builder()
                .build();
        videoCapture = new VideoCapture(videoCaptureConfig);
        CameraX.bindToLifecycle(MainActivity.this, preview, videoCapture);
        setup = true;
    }

    /** Take videos and upload them periodically. */
    private Runnable periodicCaptureUpload = new Runnable() {
        @Override
        public void run() {
            if (!setup) {
                Log.e(TAG, "Video Capture not started");
                backgroundHandler.postDelayed(periodicCaptureUpload, 100);
            } else {
                File file = new File(getExternalMediaDirs()[0], updateCount + ".mp4");
                videoCapture.startRecording(file, new VideoCapture.OnVideoSavedListener() {
                            @Override
                            public void onVideoSaved(File file) {
                                updateOutputText("Starting Upload");
                                try {
                                    byte[] fileContent = Files.readAllBytes(file.toPath());
                                    VideoClientProtos.Update.Builder updateBuilder = VideoClientProtos.Update.newBuilder();
                                    updateBuilder.setUpdateId(Long.toString(updateCount));
                                    updateBuilder.setFilename(file.toPath().toString());
                                    updateBuilder.setVideo(ByteString.copyFrom(fileContent));
                                    VideoClientProtos.Update update = updateBuilder.build();

                                    webSocketInterface.Send(update);

                                    updateOutputText("Upload finished");

                                    updateCount++;
                                    backgroundHandler.postDelayed(periodicCaptureUpload, 30000);
                                } catch(java.io.IOException e) {
                                    Log.e(TAG, "Exception reading video file", e);
                                    updateOutputText("Could not read video file");
                                }
                            }

                            @Override
                            public void onError(VideoCapture.UseCaseError useCaseError, String message, @Nullable Throwable cause) {
                                String msg = "Video capture failed: " + message;
                                updateOutputText(msg);
                                Log.e(TAG, msg);
                                if (cause != null) {
                                    cause.printStackTrace();
                                }
                            }
                        }
                );
                try {
                    updateOutputText("Recording video");
                    Thread.sleep(2000);
                    videoCapture.stopRecording();
                } catch(java.lang.InterruptedException e) {
                    Log.e(TAG, "Exception waiting for video", e);
                    updateOutputText("Could not wait for video");
                }
            }
        }
    };

    private void updateOutputText(final String text) {
        runOnUiThread(() -> output.setText(text));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);

        OkHttpClient okClient = new OkHttpClient();
        webSocketInterface = new Scarlet.Builder()
                .webSocketFactory(OkHttpClientUtils.newWebSocketFactory(okClient, "ws://gs17934.sp.cs.cmu.edu:8765"))
                .addMessageAdapterFactory(new ProtobufMessageAdapter.Factory())
                .lifecycle(AndroidLifecycle.ofApplicationForeground(getApplication()))
                .build().create(WebSocketInterface.class);
        webSocketInterface.observeWebSocketEvent().start(new Stream.Observer<WebSocket.Event>() {
            @Override
            public void onNext(WebSocket.Event receivedUpdate) {
                Log.d(TAG, "Event " + receivedUpdate);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d(TAG, "event onError");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "event onComplete");

            }
        });

        // Request camera permissions
        if (allPermissionsGranted()) {
            startCamera();
        } else {
            ActivityCompat.requestPermissions(
                    this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        startBackgroundThread();
    }

    @Override
    public void onPause() {
        stopBackgroundThread();
        super.onPause();
    }

    /**
     * Process result from permission request dialog box, has the request
     * been granted? If yes, start Camera. Otherwise display a toast
     */
    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera();
            } else {
                Toast.makeText(this,
                        "Permissions not granted by the user.",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private boolean allPermissionsGranted() {
        for (String permission : REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(getBaseContext(), permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
