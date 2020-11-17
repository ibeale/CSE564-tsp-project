
import javax.swing.*;
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
        for(Point p : Repository.getInstance().getPoints()){
            g.drawOval((int)p.getX(), (int)p.getY(), 6, 6);
        }
        
//        for(Path p : paths){
//            for(int i = 1; i < p.getVisitOrder().length; i++){
//                g.drawLine((int)points.get(i-1).getX(), (int)points.get(i-1).getY(), (int)points.get(i).getX(), (int)points.get(i).getY());
//            }
//        }
    }

//    @Override
//    public void update(Observable o, Object arg) {
//        this.repaint();
//    }
}
