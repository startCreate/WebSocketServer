package com.app.vv_voronov.websocketserver.Server;



import org.java_websocket.WebSocket;
import org.java_websocket.framing.FrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;

import java.net.InetSocketAddress;
import java.util.Timer;
import java.util.TimerTask;


import de.greenrobot.event.EventBus;



/**
 * Created by vv_voronov on 20.04.2017.
 */

public class SetupServer implements Runnable {

    private WebServer server;
    private WebSocket socket;


    public SetupServer(int port) {
        server = new WebServer(new InetSocketAddress(port));
        Timer timer = new Timer();
        timer.schedule(new MyTimer(),0,2000);
        socket = server.getSocket();

    }


    @SuppressWarnings("UnusedDeclaration")
    public void onEvent(MessageEvent event) {
        String message = event.getMessage();
        server.sendMessage("echo: " + message);
    }

    @Override
    public void run() {
        server.start();
        EventBus.getDefault().register(this);
    }
    public class MyTimer extends TimerTask{
        @Override
        public void run() {
            while (socket!=null)
            server.sendPing(socket);
        }
    }
}
