import javax.swing.*;

class MyFirstPanel extends JPanel {
    MyFirstPanel(){
        JButton a = new JButton("CLick Here");
        add(a);
        add(new JButton("나도 버튼"));
        add(new JTextField(10));
    }
}

// main -> 무조건 실행되는 정적 메소드
// 메모리 아끼기 위해 JFrame 상속받아 아래처럼 작성할 수 있다.
public class HelloSwing extends JFrame{
    public static void main(String[] args){
        new HelloSwing(); // 반드시 객체화!
    }

    HelloSwing(){
        setTitle("My First Swing");
        setSize(500,400);

        setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 닫을 때 어플리케이션 종료 되도록

        //add(new JButton("Click Here")); // 화면 가득 버튼 만들고 싶을 때 (JFrame은 디폴트로 컴포넌트 추가하면 화면 가득!)
        // Jpanel은 기본적으로 컴포넌트 컴팩트하게 붇는게 디폴트 세팅! 패널에는 여러개의 컴포넌트가 나에게 붙을거야 라고 가정하므로 작게 붙임 그리고 연속해서 붙임

        add(new MyFirstPanel());

        setVisible(true);
    }
}

// 실행 후 메인 스레드부터 실행, visible이 나오면 다른 스레드가 실행되고 메인은 퇴근함 창 닫았다고 끝나진 않음 창 닫았을때 퇴근 위해서는 EXIT_ON_CLOSE 필요