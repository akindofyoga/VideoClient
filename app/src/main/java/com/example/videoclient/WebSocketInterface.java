package com.example.videoclient;

import com.tinder.scarlet.Stream;
import com.tinder.scarlet.WebSocket;
import com.tinder.scarlet.ws.Receive;
import com.tinder.scarlet.ws.Send;

import com.example.videoclient.VideoClientProtos.Update;

public interface WebSocketInterface {
    @Send
    void Send(Update update);

    @Receive
    Stream<WebSocket.Event> observeWebSocketEvent();
}
