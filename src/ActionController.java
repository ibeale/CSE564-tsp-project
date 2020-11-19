
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFileChooser;

public class ActionController extends Controller implements ActionListener{
	JFileChooser jfilechooser = new JFileChooser("."); 
	private String fileName = new String();
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println(action);
		switch(action){
			case "Open" :
				int a = jfilechooser.showOpenDialog(null); 
				if(a == JFileChooser.APPROVE_OPTION){
					fileName = jfilechooser.getSelectedFile().getPath();
					Repository.getInstance().readPointsFromFile(fileName);
				}
				break;
			case "Save":
				Repository.getInstance().savePoints();
				break;
			case "About":	
				break;
//			case "New":
//				Repository.getInstance().setStatus(action); break;
			default:
				Repository.getInstance().setStatus(action);
				break;
		}
	}
}
