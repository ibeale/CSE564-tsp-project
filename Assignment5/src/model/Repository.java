package model;

import java.util.ArrayList;
import java.util.Observable;

public class Repository extends Observable {
    ArrayList<Point> points;
    ArrayList<Path> paths;
    ArrayList<Path> sortedPaths;

    public ArrayList<Point> getPoints() {
        return points;
    }

    public ArrayList<Path> getSortedPaths() {
        return sortedPaths;
    }

    public ArrayList<Path> getKPaths(int k){
        return (new ArrayList<Path>(sortedPaths.subList(0,k)));
    }
}
