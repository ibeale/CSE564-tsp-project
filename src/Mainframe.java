

import javax.swing.*;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Mainframe extends JFrame implements Observer{

    public Mainframe(){
        super("Main Frame");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setJMenuBar(new ControllerMenuBar());
        Viewport viewport = new Viewport();
        viewport.addMouseListener(new MouseController());
        Repository.getInstance().addObserver(this);
        this.add(viewport, BorderLayout.CENTER);
        this.setSize(800,800);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
