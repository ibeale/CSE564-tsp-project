
import java.awt.event.ActionListener;

import javax.swing.*;

public class FileMenu extends JMenu {
    public FileMenu(){
        super("File");
        Controller actionController = new ActionController();
        JMenuItem openButton = new JMenuItem("Open");
        JMenuItem saveButton = new JMenuItem("Save");
        openButton.addActionListener((ActionListener) actionController);
        saveButton.addActionListener((ActionListener) actionController);
        this.add(openButton);
        this.add(saveButton);
    }
}
