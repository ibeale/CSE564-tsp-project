import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionController extends Controller implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println(action);
		switch(action){
			case "Open" :
				new FileChoose();
		}
	}
}
