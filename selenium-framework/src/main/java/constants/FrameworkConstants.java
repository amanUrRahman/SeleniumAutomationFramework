package constants;

public final class FrameworkConstants {

	private FrameworkConstants() {
		// avoid inheriting this class
		// avoid creating objects for this class
	}
	
	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources/";
	private static final String CONFIGFILEPATH = RESOURCEPATH + "config/config.properties";
	private static final long EXPLICITWAIT = 10;

	public static long getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

}
