

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

public class Mainframe extends JFrame implements Observer{
	
	private static Mainframe instance;
	
    private Mainframe(){
        super("Main Frame");
        this.setJMenuBar(new ControllerMenuBar());
        Viewport viewport = new Viewport();
        viewport.addMouseListener(new MouseController());
        
        this.add(viewport, BorderLayout.CENTER);
    }
    
    public static Mainframe getInstance() {
    	if(instance == null) {
    		instance = new Mainframe();
    	}
    	return instance;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
    
    public static void main(String args[]){
        Mainframe mainframe = Mainframe.getInstance();
        Repository.getInstance().addObserver(mainframe);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(Config.getInstance().getWindowWidth(),Config.getInstance().getWindowHeight());
        mainframe.setResizable(false);
        mainframe.setVisible(true);
    }
}
