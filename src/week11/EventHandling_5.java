package week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandling_5 extends JFrame implements ActionListener {
    private JLabel label; // 클릭 결과를 표시할 라벨

    public EventHandling_5() {
        setTitle("Event Handling with ActionCommand and Switch"); // 프레임 제목 설정
        setSize(300, 200); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 프로그램 종료
        setLayout(new FlowLayout()); // 간단한 FlowLayout 설정

        // 버튼 생성
        JButton button1 = new JButton("Submit");
        JButton button2 = new JButton("Cancel");
        JButton button3 = new JButton("Help");

        // 각 버튼에 ActionCommand 설정
        button1.setActionCommand("SUBMIT_COMMAND");
        button2.setActionCommand("CANCEL_COMMAND");
        button3.setActionCommand("HELP_COMMAND");

        // 이벤트 리스너 등록 (모든 버튼이 동일한 리스너 사용)
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        // 클릭 결과를 보여줄 라벨 생성
        label = new JLabel("Select an action");

        // 프레임에 컴포넌트 추가
        add(button1);
        add(button2);
        add(button3);
        add(label);

        setVisible(true); // 프레임을 화면에 표시
    }

    // ActionListener 인터페이스의 actionPerformed 메서드를 구현하여 버튼 클릭 이벤트를 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        // e.getActionCommand()를 사용하여 클릭된 버튼을 구분
        String command = e.getActionCommand();

        // ActionCommand 값을 기반으로 switch 문을 사용하여 버튼별 동작을 구분
        switch (command) {
            case "SUBMIT_COMMAND":
                // "Submit" 버튼을 클릭했을 때의 동작
                label.setText("Submit button clicked!");
                break;

            case "CANCEL_COMMAND":
                // "Cancel" 버튼을 클릭했을 때의 동작
                label.setText("Cancel button clicked!");
                break;

            case "HELP_COMMAND":
                // "Help" 버튼을 클릭했을 때의 동작
                label.setText("Help button clicked!");
                break;

            default:
                // 예기치 않은 경우 처리 (보통은 발생하지 않음)
                label.setText("Unknown action");
                break;
        }
    }

    public static void main(String[] args) {
        new EventHandling_5(); // 프로그램 실행
    }
}
