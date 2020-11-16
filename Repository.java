import java.util.ArrayList;
import java.util.Observable;
@SuppressWarnings("deprecation")

public class Repository extends Observable {
	private static Repository repo;
	private ArrayList<Point> paintPoints = new ArrayList<>();
	private Repository() {
	}
	
	public static Repository getInstance() {
		if(repo == null) {
			repo = new Repository();
		}
		return repo;
	}
	
	public void addPoints(double x, double y) {
		Point point = new Point(x, y);
		paintPoints.add(point);
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<Point> getPoint(){
		return paintPoints;
	}
}
