package week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListenerExample extends JFrame {
    public KeyListenerExample() {
        setTitle("Key Listener Example");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CustomPanel panel = new CustomPanel();
        add(panel);
        panel.requestFocusInWindow(); // 패널이 키보드 포커스를 받을 수 있도록 설정
        setVisible(true);
    }

    public static void main(String[] args) {
        KeyListenerExample frame = new KeyListenerExample();
    }
}

class CustomPanel extends JPanel {
    private JLabel statusLabel;

    public CustomPanel() {
        setBackground(Color.GREEN); // 패널 초기 배경색 설정
        setLayout(new BorderLayout());

        // 상태 라벨 설정
        statusLabel = new JLabel("키보드를 눌러보세요!", JLabel.CENTER);
        statusLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(statusLabel, BorderLayout.NORTH);

        // KeyAdapter를 사용하여 키 이벤트 처리
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // 특정 키에 따라 배경색 변경 및 메시지 출력
                // KeyEvent.VK_UP: 위쪽 화살표 키
                // KeyEvent.VK_DOWN: 아래쪽 화살표 키
                // KeyEvent.VK_LEFT: 왼쪽 화살표 키
                // KeyEvent.VK_RIGHT: 오른쪽 화살표 키
                // KeyEvent.VK_ENTER: 엔터 키
                // KeyEvent.VK_ESCAPE: ESC 키
                // KeyEvent.VK_A, KeyEvent.VK_B 등: A, B 등 알파벳 키
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        setBackground(Color.CYAN);
                        statusLabel.setText("위쪽 화살표");
                        break;
                    case KeyEvent.VK_DOWN:
                        setBackground(Color.RED);
                        statusLabel.setText("아래쪽 화살표");
                        break;
                    default:
                        setBackground(Color.GREEN);
                        statusLabel.setText("다른 키");
                        break;
                }
            }
        });

        // JPanel은 기본적으로 포커스를 받지 않기 때문에,
        // 키보드 이벤트를 처리하려면 반드시 포커스를 받을 수 있도록 설정해야 합니다.
        setFocusable(true);

        // 추가 설명:
        // setFocusable(true): 이 설정을 통해 JPanel이 포커스를 받을 수 있게 됩니다.
        // 이 설정이 없으면, JPanel은 키보드 포커스를 받을 수 없어 키 이벤트를 처리할 수 없습니다.

        // panel.requestFocusInWindow()를 통해 화면에 보일 때 즉시 키보드 포커스를 받도록 요청합니다.
        // 이 메서드는 주로 패널이 처음 생성된 직후 또는 이벤트가 필요할 때 포커스를 부여하기 위해 사용됩니다.
        // setFocusable(true)와 함께 사용하여, 패널이 키보드 입력을 받을 수 있도록 보장합니다.
    }
}
