package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {

	}
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	static void setExtentTest(ExtentTest extentTestReference) {
		extentTest.set(extentTestReference);
	}

	static void removeExtentTest() {
		extentTest.remove();
	}


}
