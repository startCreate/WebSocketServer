package com.app.vv_voronov.websocketserver;

import android.app.Application;

import com.app.vv_voronov.websocketserver.Server.MessageEvent;
import com.app.vv_voronov.websocketserver.Server.SetupServer;
import com.app.vv_voronov.websocketserver.Server.WebServer;

import java.net.InetSocketAddress;
import de.greenrobot.event.EventBus;

/**
 * Created by vv_voronov on 20.04.2017.
 */

public class MultipleServer extends Application {
    private static final int FIRST_SERVER_PORT = 56001;

    private WebServer server;

    @Override
    public void onCreate() {
        super.onCreate();

        for (int i = 0; i<48;i++)
        new Thread(new SetupServer(FIRST_SERVER_PORT+i)).start();
    }


}
