import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFileChooser;

public class ActionController extends Controller implements ActionListener{
	private static final int DIM_X = 750;
    private static final int DIM_Y = 800;
	JFileChooser jfilechooser = new JFileChooser("."); 
	private String fileName = new String();
	private Double[] rawPoints;
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println(action);
		switch(action){
			case "Open" :
				int a = jfilechooser.showOpenDialog(null); 
				if(a == JFileChooser.APPROVE_OPTION){
					fileName = jfilechooser.getSelectedFile().getPath();
				}
				try{
					 rawPoints = HandleInputData.handleInput(fileName);
	            }catch(IOException ev){}
	            for (int i = 0; i < rawPoints.length; i += 3) {
	                double x = rawPoints[i + 1] % DIM_X;
	                double y = rawPoints[i + 2] % DIM_Y;
	                Repository.getInstance().addPoints(x, y);
	            }
			case "Save":
		}
	}
}
