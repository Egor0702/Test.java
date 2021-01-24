package AlarmClock;

import javax.swing.*;
import java.awt.*;

public class Vidget extends JPanel {
    public void paintComponent(Graphics g) {
            Image image = new ImageIcon("C:\\Users\\vikto\\Pictures\\SuperNiks.jpg").getImage();
            g.drawImage(image, 130, 90, 300, 400, this);
        }
    }

