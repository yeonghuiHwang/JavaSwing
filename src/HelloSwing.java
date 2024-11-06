import javax.swing.JFrame;

class MyFirstFrame extends JFrame {

}



public class HelloSwing {
    public static void main(String[] args){
        MyFirstFrame f = new MyFirstFrame();
        f.setSize(500,300); // setter : 내가 값을 주는 함수들
        f.setTitle("My First Swing"); // getter : 내가 값을 얻는 함수들
        f.setVisible(true);

    }
}
