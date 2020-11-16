import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class Canvas extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Canvas() {
		Controller mouseController = new MouseController();
		this.setLayout(new BorderLayout());
        addMouseListener((MouseListener) mouseController);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawPoints(g);
    }
	
	public void drawPoints(Graphics g) {
		ArrayList<Point> points = Repository.getInstance().getPoint();
        g.setColor(Color.BLACK);
        for(Point x : points) {
        	int[] a = x.getPoint();
        	g.drawOval(a[0], a[1], 8, 8);
        }
        	
    }

}
