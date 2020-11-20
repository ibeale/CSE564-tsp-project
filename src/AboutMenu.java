import javax.swing.JButton;

public class AboutMenu extends JButton{
	public AboutMenu() {
		super("About");
		this.addActionListener(new ActionController());
	}
}