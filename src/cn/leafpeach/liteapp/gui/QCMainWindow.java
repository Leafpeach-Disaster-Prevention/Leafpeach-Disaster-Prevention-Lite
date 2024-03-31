package cn.leafpeach.liteapp.gui;

import cn.leafpeach.liteapp.QCMain;
import cn.leafpeach.liteapp.app.AppTray;
import cn.leafpeach.liteapp.app.eews.ICLEEW;
import cn.leafpeach.liteapp.gui.lists.IclList;
import cn.leafpeach.liteapp.gui.stations.StationsSelect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class QCMainWindow extends JFrame {
    public static JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel5,iclPanel,iclPanel2,iclPanel3,iclPanel4,iclPanel5,iclPanel6,iclPanel7,cencPanel,cencPanel1,cencPanel2,cencPanel3,cencPanel4,cencPanel5,cencPanel6,jmaPanel,jmaPanel1,jmaPanel2,jmaPanel3,jmaPanel4,jmaPanel5,jmaPanel6,intColor,intColor1,intColor2,intColor3,intColor4,intColor5,intColor6;
    public static JLabel jLabel,jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,jLabel10,jLabel11,jLabel12,jLabel13,jLabel14,jLabel15,jLabel16,jLabel17,jLabel18,jLabel19,jLabel20,jLabel21,jLabel22,jLabel23,jLabel24,jLabel25,jLabel26,jLabel27,jLabel28,jLabel29,jLabel30,jLabel31,jLabel32,jLabel33,jLabel34,jLabel35,jLabel36,jLabel37,jLabel38,jLabel39,jLabel40,jLabel41,jLabel42,jLabel43,jLabel44,jLabel45,jLabel46,jLabel47,jLabel48,jLabel49,jLabel50,jLabel51,jLabel52,jLabel53,jLabel54,jLabel55,jLabel56,jLabel57,jLabel58,jLabel59,jLabel60,jLabel61,jLabel62,jLabel63,jLabel64,jLabel65,jLabel66,jLabel67,jLabel68,jLabel69,jLabel70,jLabel71,jLabel72,jLabel73,jLabel74,jLabel75,jLabel76,tipLabel1,tipLabel2,tipLabel3,Int,Int1,Int2,Int3,Int4,Int5,Int6,shindo,shindo1,shindo2,shindo3,shindo4,shindo5,shindo6,label,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13;
    JTabbedPane jTabbedPane;
    JButton button1,jButton,jButton2,jButton3,jButton4,jButton5,jButton6,jButton7,jButton8,jButton9,jButton10,jButton11;
    File file = new File("font\\OPPOSans-B.ttf");
    File file1 = new File("font\\mplus-2p-bold.ttf");
    Font font = null;
    Font font1 = null;
    Font aboutFont = null;
    Font aboutFont1 = null;
    Font jmaFont = null;
    Font jmaFont1 = null;
    Font jmaFont2 = null;

    public QCMainWindow(String title) {
        super(title);
        Image image = Toolkit.getDefaultToolkit().getImage("Files\\img\\icon.png");
        setIconImage(image);
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        jPanel1 = new JPanel(); // 选项卡1
        jPanel2 = new JPanel(); // 选项卡2
        jPanel3 = new JPanel(); // 选项卡3
        jPanel4 = new JPanel(); // 选项卡4
        jPanel5 = new JPanel(); // 选项卡5

        iclPanel = new JPanel();
        iclPanel2 = new JPanel();
        iclPanel3 = new JPanel();
        iclPanel4 = new JPanel();
        iclPanel5 = new JPanel();
        iclPanel6 = new JPanel();
        iclPanel7 = new JPanel();

        cencPanel = new JPanel();
        cencPanel1 = new JPanel();
        cencPanel2 = new JPanel();
        cencPanel3 = new JPanel();
        cencPanel4 = new JPanel();
        cencPanel5 = new JPanel();
        cencPanel6 = new JPanel();

        jmaPanel = new JPanel();
        jmaPanel1 = new JPanel();
        jmaPanel2 = new JPanel();
        jmaPanel3 = new JPanel();
        jmaPanel4 = new JPanel();
        jmaPanel5 = new JPanel();
        jmaPanel6 = new JPanel();

        jTabbedPane = new JTabbedPane();

        // 右键菜单
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem jMenuItem = new JMenuItem("退出程序");
        JMenuItem jMenuItem1 = new JMenuItem("设置");
        jMenuItem.setFont(new Font("微软雅黑",Font.BOLD,12));
        jMenuItem.addActionListener(e -> System.exit(1));
        jMenuItem1.setFont(new Font("微软雅黑",Font.BOLD,12));
        jMenuItem1.addActionListener(e -> new SettingsDialog());
        jPopupMenu.add(jMenuItem1);
        jPopupMenu.add(jMenuItem);

        // 右键菜单事件监听器
        jPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(jPanel1,e.getX(),e.getY());
                }
            }
        });
        jPanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(jPanel2,e.getX(),e.getY());
                }
            }
        });
        jPanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(jPanel3,e.getX(),e.getY());
                }
            }
        });
        jPanel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(jPanel4,e.getX(),e.getY());
                }
            }
        });
        jPanel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(jPanel5,e.getX(),e.getY());
                }
            }
        });

        // 窗口关闭事件监听器
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AppTray.showMessage("提示","软件正在后台运行,左键点击托盘图标可显示程序主窗口,右键点击托盘图标可显示选项。");
            }
        });
    }

    public void displayWindow() {
        jPanel1.setLayout(null);
        jPanel2.setLayout(null);
        jPanel3.setLayout(null);
        jPanel4.setLayout(null);
        jPanel5.setLayout(null);
        iclPanel.setLayout(null);
        iclPanel2.setLayout(null);
        iclPanel3.setLayout(null);
        iclPanel4.setLayout(null);
        iclPanel5.setLayout(null);
        iclPanel6.setLayout(null);
        iclPanel7.setLayout(null);
        cencPanel.setLayout(null);
        cencPanel1.setLayout(null);
        cencPanel2.setLayout(null);
        cencPanel3.setLayout(null);
        cencPanel4.setLayout(null);
        cencPanel5.setLayout(null);
        cencPanel6.setLayout(null);
        jmaPanel.setLayout(null);
        jmaPanel1.setLayout(null);
        jmaPanel2.setLayout(null);
        jmaPanel3.setLayout(null);
        jmaPanel4.setLayout(null);
        jmaPanel5.setLayout(null);
        jmaPanel6.setLayout(null);

        jTabbedPane.addTab("预警列表", jPanel1);
        jTabbedPane.addTab("台网列表", jPanel2);
        jTabbedPane.addTab("JMA详情列表", jPanel3);
        jTabbedPane.addTab("关于", jPanel4);
        jTabbedPane.addTab("其他功能", jPanel5);

        setContentPane(jTabbedPane);

        jPanel1.setBackground(new Color(36, 34, 34, 255));
        jPanel2.setBackground(new Color(36, 34, 34, 255));
        jPanel3.setBackground(new Color(36, 34, 34, 255));
        jPanel4.setBackground(new Color(36, 34, 34, 255));
        jPanel5.setBackground(new Color(36, 34, 34, 255));

        // 加载字体
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileInputStream fileInputStream1 = new FileInputStream(file1);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedInputStream bufferedInputStream1 = new BufferedInputStream(fileInputStream1);
            font = Font.createFont(Font.TRUETYPE_FONT, bufferedInputStream);
            font = font.deriveFont(Font.PLAIN, 20);
            font1 = font.deriveFont(Font.PLAIN, 14);
            aboutFont = font.deriveFont(Font.PLAIN, 15);
            aboutFont1 = font.deriveFont(Font.PLAIN, 24);
            jmaFont = Font.createFont(Font.TRUETYPE_FONT, bufferedInputStream1);
            jmaFont = jmaFont.deriveFont(Font.PLAIN, 20);
            jmaFont1 = jmaFont.deriveFont(Font.PLAIN, 14);
            jmaFont2 = jmaFont.deriveFont(Font.PLAIN, 24);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // icl 1
        iclPanel.setBackground(new Color(19, 15, 15));
        iclPanel.setSize(500,75);
        jLabel = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        intColor = new JPanel();
        jButton = new JButton();

        // icl 1 style
        jLabel.setSize(500,40);
        jLabel.setForeground(Color.white);
        jLabel.setFont(font);
        jLabel.setLocation(60,0);
        jLabel1.setSize(500,40);
        jLabel1.setForeground(Color.white);
        jLabel1.setFont(font1);
        jLabel1.setLocation(60,20);
        jLabel2.setSize(500,40);
        jLabel2.setForeground(Color.gray);
        jLabel2.setFont(font1);
        jLabel2.setLocation(60,40);
        intColor.setSize(40,75);
        intColor.setLocation(0,0);
        jButton.setSize(100,30);
        jButton.setLocation(350,20);
        jButton.setFont(font1);
        jButton.setBackground(Color.gray);
        jButton.setForeground(Color.white);
        jButton.setText("详情");
        jButton.setBorderPainted(false);
        jButton.addActionListener(e -> {
            try {
                new EarthQuakeInfoWindow(0);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        iclPanel.add(jLabel);
        iclPanel.add(jLabel1);
        iclPanel.add(jLabel2);
        iclPanel.add(intColor);
        iclPanel.add(jButton);

        // icl 2
        iclPanel2.setBackground(new Color(19, 15, 15));
        iclPanel2.setSize(500,75);
        iclPanel2.setLocation(0,80);
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        intColor1 = new JPanel();
        jButton2 = new JButton();

        // icl 2 style
        jLabel3.setSize(500,40);
        jLabel3.setForeground(Color.white);
        jLabel3.setFont(font);
        jLabel3.setLocation(60,0);
        jLabel4.setSize(500,40);
        jLabel4.setForeground(Color.white);
        jLabel4.setFont(font1);
        jLabel4.setLocation(60,20);
        jLabel5.setSize(500,40);
        jLabel5.setForeground(Color.gray);
        jLabel5.setFont(font1);
        jLabel5.setLocation(60,40);
        intColor1.setSize(40,75);
        intColor1.setLocation(0,0);
        jButton2.setSize(100,30);
        jButton2.setLocation(350,20);
        jButton2.setFont(font1);
        jButton2.setBackground(Color.gray);
        jButton2.setForeground(Color.white);
        jButton2.setText("详情");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(e -> {
            try {
                new EarthQuakeInfoWindow(1);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        iclPanel2.add(jLabel3);
        iclPanel2.add(jLabel4);
        iclPanel2.add(jLabel5);
        iclPanel2.add(intColor1);
        iclPanel2.add(jButton2);

        // icl 3
        iclPanel3.setBackground(new Color(19, 15, 15));
        iclPanel3.setSize(500,75);
        iclPanel3.setLocation(0,160);
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        intColor2 = new JPanel();
        jButton3 = new JButton();

        // icl 3 style
        jLabel6.setSize(500,40);
        jLabel6.setForeground(Color.white);
        jLabel6.setFont(font);
        jLabel6.setLocation(60,0);
        jLabel7.setSize(500,40);
        jLabel7.setForeground(Color.white);
        jLabel7.setFont(font1);
        jLabel7.setLocation(60,20);
        jLabel8.setSize(500,40);
        jLabel8.setForeground(Color.gray);
        jLabel8.setFont(font1);
        jLabel8.setLocation(60,40);
        intColor2.setSize(40,75);
        intColor2.setLocation(0,0);
        jButton3.setSize(100,30);
        jButton3.setLocation(350,20);
        jButton3.setFont(font1);
        jButton3.setBackground(Color.gray);
        jButton3.setForeground(Color.white);
        jButton3.setText("详情");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(e -> {
            try {
                new EarthQuakeInfoWindow(2);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        iclPanel3.add(jLabel6);
        iclPanel3.add(jLabel7);
        iclPanel3.add(jLabel8);
        iclPanel3.add(intColor2);
        iclPanel3.add(jButton3);

        // icl 4
        iclPanel4.setBackground(new Color(19, 15, 15));
        iclPanel4.setSize(500,75);
        iclPanel4.setLocation(0,240);
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        intColor3 = new JPanel();
        jButton4 = new JButton();

        // icl 4 style
        jLabel9.setSize(500,40);
        jLabel9.setForeground(Color.white);
        jLabel9.setFont(font);
        jLabel9.setLocation(60,0);
        jLabel10.setSize(500,40);
        jLabel10.setForeground(Color.white);
        jLabel10.setFont(font1);
        jLabel10.setLocation(60,20);
        jLabel11.setSize(500,40);
        jLabel11.setForeground(Color.gray);
        jLabel11.setFont(font1);
        jLabel11.setLocation(60,40);
        intColor3.setSize(40,75);
        intColor3.setLocation(0,0);
        jButton4.setSize(100,30);
        jButton4.setLocation(350,20);
        jButton4.setFont(font1);
        jButton4.setBackground(Color.gray);
        jButton4.setForeground(Color.white);
        jButton4.setText("详情");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(e -> {
            try {
                new EarthQuakeInfoWindow(3);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        iclPanel4.add(jLabel9);
        iclPanel4.add(jLabel10);
        iclPanel4.add(jLabel11);
        iclPanel4.add(intColor3);
        iclPanel4.add(jButton4);

        // icl 5
        iclPanel5.setBackground(new Color(19, 15, 15));
        iclPanel5.setSize(500,75);
        iclPanel5.setLocation(0,320);
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        intColor4 = new JPanel();
        jButton5 = new JButton();

        // icl 5 style
        jLabel12.setSize(500,40);
        jLabel12.setForeground(Color.white);
        jLabel12.setFont(font);
        jLabel12.setLocation(60,0);
        jLabel13.setSize(500,40);
        jLabel13.setForeground(Color.white);
        jLabel13.setFont(font1);
        jLabel13.setLocation(60,20);
        jLabel14.setSize(500,40);
        jLabel14.setForeground(Color.gray);
        jLabel14.setFont(font1);
        jLabel14.setLocation(60,40);
        intColor4.setSize(40,75);
        intColor4.setLocation(0,0);
        jButton5.setSize(100,30);
        jButton5.setLocation(350,20);
        jButton5.setFont(font1);
        jButton5.setBackground(Color.gray);
        jButton5.setForeground(Color.white);
        jButton5.setText("详情");
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(e -> {
            try {
                new EarthQuakeInfoWindow(4);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        iclPanel5.add(jLabel12);
        iclPanel5.add(jLabel13);
        iclPanel5.add(jLabel14);
        iclPanel5.add(intColor4);
        iclPanel5.add(jButton5);

        // icl 6
        iclPanel6.setBackground(new Color(19, 15, 15));
        iclPanel6.setSize(500,75);
        iclPanel6.setLocation(0,400);
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        intColor5 = new JPanel();
        jButton6 = new JButton();

        // icl 6 style
        jLabel15.setSize(500,40);
        jLabel15.setForeground(Color.white);
        jLabel15.setFont(font);
        jLabel15.setLocation(60,0);
        jLabel16.setSize(500,40);
        jLabel16.setForeground(Color.white);
        jLabel16.setFont(font1);
        jLabel16.setLocation(60,20);
        jLabel17.setSize(500,40);
        jLabel17.setForeground(Color.gray);
        jLabel17.setFont(font1);
        jLabel17.setLocation(60,40);
        intColor5.setSize(40,75);
        intColor5.setLocation(0,0);
        jButton6.setSize(100,30);
        jButton6.setLocation(350,20);
        jButton6.setFont(font1);
        jButton6.setBackground(Color.gray);
        jButton6.setForeground(Color.white);
        jButton6.setText("详情");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(e -> {
            try {
                new EarthQuakeInfoWindow(5);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        iclPanel6.add(jLabel15);
        iclPanel6.add(jLabel16);
        iclPanel6.add(jLabel17);
        iclPanel6.add(intColor5);
        iclPanel6.add(jButton6);

        // icl 7
        iclPanel7.setBackground(new Color(19, 15, 15));
        iclPanel7.setSize(500,75);
        iclPanel7.setLocation(0,480);
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        intColor6 = new JPanel();
        jButton7 = new JButton();

        // icl 7 style
        jLabel18.setSize(500,40);
        jLabel18.setForeground(Color.white);
        jLabel18.setFont(font);
        jLabel18.setLocation(60,0);
        jLabel19.setSize(500,40);
        jLabel19.setForeground(Color.white);
        jLabel19.setFont(font1);
        jLabel19.setLocation(60,20);
        jLabel20.setSize(500,40);
        jLabel20.setForeground(Color.gray);
        jLabel20.setFont(font1);
        jLabel20.setLocation(60,40);
        intColor6.setSize(40,75);
        intColor6.setLocation(0,0);
        jButton7.setSize(100,30);
        jButton7.setLocation(350,20);
        jButton7.setFont(font1);
        jButton7.setBackground(Color.gray);
        jButton7.setForeground(Color.white);
        jButton7.setText("详情");
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(e -> {
            try {
                new EarthQuakeInfoWindow(6);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        iclPanel7.add(jLabel18);
        iclPanel7.add(jLabel19);
        iclPanel7.add(jLabel20);
        iclPanel7.add(intColor6);
        iclPanel7.add(jButton7);

        // tip1
        tipLabel1 = new JLabel();
        tipLabel1.setSize(500,40);
        tipLabel1.setForeground(Color.gray);
        tipLabel1.setFont(font1);
        tipLabel1.setLocation(120,550);
        tipLabel1.setText("更多预警历史请至官方预警app查看");

        // button1
        button1 = new JButton();
        button1.setSize(100,30);
        button1.setLocation(190,580);
        button1.setFont(font1);
        button1.setBackground(Color.gray);
        button1.setForeground(Color.white);
        button1.setText("刷新页面");
        button1.setBorderPainted(false);
        button1.addActionListener(e -> {
            try {
                IclList.timerTask.cancel();
                IclList.load();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        jPanel1.add(iclPanel);
        jPanel1.add(iclPanel2);
        jPanel1.add(iclPanel3);
        jPanel1.add(iclPanel4);
        jPanel1.add(iclPanel5);
        jPanel1.add(iclPanel6);
        jPanel1.add(iclPanel7);
        jPanel1.add(tipLabel1);
        jPanel1.add(button1);

        // cenc 1
        cencPanel.setBackground(new Color(19, 15, 15));
        cencPanel.setSize(500,75);
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        jLabel24 = new JLabel();
        Int = new JLabel();

        // cenc 1 style
        jLabel21.setSize(500,40);
        jLabel21.setForeground(Color.white);
        jLabel21.setFont(font);
        jLabel21.setLocation(90,0);
        jLabel22.setSize(500,40);
        jLabel22.setForeground(Color.white);
        jLabel22.setFont(font1);
        jLabel22.setLocation(90,20);
        jLabel23.setSize(500,40);
        jLabel23.setForeground(Color.gray);
        jLabel23.setFont(font1);
        jLabel23.setLocation(90,40);
        jLabel24.setSize(500,40);
        jLabel24.setForeground(Color.white);
        jLabel24.setFont(font);
        jLabel24.setLocation(400,40);
        cencPanel.add(jLabel21);
        cencPanel.add(jLabel22);
        cencPanel.add(jLabel23);
        cencPanel.add(jLabel24);

        // cenc 2
        cencPanel1.setBackground(new Color(19, 15, 15));
        cencPanel1.setSize(500,75);
        cencPanel1.setLocation(0,80);
        jLabel25 = new JLabel();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        jLabel28 = new JLabel();
        Int1 = new JLabel();

        // cenc 2 style
        jLabel25.setSize(500,40);
        jLabel25.setForeground(Color.white);
        jLabel25.setFont(font);
        jLabel25.setLocation(90,0);
        jLabel26.setSize(500,40);
        jLabel26.setForeground(Color.white);
        jLabel26.setFont(font1);
        jLabel26.setLocation(90,20);
        jLabel27.setSize(500,40);
        jLabel27.setForeground(Color.gray);
        jLabel27.setFont(font1);
        jLabel27.setLocation(90,40);
        jLabel28.setSize(500,40);
        jLabel28.setForeground(Color.white);
        jLabel28.setFont(font);
        jLabel28.setLocation(400,40);
        cencPanel1.add(jLabel25);
        cencPanel1.add(jLabel26);
        cencPanel1.add(jLabel27);
        cencPanel1.add(jLabel28);

        // cenc 3
        cencPanel2.setBackground(new Color(19, 15, 15));
        cencPanel2.setSize(500,75);
        cencPanel2.setLocation(0,160);
        jLabel29 = new JLabel();
        jLabel30 = new JLabel();
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();
        Int2 = new JLabel();

        // cenc 3 style
        jLabel29.setSize(500,40);
        jLabel29.setForeground(Color.white);
        jLabel29.setFont(font);
        jLabel29.setLocation(90,0);
        jLabel30.setSize(500,40);
        jLabel30.setForeground(Color.white);
        jLabel30.setFont(font1);
        jLabel30.setLocation(90,20);
        jLabel31.setSize(500,40);
        jLabel31.setForeground(Color.gray);
        jLabel31.setFont(font1);
        jLabel31.setLocation(90,40);
        jLabel32.setSize(500,40);
        jLabel32.setForeground(Color.white);
        jLabel32.setFont(font);
        jLabel32.setLocation(400,40);
        cencPanel2.add(jLabel29);
        cencPanel2.add(jLabel30);
        cencPanel2.add(jLabel31);
        cencPanel2.add(jLabel32);

        // cenc 4
        cencPanel3.setBackground(new Color(19, 15, 15));
        cencPanel3.setSize(500,75);
        cencPanel3.setLocation(0,240);
        jLabel33 = new JLabel();
        jLabel34 = new JLabel();
        jLabel35 = new JLabel();
        jLabel36 = new JLabel();
        Int3 = new JLabel();

        // cenc 4 style
        jLabel33.setSize(500,40);
        jLabel33.setForeground(Color.white);
        jLabel33.setFont(font);
        jLabel33.setLocation(90,0);
        jLabel34.setSize(500,40);
        jLabel34.setForeground(Color.white);
        jLabel34.setFont(font1);
        jLabel34.setLocation(90,20);
        jLabel35.setSize(500,40);
        jLabel35.setForeground(Color.gray);
        jLabel35.setFont(font1);
        jLabel35.setLocation(90,40);
        jLabel36.setSize(500,40);
        jLabel36.setForeground(Color.white);
        jLabel36.setFont(font);
        jLabel36.setLocation(400,40);
        cencPanel3.add(jLabel33);
        cencPanel3.add(jLabel34);
        cencPanel3.add(jLabel35);
        cencPanel3.add(jLabel36);

        // cenc 5
        cencPanel4.setBackground(new Color(19, 15, 15));
        cencPanel4.setSize(500,75);
        cencPanel4.setLocation(0,320);
        jLabel37 = new JLabel();
        jLabel38 = new JLabel();
        jLabel39 = new JLabel();
        jLabel40 = new JLabel();
        Int4 = new JLabel();

        // cenc 5 style
        jLabel37.setSize(500,40);
        jLabel37.setForeground(Color.white);
        jLabel37.setFont(font);
        jLabel37.setLocation(90,0);
        jLabel38.setSize(500,40);
        jLabel38.setForeground(Color.white);
        jLabel38.setFont(font1);
        jLabel38.setLocation(90,20);
        jLabel39.setSize(500,40);
        jLabel39.setForeground(Color.gray);
        jLabel39.setFont(font1);
        jLabel39.setLocation(90,40);
        jLabel40.setSize(500,40);
        jLabel40.setForeground(Color.white);
        jLabel40.setFont(font);
        jLabel40.setLocation(400,40);
        cencPanel4.add(jLabel37);
        cencPanel4.add(jLabel38);
        cencPanel4.add(jLabel39);
        cencPanel4.add(jLabel40);

        // cenc 6
        cencPanel5.setBackground(new Color(19, 15, 15));
        cencPanel5.setSize(500,75);
        cencPanel5.setLocation(0,400);
        jLabel41 = new JLabel();
        jLabel42 = new JLabel();
        jLabel43 = new JLabel();
        jLabel44 = new JLabel();
        Int5 = new JLabel();

        // cenc 6 style
        jLabel41.setSize(500,40);
        jLabel41.setForeground(Color.white);
        jLabel41.setFont(font);
        jLabel41.setLocation(90,0);
        jLabel42.setSize(500,40);
        jLabel42.setForeground(Color.white);
        jLabel42.setFont(font1);
        jLabel42.setLocation(90,20);
        jLabel43.setSize(500,40);
        jLabel43.setForeground(Color.gray);
        jLabel43.setFont(font1);
        jLabel43.setLocation(90,40);
        jLabel44.setSize(500,40);
        jLabel44.setForeground(Color.white);
        jLabel44.setFont(font);
        jLabel44.setLocation(400,40);
        cencPanel5.add(jLabel41);
        cencPanel5.add(jLabel42);
        cencPanel5.add(jLabel43);
        cencPanel5.add(jLabel44);

        // cenc 7
        cencPanel6.setBackground(new Color(19, 15, 15));
        cencPanel6.setSize(500,75);
        cencPanel6.setLocation(0,480);
        jLabel45 = new JLabel();
        jLabel46 = new JLabel();
        jLabel47 = new JLabel();
        jLabel48 = new JLabel();
        Int6 = new JLabel();

        // cenc 7 style
        jLabel45.setSize(500,40);
        jLabel45.setForeground(Color.white);
        jLabel45.setFont(font);
        jLabel45.setLocation(90,0);
        jLabel46.setSize(500,40);
        jLabel46.setForeground(Color.white);
        jLabel46.setFont(font1);
        jLabel46.setLocation(90,20);
        jLabel47.setSize(500,40);
        jLabel47.setForeground(Color.gray);
        jLabel47.setFont(font1);
        jLabel47.setLocation(90,40);
        jLabel48.setSize(500,40);
        jLabel48.setForeground(Color.white);
        jLabel48.setFont(font);
        jLabel48.setLocation(400,40);
        cencPanel6.add(jLabel45);
        cencPanel6.add(jLabel46);
        cencPanel6.add(jLabel47);
        cencPanel6.add(jLabel48);

        // tip2
        tipLabel2 = new JLabel();
        tipLabel2.setSize(500,40);
        tipLabel2.setForeground(Color.gray);
        tipLabel2.setFont(font1);
        tipLabel2.setLocation(120,550);
        tipLabel2.setText("注: 列表左侧的数字表示预估最大烈度");

        jPanel2.add(cencPanel);
        jPanel2.add(cencPanel1);
        jPanel2.add(cencPanel2);
        jPanel2.add(cencPanel3);
        jPanel2.add(cencPanel4);
        jPanel2.add(cencPanel5);
        jPanel2.add(cencPanel6);
        jPanel2.add(tipLabel2);

        // jma 1
        jmaPanel.setBackground(new Color(19, 15, 15));
        jmaPanel.setSize(500,75);
        jLabel49 = new JLabel();
        jLabel50 = new JLabel();
        jLabel51 = new JLabel();
        jLabel52 = new JLabel();
        shindo = new JLabel();

        // jma 1 style
        jLabel49.setSize(500,40);
        jLabel49.setForeground(Color.white);
        jLabel49.setFont(jmaFont);
        jLabel49.setLocation(90,0);
        jLabel50.setSize(500,40);
        jLabel50.setForeground(Color.white);
        jLabel50.setFont(jmaFont1);
        jLabel50.setLocation(90,20);
        jLabel51.setSize(500,40);
        jLabel51.setForeground(Color.gray);
        jLabel51.setFont(jmaFont1);
        jLabel51.setLocation(90,40);
        jLabel52.setSize(500,40);
        jLabel52.setForeground(Color.white);
        jLabel52.setFont(jmaFont2);
        jLabel52.setLocation(400,40);
        jmaPanel.add(jLabel49);
        jmaPanel.add(jLabel50);
        jmaPanel.add(jLabel51);
        jmaPanel.add(jLabel52);

        // jma 2
        jmaPanel1.setBackground(new Color(19, 15, 15));
        jmaPanel1.setSize(500,75);
        jmaPanel1.setLocation(0,80);
        jLabel53 = new JLabel();
        jLabel54 = new JLabel();
        jLabel55 = new JLabel();
        jLabel56 = new JLabel();
        shindo1 = new JLabel();

        // jma 2 style
        jLabel53.setSize(500,40);
        jLabel53.setForeground(Color.white);
        jLabel53.setFont(jmaFont);
        jLabel53.setLocation(90,0);
        jLabel54.setSize(500,40);
        jLabel54.setForeground(Color.white);
        jLabel54.setFont(jmaFont1);
        jLabel54.setLocation(90,20);
        jLabel55.setSize(500,40);
        jLabel55.setForeground(Color.gray);
        jLabel55.setFont(jmaFont1);
        jLabel55.setLocation(90,40);
        jLabel56.setSize(500,40);
        jLabel56.setForeground(Color.white);
        jLabel56.setFont(jmaFont2);
        jLabel56.setLocation(400,40);
        jmaPanel1.add(jLabel53);
        jmaPanel1.add(jLabel54);
        jmaPanel1.add(jLabel55);
        jmaPanel1.add(jLabel56);

        // jma 3
        jmaPanel2.setBackground(new Color(19, 15, 15));
        jmaPanel2.setSize(500,75);
        jmaPanel2.setLocation(0,160);
        jLabel57 = new JLabel();
        jLabel58 = new JLabel();
        jLabel59 = new JLabel();
        jLabel60 = new JLabel();
        shindo2 = new JLabel();

        // jma 3 style
        jLabel57.setSize(500,40);
        jLabel57.setForeground(Color.white);
        jLabel57.setFont(jmaFont);
        jLabel57.setLocation(90,0);
        jLabel58.setSize(500,40);
        jLabel58.setForeground(Color.white);
        jLabel58.setFont(jmaFont1);
        jLabel58.setLocation(90,20);
        jLabel59.setSize(500,40);
        jLabel59.setForeground(Color.gray);
        jLabel59.setFont(jmaFont1);
        jLabel59.setLocation(90,40);
        jLabel60.setSize(500,40);
        jLabel60.setForeground(Color.white);
        jLabel60.setFont(jmaFont2);
        jLabel60.setLocation(400,40);
        jmaPanel2.add(jLabel57);
        jmaPanel2.add(jLabel58);
        jmaPanel2.add(jLabel59);
        jmaPanel2.add(jLabel60);

        // jma 4
        jmaPanel3.setBackground(new Color(19, 15, 15));
        jmaPanel3.setSize(500,75);
        jmaPanel3.setLocation(0,240);
        jLabel61 = new JLabel();
        jLabel62 = new JLabel();
        jLabel63 = new JLabel();
        jLabel64 = new JLabel();
        shindo3 = new JLabel();

        // jma 4 style
        jLabel61.setSize(500,40);
        jLabel61.setForeground(Color.white);
        jLabel61.setFont(jmaFont);
        jLabel61.setLocation(90,0);
        jLabel62.setSize(500,40);
        jLabel62.setForeground(Color.white);
        jLabel62.setFont(jmaFont1);
        jLabel62.setLocation(90,20);
        jLabel63.setSize(500,40);
        jLabel63.setForeground(Color.gray);
        jLabel63.setFont(jmaFont1);
        jLabel63.setLocation(90,40);
        jLabel64.setSize(500,40);
        jLabel64.setForeground(Color.white);
        jLabel64.setFont(jmaFont2);
        jLabel64.setLocation(400,40);
        jmaPanel3.add(jLabel61);
        jmaPanel3.add(jLabel62);
        jmaPanel3.add(jLabel63);
        jmaPanel3.add(jLabel64);

        // jma 5
        jmaPanel4.setBackground(new Color(19, 15, 15));
        jmaPanel4.setSize(500,75);
        jmaPanel4.setLocation(0,320);
        jLabel65 = new JLabel();
        jLabel66 = new JLabel();
        jLabel67 = new JLabel();
        jLabel68 = new JLabel();
        shindo4 = new JLabel();

        // jma 5 style
        jLabel65.setSize(500,40);
        jLabel65.setForeground(Color.white);
        jLabel65.setFont(jmaFont);
        jLabel65.setLocation(90,0);
        jLabel66.setSize(500,40);
        jLabel66.setForeground(Color.white);
        jLabel66.setFont(jmaFont1);
        jLabel66.setLocation(90,20);
        jLabel67.setSize(500,40);
        jLabel67.setForeground(Color.gray);
        jLabel67.setFont(jmaFont1);
        jLabel67.setLocation(90,40);
        jLabel68.setSize(500,40);
        jLabel68.setForeground(Color.white);
        jLabel68.setFont(jmaFont2);
        jLabel68.setLocation(400,40);
        jmaPanel4.add(jLabel65);
        jmaPanel4.add(jLabel66);
        jmaPanel4.add(jLabel67);
        jmaPanel4.add(jLabel68);

        // jma 6
        jmaPanel5.setBackground(new Color(19, 15, 15));
        jmaPanel5.setSize(500,75);
        jmaPanel5.setLocation(0,400);
        jLabel69 = new JLabel();
        jLabel70 = new JLabel();
        jLabel71 = new JLabel();
        jLabel72 = new JLabel();
        shindo5 = new JLabel();

        // jma 6 style
        jLabel69.setSize(500,40);
        jLabel69.setForeground(Color.white);
        jLabel69.setFont(jmaFont);
        jLabel69.setLocation(90,0);
        jLabel70.setSize(500,40);
        jLabel70.setForeground(Color.white);
        jLabel70.setFont(jmaFont1);
        jLabel70.setLocation(90,20);
        jLabel71.setSize(500,40);
        jLabel71.setForeground(Color.gray);
        jLabel71.setFont(jmaFont1);
        jLabel71.setLocation(90,40);
        jLabel72.setSize(500,40);
        jLabel72.setForeground(Color.white);
        jLabel72.setFont(jmaFont2);
        jLabel72.setLocation(400,40);
        jmaPanel5.add(jLabel69);
        jmaPanel5.add(jLabel70);
        jmaPanel5.add(jLabel71);
        jmaPanel5.add(jLabel72);

        // jma 7
        jmaPanel6.setBackground(new Color(19, 15, 15));
        jmaPanel6.setSize(500,75);
        jmaPanel6.setLocation(0,480);
        jLabel73 = new JLabel();
        jLabel74 = new JLabel();
        jLabel75 = new JLabel();
        jLabel76 = new JLabel();
        shindo6 = new JLabel();

        // jma 7 style
        jLabel73.setSize(500,40);
        jLabel73.setForeground(Color.white);
        jLabel73.setFont(jmaFont);
        jLabel73.setLocation(90,0);
        jLabel74.setSize(500,40);
        jLabel74.setForeground(Color.white);
        jLabel74.setFont(jmaFont1);
        jLabel74.setLocation(90,20);
        jLabel75.setSize(500,40);
        jLabel75.setForeground(Color.gray);
        jLabel75.setFont(jmaFont1);
        jLabel75.setLocation(90,40);
        jLabel76.setSize(500,40);
        jLabel76.setForeground(Color.white);
        jLabel76.setFont(jmaFont2);
        jLabel76.setLocation(400,40);
        jmaPanel6.add(jLabel73);
        jmaPanel6.add(jLabel74);
        jmaPanel6.add(jLabel75);
        jmaPanel6.add(jLabel76);

        // tip3
        tipLabel3 = new JLabel();
        tipLabel3.setSize(500,40);
        tipLabel3.setForeground(Color.gray);
        tipLabel3.setFont(font1);
        tipLabel3.setLocation(120,550);
        tipLabel3.setText("注: 列表左侧的数字表示最大震度");

        jPanel3.add(jmaPanel);
        jPanel3.add(jmaPanel1);
        jPanel3.add(jmaPanel2);
        jPanel3.add(jmaPanel3);
        jPanel3.add(jmaPanel4);
        jPanel3.add(jmaPanel5);
        jPanel3.add(jmaPanel6);
        jPanel3.add(tipLabel3);

        // 关于页面
        label = new JLabel();
        label.setSize(500,40);
        label.setForeground(Color.white);
        label.setFont(aboutFont1);
        label.setLocation(130,0);
        label.setText("叶桃防灾Lite v" + QCMain.version);

        label1 = new JLabel();
        label1.setSize(500,40);
        label1.setForeground(Color.white);
        label1.setFont(aboutFont);
        label1.setLocation(10,30);
        label1.setText("感谢您使用叶桃防灾Lite App!");

        label2 = new JLabel();
        label2.setSize(500,40);
        label2.setForeground(Color.white);
        label2.setFont(aboutFont);
        label2.setLocation(10,80);
        label2.setText("叶桃防灾Lite 从以下来源获取地震信息:");

        label3 = new JLabel();
        label3.setSize(500,40);
        label3.setForeground(Color.white);
        label3.setFont(aboutFont);
        label3.setLocation(10,110);
        label3.setText("1.成都高新减灾研究所 四川地震局 福建地震局");

        label4 = new JLabel();
        label4.setSize(500,40);
        label4.setForeground(Color.white);
        label4.setFont(aboutFont);
        label4.setLocation(10,140);
        label4.setText("2.中国地震台网中心");

        label5 = new JLabel();
        label5.setSize(500,40);
        label5.setForeground(Color.white);
        label5.setFont(aboutFont);
        label5.setLocation(10,170);
        label5.setText("3.日本气象厅");

        label6 = new JLabel();
        label6.setSize(500,40);
        label6.setForeground(Color.white);
        label6.setFont(aboutFont);
        label6.setLocation(10,220);
        label6.setText("鸣谢:");

        label7 = new JLabel();
        label7.setSize(500,40);
        label7.setForeground(Color.white);
        label7.setFont(aboutFont);
        label7.setLocation(10,250);
        label7.setText("1.RCBS(qq: 3336817082) 制作软件音效");

        label8 = new JLabel();
        label8.setSize(500,40);
        label8.setForeground(Color.white);
        label8.setFont(aboutFont);
        label8.setLocation(10,280);
        label8.setText("2.Wolfx Studio(wolfx.jp) 提供api接口");

        label9 = new JLabel();
        label9.setSize(500,40);
        label9.setForeground(Color.white);
        label9.setFont(aboutFont);
        label9.setLocation(10,310);
        label9.setText("3.ProjectBS(projectbs.cn)github开源仓库 提供烈度算法");

        label10 = new JLabel();
        label10.setSize(500,40);
        label10.setForeground(Color.white);
        label10.setFont(font1);
        label10.setLocation(0,360);
        label10.setText("本软件由叶桃防灾团队(官网leafpeach.cn)开发,使用时请遵守权利声明");

        label11 = new JLabel();
        label11.setSize(500,40);
        label11.setForeground(Color.white);
        label11.setFont(font1);
        label11.setLocation(0,410);
        label11.setText("若您在使用中遇到问题,请至叶桃防灾用户交流群反馈(群号: 757495714)");

        label12 = new JLabel();
        label12.setSize(500,40);
        label12.setForeground(Color.white);
        label12.setFont(aboutFont);
        label12.setLocation(10,460);
        label12.setText("B站: @叶桃防灾(uid: 1297775055)");

        label13 = new JLabel();
        label13.setSize(500,40);
        label13.setForeground(Color.white);
        label13.setFont(new Font("微软雅黑",Font.BOLD,15));
        label13.setLocation(10,490);
        label13.setText("测站实时数据的排版参照B站@チルノヽ直播间的排版制作");

        jPanel4.add(label);
        jPanel4.add(label1);
        jPanel4.add(label2);
        jPanel4.add(label3);
        jPanel4.add(label4);
        jPanel4.add(label5);
        jPanel4.add(label6);
        jPanel4.add(label7);
        jPanel4.add(label8);
        jPanel4.add(label9);
        jPanel4.add(label10);
        jPanel4.add(label11);
        jPanel4.add(label12);
        jPanel4.add(label13);

        // 其他功能
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButton10 = new JButton();
        jButton11 = new JButton();

        jButton8.setSize(200,30);
        jButton8.setLocation(10,10);
        jButton8.setFont(font1);
        jButton8.setBackground(Color.gray);
        jButton8.setForeground(Color.white);
        jButton8.setText("地震测站数据");
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(e -> new StationsSelect());

        jButton9.setSize(200,30);
        jButton9.setLocation(10,50);
        jButton9.setFont(font1);
        jButton9.setBackground(Color.gray);
        jButton9.setForeground(Color.white);
        jButton9.setText("查看最新震度分布图");
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(e -> {
            try {
                new ShindoImageWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        jButton10.setSize(300,30);
        jButton10.setLocation(10,90);
        jButton10.setFont(font1);
        jButton10.setBackground(Color.gray);
        jButton10.setForeground(Color.white);
        jButton10.setText("查看NIED Hi-net过去24h震源分布图");
        jButton10.setBorderPainted(false);
        jButton10.addActionListener(e -> {
            try {
                new EpiCenterImageWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        jButton11.setSize(200,30);
        jButton11.setLocation(10,130);
        jButton11.setFont(font1);
        jButton11.setBackground(Color.gray);
        jButton11.setForeground(Color.white);
        jButton11.setText("测试预警");
        jButton11.setBorderPainted(false);
        jButton11.addActionListener(e -> ICLEEW.test());

        jPanel5.add(jButton8);
        jPanel5.add(jButton9);
        jPanel5.add(jButton10);
        jPanel5.add(jButton11);

        // 重绘页面
        repaint();
    }
}
