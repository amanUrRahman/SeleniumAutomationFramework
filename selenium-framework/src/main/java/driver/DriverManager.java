package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {
		// avoid inheriting this class
		// avoid creating objects for this class
	}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverReference) {
		driver.set(driverReference);
	}

	public static void removeDriver() {
		driver.remove();
	}

}
