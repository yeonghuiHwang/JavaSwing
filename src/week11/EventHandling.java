package week11;
import javax.swing.*;
import java.awt.*;

class EventHandlingPanel extends JPanel{
    EventHandlingPanel(){
        setBackground(Color.ORANGE); // 패널의 영역
//        setLayout(null);
//        for (int i = 0; i < 5; i ++){
//            JButton b = new JButton("click");
//            b.setSize(100,50);
//            b.setLocation(100+50*i, 100+30*i);
//            add(b);
//        }

        setLayout(new FlowLayout());
        JButton b = new JButton("Click Me");
        JLabel l = new JLabel("Sejong");
        add(b);
        add(l);
    }
}


public class EventHandling extends JFrame{

    EventHandling(){
        setTitle("EventHandling");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new EventHandlingPanel());
        setVisible(true);
    }

    public static void main(String[] args){
        new EventHandling();
    }
}


