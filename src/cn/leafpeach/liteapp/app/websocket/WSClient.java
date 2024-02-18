package cn.leafpeach.liteapp.app.websocket;

import cn.leafpeach.liteapp.utils.AppUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

public class WSClient extends WebSocketClient {
    private static String excptMessage;

    //构造方法
    public WSClient(URI serverUri) {
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
        JSONObject jsonObject = JSON.parseObject(s);
        if (!jsonObject.getString("type").equals("heartbeat")) {
            if (jsonObject.getString("type").equals("cenc_eqlist")) {
                System.out.println("[WebSocket][" + AppUtils.getTime() + "] 数据更新!");
                try {
                    fileWriterMethod("Files\\data\\cenc.json", s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (jsonObject.getString("type").equals("jma_eqlist")) {
                System.out.println("[WebSocket][" + AppUtils.getTime() + "] 数据更新!");
                try {
                    fileWriterMethod("Files\\data\\jma.json", s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (jsonObject.getString("type").equals("jma_eew")) {
                System.out.println("[WebSocket][" + AppUtils.getTime() + "] 数据更新!");
                try {
                    fileWriterMethod("Files\\data\\jma_eew.json", s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (jsonObject.getString("type").equals("sc_eew")) {
                System.out.println("[WebSocket][" + AppUtils.getTime() + "] 数据更新!");
                try {
                    fileWriterMethod("Files\\data\\sceew.json", s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (jsonObject.getString("type").equals("fj_eew")) {
                System.out.println("[WebSocket][" + AppUtils.getTime() + "] 数据更新!");
                try {
                    fileWriterMethod("Files\\data\\fjeew.json", s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
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
