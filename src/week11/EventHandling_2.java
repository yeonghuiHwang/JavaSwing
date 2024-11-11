package week11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// EventHandlingPanel_2가 ActionListener를 구현합니다.
class EventHandlingPanel_2 extends JPanel implements ActionListener {
    EventHandlingPanel_2() {
        setLayout(new FlowLayout()); // 패널의 레이아웃을 FlowLayout으로 설정
        setBackground(Color.ORANGE); // 패널의 배경색을 주황색으로 설정
        JButton b = new JButton("Click Me"); // "Click Me" 텍스트가 표시된 버튼 생성

        // 현재 클래스 자체를 리스너로 등록하여 버튼 클릭 시 actionPerformed 메서드를 호출
        b.addActionListener(this);

        // 람다식을 사용하여 리스너를 추가하고, 버튼 클릭 시 "HuHuHu!" 메시지 출력
        b.addActionListener((e) -> {
            System.out.println("HuHuHu!");
        });

        // 무명 클래스를 사용하여 리스너를 추가하고, 버튼 클릭 시 "Hello from Anonymous Class!" 메시지 출력
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello from Anonymous Class!");
            }
        });

        add(b); // 패널에 버튼 추가
    }

    // ActionListener 인터페이스의 actionPerformed 메서드를 구현합니다.
    // 이 메서드는 현재 클래스가 리스너로 등록된 이벤트가 발생할 때 호출됩니다.
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button was clicked!"); // 버튼 클릭 시 출력될 메시지
    }
}

public class EventHandling_2 extends JFrame {
    public EventHandling_2() {
        setTitle("Event Handling 2"); // 프레임 제목 설정
        setSize(500, 300); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기 설정
        add(new EventHandlingPanel_2()); // EventHandlingPanel_2 패널 추가
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    public static void main(String[] args) {
        new EventHandling_2(); // 프로그램 시작
    }
}
