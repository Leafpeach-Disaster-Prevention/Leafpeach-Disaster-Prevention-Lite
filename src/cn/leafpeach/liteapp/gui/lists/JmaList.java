package cn.leafpeach.liteapp.gui.lists;

import cn.leafpeach.liteapp.app.AppTray;
import cn.leafpeach.liteapp.gui.QCMainWindow;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class JmaList {
    public static TimerTask timerTask2;
    static Icon image1,image2,image3,image4,image5,image6,image7,image8,image9,Null;
    static String id = null;
    static File file = new File("Files\\data\\jma.json");

    static {
        try {
            image1 = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\1.png")));
            image2 = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\2.png")));
            image3 = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\3.png")));
            image4 = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\4.png")));
            image5 = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\5-.png")));
            image6 = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\5+.png")));
            image7 = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\6-.png")));
            image8 = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\6+.png")));
            image9 = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\7.png")));
            Null = new ImageIcon(ImageIO.read(new File("Files\\img\\shindo\\null.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load() {
        timerTask2 = new TimerTask() {
            @Override
            public void run() {
                String httpGet;
                try {
                    httpGet = FileUtils.readFileToString(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JSONObject jsonObject1 = JSON.parseObject(httpGet);
                JSONObject json1 = jsonObject1.getJSONObject("No1");
                JSONObject json2 = jsonObject1.getJSONObject("No2");
                JSONObject json3 = jsonObject1.getJSONObject("No3");
                JSONObject json4 = jsonObject1.getJSONObject("No4");
                JSONObject json5 = jsonObject1.getJSONObject("No5");
                JSONObject json6 = jsonObject1.getJSONObject("No6");
                JSONObject json7 = jsonObject1.getJSONObject("No7");
                // jma 1
                try {
                    String region = json1.getString("location");
                    if (region.equals("")) {
                        QCMainWindow.jLabel49.setText("震源 調査中");
                    } else {
                        QCMainWindow.jLabel49.setText(region);
                    }
                    String depth = json1.getString("depth");
                    if (depth.contains("0km")) {
                        QCMainWindow.jLabel50.setText("深さ: ごく浅い" + " | " + json1.getString("Title")) ;
                    } else {
                        QCMainWindow.jLabel50.setText("深さ: " + depth + " | " + json1.getString("Title"));
                    }
                    String shindo = json1.getString("shindo");
                    if (shindo != null && shindo.equals("1")) {
                        QCMainWindow.shindo.setIcon(image1);
                    }
                    if (shindo != null && shindo.equals("2")) {
                        QCMainWindow.shindo.setIcon(image2);
                    }
                    if (shindo != null && shindo.equals("3")) {
                        QCMainWindow.shindo.setIcon(image3);
                    }
                    if (shindo != null && shindo.equals("4")) {
                        QCMainWindow.shindo.setIcon(image4);
                    }
                    if (shindo != null && shindo.equals("5-")) {
                        QCMainWindow.shindo.setIcon(image5);
                    }
                    if (shindo != null && shindo.equals("5+")) {
                        QCMainWindow.shindo.setIcon(image6);
                    }
                    if (shindo != null && shindo.equals("6-")) {
                        QCMainWindow.shindo.setIcon(image7);
                    }
                    if (shindo != null && shindo.equals("6+")) {
                        QCMainWindow.shindo.setIcon(image8);
                    }
                    if (shindo != null && shindo.equals("7")) {
                        QCMainWindow.shindo.setIcon(image9);
                    }
                    if (shindo != null && !shindo.equals("1") && !shindo.equals("2") && !shindo.equals("3") && !shindo.equals("4") && !shindo.equals("5-") && !shindo.equals("5+") && !shindo.equals("6-") && !shindo.equals("6+") && !shindo.equals("7")) {
                        QCMainWindow.shindo.setIcon(Null);
                    }
                    QCMainWindow.jLabel51.setText(json1.getString("time_full"));
                    QCMainWindow.jLabel52.setText("M" + json1.getString("magnitude"));
                    QCMainWindow.shindo.setSize(75, 86);
                    QCMainWindow.shindo.setLocation(0, -7);
                    QCMainWindow.jmaPanel.add(QCMainWindow.shindo);
                } catch (Exception e) {
                    e.printStackTrace();
                    timerTask2.cancel();
                    load();
                }

                // jma 2
                try {
                    String region = json2.getString("location");
                    QCMainWindow.jLabel53.setText(region);
                    String depth = json2.getString("depth");
                    if (depth != null && depth.equals("0km")) {
                        QCMainWindow.jLabel54.setText("深さ: ごく浅い" + " | " + json2.getString("Title"));
                    } else {
                        QCMainWindow.jLabel54.setText("深さ: " + depth + " | " + json2.getString("Title"));
                    }
                    String shindo = json2.getString("shindo");
                    if (shindo != null && shindo.equals("1")) {
                        QCMainWindow.shindo1.setIcon(image1);
                    }
                    if (shindo != null && shindo.equals("2")) {
                        QCMainWindow.shindo1.setIcon(image2);
                    }
                    if (shindo != null && shindo.equals("3")) {
                        QCMainWindow.shindo1.setIcon(image3);
                    }
                    if (shindo != null && shindo.equals("4")) {
                        QCMainWindow.shindo1.setIcon(image4);
                    }
                    if (shindo != null && shindo.equals("5-")) {
                        QCMainWindow.shindo1.setIcon(image5);
                    }
                    if (shindo != null && shindo.equals("5+")) {
                        QCMainWindow.shindo1.setIcon(image6);
                    }
                    if (shindo != null && shindo.equals("6-")) {
                        QCMainWindow.shindo1.setIcon(image7);
                    }
                    if (shindo != null && shindo.equals("6+")) {
                        QCMainWindow.shindo1.setIcon(image8);
                    }
                    if (shindo != null && shindo.equals("7")) {
                        QCMainWindow.shindo1.setIcon(image9);
                    }
                    if (shindo != null && !shindo.equals("1") && !shindo.equals("2") && !shindo.equals("3") && !shindo.equals("4") && !shindo.equals("5-") && !shindo.equals("5+") && !shindo.equals("6-") && !shindo.equals("6+") && !shindo.equals("7")) {
                        QCMainWindow.shindo1.setIcon(Null);
                    }
                    QCMainWindow.jLabel55.setText(json2.getString("time_full"));
                    QCMainWindow.jLabel56.setText("M" + json2.getString("magnitude"));
                    QCMainWindow.shindo1.setSize(75, 86);
                    QCMainWindow.shindo1.setLocation(0, -7);
                    QCMainWindow.jmaPanel1.add(QCMainWindow.shindo1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // jma 3
                try {
                    String region = json3.getString("location");
                    QCMainWindow.jLabel57.setText(region);
                    String depth = json3.getString("depth");
                    if (depth != null && depth.equals("0km")) {
                        QCMainWindow.jLabel58.setText("深さ: ごく浅い" + " | " + json3.getString("Title"));
                    } else {
                        QCMainWindow.jLabel58.setText("深さ: " + depth + " | " + json3.getString("Title"));
                    }
                    String shindo = json3.getString("shindo");
                    if (shindo != null && shindo.equals("1")) {
                        QCMainWindow.shindo2.setIcon(image1);
                    }
                    if (shindo != null && shindo.equals("2")) {
                        QCMainWindow.shindo2.setIcon(image2);
                    }
                    if (shindo != null && shindo.equals("3")) {
                        QCMainWindow.shindo2.setIcon(image3);
                    }
                    if (shindo != null && shindo.equals("4")) {
                        QCMainWindow.shindo2.setIcon(image4);
                    }
                    if (shindo != null && shindo.equals("5-")) {
                        QCMainWindow.shindo2.setIcon(image5);
                    }
                    if (shindo != null && shindo.equals("5+")) {
                        QCMainWindow.shindo2.setIcon(image6);
                    }
                    if (shindo != null && shindo.equals("6-")) {
                        QCMainWindow.shindo2.setIcon(image7);
                    }
                    if (shindo != null && shindo.equals("6+")) {
                        QCMainWindow.shindo2.setIcon(image8);
                    }
                    if (shindo != null && shindo.equals("7")) {
                        QCMainWindow.shindo2.setIcon(image9);
                    }
                    if (shindo != null && !shindo.equals("1") && !shindo.equals("2") && !shindo.equals("3") && !shindo.equals("4") && !shindo.equals("5-") && !shindo.equals("5+") && !shindo.equals("6-") && !shindo.equals("6+") && !shindo.equals("7")) {
                        QCMainWindow.shindo2.setIcon(Null);
                    }
                    QCMainWindow.jLabel59.setText(json3.getString("time_full"));
                    QCMainWindow.jLabel60.setText("M" + json3.getString("magnitude"));
                    QCMainWindow.shindo2.setSize(75, 86);
                    QCMainWindow.shindo2.setLocation(0, -7);
                    QCMainWindow.jmaPanel2.add(QCMainWindow.shindo2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // jma 4
                try {
                    String region = json4.getString("location");
                    QCMainWindow.jLabel61.setText(region);
                    String depth = json4.getString("depth");
                    if (depth != null && depth.equals("0km")) {
                        QCMainWindow.jLabel62.setText("深さ: ごく浅い" + " | " + json4.getString("Title"));
                    } else {
                        QCMainWindow.jLabel62.setText("深さ: " + depth + " | " + json4.getString("Title"));
                    }
                    String shindo = json4.getString("shindo");
                    if (shindo != null && shindo.equals("1")) {
                        QCMainWindow.shindo3.setIcon(image1);
                    }
                    if (shindo != null && shindo.equals("2")) {
                        QCMainWindow.shindo3.setIcon(image2);
                    }
                    if (shindo != null && shindo.equals("3")) {
                        QCMainWindow.shindo3.setIcon(image3);
                    }
                    if (shindo != null && shindo.equals("4")) {
                        QCMainWindow.shindo3.setIcon(image4);
                    }
                    if (shindo != null && shindo.equals("5-")) {
                        QCMainWindow.shindo3.setIcon(image5);
                    }
                    if (shindo != null && shindo.equals("5+")) {
                        QCMainWindow.shindo3.setIcon(image6);
                    }
                    if (shindo != null && shindo.equals("6-")) {
                        QCMainWindow.shindo3.setIcon(image7);
                    }
                    if (shindo != null && shindo.equals("6+")) {
                        QCMainWindow.shindo3.setIcon(image8);
                    }
                    if (shindo != null && shindo.equals("7")) {
                        QCMainWindow.shindo3.setIcon(image9);
                    }
                    if (shindo != null && !shindo.equals("1") && !shindo.equals("2") && !shindo.equals("3") && !shindo.equals("4") && !shindo.equals("5-") && !shindo.equals("5+") && !shindo.equals("6-") && !shindo.equals("6+") && !shindo.equals("7")) {
                        QCMainWindow.shindo3.setIcon(Null);
                    }
                    QCMainWindow.jLabel63.setText(json4.getString("time_full"));
                    QCMainWindow.jLabel64.setText("M" + json4.getString("magnitude"));
                    QCMainWindow.shindo3.setSize(75, 86);
                    QCMainWindow.shindo3.setLocation(0, -7);
                    QCMainWindow.jmaPanel3.add(QCMainWindow.shindo3);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // jma 5
                try {
                    String region = json5.getString("location");
                    QCMainWindow.jLabel65.setText(region);
                    String depth = json5.getString("depth");
                    if (depth != null && depth.equals("0km")) {
                        QCMainWindow.jLabel66.setText("深さ: ごく浅い" + " | " + json5.getString("Title"));
                    } else {
                        QCMainWindow.jLabel66.setText("深さ: " + depth + " | " + json5.getString("Title"));
                    }
                    String shindo = json5.getString("shindo");
                    if (shindo != null && shindo.equals("1")) {
                        QCMainWindow.shindo4.setIcon(image1);
                    }
                    if (shindo != null && shindo.equals("2")) {
                        QCMainWindow.shindo4.setIcon(image2);
                    }
                    if (shindo != null && shindo.equals("3")) {
                        QCMainWindow.shindo4.setIcon(image3);
                    }
                    if (shindo != null && shindo.equals("4")) {
                        QCMainWindow.shindo4.setIcon(image4);
                    }
                    if (shindo != null && shindo.equals("5-")) {
                        QCMainWindow.shindo4.setIcon(image5);
                    }
                    if (shindo != null && shindo.equals("5+")) {
                        QCMainWindow.shindo4.setIcon(image6);
                    }
                    if (shindo != null && shindo.equals("6-")) {
                        QCMainWindow.shindo4.setIcon(image7);
                    }
                    if (shindo != null && shindo.equals("6+")) {
                        QCMainWindow.shindo4.setIcon(image8);
                    }
                    if (shindo != null && shindo.equals("7")) {
                        QCMainWindow.shindo4.setIcon(image9);
                    }
                    if (shindo != null && !shindo.equals("1") && !shindo.equals("2") && !shindo.equals("3") && !shindo.equals("4") && !shindo.equals("5-") && !shindo.equals("5+") && !shindo.equals("6-") && !shindo.equals("6+") && !shindo.equals("7")) {
                        QCMainWindow.shindo4.setIcon(Null);
                    }
                    QCMainWindow.jLabel67.setText(json5.getString("time_full"));
                    QCMainWindow.jLabel68.setText("M" + json5.getString("magnitude"));
                    QCMainWindow.shindo4.setSize(75, 86);
                    QCMainWindow.shindo4.setLocation(0, -7);
                    QCMainWindow.jmaPanel4.add(QCMainWindow.shindo4);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // jma 6
                try {
                    String region = json6.getString("location");
                    QCMainWindow.jLabel69.setText(region);
                    String depth = json6.getString("depth");
                    if (depth != null && depth.equals("0km")) {
                        QCMainWindow.jLabel70.setText("深さ: ごく浅い" + " | " + json6.getString("Title"));
                    } else {
                        QCMainWindow.jLabel70.setText("深さ: " + depth + " | " + json6.getString("Title"));
                    }
                    String shindo = json6.getString("shindo");
                    if (shindo != null && shindo.equals("1")) {
                        QCMainWindow.shindo5.setIcon(image1);
                    }
                    if (shindo != null && shindo.equals("2")) {
                        QCMainWindow.shindo5.setIcon(image2);
                    }
                    if (shindo != null && shindo.equals("3")) {
                        QCMainWindow.shindo5.setIcon(image3);
                    }
                    if (shindo != null && shindo.equals("4")) {
                        QCMainWindow.shindo5.setIcon(image4);
                    }
                    if (shindo != null && shindo.equals("5-")) {
                        QCMainWindow.shindo5.setIcon(image5);
                    }
                    if (shindo != null && shindo.equals("5+")) {
                        QCMainWindow.shindo5.setIcon(image6);
                    }
                    if (shindo != null && shindo.equals("6-")) {
                        QCMainWindow.shindo5.setIcon(image7);
                    }
                    if (shindo != null && shindo.equals("6+")) {
                        QCMainWindow.shindo5.setIcon(image8);
                    }
                    if (shindo != null && shindo.equals("7")) {
                        QCMainWindow.shindo5.setIcon(image9);
                    }
                    if (shindo != null && !shindo.equals("1") && !shindo.equals("2") && !shindo.equals("3") && !shindo.equals("4") && !shindo.equals("5-") && !shindo.equals("5+") && !shindo.equals("6-") && !shindo.equals("6+") && !shindo.equals("7")) {
                        QCMainWindow.shindo5.setIcon(Null);
                    }
                    QCMainWindow.jLabel71.setText(json6.getString("time_full"));
                    QCMainWindow.jLabel72.setText("M" + json6.getString("magnitude"));
                    QCMainWindow.shindo5.setSize(75, 86);
                    QCMainWindow.shindo5.setLocation(0, -7);
                    QCMainWindow.jmaPanel5.add(QCMainWindow.shindo5);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // jma 7
                try {
                    String region = json7.getString("location");
                    QCMainWindow.jLabel73.setText(region);
                    String depth = json7.getString("depth");
                    if (depth != null && depth.equals("0km")) {
                        QCMainWindow.jLabel74.setText("深さ: ごく浅い" + " | " + json7.getString("Title"));
                    } else {
                        QCMainWindow.jLabel74.setText("深さ: " + depth + " | " + json7.getString("Title"));
                    }
                    String shindo = json7.getString("shindo");
                    if (shindo != null && shindo.equals("1")) {
                        QCMainWindow.shindo6.setIcon(image1);
                    }
                    if (shindo != null && shindo.equals("2")) {
                        QCMainWindow.shindo6.setIcon(image2);
                    }
                    if (shindo != null && shindo.equals("3")) {
                        QCMainWindow.shindo6.setIcon(image3);
                    }
                    if (shindo != null && shindo.equals("4")) {
                        QCMainWindow.shindo6.setIcon(image4);
                    }
                    if (shindo != null && shindo.equals("5-")) {
                        QCMainWindow.shindo6.setIcon(image5);
                    }
                    if (shindo != null && shindo.equals("5+")) {
                        QCMainWindow.shindo6.setIcon(image6);
                    }
                    if (shindo != null && shindo.equals("6-")) {
                        QCMainWindow.shindo6.setIcon(image7);
                    }
                    if (shindo != null && shindo.equals("6+")) {
                        QCMainWindow.shindo6.setIcon(image8);
                    }
                    if (shindo != null && shindo.equals("7")) {
                        QCMainWindow.shindo6.setIcon(image9);
                    }
                    if (shindo != null && !shindo.equals("1") && !shindo.equals("2") && !shindo.equals("3") && !shindo.equals("4") && !shindo.equals("5-") && !shindo.equals("5+") && !shindo.equals("6-") && !shindo.equals("6+") && !shindo.equals("7")) {
                        QCMainWindow.shindo6.setIcon(Null);
                    }
                    QCMainWindow.jLabel75.setText(json7.getString("time_full"));
                    QCMainWindow.jLabel76.setText("M" + json7.getString("magnitude"));
                    QCMainWindow.shindo6.setSize(75, 86);
                    QCMainWindow.shindo6.setLocation(0, -7);
                    QCMainWindow.jmaPanel6.add(QCMainWindow.shindo6);

                    QCMainWindow.jPanel3.updateUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (!Objects.equals(json1.getString("EventID") + json1.getString("Title"), id)) {
                    if (json1.getString("Title").equals("震源・震度情報")) {
                        AppTray.showMessage("地震情報（気象庁）","発生時刻: " + json1.getString("time_full") + "\n震源地: " + json1.getString("location") + "\n最大震度: " + json1.getString("shindo") + "\nマグニチュード: " + json1.getString("magnitude") + " 深さ: " + json1.getString("depth"));
                    }
                    if (json1.getString("Title").equals("震度速報")) {
                        AppTray.showMessage("震度速報（気象庁）","発生時刻: " + json1.getString("time_full") + "\n最大震度: " + json1.getString("shindo") + "\n震源 調査中" + "\n" + json1.getString("info"));
                    }
                    id = json1.getString("EventID") + json1.getString("Title");
                }
            }
        };
        new Timer().schedule(timerTask2,0L,1000L);
    }
}
