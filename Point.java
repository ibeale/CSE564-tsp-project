
public class Point {
	private double x, y;

    public Point(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }

    public double[] getPoint() {
        double[] a = { x, y };
        return a;
    }

}
