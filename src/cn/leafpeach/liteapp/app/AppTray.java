package cn.leafpeach.liteapp.app;

import cn.leafpeach.liteapp.gui.SettingsDialog;
import cn.leafpeach.liteapp.QCMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppTray {
    private static final Image image = Toolkit.getDefaultToolkit().getImage("Files\\img\\tray.png");
    public static final TrayIcon trayIcon = new TrayIcon(image);
    static JDialog jDialog;
    static JPopupMenu jPopupMenu;

    public AppTray() {
        // 系统托盘
        if (SystemTray.isSupported()) {
            SystemTray systemTray = SystemTray.getSystemTray();
            trayIcon.setToolTip("叶桃防灾Lite");
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        jDialog = new JDialog();
                        jPopupMenu = new JPopupMenu();
                        jDialog.setUndecorated(true);
                        jDialog.setSize(0, 0);
                        JMenuItem jmenuItem = new JMenuItem("设置");
                        jmenuItem.addActionListener(e1 -> new SettingsDialog());
                        JMenuItem jmenuItem2 = new JMenuItem("显示主窗口");
                        jmenuItem2.addActionListener(e1 -> QCMain.qcMainWindow.setVisible(true));
                        JMenuItem jmenuItem1 = new JMenuItem("退出程序");
                        jmenuItem1.addActionListener(e1 -> System.exit(1));
                        jPopupMenu.add(jmenuItem);
                        jPopupMenu.add(jmenuItem2);
                        jPopupMenu.add(jmenuItem1);
                        jDialog.setLocation(e.getX(),e.getY());
                        jDialog.setVisible(true);
                        jPopupMenu.show(jDialog, 0, 0);
                    } else if (e.getButton() == MouseEvent.BUTTON1) {
                        QCMain.qcMainWindow.setVisible(true);
                    }
                }
            });
            try {
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

    // 发送系统通知的方法
    public static void showMessage (String title, String message){
        trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO);
    }
}
