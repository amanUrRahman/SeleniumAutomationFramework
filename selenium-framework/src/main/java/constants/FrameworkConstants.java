package constants;

import enums.ConfigProperties;
import utils.PropertyFileUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {
		// avoid inheriting this class
		// avoid creating objects for this class
	}

	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources/";
	private static final String EXCELFILEPATH = RESOURCEPATH + "excel/TestData.xlsx";
	private static final String CONFIGFILEPATH = RESOURCEPATH + "config/config.properties";
	private static final String REPORTFILEPATH = RESOURCEPATH + "extent-test-output";
	private static final long EXPLICITWAIT = 10;
	private static final String TESTDATA = "TestData";
	private static final String RUNMANAGER = "RunManager";

	public static String getReportfilepath() {
		if (PropertyFileUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return REPORTFILEPATH + "/" + System.currentTimeMillis() + "_TestResults.html";
		} else {
			return REPORTFILEPATH + "/" + "TestResults.html";
		}
	}

	public static long getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
	
	public static String getExcelpath() {
		return EXCELFILEPATH;
	}

	public static String getTestdata() {
		return TESTDATA;
	}

	public static String getRunmanager() {
		return RUNMANAGER;
	}
	
	


}
