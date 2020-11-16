@SuppressWarnings("deprecation")	

public class Driver {
	public static void main(String[] args) {
		Mainframe mainFrame = new Mainframe();
		Repository.getInstance().addObserver(mainFrame);
	}
}
