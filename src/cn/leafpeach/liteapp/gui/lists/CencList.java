package cn.leafpeach.liteapp.gui.lists;

import cn.leafpeach.liteapp.gui.QCMainWindow;
import cn.leafpeach.liteapp.utils.AppUtils;
import cn.leafpeach.liteapp.utils.HttpUtils;
import cn.leafpeach.liteapp.utils.SoundUtil;
import cn.leafpeach.liteapp.app.AppTray;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class CencList {
    public static TimerTask timerTask1;
    static String id = null;
    static Icon image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12;
    static File file = new File("Files\\data\\cenc.json");

    static {
        try {
            image1 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\1.png")));
            image2 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\2.png")));
            image3 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\3.png")));
            image4 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\4.png")));
            image5 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\5.png")));
            image6 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\6.png")));
            image7 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\7.png")));
            image8 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\8.png")));
            image9 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\9.png")));
            image10 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\10.png")));
            image11 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\11.png")));
            image12 = new ImageIcon(ImageIO.read(new File("Files\\img\\csis\\12.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 加载列表
    public static void load() {
        timerTask1 = new TimerTask() {
            @Override
            public void run() {
                String httpGet;
                try {
                    httpGet = FileUtils.readFileToString(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String httpGet1 = HttpUtils.sendGet(AppUtils.CencUrl1);
                JSONObject jsonObject = JSON.parseObject(httpGet1);
                JSONArray jsonArray = jsonObject.getJSONArray("list");
                JSONObject json = jsonArray.getJSONObject(0);
                JSONObject jsonObject1 = JSON.parseObject(httpGet);
                JSONObject json1 = jsonObject1.getJSONObject("No2");
                JSONObject json2 = jsonObject1.getJSONObject("No3");
                JSONObject json3 = jsonObject1.getJSONObject("No4");
                JSONObject json4 = jsonObject1.getJSONObject("No5");
                JSONObject json5 = jsonObject1.getJSONObject("No6");
                JSONObject json6 = jsonObject1.getJSONObject("No7");
                // cenc 1
                try {
                    String getCencRegion = json.getString("placeName");
                    String getCencDepth = json.getString("depth");
                    String getCencMag = json.getString("magnitude");
                    String getCencDate = json.getString("shockTime");
                    String getCencType = json.getString("infoTypeName");
                    QCMainWindow.jLabel21.setText(getCencType + " " + getCencRegion);
                    QCMainWindow.jLabel22.setText("震源深度: " + getCencDepth + "公里");
                    double feel1 = AppUtils.calcMaxInt(Double.parseDouble(Objects.requireNonNull(getCencMag)), Double.parseDouble(Objects.requireNonNull(getCencDepth)));
                    if (feel1 >= 0.0 && feel1 < 1.5) {
                        QCMainWindow.Int.setIcon(image1);
                    }
                    if (feel1 >= 1.5 && feel1 < 2.5) {
                        QCMainWindow.Int.setIcon(image2);
                    }
                    if (feel1 >= 2.5 && feel1 < 3.5) {
                        QCMainWindow.Int.setIcon(image3);
                    }
                    if (feel1 >= 3.5 && feel1 < 4.5) {
                        QCMainWindow.Int.setIcon(image4);
                    }
                    if (feel1 >= 4.5 && feel1 < 5.5) {
                        QCMainWindow.Int.setIcon(image5);
                    }
                    if (feel1 >= 5.5 && feel1 < 6.5) {
                        QCMainWindow.Int.setIcon(image6);
                    }
                    if (feel1 >= 6.5 && feel1 < 7.5) {
                        QCMainWindow.Int.setIcon(image7);
                    }
                    if (feel1 >= 7.5 && feel1 < 8.5) {
                        QCMainWindow.Int.setIcon(image8);
                    }
                    if (feel1 >= 8.5 && feel1 < 9.5) {
                        QCMainWindow.Int.setIcon(image9);
                    }
                    if (feel1 >= 9.5 && feel1 < 10.5) {
                        QCMainWindow.Int.setIcon(image10);
                    }
                    if (feel1 >= 10.5 && feel1 < 11.5) {
                        QCMainWindow.Int.setIcon(image11);
                    }
                    if (feel1 >= 11.5 && feel1 < 12.5) {
                        QCMainWindow.Int.setIcon(image12);
                    }
                    if (feel1 > 12.5) {
                        QCMainWindow.Int.setIcon(image12);
                    }
                    QCMainWindow.jLabel23.setText("发震时刻: " + getCencDate);
                    QCMainWindow.jLabel24.setText("M" + getCencMag);
                    QCMainWindow.Int.setSize(75, 86);
                    QCMainWindow.Int.setLocation(0, -7);
                    QCMainWindow.cencPanel.add(QCMainWindow.Int);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // cenc 2
                try {
                    String getCencRegion = json1.getString("location");
                    String getCencDepth = json1.getString("depth");
                    String getCencMag = json1.getString("magnitude");
                    String getCencDate = json1.getString("time");
                    QCMainWindow.jLabel25.setText(getCencRegion);
                    QCMainWindow.jLabel26.setText("震源深度: " + getCencDepth + "公里");
                    double feel1 = AppUtils.calcMaxInt(Double.parseDouble(Objects.requireNonNull(getCencMag)), Double.parseDouble(Objects.requireNonNull(getCencDepth)));
                    if (feel1 >= 0.0 && feel1 < 1.5) {
                        QCMainWindow.Int1.setIcon(image1);
                    }
                    if (feel1 >= 1.5 && feel1 < 2.5) {
                        QCMainWindow.Int1.setIcon(image2);
                    }
                    if (feel1 >= 2.5 && feel1 < 3.5) {
                        QCMainWindow.Int1.setIcon(image3);
                    }
                    if (feel1 >= 3.5 && feel1 < 4.5) {
                        QCMainWindow.Int1.setIcon(image4);
                    }
                    if (feel1 >= 4.5 && feel1 < 5.5) {
                        QCMainWindow.Int1.setIcon(image5);
                    }
                    if (feel1 >= 5.5 && feel1 < 6.5) {
                        QCMainWindow.Int1.setIcon(image6);
                    }
                    if (feel1 >= 6.5 && feel1 < 7.5) {
                        QCMainWindow.Int1.setIcon(image7);
                    }
                    if (feel1 >= 7.5 && feel1 < 8.5) {
                        QCMainWindow.Int1.setIcon(image8);
                    }
                    if (feel1 >= 8.5 && feel1 < 9.5) {
                        QCMainWindow.Int1.setIcon(image9);
                    }
                    if (feel1 >= 9.5 && feel1 < 10.5) {
                        QCMainWindow.Int1.setIcon(image10);
                    }
                    if (feel1 >= 10.5 && feel1 < 11.5) {
                        QCMainWindow.Int1.setIcon(image11);
                    }
                    if (feel1 >= 11.5 && feel1 < 12.5) {
                        QCMainWindow.Int1.setIcon(image12);
                    }
                    if (feel1 > 12.5) {
                        QCMainWindow.Int1.setIcon(image12);
                    }
                    QCMainWindow.jLabel27.setText("发震时刻: " + getCencDate);
                    QCMainWindow.jLabel28.setText("M" + getCencMag);
                    QCMainWindow.Int1.setSize(75, 86);
                    QCMainWindow.Int1.setLocation(0, -7);
                    QCMainWindow.cencPanel1.add(QCMainWindow.Int1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // cenc 3
                try {
                    String getCencRegion = json2.getString("location");
                    String getCencDepth = json2.getString("depth");
                    String getCencMag = json2.getString("magnitude");
                    String getCencDate = json2.getString("time");
                    QCMainWindow.jLabel29.setText(getCencRegion);
                    QCMainWindow.jLabel30.setText("震源深度: " + getCencDepth + "公里");
                    double feel1 = AppUtils.calcMaxInt(Double.parseDouble(Objects.requireNonNull(getCencMag)), Double.parseDouble(Objects.requireNonNull(getCencDepth)));
                    if (feel1 >= 0.0 && feel1 < 1.5) {
                        QCMainWindow.Int2.setIcon(image1);
                    }
                    if (feel1 >= 1.5 && feel1 < 2.5) {
                        QCMainWindow.Int2.setIcon(image2);
                    }
                    if (feel1 >= 2.5 && feel1 < 3.5) {
                        QCMainWindow.Int2.setIcon(image3);
                    }
                    if (feel1 >= 3.5 && feel1 < 4.5) {
                        QCMainWindow.Int2.setIcon(image4);
                    }
                    if (feel1 >= 4.5 && feel1 < 5.5) {
                        QCMainWindow.Int2.setIcon(image5);
                    }
                    if (feel1 >= 5.5 && feel1 < 6.5) {
                        QCMainWindow.Int2.setIcon(image6);
                    }
                    if (feel1 >= 6.5 && feel1 < 7.5) {
                        QCMainWindow.Int2.setIcon(image7);
                    }
                    if (feel1 >= 7.5 && feel1 < 8.5) {
                        QCMainWindow.Int2.setIcon(image8);
                    }
                    if (feel1 >= 8.5 && feel1 < 9.5) {
                        QCMainWindow.Int2.setIcon(image9);
                    }
                    if (feel1 >= 9.5 && feel1 < 10.5) {
                        QCMainWindow.Int2.setIcon(image10);
                    }
                    if (feel1 >= 10.5 && feel1 < 11.5) {
                        QCMainWindow.Int2.setIcon(image11);
                    }
                    if (feel1 >= 11.5 && feel1 < 12.5) {
                        QCMainWindow.Int2.setIcon(image12);
                    }
                    if (feel1 > 12.5) {
                        QCMainWindow.Int2.setIcon(image12);
                    }
                    QCMainWindow.jLabel31.setText("发震时刻: " + getCencDate);
                    QCMainWindow.jLabel32.setText("M" + getCencMag);
                    QCMainWindow.Int2.setSize(75, 86);
                    QCMainWindow.Int2.setLocation(0, -7);
                    QCMainWindow.cencPanel2.add(QCMainWindow.Int2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // cenc 4
                try {
                    String getCencRegion = json3.getString("location");
                    String getCencDepth = json3.getString("depth");
                    String getCencMag = json3.getString("magnitude");
                    String getCencDate = json3.getString("time");
                    QCMainWindow.jLabel33.setText(getCencRegion);
                    QCMainWindow.jLabel34.setText("震源深度: " + getCencDepth + "公里");
                    double feel1 = AppUtils.calcMaxInt(Double.parseDouble(Objects.requireNonNull(getCencMag)), Double.parseDouble(Objects.requireNonNull(getCencDepth)));
                    if (feel1 >= 0.0 && feel1 < 1.5) {
                        QCMainWindow.Int3.setIcon(image1);
                    }
                    if (feel1 >= 1.5 && feel1 < 2.5) {
                        QCMainWindow.Int3.setIcon(image2);
                    }
                    if (feel1 >= 2.5 && feel1 < 3.5) {
                        QCMainWindow.Int3.setIcon(image3);
                    }
                    if (feel1 >= 3.5 && feel1 < 4.5) {
                        QCMainWindow.Int3.setIcon(image4);
                    }
                    if (feel1 >= 4.5 && feel1 < 5.5) {
                        QCMainWindow.Int3.setIcon(image5);
                    }
                    if (feel1 >= 5.5 && feel1 < 6.5) {
                        QCMainWindow.Int3.setIcon(image6);
                    }
                    if (feel1 >= 6.5 && feel1 < 7.5) {
                        QCMainWindow.Int3.setIcon(image7);
                    }
                    if (feel1 >= 7.5 && feel1 < 8.5) {
                        QCMainWindow.Int3.setIcon(image8);
                    }
                    if (feel1 >= 8.5 && feel1 < 9.5) {
                        QCMainWindow.Int3.setIcon(image9);
                    }
                    if (feel1 >= 9.5 && feel1 < 10.5) {
                        QCMainWindow.Int3.setIcon(image10);
                    }
                    if (feel1 >= 10.5 && feel1 < 11.5) {
                        QCMainWindow.Int3.setIcon(image11);
                    }
                    if (feel1 >= 11.5 && feel1 < 12.5) {
                        QCMainWindow.Int3.setIcon(image12);
                    }
                    if (feel1 > 12.5) {
                        QCMainWindow.Int3.setIcon(image12);
                    }
                    QCMainWindow.jLabel35.setText("发震时刻: " + getCencDate);
                    QCMainWindow.jLabel36.setText("M" + getCencMag);
                    QCMainWindow.Int3.setSize(75, 86);
                    QCMainWindow.Int3.setLocation(0, -7);
                    QCMainWindow.cencPanel3.add(QCMainWindow.Int3);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // cenc 5
                try {
                    String getCencRegion = json4.getString("location");
                    String getCencDepth = json4.getString("depth");
                    String getCencMag = json4.getString("magnitude");
                    String getCencDate = json4.getString("time");
                    QCMainWindow.jLabel37.setText(getCencRegion);
                    QCMainWindow.jLabel38.setText("震源深度: " + getCencDepth + "公里");
                    double feel1 = AppUtils.calcMaxInt(Double.parseDouble(Objects.requireNonNull(getCencMag)), Double.parseDouble(Objects.requireNonNull(getCencDepth)));
                    if (feel1 >= 0.0 && feel1 < 1.5) {
                        QCMainWindow.Int4.setIcon(image1);
                    }
                    if (feel1 >= 1.5 && feel1 < 2.5) {
                        QCMainWindow.Int4.setIcon(image2);
                    }
                    if (feel1 >= 2.5 && feel1 < 3.5) {
                        QCMainWindow.Int4.setIcon(image3);
                    }
                    if (feel1 >= 3.5 && feel1 < 4.5) {
                        QCMainWindow.Int4.setIcon(image4);
                    }
                    if (feel1 >= 4.5 && feel1 < 5.5) {
                        QCMainWindow.Int4.setIcon(image5);
                    }
                    if (feel1 >= 5.5 && feel1 < 6.5) {
                        QCMainWindow.Int4.setIcon(image6);
                    }
                    if (feel1 >= 6.5 && feel1 < 7.5) {
                        QCMainWindow.Int4.setIcon(image7);
                    }
                    if (feel1 >= 7.5 && feel1 < 8.5) {
                        QCMainWindow.Int4.setIcon(image8);
                    }
                    if (feel1 >= 8.5 && feel1 < 9.5) {
                        QCMainWindow.Int4.setIcon(image9);
                    }
                    if (feel1 >= 9.5 && feel1 < 10.5) {
                        QCMainWindow.Int4.setIcon(image10);
                    }
                    if (feel1 >= 10.5 && feel1 < 11.5) {
                        QCMainWindow.Int4.setIcon(image11);
                    }
                    if (feel1 >= 11.5 && feel1 < 12.5) {
                        QCMainWindow.Int4.setIcon(image12);
                    }
                    if (feel1 > 12.5) {
                        QCMainWindow.Int4.setIcon(image12);
                    }
                    QCMainWindow.jLabel39.setText("发震时刻: " + getCencDate);
                    QCMainWindow.jLabel40.setText("M" + getCencMag);
                    QCMainWindow.Int4.setSize(75, 86);
                    QCMainWindow.Int4.setLocation(0, -7);
                    QCMainWindow.cencPanel4.add(QCMainWindow.Int4);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // cenc 6
                try {
                    String getCencRegion = json5.getString("location");
                    String getCencDepth = json5.getString("depth");
                    String getCencMag = json5.getString("magnitude");
                    String getCencDate = json5.getString("time");
                    QCMainWindow.jLabel41.setText(getCencRegion);
                    QCMainWindow.jLabel42.setText("震源深度: " + getCencDepth + "公里");
                    double feel1 = AppUtils.calcMaxInt(Double.parseDouble(Objects.requireNonNull(getCencMag)), Double.parseDouble(Objects.requireNonNull(getCencDepth)));
                    if (feel1 >= 0.0 && feel1 < 1.5) {
                        QCMainWindow.Int5.setIcon(image1);
                    }
                    if (feel1 >= 1.5 && feel1 < 2.5) {
                        QCMainWindow.Int5.setIcon(image2);
                    }
                    if (feel1 >= 2.5 && feel1 < 3.5) {
                        QCMainWindow.Int5.setIcon(image3);
                    }
                    if (feel1 >= 3.5 && feel1 < 4.5) {
                        QCMainWindow.Int5.setIcon(image4);
                    }
                    if (feel1 >= 4.5 && feel1 < 5.5) {
                        QCMainWindow.Int5.setIcon(image5);
                    }
                    if (feel1 >= 5.5 && feel1 < 6.5) {
                        QCMainWindow.Int5.setIcon(image6);
                    }
                    if (feel1 >= 6.5 && feel1 < 7.5) {
                        QCMainWindow.Int5.setIcon(image7);
                    }
                    if (feel1 >= 7.5 && feel1 < 8.5) {
                        QCMainWindow.Int5.setIcon(image8);
                    }
                    if (feel1 >= 8.5 && feel1 < 9.5) {
                        QCMainWindow.Int5.setIcon(image9);
                    }
                    if (feel1 >= 9.5 && feel1 < 10.5) {
                        QCMainWindow.Int5.setIcon(image10);
                    }
                    if (feel1 >= 10.5 && feel1 < 11.5) {
                        QCMainWindow.Int5.setIcon(image11);
                    }
                    if (feel1 >= 11.5 && feel1 < 12.5) {
                        QCMainWindow.Int5.setIcon(image12);
                    }
                    if (feel1 > 12.5) {
                        QCMainWindow.Int5.setIcon(image12);
                    }
                    QCMainWindow.jLabel43.setText("发震时刻: " + getCencDate);
                    QCMainWindow.jLabel44.setText("M" + getCencMag);
                    QCMainWindow.Int5.setSize(75, 86);
                    QCMainWindow.Int5.setLocation(0, -7);
                    QCMainWindow.cencPanel5.add(QCMainWindow.Int5);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // cenc 7
                try {
                    String getCencRegion = json6.getString("location");
                    String getCencDepth = json6.getString("depth");
                    String getCencMag = json6.getString("magnitude");
                    String getCencDate = json6.getString("time");
                    QCMainWindow.jLabel45.setText(getCencRegion);
                    QCMainWindow.jLabel46.setText("震源深度: " + getCencDepth + "公里");
                    double feel1 = AppUtils.calcMaxInt(Double.parseDouble(Objects.requireNonNull(getCencMag)), Double.parseDouble(Objects.requireNonNull(getCencDepth)));
                    if (feel1 >= 0.0 && feel1 < 1.5) {
                        QCMainWindow.Int6.setIcon(image1);
                    }
                    if (feel1 >= 1.5 && feel1 < 2.5) {
                        QCMainWindow.Int6.setIcon(image2);
                    }
                    if (feel1 >= 2.5 && feel1 < 3.5) {
                        QCMainWindow.Int6.setIcon(image3);
                    }
                    if (feel1 >= 3.5 && feel1 < 4.5) {
                        QCMainWindow.Int6.setIcon(image4);
                    }
                    if (feel1 >= 4.5 && feel1 < 5.5) {
                        QCMainWindow.Int6.setIcon(image5);
                    }
                    if (feel1 >= 5.5 && feel1 < 6.5) {
                        QCMainWindow.Int6.setIcon(image6);
                    }
                    if (feel1 >= 6.5 && feel1 < 7.5) {
                        QCMainWindow.Int6.setIcon(image7);
                    }
                    if (feel1 >= 7.5 && feel1 < 8.5) {
                        QCMainWindow.Int6.setIcon(image8);
                    }
                    if (feel1 >= 8.5 && feel1 < 9.5) {
                        QCMainWindow.Int6.setIcon(image9);
                    }
                    if (feel1 >= 9.5 && feel1 < 10.5) {
                        QCMainWindow.Int6.setIcon(image10);
                    }
                    if (feel1 >= 10.5 && feel1 < 11.5) {
                        QCMainWindow.Int6.setIcon(image11);
                    }
                    if (feel1 >= 11.5 && feel1 < 12.5) {
                        QCMainWindow.Int6.setIcon(image12);
                    }
                    if (feel1 > 12.5) {
                        QCMainWindow.Int6.setIcon(image12);
                    }
                    QCMainWindow.jLabel47.setText("发震时刻: " + getCencDate);
                    QCMainWindow.jLabel48.setText("M" + getCencMag);
                    QCMainWindow.Int6.setSize(75, 86);
                    QCMainWindow.Int6.setLocation(0, -7);
                    QCMainWindow.cencPanel6.add(QCMainWindow.Int6);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                QCMainWindow.jPanel2.updateUI();

                if (!Objects.equals(json.getString("eventId"), id)) {
                    SoundUtil soundUtil = new SoundUtil();
                    soundUtil.playSound("sounds\\new.wav");
                    AppTray.showMessage("中国地震台网" + json.getString("infoTypeName"), json.getString("shockTime") + "在" + json.getString("placeName") + "(北纬" + json.getString("latitude") + "度,东经" + json.getString("longitude") + "度)" + "发生" + json.getString("magnitude") + "级地震,震源深度" + json.getString("depth") + "公里,预估最大烈度" + AppUtils.decimalFormat.format(AppUtils.calcMaxInt(Double.parseDouble(Objects.requireNonNull(json.getString("magnitude"))), Double.parseDouble(Objects.requireNonNull(json.getString("depth"))))) + "度");
                    id = json.getString("eventId");
                }
            }
        };
        new Timer().schedule(timerTask1,0L,1000L);
    }
}
