package cn.leafpeach.liteapp.app.websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

public class IclClient extends WebSocketClient {
    private static String excptMessage;

    //构造方法
    public IclClient(URI serverUri) {
        super(serverUri);
        excptMessage = null;
    }

    //连接建立成功时调用该方法
    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("[websocket]连接成功!");
    }

    //收到来自服务端的消息时调用该方法
    @Override
    public void onMessage(String s) {
        try {
            fileWriterMethod("Files\\data\\icl.json",s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fileWriterMethod(String path,String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.append(content);
        }
    }

    //连接关闭时调用该方法
    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("[WebSocket]连接已关闭!");
        WebSocketTask.start();
    }

    //出现错误时调用该方法
    @Override
    public void onError(Exception e) {
        System.out.println("[WebSocket]连接出现错误!");
    }

    //获取接收到的信息
    public static String getExcptMessage() {
        if(excptMessage != null){
            return excptMessage;
        }
        return null;
    }
}
