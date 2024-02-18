package cn.leafpeach.liteapp.gui;

import cn.leafpeach.liteapp.utils.AppUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ShindoImageWindow extends JFrame {
    JPanel jPanel;
    JLabel jLabel;

    public ShindoImageWindow() throws IOException {
        Image image = Toolkit.getDefaultToolkit().getImage("Files\\img\\icon.png");
        setIconImage(image);
        setTitle("最新各地震度分布图");
        setSize(1200,900);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        jPanel = new JPanel();
        jPanel.setSize(1200,900);
        jPanel.setLayout(null);
        jPanel.setBackground(new Color(36, 34, 34, 255));

        String url = "https://typhoon.yahoo.co.jp/weather/jp/earthquake/";
        String encoding = "UTF-8";
        String htmlResource = AppUtils.getHtmlResourceByUrl(url, encoding);
        Document document = Jsoup.parse(htmlResource);
        Elements elements = document.getElementsByTag("img");
        for(Element element : elements){
            String imgSrc = element.attr("src");
            if ((imgSrc.contains("area") && imgSrc.contains("https://weather-pctr.c.yimg.jp/t/weather-img/earthquake"))) {
                URL url1 = new URL(imgSrc);
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
            }
        }

        jLabel.setSize(1200,900);
        jLabel.setLocation(0,0);

        add(jPanel);
        jPanel.add(jLabel);
    }
}
