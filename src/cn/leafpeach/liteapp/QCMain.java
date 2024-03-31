package cn.leafpeach.liteapp;

import cn.leafpeach.liteapp.app.eews.EEW;
import cn.leafpeach.liteapp.app.eews.ICLEEW;
import cn.leafpeach.liteapp.gui.*;
import cn.leafpeach.liteapp.app.*;
import cn.leafpeach.liteapp.app.websocket.WebSocketTask;
import cn.leafpeach.liteapp.gui.lists.CencList;
import cn.leafpeach.liteapp.gui.lists.IclList;
import cn.leafpeach.liteapp.gui.lists.JmaList;
import cn.leafpeach.liteapp.utils.AppUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.formdev.flatlaf.FlatIntelliJLaf;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class QCMain {
    public static QCMainWindow qcMainWindow;

    // 定义程序版本
    public static String version = "2.0.7";

    // 程序主类
    public static void main(String[] args) throws IOException {
        // 加载UI
        FlatIntelliJLaf.setup();

        // 加载托盘图标
        //noinspection InstantiationOfUtilityClass
        new AppTray();

        // 写入初始数据
        StartDataWriter.write();
        DataWriter.write();

        // 启动WebSocket连接
        WebSocketTask.start();

        // 启动预警任务
        //noinspection InstantiationOfUtilityClass
        new ICLEEW();
        String data = FileUtils.readFileToString(AppUtils.tipsFile);
        JSONObject jsonObject = JSON.parseObject(data);
        if (jsonObject.getString("status").equals("on")) {
            //noinspection InstantiationOfUtilityClass
            new EEW();
        }

        // 实例化预警窗口
        EQWarningWindow eqWarningWindow = new EQWarningWindow();
        eqWarningWindow.display();
        eqWarningWindow.dispose();

        // 检查更新
        VersionChecker.check();

        // 加载主窗口
        qcMainWindow = new QCMainWindow("叶桃防灾Lite");
        qcMainWindow.setVisible(true);
        qcMainWindow.displayWindow();
        IclList.load();
        CencList.load();
        JmaList.load();
        
        //判断是否为第一次启动
        File file = new File("Files\\isFirstLaunch.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "检测到您是第一次启动软件,请点击确定以设置您所在地的经纬度以及预警策略");
            new SettingsDialog();
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
