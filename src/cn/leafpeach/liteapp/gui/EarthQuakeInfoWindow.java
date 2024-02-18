package cn.leafpeach.liteapp.gui;

import cn.leafpeach.liteapp.utils.AppUtils;
import cn.leafpeach.liteapp.utils.DistanceUtil;
import cn.leafpeach.liteapp.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class EarthQuakeInfoWindow extends JFrame {
    JPanel jPanel;
    JLabel jLabel,jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6,jLabel7,jLabel8;
    Font font = null;
    Font font1 = null;
    DecimalFormat decimalFormat = new DecimalFormat("0.0");
    DecimalFormat decimalFormat1 = new DecimalFormat("0.00");
    SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

    public EarthQuakeInfoWindow(int index) throws IOException {
        Image image = Toolkit.getDefaultToolkit().getImage("Files\\img\\icon.png");
        setIconImage(image);
        setTitle("预警详情");
        setSize(400,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        jPanel = new JPanel();
        jPanel.setSize(400,500);
        jPanel.setLayout(null);
        jPanel.setBackground(new Color(36, 34, 34, 255));

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();

        // 显示地图
        String httpGet = HttpUtils.sendGet(AppUtils.IclUrl);
        JSONObject jsonObject = JSON.parseObject(httpGet);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONObject json = jsonArray.getJSONObject(index);
        String url = "https://restapi.amap.com/v3/staticmap?location=" + json.getString("longitude") + "," + json.getString("latitude") + "&zoom=8&size=400*200&markers=mid,,A:" + json.getString("longitude") + "," + json.getString("latitude") + "&key=apikey已隐藏";
        URL url1 = new URL(url);
        InputStream inputStream = url1.openStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int read;
        while ((read = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0,read);
        }
        byte[] imageBytes = outputStream.toByteArray();
        Image image1 = Toolkit.getDefaultToolkit().createImage(imageBytes);
        jLabel = new JLabel(new ImageIcon(image1));

        // 加载字体
        try {
            FileInputStream fileInputStream = new FileInputStream("font\\OPPOSans-B.ttf");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            font = Font.createFont(Font.TRUETYPE_FONT, bufferedInputStream);
            font = font.deriveFont(Font.PLAIN, 18);
            font1 = font.deriveFont(Font.PLAIN, 14);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jLabel.setSize(400,200);
        jLabel.setLocation(0,0);
        jLabel1.setSize(400,100);
        jLabel1.setLocation(0,180);
        jLabel1.setFont(font);
        jLabel1.setForeground(Color.white);
        jLabel1.setText("     震中位置: " + json.getString("epicenter") + "    预警震级: M" + decimalFormat.format(json.getDouble("magnitude")));

        jLabel2.setSize(400,100);
        jLabel2.setLocation(0,210);
        jLabel2.setFont(font);
        jLabel2.setForeground(Color.white);
        String startAt = json.getString("startAt");
        Long time = Long.parseLong(startAt);
        String date = format.format(time);
        jLabel2.setText("     发震时刻: " + date);

        jLabel3.setSize(400,100);
        jLabel3.setLocation(0,240);
        jLabel3.setFont(font);
        jLabel3.setForeground(Color.white);
        jLabel3.setText("     震中经纬度: " + "E" + decimalFormat1.format(json.getDouble("longitude")) + ",N" + decimalFormat1.format(json.getDouble("latitude")));

        jLabel4.setSize(400,100);
        jLabel4.setLocation(0,270);
        jLabel4.setFont(font);
        jLabel4.setForeground(Color.white);
        double userLng = Double.parseDouble(AppUtils.getUserLng());
        double userLat = Double.parseDouble(AppUtils.getUserLat());
        jLabel4.setText("     震源深度: " + decimalFormat.format(json.getDouble("depth")) + "公里  震中距您: " + decimalFormat.format(DistanceUtil.getDistance(userLng,userLat,json.getDouble("longitude"),json.getDouble("latitude"))) + "公里");

        jLabel5.setSize(400,100);
        jLabel5.setLocation(0,300);
        jLabel5.setFont(font);
        jLabel5.setForeground(Color.white);
        double Int = AppUtils.getLocal(index);
        double max = AppUtils.calcMaxInt(json.getDouble("magnitude"),json.getDouble("depth"));
        if (Int < 0) {
            jLabel5.setText("     本地预估烈度: 0.0度  震中预估烈度: " + decimalFormat.format(max) + "度");
        } else {
            if (Int > max) {
                jLabel5.setText("     本地预估烈度: " + decimalFormat.format(max) + "度  震中预估烈度: " + decimalFormat.format(max) + "度");
            } else {
                jLabel5.setText("     本地预估烈度: " + decimalFormat.format(Int) + "度  震中预估烈度: " + decimalFormat.format(max) + "度");
            }
        }

        jLabel6.setSize(400,100);
        jLabel6.setLocation(0,330);
        jLabel6.setFont(font);
        jLabel6.setForeground(Color.white);
        jLabel6.setText("     预警时间: " + decimalFormat.format(DistanceUtil.getTime(userLng,userLat,json.getDouble("longitude"),json.getDouble("latitude"))) + "秒");

        jLabel7.setSize(400,100);
        jLabel7.setLocation(0,360);
        jLabel7.setFont(font1);
        jLabel7.setForeground(Color.gray);
        jLabel7.setText("     中国地震预警网");

        jLabel8.setSize(400,100);
        jLabel8.setLocation(0,390);
        jLabel8.setFont(font1);
        jLabel8.setForeground(Color.gray);
        jLabel8.setText("     成都高新减灾研究所  四川大学");

        add(jPanel);
        jPanel.add(jLabel);
        jPanel.add(jLabel1);
        jPanel.add(jLabel2);
        jPanel.add(jLabel3);
        jPanel.add(jLabel4);
        jPanel.add(jLabel5);
        jPanel.add(jLabel6);
        jPanel.add(jLabel7);
        jPanel.add(jLabel8);
    }
}
