

public class Config {
	private int windowWidth = 800;
	private int windowHeight = 800;
	private int normalizationFactorX = windowWidth - 75;
	private int normalizationFactorY = windowHeight - 75;
	private static Config instance;
	
	private Config() {}
	
	public static Config getInstance() {
		if(instance == null) {
			instance = new Config();
		}
		return instance;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public int getNormalizationFactorX() {
		return normalizationFactorX;
	}


	public int getNormalizationFactorY() {
		return normalizationFactorY;
	}
}
