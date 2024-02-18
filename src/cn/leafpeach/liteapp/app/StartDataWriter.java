package cn.leafpeach.liteapp.app;

import cn.leafpeach.liteapp.utils.AppUtils;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StartDataWriter {

    // 写入初始数据的方法
    public static void write() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID", AppUtils.getJmaID());
            BufferedWriter bufferedWriter1;
            try {
                bufferedWriter1 = new BufferedWriter(new FileWriter("Files\\EEW.json"));
                bufferedWriter1.write(jsonObject.toString());
                bufferedWriter1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("ID", AppUtils.getIclID());
            BufferedWriter bufferedWriter;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter("Files\\start.json"));
                bufferedWriter.write(jsonObject2.toString());
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject3 = new JSONObject();
            jsonObject3.put("ID", AppUtils.getSCID());
            BufferedWriter bufferedWriter2;
            try {
                bufferedWriter2 = new BufferedWriter(new FileWriter("Files\\sc.json"));
                bufferedWriter2.write(jsonObject3.toString());
                bufferedWriter2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject4 = new JSONObject();
            jsonObject4.put("ID", AppUtils.getFJID());
            BufferedWriter bufferedWriter3;
            try {
                bufferedWriter3 = new BufferedWriter(new FileWriter("Files\\fj.json"));
                bufferedWriter3.write(jsonObject4.toString());
                bufferedWriter3.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
