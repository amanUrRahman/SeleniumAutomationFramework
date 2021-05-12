package reports;

import com.aventstack.extentreports.MediaEntityBuilder;

import enums.ConfigProperties;
import utils.PropertyFileUtils;
import utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		if (PropertyFileUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else
			ExtentManager.getExtentTest().pass(message);

	}

	public static void fail(String message) {
		if (PropertyFileUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes")) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else
			ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		if (PropertyFileUtils.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else
			ExtentManager.getExtentTest().skip(message);
	}

}
