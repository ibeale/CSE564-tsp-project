import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Canvas extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Canvas() {
		this.setLayout(new BorderLayout());
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
        	double[] a = x.getPoint();
        	g.drawOval((int) a[0], (int) a[1], 8, 8);
        }
        	
    }

}
