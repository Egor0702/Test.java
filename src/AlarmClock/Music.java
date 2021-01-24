package AlarmClock;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    Clip clip;
    public void go() {
        try {
            File soundFile = new File("C:\\Users\\vikto\\Music\\music.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
        }catch(IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
            exc.printStackTrace();
        }
    }
    public void stop(){
        clip.stop();
    }
}
