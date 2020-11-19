

public class ThreadManager {
	public static void startThreads() {
		Thread worker1 = new Thread(new PathCalculator());
		Thread worker2 = new Thread(new PathCalculator());
		Thread worker3 = new Thread(new PathCalculator());
		Thread leader = new Thread(new PathJudge());
		worker1.start();
		worker2.start();
		worker3.start();
		leader.start();
	}

}
