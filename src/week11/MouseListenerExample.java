package week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerExample extends JFrame implements MouseListener, MouseMotionListener {
    private JPanel panel;       // 패널: 마우스 이벤트를 감지하고 배경색을 변경
    private JLabel statusLabel; // 상태 라벨: 마우스 이벤트와 위치 정보를 표시
    // 생성자: 프레임과 패널, 이벤트 리스너를 설정합니다.
    public MouseListenerExample() {
        // JFrame 설정
        setTitle("Mouse Listener Example");     // 프레임 제목 설정
        setSize(500, 400);                      // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램 종료

        // JPanel 설정
        panel = new JPanel();
        panel.setBackground(Color.WHITE);       // 패널 초기 배경색 설정
        panel.setLayout(new BorderLayout());    // BorderLayout으로 배치 설정
        add(panel);                             // 패널을 프레임에 추가

        // 상태 라벨 설정
        statusLabel = new JLabel("마우스를 올려보세요!", JLabel.CENTER); // 라벨 초기 텍스트와 중앙 정렬
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // 라벨 폰트 설정
        panel.add(statusLabel, BorderLayout.SOUTH); // 패널의 남쪽(SOUTH)에 라벨 추가

        // MouseListener 및 MouseMotionListener를 패널에 추가하여 마우스 이벤트 감지
        // 두 인터페이스가 현재 클래스에 모두 구현되어있기 때문에 this 전달
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
        // 만약 모든 클래스를 구현할 이유가 없다면 Adapter 사용하면 됨 또는 빈 클래스 구현하면 됨
//        panel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                // 마우스 클릭 이벤트 처리
//            }
//        });
//
//        panel.addMouseMotionListener(new MouseMotionAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                // 마우스 드래그 이벤트 처리
//            }
//        });


        setVisible(true);
    }

    //main 메서드 : 프로그램 실행 진입점
    public static void main(String[] args){
        new MouseListenerExample(); // 프레임 생성
    }

    // MouseListener 메서드 구현

    // 마우스를 클릭했을 때 호출되는 메서드
    @Override
    public void mouseClicked(MouseEvent e) {
        panel.setBackground(Color.YELLOW); // 클릭 시 배경을 노란색으로 변경
        statusLabel.setText("마우스를 클릭했습니다! 위치: (" + e.getX() + ", " + e.getY() + ")");
    }

    // 마우스를 눌렀을 때 호출되는 메서드
    @Override
    public void mousePressed(MouseEvent e) {
        panel.setBackground(Color.BLUE); // 마우스 버튼을 눌렀을 때 배경을 파란색으로 변경
        statusLabel.setText("마우스를 눌렀습니다! 위치: (" + e.getX() + ", " + e.getY() + ")");
    }

    // 마우스를 놓았을 때 호출되는 메서드
    @Override
    public void mouseReleased(MouseEvent e) {
        panel.setBackground(Color.GREEN); // 마우스 버튼을 놓았을 때 배경을 초록색으로 변경
        statusLabel.setText("마우스를 놓았습니다! 위치: (" + e.getX() + ", " + e.getY() + ")");
    }

    // 마우스가 패널에 들어왔을 때 호출되는 메서드
    @Override
    public void mouseEntered(MouseEvent e) {
        panel.setBackground(Color.CYAN); // 마우스가 패널에 들어올 때 배경을 청록색으로 변경
        statusLabel.setText("마우스가 패널에 들어왔습니다!");
    }

    // 마우스가 패널을 떠났을 때 호출되는 메서드
    @Override
    public void mouseExited(MouseEvent e) {
        panel.setBackground(Color.WHITE); // 마우스가 패널을 떠날 때 배경을 흰색으로 변경
        statusLabel.setText("마우스가 패널을 떠났습니다!");
    }

    // MouseMotionListener 메서드 구현

    // 마우스를 드래그할 때 호출되는 메서드
    @Override
    public void mouseDragged(MouseEvent e) {
        panel.setBackground(Color.PINK); // 드래그할 때 배경을 분홍색으로 변경
        statusLabel.setText("마우스를 드래그 중입니다! 위치: (" + e.getX() + ", " + e.getY() + ")");
    }

    // 마우스를 이동할 때 호출되는 메서드
    @Override
    public void mouseMoved(MouseEvent e) {
        panel.setBackground(Color.LIGHT_GRAY); // 이동 중일 때 배경을 밝은 회색으로 변경
        statusLabel.setText("마우스가 이동 중입니다! 위치: (" + e.getX() + ", " + e.getY() + ")");
    }
}

