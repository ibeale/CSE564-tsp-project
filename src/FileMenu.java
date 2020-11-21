import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu {
    public FileMenu(){
        super("File");
        ActionController actionController = new ActionController();
        JMenuItem openButton = new JMenuItem("Open");
        JMenuItem saveButton = new JMenuItem("Save");
        openButton.addActionListener(actionController);
        saveButton.addActionListener(actionController);
        this.add(openButton);
        this.add(saveButton);
    }
}
