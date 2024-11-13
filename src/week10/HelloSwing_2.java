package week10;
import javax.swing.*;
import java.awt.*;


class MyFirstPanel_2 extends JPanel {
    MyFirstPanel_2(){
        JButton a = new JButton("CLick Here");
        add(a);
        add(new JButton("나도 버튼"));
        add(new JTextField(10));

        for (int i = 0; i < 10; i ++){
            add(new JButton("B " + (i+1)));
        }
    }
}


public class HelloSwing_2 extends JFrame{
    public static void main(String[] args){
        new HelloSwing_2(); // 반드시 객체화!
    }

    HelloSwing_2(){
        setTitle("My First Swing");
        setSize(500,400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        this.setLayout(new FlowLayout());
//        /*
//        HelloSwing_2의 레이아웃을 FlowLayout으로 설정합니다.
//        FlowLayout은 컴포넌트들을 왼쪽에서 오른쪽으로 순서대로 배치합니다.
//         */
//        add(new MyFirstPanel_2());


        add(new MyFirstPanel_2(), BorderLayout.CENTER);
        add(new JButton("1"), BorderLayout.NORTH);
        add(new JButton("2"), BorderLayout.SOUTH);

        //add(new MyFirstPanel());

        setVisible(true);
    }
}

