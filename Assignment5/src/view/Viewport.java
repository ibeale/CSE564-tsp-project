package view;

import model.*;

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Viewport extends JPanel implements Observer {
    ArrayList<Point> points;
    ArrayList<Path> paths;

    @Override
    protected void paintComponent(Graphics g){
        for(Point p : points){
            g.drawOval((int)p.getX(), (int)p.getY(), 2, 2);
        }
        for(Path p : paths){
            for(int i = 1; i < p.getVisitOrder().length; i++){
                g.drawLine((int)points.get(i-1).getX(), (int)points.get(i-1).getY(), (int)points.get(i).getX(), (int)points.get(i).getY());
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        points = ((Repository) o).getPoints();
        paths = ((Repository) o).getKPaths(3);
        this.repaint();

    }
}
