package cn.leafpeach.liteapp.app.websocket;

import cn.leafpeach.liteapp.utils.AppUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.IOException;
import java.net.URI;

public class LPClient extends WebSocketClient {
    private static String excptMessage;

    //构造方法
    public LPClient(URI serverUri) {
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
        if (jsonObject.getString("type").equals("icl_eew")) {
            try {
                AppUtils.fileWriterMethod("Files\\data\\icl.json",s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (jsonObject.getString("type").equals("cenc")) {
            try {
                AppUtils.fileWriterMethod("Files\\data\\cenc_1.json",s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //连接关闭时调用该方法
    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("[WebSocket]连接已关闭!");
        Connection.IclConnect();
    }

    //出现错误时调用该方法
    @Override
    public void onError(Exception e) {
        System.out.println("[WebSocket]连接出现错误!" + e);
    }

    //获取接收到的信息
    public static String getExcptMessage() {
        if(excptMessage != null){
            return excptMessage;
        }
        return null;
    }
}
