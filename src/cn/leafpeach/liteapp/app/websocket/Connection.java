package cn.leafpeach.liteapp.app.websocket;

import org.java_websocket.WebSocket;

import java.net.URI;

public class Connection {
    public static WSClient client;
    public static LPClient lpClient;

    public static void connect() {
        try {
            client = new WSClient(new URI("wss://ws-api.wolfx.jp/all_eew"));
            client.connect();
            while (!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
                Thread.sleep(1000);
            }
            while (WSClient.getExcptMessage() == null) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void IclConnect() {
        try {
            lpClient = new LPClient(new URI(""));
            lpClient.connect();
            while (!lpClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
                Thread.sleep(1000);
            }
            while (LPClient.getExcptMessage() == null) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
