package cn.leafpeach.liteapp.gui.stations;

import cn.leafpeach.liteapp.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class StationDataWindow extends JFrame {
    static TimerTask timerTask;
    static final JPanel jPanel = new JPanel();
    File file = new File("font\\OPPOSans-B.ttf");
    Font font = null;
    Font font2 = null;

    public StationDataWindow(String StationName) {
        String url = null;
        switch (StationName) {
            case "NM_EEDS_00" -> {
                setTitle("NM_EEDS_00-内蒙古 鄂尔多斯");
                url = "https://api.wolfx.jp/NM_EEDS_00.json";
            }
            case "CQ_BEB_00" -> {
                setTitle("CQ_BEB_00-重庆 北碚");
                url = "https://api.wolfx.jp/CQ_BEB_00.json";
            }
            case "SC_CHD_00" -> {
                setTitle("SC_CHD_00-四川 成都");
                url = "https://api.wolfx.jp/SC_CHD_00.json";
            }
            case "CQ_TOL_00" -> {
                setTitle("CQ_TOL_00-重庆 铜梁");
                url = "https://api.wolfx.jp/CQ_TOL_00.json";
            }
            case "GD_SHZ_00" -> {
                setTitle("GD_SHZ_00-广东 深圳");
                url = "https://api.wolfx.jp/GD_SHZ_00.json";
            }
            case "CQ_DAZ_00" -> {
                setTitle("CQ_DAZ_00-重庆 大足");
                url = "https://api.wolfx.jp/CQ_DAZ_00.json";
            }
        }
        setSize(330, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout());
        setResizable(false);

        // 加载字体
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            font = Font.createFont(Font.TRUETYPE_FONT, bufferedInputStream);
            font = font.deriveFont(Font.PLAIN, 22);
            font2 = font.deriveFont(Font.PLAIN, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jPanel.setFont(font);
        jPanel.setBounds(0, 0, 330, 300);
        JLabel label = new JLabel();
        label.setFont(font);
        JLabel label2 = new JLabel();
        label2.setFont(font);
        JLabel label3 = new JLabel();
        label3.setFont(font);
        JLabel label4 = new JLabel();
        label4.setFont(font2);
        JLabel label5 = new JLabel();
        label5.setFont(font);
        jPanel.setBackground(new Color(37, 42, 37, 255));
        label.setForeground(Color.white);
        label2.setForeground(Color.white);
        label3.setForeground(Color.white);
        label4.setForeground(Color.white);
        label5.setForeground(Color.white);
        jPanel.add(label);
        jPanel.add(label2);
        jPanel.add(label3);
        jPanel.add(label4);
        add(jPanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                timerTask.cancel();
                jPanel.remove(label);
                jPanel.remove(label2);
                jPanel.remove(label3);
                jPanel.remove(label4);
            }
        });

        String finalUrl = url;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    String httpGet = HttpUtils.sendGet(finalUrl);
                    JSONObject jsonObject = JSON.parseObject(httpGet);
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    label.setText("  PGA " + decimalFormat.format(jsonObject.getDouble("PGA")) + " gal ");
                    label2.setText("  震度 " + jsonObject.getString("Shindo") + "(计测" + jsonObject.getString("CalcShindo") + ")");
                    label3.setText("  仪器烈度 " + jsonObject.getString("Intensity"));
                    label4.setText("    PGV " + decimalFormat.format(jsonObject.getDouble("PGV")) + " cm/s");
                } catch (Exception e) {
                    e.printStackTrace();
                    reload();
                }
            }
        };
        new Timer().schedule(timerTask,0L,1000L);
    }

    private static void reload(){
        jPanel.updateUI();
        timerTask.run();
    }
}
