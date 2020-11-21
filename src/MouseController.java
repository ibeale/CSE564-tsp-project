import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseController implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		if(Repository.getInstance().getStatus() != "RUN") {
			int x = e.getX();
			int y = e.getY();
			Repository.getInstance().addPoint(x, y);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
