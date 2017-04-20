package com.app.vv_voronov.websocketserver.Server;

/**
 * Created by vv_voronov on 20.04.2017.
 */

public class MessageEvent {
    private String message;

    public String getMessage() {
        return message;
    }

    public MessageEvent(String message) {

        this.message = message;
    }
}
