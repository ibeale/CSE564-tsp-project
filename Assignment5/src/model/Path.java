package model;

public class Path {
    int startingPointIndex;
    int[] visitOrder;
    float distance;

    public Path(int startingPointIndex, int[] visitOrder, float distance) {
        this.startingPointIndex = startingPointIndex;
        this.visitOrder = visitOrder;
        this.distance = distance;
    }

    public int getStartingPointIndex() {
        return startingPointIndex;
    }

    public int[] getVisitOrder() {
        return visitOrder;
    }

    public float getDistance() {
        return distance;
    }
}
