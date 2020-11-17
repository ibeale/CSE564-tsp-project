
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Viewport extends JPanel{// implements Observer {    
    public Viewport() {
    	setSize(800,800);
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
        
        
        
        for(int j = 0; j < sortedPaths.size(); j++){
            for(int i = 1; i < sortedPaths.get(j).getVisitOrder().length; i++){
            	g.setColor(colors[j]);
                g.drawLine((int)points.get(i-1).getX(), (int)points.get(i-1).getY(), (int)points.get(i).getX(), (int)points.get(i).getY());
            }
        }
    }

//    @Override
//    public void update(Observable o, Object arg) {
//        this.repaint();
//    }
}
