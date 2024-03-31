package cn.leafpeach.liteapp.app.eews;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.leafpeach.liteapp.app.AppTray;
import cn.leafpeach.liteapp.gui.EQWarningWindow;
import cn.leafpeach.liteapp.utils.AppUtils;
import cn.leafpeach.liteapp.utils.SoundUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class ICLEEW {
    private static String EventID = null;
    static TimerTask timerTask;
    static File file = new File("Files\\data\\icl.json");

    public ICLEEW() {
        SoundUtil soundUtil = new SoundUtil();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                String data;
                String data1;
                String data2;
                try {
                    data = FileUtils.readFileToString(AppUtils.startFile);
                    data1 = FileUtils.readFileToString(file);
                    data2 = FileUtils.readFileToString(AppUtils.intFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    JSONObject jsonObject = JSON.parseObject(data);
                    JSONObject jsonObject1 = JSON.parseObject(data1);
                    JSONObject jsonObject2 = JSON.parseObject(data2);
                    JSONArray jsonArray = jsonObject1.getJSONArray("data");
                    JSONObject json = jsonArray.getJSONObject(0);
                    String startAt = json.getString("startAt");
                    Long time = Long.parseLong(startAt);
                    String date = AppUtils.format.format(time);
                    double userInt = jsonObject2.getDouble("Int");
                    double Int;
                    try {
                        Int = AppUtils.getLocal(0);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    double max = AppUtils.calcMaxInt(json.getDouble("magnitude"), json.getDouble("depth"));
                    EQWarningWindow.jLabel1.setText(json.getString("epicenter") + "    M" + AppUtils.decimalFormat.format(json.getDouble("magnitude")));
                    EQWarningWindow.jLabel2.setText(date + " 发生");
                    if (Int < 0) {
                        EQWarningWindow.jLabel4.setText("本地预估烈度: 0.0度");
                    } else {
                        if (Int > max) {
                            EQWarningWindow.jLabel4.setText("本地预估烈度: " + AppUtils.decimalFormat.format(max) + "度");
                        } else {
                            EQWarningWindow.jLabel4.setText("本地预估烈度: " + AppUtils.decimalFormat.format(Int) + "度");
                        }
                    }
                    try {
                        EQWarningWindow.jLabel5.setText(AppUtils.getFeel(0));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Date date1 = DateUtil.parse(date);
                    Date date2 = DateUtil.parse(AppUtils.getTime());
                    long a = DateUtil.between(date1,date2, DateUnit.MINUTE);
                    if (!Objects.equals(json.getString("eventId"), jsonObject.getString("ID"))) {
                        if (!Objects.equals(json.getString("eventId"), EventID)) {
                            if (Int > userInt) {
                                if (a < 10) {
                                    AppTray.showMessage("地震预警发布", "现正发生有感地震,沉着冷静,迅速避险。远离悬挂物,不乘坐电梯,选择就近安全地点避险。");
                                    soundUtil.playSound("sounds\\First.wav");
                                    new EQWarningWindow().display();
                                    AppUtils.countDown();
                                }
                            }
                            EventID = json.getString("eventId");
                        }
                    }
                } catch (Exception e) {
                    reload();
                }
            }
        };
        new Timer().schedule(timerTask,0L,1000L);
    }

    public static void test() {
        // 显示测试预警窗口
        AppTray.showMessage("地震预警发布", "现正发生有感地震,沉着冷静,迅速避险。远离悬挂物,不乘坐电梯,选择就近安全地点避险。");
        new EQWarningWindow().display();
        AppUtils.countDownTest();
    }

    public static void reload() {
        timerTask.run();
    }
}
