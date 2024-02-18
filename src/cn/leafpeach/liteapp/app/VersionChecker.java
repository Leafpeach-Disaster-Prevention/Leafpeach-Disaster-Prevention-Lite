package cn.leafpeach.liteapp.app;

import cn.leafpeach.liteapp.QCMain;
import cn.leafpeach.liteapp.utils.AppUtils;
import cn.leafpeach.liteapp.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;

public class VersionChecker {

    // 检查版本的方法
    public static void check() {
        try {
            String httpGet = HttpUtils.sendGet(AppUtils.getVersionUrl());
            JSONObject jsonObject = JSON.parseObject(httpGet);
            if (!QCMain.version.equals(jsonObject.getString("latest"))) {
                JOptionPane.showMessageDialog(null, "您的版本已过期,请至叶桃防灾用户群或官网leafpeach.cn下载最新版本!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "程序启动失败,可能是api接口出现故障或网络问题,请尝试重启程序或关注群内公告! \n" + e, "启动失败", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
