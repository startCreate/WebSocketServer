package com.app.vv_voronov.websocketserver.Server;

import java.net.InetSocketAddress;

import de.greenrobot.event.EventBus;

/**
 * Created by vv_voronov on 20.04.2017.
 */

public class SetupServer implements Runnable {

    private WebServer server;

    public SetupServer(int port) {
        server = new WebServer(new InetSocketAddress(port));

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
}
