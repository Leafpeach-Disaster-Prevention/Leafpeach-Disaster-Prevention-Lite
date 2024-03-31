package cn.leafpeach.liteapp.app;

import cn.leafpeach.liteapp.utils.AppUtils;
import cn.leafpeach.liteapp.utils.HttpUtils;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    public static void write() {
        try {
            String httpGet = HttpUtils.sendGet(AppUtils.getCencUrl());
            String httpGet2 = HttpUtils.sendGet(AppUtils.getJmaUrl());
            String httpGet3 = HttpUtils.sendGet(AppUtils.JmaEEWUrl);
            String httpGet4 = HttpUtils.sendGet(AppUtils.IclUrl);
            String httpGet5 = HttpUtils.sendGet(AppUtils.scUrl);
            String httpGet6 = HttpUtils.sendGet(AppUtils.fjUrl);
            String httpGet7 = HttpUtils.sendGet(AppUtils.CencUrl1);
            fileWriterMethod(httpGet,"Files\\data\\cenc.json");
            fileWriterMethod(httpGet2,"Files\\data\\jma.json");
            fileWriterMethod(httpGet3,"Files\\data\\jma_eew.json");
            fileWriterMethod(httpGet4,"Files\\data\\icl.json");
            fileWriterMethod(httpGet5,"Files\\data\\sceew.json");
            fileWriterMethod(httpGet6,"Files\\data\\fjeew.json");
            fileWriterMethod(httpGet7,"Files\\data\\cenc_1.json");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "程序启动失败,可能是api接口出现故障或您的网络问题,请确保您可以正常访问https://api.wolfx.jp \n" + e, "启动失败", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private static void fileWriterMethod(String content,String path) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.append(content);
        }
    }
}
