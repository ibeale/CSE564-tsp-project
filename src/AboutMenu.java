


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class AboutMenu extends JButton{
	public AboutMenu() {
		super("About");
		this.addActionListener((ActionListener)new ActionController());
	}
}
