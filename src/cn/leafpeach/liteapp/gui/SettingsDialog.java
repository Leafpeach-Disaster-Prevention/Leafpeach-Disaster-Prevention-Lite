package cn.leafpeach.liteapp.gui;

import cn.leafpeach.liteapp.utils.SoundUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SettingsDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboWarningIntensity;
    private JTabbedPane tabbedPane1;
    private JButton buttonTestEEWSFX;
    private JButton buttonTestSWAVESFX;
    private JTextField editLatitude;
    private JTextField editLongitude;
    private JButton buttonNew;
    private JComboBox comboTips;

    public SettingsDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("设置");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Files\\img\\icon.png"));
        pack();

        buttonOK.addActionListener(e->onOK());
        buttonCancel.addActionListener(e->onCancel());
        LoadSettings();
        setLocationRelativeTo(null);
        setVisible(true);//设为模态后，会造成阻塞
    }

    private void LoadSettings(){
        File fSettings=new File("Files/settings.json");
        File fInt=new File("Files/int.json");
        File fTip =new File("Files/tips.json");
        try{
            String strSettings=FileUtils.readFileToString(fSettings);
            JSONObject jsonSettings=JSON.parseObject(strSettings);
            editLatitude.setText(jsonSettings.getString("Lat"));
            editLongitude.setText(jsonSettings.getString("Lng"));
            String strInt=FileUtils.readFileToString(fInt);
            JSONObject jsonInt=JSON.parseObject(strInt);
            switch (jsonInt.getString("Int")) {
                case "-1000.0" -> comboWarningIntensity.setSelectedIndex(0);
                case "2.0" -> comboWarningIntensity.setSelectedIndex(1);
                case "3.0" -> comboWarningIntensity.setSelectedIndex(2);
                case "4.0" -> comboWarningIntensity.setSelectedIndex(3);
            }
            String strTip=FileUtils.readFileToString(fTip);
            JSONObject jsonTip=JSON.parseObject(strTip);
            switch (jsonTip.getString("status")) {
                case "on" -> comboTips.setSelectedIndex(0);
                case "off" -> comboTips.setSelectedIndex(1);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        SoundUtil soundUtil=new SoundUtil();
        buttonTestEEWSFX.addActionListener(e -> soundUtil.playSound("sounds/First.wav"));
        buttonTestSWAVESFX.addActionListener(e->soundUtil.playSound("sounds/arrive.wav"));
        buttonNew.addActionListener(e->soundUtil.playSound("sounds/new.wav"));
    }

    private void onOK() {
        try{
            JSONObject jsonSettings=new JSONObject(),jsonInt=new JSONObject(),jsonTip=new JSONObject();
            jsonSettings.put("Lat",editLatitude.getText());
            jsonSettings.put("Lng",editLongitude.getText());
            final String[]intensityStrings={"-1000.0","2.0","3.0","4.0"};
            final String[]tipStrings={"on","off"};
            jsonTip.put("status",tipStrings[comboTips.getSelectedIndex()]);
            jsonInt.put("Int",intensityStrings[comboWarningIntensity.getSelectedIndex()]);
            BufferedWriter bufferedWriterSettings=new BufferedWriter(new FileWriter("Files/settings.json"));
            bufferedWriterSettings.write(jsonSettings.toString());
            bufferedWriterSettings.close();
            BufferedWriter bufferedWriterInt=new BufferedWriter(new FileWriter("Files/int.json"));
            bufferedWriterInt.write(jsonInt.toString());
            bufferedWriterInt.close();
            BufferedWriter bufferedWriterTips=new BufferedWriter(new FileWriter("Files/tips.json"));
            bufferedWriterTips.write(jsonTip.toString());
            bufferedWriterTips.close();
            JOptionPane.showMessageDialog(this,"设置保存成功！");
        }catch (IOException e){
            JOptionPane.showMessageDialog(this,"设置保存失败！\n"+e,"错误",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        dispose();
    }

    private void onCancel() {
        dispose();
    }
}
