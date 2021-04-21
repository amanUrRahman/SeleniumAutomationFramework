package driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropertyFileUtils;

public final class Driver {

	private Driver() {
		// avoid inheriting this class
		// avoid creating objects for this class
	}

	public static void initDriver() throws Exception {

		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(PropertyFileUtils.getValue(ConfigProperties.URL));
		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.removeDriver();
		}

	}

}
