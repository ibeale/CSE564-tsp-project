import javax.swing.JFrame;

public class App {
    public static void main(String args[]){
        Mainframe mf = Mainframe.getInstance();
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setSize(Config.getInstance().getWindowWidth(),Config.getInstance().getWindowHeight());
        mf.setResizable(false);
        mf.setVisible(true);
    }
}
