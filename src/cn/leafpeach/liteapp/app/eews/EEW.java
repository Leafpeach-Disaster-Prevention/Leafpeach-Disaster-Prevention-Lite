package cn.leafpeach.liteapp.app.eews;

import cn.leafpeach.liteapp.app.AppTray;
import cn.leafpeach.liteapp.utils.AppUtils;
import cn.leafpeach.liteapp.utils.DistanceUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class EEW {
    private static String EventID = null;
    private static String scID = null;
    private static String fjID = null;
    static TimerTask timerTask;
    static File file = new File("Files\\data\\jma_eew.json");
    static File file1 = new File("Files\\data\\sceew.json");
    static File file2 = new File("Files\\data\\fjeew.json");

    public EEW() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                String data;
                String data1;
                String data2;
                String data3;
                String data4;
                String data5;
                try {
                    data = FileUtils.readFileToString(AppUtils.EEWFile);
                    data1 = FileUtils.readFileToString(file);
                    data2 = FileUtils.readFileToString(AppUtils.scFile);
                    data3 = FileUtils.readFileToString(file1);
                    data4 = FileUtils.readFileToString(AppUtils.fjFile);
                    data5 = FileUtils.readFileToString(file2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JSONObject jsonObject = JSON.parseObject(data);
                JSONObject jsonObject1 = JSON.parseObject(data1);
                String isFinal;
                if (jsonObject1.getBoolean("isFinal")) {
                    isFinal = "最終";
                } else {
                    isFinal = "";
                }
                if (!Objects.equals(jsonObject1.getString("EventID"),jsonObject.getString("ID"))) {
                    if (!Objects.equals(jsonObject1.getString("EventID") + jsonObject1.getString("Serial"),EventID)) {
                        AppTray.showMessage(jsonObject1.getString("Title"),jsonObject1.getString("Hypocenter") + "で地震発生\n" + isFinal + "第" + jsonObject1.getString("Serial") + "報 予想最大震度" + jsonObject1.getString("MaxIntensity") + "\n" + "M" + jsonObject1.getString("Magunitude") + " 深さ " + jsonObject1.getString("Depth") + "Km");
                        EventID = jsonObject1.getString("EventID") + jsonObject1.getString("Serial");
                    }
                }
                JSONObject jsonObject2 = JSON.parseObject(data2);
                JSONObject jsonObject3 = JSON.parseObject(data3);
                if (!Objects.equals(jsonObject3.getString("EventID"),jsonObject2.getString("ID"))) {
                    if (!Objects.equals(jsonObject3.getString("EventID") + jsonObject3.getString("ReportNum"),scID)) {
                        try {
                            double time = DistanceUtil.getTime(Double.parseDouble(AppUtils.getUserLng()),Double.parseDouble(AppUtils.getUserLat()),jsonObject3.getDouble("Longitude"),jsonObject3.getDouble("Latitude"));
                            AppTray.showMessage("四川省地震局地震预警(第" + jsonObject3.getString("ReportNum") + "报)\n","发震时刻: " + jsonObject3.getString("OriginTime") + "\n震中: " + jsonObject3.getString("HypoCenter") + "\n震级: M" + jsonObject3.getString("Magunitude") + "\n震源深度: 10Km(推测)" + "\n地震横波预计" + time + "秒后抵达");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        scID = jsonObject3.getString("EventID") + jsonObject3.getString("ReportNum");
                    }
                }
                JSONObject jsonObject4 = JSON.parseObject(data4);
                JSONObject jsonObject5 = JSON.parseObject(data5);
                if (!Objects.equals(jsonObject5.getString("EventID"),jsonObject4.getString("ID"))) {
                    if (!Objects.equals(jsonObject5.getString("EventID") + jsonObject5.getString("ReportNum"),fjID)) {
                        try {
                            double time = DistanceUtil.getTime(Double.parseDouble(AppUtils.getUserLng()),Double.parseDouble(AppUtils.getUserLat()),jsonObject5.getDouble("Longitude"),jsonObject5.getDouble("Latitude"));
                            AppTray.showMessage("福建省地震局地震预警(第" + jsonObject5.getString("ReportNum") + "报)\n","发震时刻: " + jsonObject5.getString("OriginTime") + "\n震中: " + jsonObject5.getString("HypoCenter") + "\n震级: M" + jsonObject5.getString("Magunitude") + "\n震源深度: 原报文未提供" + "\n地震横波预计" + time + "秒后抵达");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        fjID = jsonObject5.getString("EventID") + jsonObject5.getString("ReportNum");
                    }
                }
            }
        };
        new Timer().schedule(timerTask,0L,1000L);
    }
}
