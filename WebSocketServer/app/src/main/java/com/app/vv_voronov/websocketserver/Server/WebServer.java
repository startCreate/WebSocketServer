package com.app.vv_voronov.websocketserver.Server;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

import de.greenrobot.event.EventBus;

/**
 * Created by vv_voronov on 20.04.2017.
 */

public class WebServer extends WebSocketServer {

    private WebSocket socket;

    public WebServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        socket = conn;

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        EventBus.getDefault().post(new MessageEvent(message));

    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }



     public void sendMessage(String message) {
        socket.send(message);
    }

}
