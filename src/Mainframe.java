

import javax.swing.*;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Mainframe extends JFrame implements Observer{
	
	private static Mainframe instance;
	
    private Mainframe(){
        super("Main Frame");
        this.setJMenuBar(new ControllerMenuBar());
        Viewport viewport = new Viewport();
        viewport.addMouseListener(new MouseController());
        Repository.getInstance().addObserver(this);
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
}
