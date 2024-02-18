package cn.leafpeach.liteapp.app.websocket;

import org.java_websocket.WebSocket;

import java.net.URI;

public class Connection {
    public static WSClient client;
    public static IclClient iclClient;

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
            iclClient = new IclClient(new URI("ws://49.232.181.118:49133"));
            iclClient.connect();
            while (!iclClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
                Thread.sleep(1000);
            }
            while (IclClient.getExcptMessage() == null) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
