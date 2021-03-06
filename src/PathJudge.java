import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PathJudge implements Runnable {

	@Override
	public void run() {
		Repository repo = Repository.getInstance();
		while(repo.getStatus().equals("RUN")) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ArrayList<Path> paths = new ArrayList<Path>(repo.getPaths());
			Collections.sort(paths, Comparator.nullsLast(Comparator.naturalOrder()));
			if(repo.getSortedPaths().size() < 3 || !isTopKEqual(paths,3)) {
				System.out.println("notifiying view");
				repo.notifyView();
				repo.setSortedPaths(paths);	
			}
			else {
				repo.setSortedPaths(paths);
			}
			if(repo.getPaths().size() >= repo.getPoints().size()) break; 
			
		}
		System.out.println("PathJudge: " + Thread.currentThread().getName() + " has finished.");
	}
	
	private boolean isTopKEqual(ArrayList<Path> currentPaths, int k) {
		if(currentPaths.size() < k || Repository.getInstance().getSortedPaths().size() < k)
			return false;
		for (int i = 0; i < k; i++) {
			if(!currentPaths.get(i).equals(Repository.getInstance().getSortedPaths().get(i))) {
				return false;
			}
		}
		return true;
	}
	
}
