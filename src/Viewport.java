
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Viewport extends JPanel{   
    public Viewport() {
    	int WINDOWWIDTH = Config.getInstance().getWindowWidth();
    	int WINDOWHEIGHT = Config.getInstance().getWindowHeight();
    	setSize(WINDOWWIDTH,WINDOWHEIGHT);
    }
    
    @Override
    protected void paintComponent(Graphics g){
    	Color[] colors = {Color.RED,Color.PINK,Color.GRAY};
    	Repository repo = Repository.getInstance();
    	ArrayList<Point> points = repo.getPoints();
    	ArrayList<Path> sortedPaths = repo.getTopKPaths(colors.length);
    	
    	
        for(Point p : points){
            g.drawOval((int)p.getX(), (int)p.getY(), 6, 6);
        }
        
        
        
        for(int j = sortedPaths.size()-1; j >= 0 ; j--){
        	int[] visitOrder = sortedPaths.get(j).getVisitOrder();
            for(int i = 1; i < visitOrder.length; i++){
            	g.setColor(colors[j]);
                g.drawLine((int) points.get(visitOrder[i - 1]).getX(), (int)points.get(visitOrder[i - 1]).getY(), (int)points.get(visitOrder[i]).getX(), (int)points.get(visitOrder[i]).getY());
            }
        }
    }
}
