
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class ActionController extends Controller implements ActionListener{
	JFileChooser jfilechooser = new JFileChooser(".");
	private String fileName = new String(), saveFile = new String();
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println(action);
		switch(action){
			case "Open" :
				int openDiag = jfilechooser.showOpenDialog(null); 
				if(openDiag == JFileChooser.APPROVE_OPTION){
					fileName = jfilechooser.getSelectedFile().getPath();
					Repository.getInstance().readPointsFromFile(fileName);
				}
				break;
			case "Save":
				int saveDiag = jfilechooser.showSaveDialog(null);
				if (saveDiag == JFileChooser.APPROVE_OPTION) {
					saveFile = jfilechooser.getSelectedFile().getPath();
					Repository.getInstance().savePoints(saveFile);
				}
				break;
			case "About":	
				break;
			default:
				Repository.getInstance().setStatus(action);
				break;
		}
	}
}
