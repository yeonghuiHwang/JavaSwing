package week11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JPanel을 상속받고, ActionListener 인터페이스를 구현하는 EventHandlingPanel_3 클래스
class EventHandlingPanel_3 extends JPanel implements ActionListener {
    int count = 0; // 이렇게 빼면 됨! (필드로 선언하여 이벤트 핸들러 내에서 값을 유지하고 접근할 수 있음)

    EventHandlingPanel_3() {
        JButton b = new JButton("button 1"); // 버튼 생성, 클릭 시마다 라벨의 텍스트가 변경됨
        JButton b2 = new JButton("button 2"); // 두 번째 버튼 생성, 클릭 시 별도 동작 수행
        JLabel l = new JLabel("Click Me");   // 라벨 생성, 초기 텍스트는 "Click Me"로 설정

        // int count = 0;
        // 이렇게 지역변수로 선언할 경우 익명 클래스 내부에서 접근이 불가능하며, 이를 해결하기 위해 count를 필드로 선언했습니다.

        // 무명 클래스를 사용하여 버튼에 이벤트 리스너 추가
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // count ++; 로컬 변수를 사용하려면 final처럼 써야한다. 값이 변하면 안됨. 밖에서도 변하면 안됨
                // 무명 클래스 내부에서 로컬 변수는 final로 간주되므로 값이 변경될 수 없습니다.
                // 따라서 필드 변수로 선언하여 값을 변경할 수 있도록 했습니다.

                count++; // 버튼 클릭 시마다 count 값 증가

                // count의 현재 값이 홀수이면 라벨을 "Computer"로 설정하고, 짝수면 "Sejong"으로 설정합니다.
                if (count % 2 == 1)
                    l.setText("Computer"); // 홀수 클릭일 때 라벨 텍스트를 "Computer"로 변경
                else
                    l.setText("Sejong");   // 짝수 클릭일 때 라벨 텍스트를 "Sejong"으로 변경
            }
        });

        // 두 번째 버튼(b2)에 대한 이벤트 리스너 추가
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 두 번째 버튼이 클릭될 때마다 count 값을 초기화하고 라벨을 "Reset!"으로 설정
                count = 0; // count 값을 초기화
                l.setText("Reset!"); // 라벨 텍스트를 "Reset!"으로 변경
            }
        });

        // 생성한 버튼과 라벨을 패널에 추가
        add(b);
        add(b2); // 두 번째 버튼 추가
        add(l);
    }

    // ActionListener 인터페이스의 actionPerformed 메서드를 구현 (빈 메서드로 구현함)
    @Override
    public void actionPerformed(ActionEvent e) {
        // 이 메서드는 ActionListener 인터페이스 구현의 일환으로 정의되었으나, 현재는 사용되지 않습니다.
        // 만약 다른 이벤트를 처리하고자 한다면 여기에 로직을 추가할 수 있습니다.
    }
}

// JFrame을 상속받는 메인 프레임 클래스
public class EventHandling_3 extends JFrame {
    public EventHandling_3() {
        setTitle("Event Handling Example 3"); // 프레임 제목 설정
        setSize(300, 200);                    // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 프로그램 종료
        add(new EventHandlingPanel_3());      // 패널을 프레임에 추가하여 GUI 구성
        setVisible(true);                     // 프레임을 화면에 표시
    }

    // 프로그램의 시작점
    public static void main(String[] args) {
        new EventHandling_3(); // 메인 프레임 생성 및 표시
    }
}
