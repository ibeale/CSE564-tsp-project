


import javax.swing.*;

public class ControllerMenuBar extends JMenuBar {
    public ControllerMenuBar(){
        super();
        this.add(new FileMenu());
        this.add(new ProjectMenu());
        this.add(new AboutMenu());
    }
}
