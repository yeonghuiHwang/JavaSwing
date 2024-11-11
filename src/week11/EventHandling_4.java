package week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JPanel을 상속받고, ActionListener 인터페이스를 구현하는 EventHandlingPanel_4 클래스
class EventHandlingPanel_4 extends JPanel implements ActionListener {
    int count = 0; // 클릭 횟수를 저장할 변수

    EventHandlingPanel_4() {
        JButton b1 = new JButton("Button 1"); // 첫 번째 버튼 생성
        JButton b2 = new JButton("Button 2"); // 두 번째 버튼 생성
        JLabel label = new JLabel("Click a button"); // 초기 텍스트가 "Click a button"인 라벨 생성

        // 두 개의 버튼 모두 동일한 리스너(this)를 사용하여 ActionEvent를 호출하도록 설정
        b1.addActionListener(this);
        b2.addActionListener(this);

        // 패널에 버튼과 라벨 추가
        add(b1);
        add(b2);
        add(label);
    }

    // ActionListener 인터페이스의 actionPerformed 메서드를 구현하여 이벤트 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource(); // 이벤트가 발생한 버튼을 가져옴

        // 이벤트가 발생한 컴포넌트를 가져와 JButton 타입으로 형변환 (캐스팅)합니다.
        // `e.getSource()`는 이벤트가 발생한 객체(이 경우, 클릭된 버튼)를 반환합니다.
        // 하지만 반환되는 타입은 일반적인 Object 타입이므로, JButton으로 캐스팅하여 사용합니다.

        if (source.getText().equals("Button 1")) {
            // `source.getText()`를 통해 버튼의 텍스트를 가져옵니다.
            // 버튼의 텍스트가 "Button 1"과 일치하는지 비교합니다.
            // 일치한다면, 이는 "Button 1"이 클릭된 경우를 의미합니다.

            count++; // 버튼이 클릭될 때마다 count 값을 1씩 증가시킵니다.

            if (count % 2 == 1) {
                ((JLabel) getComponent(2)).setText("Button 1: Odd Click");
                // `getComponent(2)`를 사용하여 패널에 추가된 세 번째 컴포넌트(JLabel)를 가져옵니다.
                // `add`된 순서대로 컴포넌트가 0부터 인덱싱되므로, `getComponent(2)`는 라벨입니다.
                // JLabel로 형변환 후, `setText("Button 1: Odd Click")`을 호출하여 라벨 텍스트를 변경합니다.
            } else {
                // count가 짝수인 경우
                ((JLabel) getComponent(2)).setText("Button 1: Even Click");
                // `setText("Button 1: Even Click")`을 호출하여 라벨 텍스트를 "Button 1: Even Click"으로 변경합니다.
            }
        } else if (source.getText().equals("Button 2")) {
            // `source.getText()`가 "Button 2"와 일치하는지 확인합니다.
            // 일치한다면, 이는 "Button 2"이 클릭된 경우를 의미합니다.

            count = 0; // count 값을 0으로 초기화하여 클릭 횟수를 리셋합니다.

            ((JLabel) getComponent(2)).setText("Reset by Button 2");
            // 라벨 텍스트를 "Reset by Button 2"로 변경하여, "Button 2"에 의해 초기화되었음을 표시합니다.
        }

    }
}

// JFrame을 상속받는 메인 프레임 클래스
public class EventHandling_4 extends JFrame {
    public EventHandling_4() {
        setTitle("Event Handling Example 4"); // 프레임 제목 설정
        setSize(300, 200);                    // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 프로그램 종료
        add(new EventHandlingPanel_4());      // 패널을 프레임에 추가하여 GUI 구성
        setVisible(true);                     // 프레임을 화면에 표시
    }

    // 프로그램의 시작점
    public static void main(String[] args) {
        new EventHandling_4(); // 메인 프레임 생성 및 표시
    }
}
