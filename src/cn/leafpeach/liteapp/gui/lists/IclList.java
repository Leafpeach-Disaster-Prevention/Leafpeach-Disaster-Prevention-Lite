package cn.leafpeach.liteapp.gui.lists;

import cn.leafpeach.liteapp.gui.QCMainWindow;
import cn.leafpeach.liteapp.utils.AppUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class IclList {
    public static TimerTask timerTask;
    static Timer timer = new Timer();
    static File file = new File("Files\\data\\icl.json");

    // 加载列表
    public static void load() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                String data;
                try {
                    data = FileUtils.readFileToString(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JSONObject jsonObject = JSON.parseObject(data);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONObject json0 = jsonArray.getJSONObject(0);
                JSONObject json1 = jsonArray.getJSONObject(1);
                JSONObject json2 = jsonArray.getJSONObject(2);
                JSONObject json3 = jsonArray.getJSONObject(3);
                JSONObject json4 = jsonArray.getJSONObject(4);
                JSONObject json5 = jsonArray.getJSONObject(5);
                JSONObject json6 = jsonArray.getJSONObject(6);
                String startAt = json0.getString("startAt");
                Long time = Long.parseLong(startAt);
                String date0 = AppUtils.format.format(time);
                String startAt1 = json1.getString("startAt");
                Long time1 = Long.parseLong(startAt1);
                String date1 = AppUtils.format.format(time1);
                String startAt2 = json2.getString("startAt");
                Long time2 = Long.parseLong(startAt2);
                String date2 = AppUtils.format.format(time2);
                String startAt3 = json3.getString("startAt");
                Long time3 = Long.parseLong(startAt3);
                String date3 = AppUtils.format.format(time3);
                String startAt4= json4.getString("startAt");
                Long time4 = Long.parseLong(startAt4);
                String date4 = AppUtils.format.format(time4);
                String startAt5 = json5.getString("startAt");
                Long time5 = Long.parseLong(startAt5);
                String date5 = AppUtils.format.format(time5);
                String startAt6 = json6.getString("startAt");
                Long time6 = Long.parseLong(startAt6);
                String date6 = AppUtils.format.format(time6);

                // icl 1
                QCMainWindow.jLabel.setText(AppUtils.decimalFormat.format(json0.getDouble("magnitude")) + "级  " + json0.getString("epicenter"));
                try {
                    QCMainWindow.jLabel1.setText(AppUtils.getFeel(0));
                    String feel1 = AppUtils.getFeel(0);
                    switch (feel1) {
                        case "当前位置无震感" -> QCMainWindow.intColor.setBackground(Color.gray);
                        case "当前位置可能有震感" -> QCMainWindow.intColor.setBackground(Color.blue);
                        case "当前位置高楼层有感" -> QCMainWindow.intColor.setBackground(Color.yellow);
                        case "当前位置震感较强" -> QCMainWindow.intColor.setBackground(new Color(190, 113, 14, 255));
                        case "当前位置震感强烈" -> QCMainWindow.intColor.setBackground(new Color(225, 7, 7, 255));
                        case "当前位置震感极强" -> QCMainWindow.intColor.setBackground(new Color(128, 7, 28, 255));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                QCMainWindow.jLabel2.setText("发震时刻: " + date0);

                // icl 2
                QCMainWindow.jLabel3.setText(AppUtils.decimalFormat.format(json1.getDouble("magnitude")) + "级  " + json1.getString("epicenter"));
                try {
                    QCMainWindow.jLabel4.setText(AppUtils.getFeel(1));
                    String feel1 = AppUtils.getFeel(1);
                    switch (feel1) {
                        case "当前位置无震感" -> QCMainWindow.intColor1.setBackground(Color.gray);
                        case "当前位置可能有震感" -> QCMainWindow.intColor1.setBackground(Color.blue);
                        case "当前位置高楼层有感" -> QCMainWindow.intColor1.setBackground(Color.yellow);
                        case "当前位置震感较强" -> QCMainWindow.intColor1.setBackground(new Color(190,113,14,255));
                        case "当前位置震感强烈" -> QCMainWindow.intColor1.setBackground(new Color(225, 7, 7, 255));
                        case "当前位置震感极强" -> QCMainWindow.intColor1.setBackground(new Color(128, 7, 28, 255));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                QCMainWindow.jLabel5.setText("发震时刻: " + date1);

                // icl 3
                QCMainWindow.jLabel6.setText(AppUtils.decimalFormat.format(json2.getDouble("magnitude")) + "级  " + json2.getString("epicenter"));
                try {
                    QCMainWindow.jLabel7.setText(AppUtils.getFeel(2));
                    String feel1 = AppUtils.getFeel(2);
                    switch (feel1) {
                        case "当前位置无震感" -> QCMainWindow.intColor2.setBackground(Color.gray);
                        case "当前位置可能有震感" -> QCMainWindow.intColor2.setBackground(Color.blue);
                        case "当前位置高楼层有感" -> QCMainWindow.intColor2.setBackground(Color.yellow);
                        case "当前位置震感较强" -> QCMainWindow.intColor2.setBackground(new Color(190, 113, 14, 255));
                        case "当前位置震感强烈" -> QCMainWindow.intColor2.setBackground(new Color(225, 7, 7, 255));
                        case "当前位置震感极强" -> QCMainWindow.intColor2.setBackground(new Color(128, 7, 28, 255));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                QCMainWindow.jLabel8.setText("发震时刻: " + date2);

                // icl 4
                QCMainWindow.jLabel9.setText(AppUtils.decimalFormat.format(json3.getDouble("magnitude")) + "级  " + json3.getString("epicenter"));
                try {
                    QCMainWindow.jLabel10.setText(AppUtils.getFeel(3));
                    String feel1 = AppUtils.getFeel(3);
                    switch (feel1) {
                        case "当前位置无震感" -> QCMainWindow.intColor3.setBackground(Color.gray);
                        case "当前位置可能有震感" -> QCMainWindow.intColor3.setBackground(Color.blue);
                        case "当前位置高楼层有感" -> QCMainWindow.intColor3.setBackground(Color.yellow);
                        case "当前位置震感较强" -> QCMainWindow.intColor3.setBackground(new Color(190, 113, 14, 255));
                        case "当前位置震感强烈" -> QCMainWindow.intColor3.setBackground(new Color(225, 7, 7, 255));
                        case "当前位置震感极强" -> QCMainWindow.intColor3.setBackground(new Color(128, 7, 28, 255));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                QCMainWindow.jLabel11.setText("发震时刻: " + date3);

                // icl 5
                QCMainWindow.jLabel12.setText(AppUtils.decimalFormat.format(json4.getDouble("magnitude")) + "级  " + json4.getString("epicenter"));
                try {
                    QCMainWindow.jLabel13.setText(AppUtils.getFeel(4));
                    String feel1 = AppUtils.getFeel(4);
                    switch (feel1) {
                        case "当前位置无震感" -> QCMainWindow.intColor4.setBackground(Color.gray);
                        case "当前位置可能有震感" -> QCMainWindow.intColor4.setBackground(Color.blue);
                        case "当前位置高楼层有感" -> QCMainWindow.intColor4.setBackground(Color.yellow);
                        case "当前位置震感较强" -> QCMainWindow.intColor4.setBackground(new Color(190, 113, 14, 255));
                        case "当前位置震感强烈" -> QCMainWindow.intColor4.setBackground(new Color(225, 7, 7, 255));
                        case "当前位置震感极强" -> QCMainWindow.intColor4.setBackground(new Color(128, 7, 28, 255));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                QCMainWindow.jLabel14.setText("发震时刻: " + date4);

                // icl 6
                QCMainWindow.jLabel15.setText(AppUtils.decimalFormat.format(json5.getDouble("magnitude")) + "级  " + json5.getString("epicenter"));
                try {
                    QCMainWindow.jLabel16.setText(AppUtils.getFeel(5));
                    String feel1 = AppUtils.getFeel(5);
                    switch (feel1) {
                        case "当前位置无震感" -> QCMainWindow.intColor5.setBackground(Color.gray);
                        case "当前位置可能有震感" -> QCMainWindow.intColor5.setBackground(Color.blue);
                        case "当前位置高楼层有感" -> QCMainWindow.intColor5.setBackground(Color.yellow);
                        case "当前位置震感较强" -> QCMainWindow.intColor5.setBackground(new Color(190, 113, 14, 255));
                        case "当前位置震感强烈" -> QCMainWindow.intColor5.setBackground(new Color(225, 7, 7, 255));
                        case "当前位置震感极强" -> QCMainWindow.intColor5.setBackground(new Color(128, 7, 28, 255));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                QCMainWindow.jLabel17.setText("发震时刻: " + date5);

                // icl 7
                QCMainWindow.jLabel18.setText(AppUtils.decimalFormat.format(json6.getDouble("magnitude")) + "级  " + json6.getString("epicenter"));
                try {
                    QCMainWindow.jLabel19.setText(AppUtils.getFeel(6));
                    String feel1 = AppUtils.getFeel(6);
                    switch (feel1) {
                        case "当前位置无震感" -> QCMainWindow.intColor6.setBackground(Color.gray);
                        case "当前位置可能有震感" -> QCMainWindow.intColor6.setBackground(Color.blue);
                        case "当前位置高楼层有感" -> QCMainWindow.intColor6.setBackground(Color.yellow);
                        case "当前位置震感较强" -> QCMainWindow.intColor6.setBackground(new Color(227, 109, 21, 255));
                        case "当前位置震感强烈" -> QCMainWindow.intColor6.setBackground(new Color(225, 7, 7, 255));
                        case "当前位置震感极强" -> QCMainWindow.intColor6.setBackground(new Color(128, 7, 28, 255));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                QCMainWindow.jLabel20.setText("发震时刻: " + date6);
            }
        };
        timer.schedule(timerTask,0L,3000L);
    }
}
