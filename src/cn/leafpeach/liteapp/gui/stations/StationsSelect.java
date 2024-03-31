package cn.leafpeach.liteapp.gui.stations;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class StationsSelect extends JFrame {
    File file = new File("font\\OPPOSans-B.ttf");
    Font font;
    Font font1 = null;
    public StationsSelect() {
        Image image = Toolkit.getDefaultToolkit().getImage("Files\\img\\icon.png");
        setIconImage(image);
        setTitle("地震测站选择");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        setVisible(true);

        // 加载字体
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            font = Font.createFont(Font.TRUETYPE_FONT, bufferedInputStream);
            font1 = font.deriveFont(Font.PLAIN, 14);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(36, 34, 34, 255));
        jPanel.setLayout(null);

        JButton jButton = new JButton();
        jButton.setSize(200,30);
        jButton.setLocation(10,10);
        jButton.setFont(font1);
        jButton.setBackground(Color.gray);
        jButton.setForeground(Color.white);
        jButton.setText("NM_EEDS_00");
        jButton.setBorderPainted(false);
        jButton.addActionListener(e -> new StationDataWindow("NM_EEDS_00"));

        JButton jButton1 = new JButton();
        jButton1.setSize(200,30);
        jButton1.setLocation(10,50);
        jButton1.setFont(font1);
        jButton1.setBackground(Color.gray);
        jButton1.setForeground(Color.white);
        jButton1.setText("CQ_BEB_00");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(e -> new StationDataWindow("CQ_BEB_00"));

        JButton jButton2 = new JButton();
        jButton2.setSize(200,30);
        jButton2.setLocation(10,90);
        jButton2.setFont(font1);
        jButton2.setBackground(Color.gray);
        jButton2.setForeground(Color.white);
        jButton2.setText("SC_CHD_00");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(e -> new StationDataWindow("SC_CHD_00"));

        JButton jButton3 = new JButton();
        jButton3.setSize(200,30);
        jButton3.setLocation(10,130);
        jButton3.setFont(font1);
        jButton3.setBackground(Color.gray);
        jButton3.setForeground(Color.white);
        jButton3.setText("CQ_TOL_00");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(e -> new StationDataWindow("CQ_TOL_00"));

        JButton jButton4 = new JButton();
        jButton4.setSize(200,30);
        jButton4.setLocation(10,170);
        jButton4.setFont(font1);
        jButton4.setBackground(Color.gray);
        jButton4.setForeground(Color.white);
        jButton4.setText("GD_SHZ_00");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(e -> new StationDataWindow("GD_SHZ_00"));

        JButton jButton5 = new JButton();
        jButton5.setSize(200,30);
        jButton5.setLocation(10,210);
        jButton5.setFont(font1);
        jButton5.setBackground(Color.gray);
        jButton5.setForeground(Color.white);
        jButton5.setText("CQ_DAZ_00");
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(e -> new StationDataWindow("CQ_DAZ_00"));

        add(jPanel);
        jPanel.add(jButton);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.add(jButton5);
    }
}
