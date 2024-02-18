package cn.leafpeach.liteapp.gui;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class EpiCenterImageWindow extends JFrame {
    JPanel jPanel;
    JLabel jLabel;

    public EpiCenterImageWindow() throws IOException {
        Image image = Toolkit.getDefaultToolkit().getImage("Files\\img\\icon.png");
        setIconImage(image);
        setTitle("NIED Hi-net高感度地震观测网 过去24h震源分布图");
        setSize(696,682);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        jPanel = new JPanel();
        jPanel.setSize(696,682);
        jPanel.setLayout(null);
        jPanel.setBackground(new Color(36, 34, 34, 255));

        String url = "https://www.hinet.bosai.go.jp/hypomap/mapout.php?_area=EXPJPW&_period=24hours";
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

        jLabel.setSize(696,682);
        jLabel.setLocation(0,0);

        add(jPanel);
        jPanel.add(jLabel);
    }
}
