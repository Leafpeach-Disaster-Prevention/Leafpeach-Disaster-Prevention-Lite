package cn.leafpeach.liteapp.utils;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.leafpeach.liteapp.gui.EQWarningWindow;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class AppUtils {
    static String CencUrl = "https://api.wolfx.jp/cenc_eqlist.json";
    public static String IclUrl = "http://api.leafpeach.cn/data/icl/data.json";
    public static String CencUrl1 = "http://api.leafpeach.cn/data/cenc/data.json";
    public static String RD3C0Url = "https://api.wolfx.jp/NM_EEDS_00.json";
    public static String RED68Url = "https://api.wolfx.jp/CQ_BEB_00.json";
    public static String JmaEEWUrl = "https://api.wolfx.jp/jma_eew.json";
    public static String scUrl = "https://api.wolfx.jp/sc_eew.json";
    public static String fjUrl = "https://api.wolfx.jp/fj_eew.json";
    static String JmaUrl = "https://api.wolfx.jp/jma_eqlist.json";
    static String versionUrl = "http://api.leafpeach.cn/data/liteapp/version.json";
    public static File startFile = new File("Files\\start.json");
    public static File tipsFile = new File("Files\\tips.json");
    public static File scFile = new File("Files\\sc.json");
    public static File fjFile = new File("Files\\fj.json");
    public static File EEWFile = new File("Files\\EEW.json");
    public static File intFile = new File("Files\\int.json");
    public static DecimalFormat decimalFormat = new DecimalFormat("0.0");
    public static SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

    public static String getCencUrl() {
        return CencUrl;
    }

    public static String getJmaUrl() {
        return JmaUrl;
    }

    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(calendar.getTime());
    }

    public static String getVersionUrl() {
        return versionUrl;
    }

    public static String getUserLat() throws IOException {
        File file = new File("Files\\settings.json");
        String data = FileUtils.readFileToString(file);
        JSONObject jsonObject = JSON.parseObject(data);
        return jsonObject.getString("Lat");
    }

    public static String getUserLng() throws IOException {
        File file = new File("Files\\settings.json");
        String data = FileUtils.readFileToString(file);
        JSONObject jsonObject = JSON.parseObject(data);
        return jsonObject.getString("Lng");
    }

    public static String getFeel(int index) throws IOException {
        String httpGet = HttpUtils.sendGet(IclUrl);
        JSONObject jsonObject = JSON.parseObject(httpGet);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONObject json = jsonArray.getJSONObject(index);
        double epicenterLat = json.getDouble("latitude");
        double epicenterLng = json.getDouble("longitude");
        double userLat = Double.parseDouble(getUserLat());
        double userlng = Double.parseDouble(getUserLng());
        String distance = decimalFormat.format(DistanceUtil.getDistance(userlng, userLat, epicenterLng, epicenterLat));
        double local = 1.92 + 1.63 * json.getDouble("magnitude") - 3.49 * Math.log10(Double.parseDouble(distance));
        String feel = "";
        if (local < 1) {
            feel = "当前位置无震感";
        }
        if (local >= 1 && local < 2) {
            feel = "当前位置可能有震感";
        }
        if (local >= 2 && local < 3) {
            feel = "当前位置高楼层有感";
        }
        if (local >= 3 && local < 4) {
            feel = "当前位置震感较强";
        }
        if (local >= 4 && local < 5) {
            feel = "当前位置震感强烈";
        }
        if (local >= 5) {
            feel = "当前位置震感极强";
        }
        return feel;
    }

    public static double getLocal(int index) throws IOException {
        String httpGet = HttpUtils.sendGet(IclUrl);
        JSONObject jsonObject = JSON.parseObject(httpGet);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONObject json = jsonArray.getJSONObject(index);
        double epicenterLat = json.getDouble("latitude");
        double epicenterLng = json.getDouble("longitude");
        double userLat = Double.parseDouble(getUserLat());
        double userlng = Double.parseDouble(getUserLng());
        String distance = decimalFormat.format(DistanceUtil.getDistance(userlng, userLat, epicenterLng, epicenterLat));
        return 1.92 + 1.63 * json.getDouble("magnitude") - 3.49 * Math.log10(Double.parseDouble(distance));
    }

    public static double calcMaxInt(double magnitude, double depth) {
        double a = 1.65 * magnitude;
        double b = depth < 10 ? 1.21 * Math.log10(10) : 1.21 * Math.log10(depth);
        return a / b;
    }

    public static String getIclID() {
        try {
            String httpGet = HttpUtils.sendGet(IclUrl);
            JSONObject jsonObject = JSON.parseObject(httpGet);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            JSONObject json = jsonArray.getJSONObject(0);
            return json.getString("eventId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJmaID() {
        try {
            String httpGet = HttpUtils.sendGet(JmaEEWUrl);
            JSONObject jsonObject = JSON.parseObject(httpGet);
            return jsonObject.getString("EventID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSCID() {
        try {
            String httpGet = HttpUtils.sendGet(scUrl);
            JSONObject jsonObject = JSON.parseObject(httpGet);
            return jsonObject.getString("EventID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFJID() {
        try {
            String httpGet = HttpUtils.sendGet(fjUrl);
            JSONObject jsonObject = JSON.parseObject(httpGet);
            return jsonObject.getString("EventID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void fileWriterMethod(String path,String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.append(content);
        }
    }

    public static String getHtmlResourceByUrl(String url,String encoding) {
        StringBuilder buffer = new StringBuilder();
        URL urlObj;
        URLConnection uc;
        InputStreamReader in = null;
        BufferedReader reader;
        try {
            urlObj = new URL(url);
            uc = urlObj.openConnection();
            in = new InputStreamReader(uc.getInputStream(),encoding);
            reader = new BufferedReader(in);
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }

    public static void countDown() {
        TaskS taskS = new TaskS();
        FutureTask<Integer> integerFutureTaskS = new FutureTask<>(taskS);
        Thread thread = new Thread(integerFutureTaskS);
        thread.start();
    }

    public static void countDownTest() {
        TaskTest tasktest = new TaskTest();
        FutureTask<Integer> integerFutureTaskTest = new FutureTask<>(tasktest);
        Thread thread = new Thread(integerFutureTaskTest);
        thread.start();
    }

    static class TaskS implements Callable<Integer> {
        @Override
        public Integer call() {
            SoundUtil soundUtil = new SoundUtil();
            try {
                String httpGet = HttpUtils.sendGet(AppUtils.IclUrl);
                JSONObject jsonObject = JSON.parseObject(httpGet);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONObject json = jsonArray.getJSONObject(0);
                String startAt = json.getString("startAt");
                Long time = Long.parseLong(startAt);
                String date = format.format(time);
                Date date1 = DateUtil.parse(date);
                Date date2 = DateUtil.parse(getTime());
                long a = DateUtil.between(date1,date2, DateUnit.SECOND);
                int Stime = (int) ((int) DistanceUtil.getTime(Double.parseDouble(getUserLng()), Double.parseDouble(getUserLat()), json.getDouble("longitude"), json.getDouble("latitude")) - a);
                if (Stime < 0) {
                    EQWarningWindow.jLabel3.setText("抵达");
                }
                // 倒计时
                for (int i = Stime; i > -1; i--) {
                    EQWarningWindow.jLabel3.setText(String.valueOf(i));
                    if (i == 0) {
                        soundUtil.playSound("sounds\\Arrive.wav");
                        EQWarningWindow.jLabel3.setText("抵达");
                    }
                    Thread.sleep(1000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    static class TaskTest implements Callable<Integer> {
        @Override
        public Integer call() {
            SoundUtil soundUtil = new SoundUtil();
            try {
                // 倒计时
                for (int i = 15; i > -1; i--) {
                    EQWarningWindow.jLabel3.setText(String.valueOf(i));
                    if (i == 0) {
                        soundUtil.playSound("sounds\\Arrive.wav");
                        EQWarningWindow.jLabel3.setText("抵达");
                    }
                    Thread.sleep(1000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
