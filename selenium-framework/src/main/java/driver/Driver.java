package driver;

import java.util.Objects;

import enums.ConfigProperties;
import factories.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropertyFileUtils;

public final class Driver {

	private Driver() {
		// avoid inheriting this class
		// avoid creating objects for this class
	}

	public static void initDriver() {

		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(DriverFactory.getDriver());
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
