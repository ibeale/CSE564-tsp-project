
import javax.swing.*;

public class FileMenu extends JMenu {
    public FileMenu(){
        super("File");
        JMenuItem openButton = new JMenuItem("Open");
        JMenuItem saveButton = new JMenuItem("Save");
        openButton.addActionListener(new ActionController());
        saveButton.addActionListener(new ActionController());
        this.add(openButton);
        this.add(saveButton);
    }
}
