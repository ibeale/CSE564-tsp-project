
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProjectMenu extends JMenu {
    public ProjectMenu(){
        super("Project");
        Controller actionController = new ActionController();
        JMenuItem newButton = new JMenuItem("New");
        JMenuItem runButton = new JMenuItem("Run");
        JMenuItem stopButton = new JMenuItem("Stop");
        newButton.addActionListener((ActionListener) actionController);
        runButton.addActionListener((ActionListener) actionController);
        stopButton.addActionListener((ActionListener) actionController);
        this.add(newButton);
        this.add(runButton);
        this.add(stopButton);
        
    }
}
