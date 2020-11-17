package view;

import javax.swing.*;

public class FileMenu extends JMenu {
    public FileMenu(){
        super("File");
        this.add(new JMenuItem("Open"));
        this.add(new JMenuItem("Save"));
    }
}
