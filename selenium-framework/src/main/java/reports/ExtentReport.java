package reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FrameworkConstants;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extentReport;

	public static void initReports() {
		if (Objects.isNull(extentReport)) {
			extentReport = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportfilepath());
			extentReport.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Execution Report");
			spark.config().setReportName("Test - Facebook");
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(extentReport)) {
			extentReport.flush();
			ExtentManager.removeExtentTest();
		}
	}

	public static void createTest(String testName) {
		ExtentManager.setExtentTest(extentReport.createTest(testName));
	}

}
