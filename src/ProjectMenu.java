import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class ProjectMenu extends JMenu {
    public ProjectMenu(){
        super("Project");
        ActionController actionController = new ActionController();
        JMenuItem newButton = new JMenuItem("New");
        JMenuItem runButton = new JMenuItem("Run");
        JMenuItem stopButton = new JMenuItem("Stop");
        newButton.addActionListener(actionController);
        runButton.addActionListener(actionController);
        stopButton.addActionListener(actionController);
        this.add(newButton);
        this.add(runButton);
        this.add(stopButton);
    }
}
