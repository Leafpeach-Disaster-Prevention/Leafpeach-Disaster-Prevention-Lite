package cn.leafpeach.liteapp.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundUtil {

    private File soundFile;

    private AudioInputStream audioStream;

    private SourceDataLine sourceLine;

    public void playSound(String filename) {
        try {
            soundFile = new File(filename);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        }catch (Exception e) {
            e.printStackTrace();
        }
        AudioFormat audioFormat = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sourceLine.start();

        int nBytesRead = 0;
        int BUFFER_SIZE = 128000;
        byte[] abData = new byte[BUFFER_SIZE];
        while (true) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            }catch (IOException e) {
                e.printStackTrace();
            }
            if(nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
                break;
            }
        }
    }
}