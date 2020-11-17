import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PathJudge implements Runnable {

	@Override
	public void run() {
		Repository repo = Repository.getInstance();
		while(repo.getStatus().equals("RUN")) {
			ArrayList<Path> paths = new ArrayList<Path>(repo.getPaths());
			Collections.sort(paths, new Comparator<Path>() {
				@Override
				public int compare(Path path1, Path path2) {
					if(path1.getDistance() > path2.getDistance())
						return 1;
					else if (path1.getDistance() < path2.getDistance())
						return -1;
					else
						return 0;
				}
			});
			repo.setSortedPaths(paths);
			if(repo.getSortedPaths().size() < 3 || !isTopKEqual(paths,3)) 
				repo.notifyView();
		}
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
