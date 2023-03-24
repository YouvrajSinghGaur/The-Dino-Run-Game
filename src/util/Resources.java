package util;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Resources {
    public static BufferedImage getResourceImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return img;

    }

    public static void playMusic(String filePath1,String filePath2){
        File music1,music2;
        try{
            music1 = new File(filePath1);
            music2 = new File(filePath2);
            AudioInputStream audio1 = AudioSystem.getAudioInputStream(music1);
            Clip clip1 = AudioSystem.getClip();
            AudioInputStream audio2 = AudioSystem.getAudioInputStream(music2);
            Clip clip2 = AudioSystem.getClip();
            clip1.open(audio1);
            clip2.open(audio2);
            clip1.start();
            clip2.start();

            Thread.sleep(clip1.getMicrosecondLength()/1000);
            Thread.sleep(clip2.getMicrosecondLength()/1000);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}
