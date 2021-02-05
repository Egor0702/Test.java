package AlarmClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    static String date;
    JButton newButton;
    Thread threadOne;
    JTextField text;
    JFrame frame;
    JPanel panel;
    JPanel panel1;
    JFrame frame2;
    Music music;
    int width = 600;
    int height = 600;


    public void go() {
        frame = new JFrame();
        panel = new JPanel();
        text = new JTextField(20);
        JButton button = new JButton("install");
        button.addActionListener(new SetTime());
        JTextField re = new JTextField(13);

        panel.add( text);
        panel.revalidate();
        panel.add(button);
        panel.revalidate();

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);

    }
    public void calc(String ter) {
        System.out.println("Зашли");
        JTextField textCalc = new JTextField(10);
        textCalc.setText(ter);
        newButton = new JButton("Выключить");
        newButton.addActionListener(new Actio());
        panel.add(textCalc);
        panel.add(newButton);
        panel.revalidate();
    }
class ThreadOne implements Runnable{
    @Override
    public void run() {
        setingTime(date);
    }
}
    class ThreadTwo implements Runnable{
        @Override
        public void run() {
            setingTime(date);
        }
    }
    public void setingTime(String input) {
        while (!threadOne . isInterrupted ()) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");
            Date date = calendar.getTime();
            String r = format1.format(date);
            if (r.equals(input)) {
                reGraph();
                break;
            }
        }
    }

    public class SetTime implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String time = text.getText();
            date = time;
            calc(date);
            threadOne = new Thread(new ThreadOne());
            threadOne.start();
            text.setText("");
        }
    }

    public static void main(String[] args) {
        new Test().go();
    }


    public void reGraph() {
        frame.setVisible(false);
        frame2 = new JFrame();
        JPanel panel2 = new Vidget();
        music = new Music();
        JLabel label = new JLabel("Nikich, wake up!");
        JButton endButton = new JButton("Выключить");
        endButton.addActionListener(new ReturnClock());
        panel2.add(BorderLayout.SOUTH, label);
        panel2.add(BorderLayout.SOUTH, endButton);
        frame2.getContentPane().add(panel2, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(width, height);
        frame2.setVisible(true);

        music.go();
    }

    public class Actio implements ActionListener {
        boolean boo = false;
        public void actionPerformed(ActionEvent ev) {
            if (boo == false) { // выключаем будильник
                threadOne.interrupt();
                newButton.setText("Включить");
                boo = true;
            } else {
                threadOne.interrupted();
                boo = false;
                newButton.setText("Выключить");
            }
        }
    }
    public class ReturnClock implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            music.stop();
            frame2.setVisible(false);
            frame.setVisible(true);
        }
    }
}
