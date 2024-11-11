package week10;

import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {
    MyPanel() {
        // 3행 3열 그리드 레이아웃 설정
        setLayout(new GridLayout(3, 3));

        // 9개의 버튼을 그리드에 추가
        for (int i = 1; i <= 9; i++) {
            add(new JButton("Button " + i));
        }
    }
}

public class HelloSwing_3 extends JFrame {
    public static void main(String[] args) {
        new HelloSwing_3();
    }

    HelloSwing_3() {
        setTitle("Hello Swing - GridLayout Example");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MyPanel을 JFrame에 추가
        add(new MyPanel());

        setVisible(true);
    }
}
