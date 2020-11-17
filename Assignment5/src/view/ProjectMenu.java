package view;

import javax.swing.*;

public class ProjectMenu extends JMenu {
    public ProjectMenu(){
        super("Project");
        this.add(new JMenuItem("New"));
        this.add(new JMenuItem("Run"));
        this.add(new JMenuItem("Stop"));
    }
}
