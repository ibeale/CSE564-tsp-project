
import java.util.ArrayList;

public class PathCalculator implements Runnable {
	
	@Override
	public void run() {
		while(Repository.getInstance().getStatus().equals("RUN") && Repository.getInstance().hasNextPoint()) {
			Point startPoint = Repository.getInstance().getNextPoint();
			Path path = calculateNearestNeighborsPath(startPoint);
			Repository.getInstance().addPath(path);
		}
		System.out.println("PathCalculator " + Thread.currentThread().getName() + " has finished executing.");
	}
	
	private Path calculateNearestNeighborsPath(Point currentCity){
		float totalDistance = 0;
		float minDistance = Integer.MAX_VALUE;
		
		ArrayList<Point> cities = new ArrayList<Point>(Repository.getInstance().getPoints());
		boolean[] visited = new boolean[cities.size()];
		visited[currentCity.getIndex()] = true;
		int[] visit_order = new int[cities.size()+1];
		visit_order[0] = currentCity.getIndex();
		visit_order[visit_order.length-1] = visit_order[0];
		
		Point nextCity = currentCity;
		int citiesVisited = 1;
		
		while(citiesVisited < cities.size()){
			for(int city = 0; city < cities.size();city++){
				if(!visited[city]){
					float currentDistance = calculateDistance(currentCity, cities.get(city));
					if(currentDistance < minDistance){
						minDistance =  currentDistance;
						nextCity = cities.get(city);
					}
				}
			}
			totalDistance+=minDistance;
			minDistance = Integer.MAX_VALUE;
			currentCity = nextCity;
			visit_order[citiesVisited] = currentCity.getIndex();
			visited[currentCity.getIndex()] = true;
			citiesVisited++;
		}
		//add final distance for returning to starting city
		totalDistance += calculateDistance(currentCity, cities.get(visit_order[0]));
	
		return new Path(visit_order[0],visit_order, totalDistance) ;
	}
	
	private float calculateDistance(Point city1, Point city2) {
		float distance = 0;
		float x1 = city1.getX();
		float x2 = city2.getX();
		float y1 = city1.getY();
		float y2 = city2.getY();
		distance = (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		return distance;
	}
	
}
