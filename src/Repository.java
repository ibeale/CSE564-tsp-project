import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Scanner;

public class Repository extends Observable {
	private static Repository repositoryInstance = null;
	ArrayList<Point> points;
	ArrayList<Path> paths;
	ArrayList<Path> sortedPaths;
	String status;
	int threadPointIndex;
	
	private Repository() {
		this.points = new ArrayList<>();
		this.paths = new ArrayList<>();
		this.sortedPaths = new ArrayList<>();
		this.status = "STOP";
		this.threadPointIndex = 0;
	}
	
	public static Repository getInstance() {
		if(repositoryInstance==null) {
			repositoryInstance = new Repository();
    	}
    	return repositoryInstance;			
	}
	
	public void readPointsFromFile(String filename) {
		float xMin,yMin,xMax,yMax;
		xMin = yMin = Integer.MAX_VALUE;
		xMax = yMax = Integer.MIN_VALUE;
		points.clear();//DEBUGGING ONLY
		File dataFile = new File(filename);
		try {
			Scanner fileReader = new Scanner(dataFile);
			while(fileReader.hasNextLine()) {
				String[] splitLine = fileReader.nextLine().split(" ");
				if (isNumeric(splitLine[0])) {
					float x = Float.parseFloat(splitLine[2]);
					float y = Float.parseFloat(splitLine[1]);
					addPoint(x,y);
					if(x < xMin)
						xMin = x;
					if(x > xMax)
						xMax = x;
					if(y < yMin)
						yMin = y;
					if(y > yMax)
						yMax = y;
				}
			}
			fileReader.close();
			normalizePoints(xMin,xMax,yMin,yMax);
		}
		catch(FileNotFoundException e) {
			System.out.println("The file could not be found.");
		}
//		printPoints(); // DEBUGGING only
		notifyView();
	}
	
	private void normalizePoints(float xMin, float xMax, float yMin, float yMax) {
		int WINDOW_LENGTH = 725;
		int WINDOW_HEIGHT = 725;
		
		for (int i = 0; i < points.size(); i++) {
			int index = points.get(i).getIndex();
			float x = points.get(i).getX();
			float y = points.get(i).getY();
			x = Math.round(  ((x-xMin)/(xMax - xMin)) * WINDOW_LENGTH);
			y = WINDOW_HEIGHT - Math.round(  ((y-yMin)/(yMax - yMin)) * WINDOW_HEIGHT);
			points.set(i, new Point(x,y,index));
		}
	}
	
	public void savePoints() {
		int WINDOW_HEIGHT = 725;
		ArrayList<Point> writePoints = new ArrayList<Point>();
		for (Point p: points) {
			writePoints.add(new Point(p.getX(), WINDOW_HEIGHT-p.getY(),p.getIndex()));
		}
		try {
			FileWriter pointWriter = new FileWriter("output.txt");
			for(Point p: writePoints) {
				pointWriter.write(p.getIndex() + " " + p.getY() + " " + p.getX() + "\n");
			}
			pointWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Path> getTopKPaths(int k) {
		if(sortedPaths.size() < k)
			return new ArrayList<Path>(sortedPaths.subList(0, sortedPaths.size()));
		
		return new ArrayList<Path>(sortedPaths.subList(0, k));
		
	}
	
	private void printPoints() {
		for (Point point : points) {
			System.out.println("index: " + point.getIndex() + "\tx: " + point.getX() + "\ty: " +point.getY());
		}
	}
	
	private boolean isNumeric(String str) {
		if(str == null || str.length() == 0)
			return false;
		return str.chars().allMatch(Character::isDigit);
	}
	
	public void addPath(Path path) {
		this.paths.add(path);
	}
	
	public void addPoint(float x,float y) {
		points.add(new Point(x,y,points.size()));
		notifyView();
	}
	
	public void notifyView() {
		setChanged();
		notifyObservers();
	}
	
	public Point getNextPoint() {
		return points.get(threadPointIndex++);
	}
	
	public boolean hasNextPoint() {
		if(threadPointIndex < points.size())
			return true;
		return false;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	public ArrayList<Path> getPaths() {
		return paths;
	}

	public ArrayList<Path> getSortedPaths() {
		return sortedPaths;
	}

	public void setSortedPaths(ArrayList<Path> sortedPaths) {
		this.sortedPaths = sortedPaths;
	}

	public String getStatus() {
		return status;
	}

	public int getThreadPointIndex() {
		return threadPointIndex;
	}

	public void setStatus(String status) {
		System.out.println("reached setStatus");
		if(status.equalsIgnoreCase("New"))
		{
			this.status = "STOP";
			this.points.clear();
			this.paths.clear();
			this.sortedPaths.clear();
			threadPointIndex = 0;
		}
		else if(status.equalsIgnoreCase("Run")) {
			this.status = "RUN";
			this.paths.clear();
			this.sortedPaths.clear();
			threadPointIndex = 0;
			ThreadManager.startThreads();
		}
		else if(status.equalsIgnoreCase("Stop")) {
			this.status = "STOP";
		}
		notifyView();
	}

	
}
