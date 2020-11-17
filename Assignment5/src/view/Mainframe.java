package view;

import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {

    public Mainframe(){
        super("Main Frame");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setJMenuBar(new ControllerMenuBar());
        this.add(new JPanel(), BorderLayout.CENTER);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
    }
}
