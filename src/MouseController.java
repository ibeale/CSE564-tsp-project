
import java.awt.event.*;


public class MouseController extends Controller implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		if(Repository.getInstance().getStatus() != "RUN") {
			int x = e.getX();
			int y = e.getY();
			Repository.getInstance().addPoint(x, y);
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
