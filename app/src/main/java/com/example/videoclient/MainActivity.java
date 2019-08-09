package com.example.videoclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraX;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.VideoCaptureConfig;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.Manifest;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

@SuppressLint("RestrictedApi")
public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE_PERMISSIONS = 10;
    private static final String TAG = "VideoClient";
    private long updateCount = 0;

    private String[] REQUIRED_PERMISSIONS = new String[] {Manifest.permission.CAMERA};

    private VideoCapture videoCapture;
    private TextView output;

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
        VideoCaptureConfig videoCaptureConfig = new VideoCaptureConfig.Builder().build();
        videoCapture = new VideoCapture(videoCaptureConfig);
        CameraX.bindToLifecycle((LifecycleOwner) this, videoCapture);
    }

    /** Take videos and upload them periodically. */
    private Runnable periodicCaptureUpload = new Runnable() {
        @Override
        public void run() {
            if (videoCapture == null) {
                Log.e(TAG, "Video Capture not started");
            } else {
                File file = new File(getExternalMediaDirs()[0], updateCount + ".mp4");
                videoCapture.startRecording(file, new VideoCapture.OnVideoSavedListener() {
                            @Override
                            public void onVideoSaved(File file) {
                                output.setText("Starting Upload");

                                output.setText("Upload Finished");
                                updateCount++;
                            }

                            @Override
                            public void onError(VideoCapture.UseCaseError useCaseError, String message, @Nullable Throwable cause) {
                                String msg = "Video capture failed: " + message;
                                output.setText(msg);
                                Log.e(TAG, msg);
                                if (cause != null) {
                                    cause.printStackTrace();
                                }
                            }
                        }
                );
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);

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
