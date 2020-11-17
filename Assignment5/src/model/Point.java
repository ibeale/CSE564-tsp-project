package model;

public class Point {
    float x;
    float y;
    int index;

    public Point(float x, float y, int index){
        this.x = x;
        this.y = y;
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

}
