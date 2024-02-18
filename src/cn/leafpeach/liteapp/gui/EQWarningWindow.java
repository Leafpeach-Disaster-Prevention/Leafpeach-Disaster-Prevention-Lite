package cn.leafpeach.liteapp.gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class EQWarningWindow extends JFrame {
    public static JPanel jPanel;
    public static JLabel jLabel,jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6;
    File file = new File("font\\OPPOSans-B.ttf");
    Font font;
    Font font1;
    Font font2;
    Font font3;

    public EQWarningWindow() {
        Image image = Toolkit.getDefaultToolkit().getImage("Files\\img\\icon.png");
        setIconImage(image);
        setTitle("地震预警");
        setSize(330, 340);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            font = Font.createFont(Font.TRUETYPE_FONT, bufferedInputStream);
            font = font.deriveFont(Font.PLAIN, 18);
            font1 = font.deriveFont(Font.PLAIN, 22);
            font2 = font.deriveFont(Font.PLAIN, 15);
            font3 = font.deriveFont(Font.PLAIN, 50);
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }

        jPanel = new JPanel();
        setContentPane(jPanel);
    }

    public void display() {
        setVisible(true);
        setAlwaysOnTop(true);
        jPanel.setBackground(new Color(19, 15, 15));
        jPanel.setLayout(null);
        jLabel = new JLabel();
        jLabel.setSize(500,40);
        jLabel.setForeground(Color.white);
        jLabel.setFont(font);
        jLabel.setLocation(75,0);
        jLabel.setText("现正发生有感地震");

        jLabel1 = new JLabel();
        jLabel1.setSize(500,40);
        jLabel1.setForeground(Color.white);
        jLabel1.setFont(font1);
        jLabel1.setLocation(60,32);

        jLabel2 = new JLabel();
        jLabel2.setSize(500,40);
        jLabel2.setForeground(Color.gray);
        jLabel2.setFont(font2);
        jLabel2.setLocation(50,54);

        jLabel3 = new JLabel();
        jLabel3.setSize(500,60);
        jLabel3.setForeground(Color.white);
        jLabel3.setFont(font3);
        jLabel3.setLocation(95,95);

        jLabel4 = new JLabel();
        jLabel4.setSize(500,60);
        jLabel4.setForeground(Color.white);
        jLabel4.setFont(font1);
        jLabel4.setLocation(50,136);

        jLabel5 = new JLabel();
        jLabel5.setSize(500,60);
        jLabel5.setForeground(Color.white);
        jLabel5.setFont(font1);
        jLabel5.setLocation(50,177);

        jLabel6 = new JLabel();
        jLabel6.setSize(500,60);
        jLabel6.setForeground(Color.gray);
        jLabel6.setFont(font2);
        jLabel6.setLocation(45,218);
        jLabel6.setText("提示: 倒计时和预估烈度仅供参考");

        jPanel.add(jLabel);
        jPanel.add(jLabel1);
        jPanel.add(jLabel2);
        jPanel.add(jLabel3);
        jPanel.add(jLabel4);
        jPanel.add(jLabel5);
        jPanel.add(jLabel6);
    }
}
