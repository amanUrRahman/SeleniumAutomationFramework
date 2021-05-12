package factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import enums.ConfigProperties;
import exceptions.InvalidPathForFilesException;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropertyFileUtils;

public class DriverFactory {

	public static WebDriver getDriver() {

		WebDriver driver = null;
		String runmode = PropertyFileUtils.getValue(ConfigProperties.RUNMODE);
		if (PropertyFileUtils.getValue(ConfigProperties.BROWSER).equalsIgnoreCase(BrowserType.CHROME)) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				// cap.setVersion(version);
				try {
					driver = new RemoteWebDriver(new URL(PropertyFileUtils.getValue(ConfigProperties.SELENIUMGRIDURL)),	cap);
				} catch (MalformedURLException e) {
					throw new InvalidPathForFilesException("Issue observed in Grid URL formation");
				}
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} else if (PropertyFileUtils.getValue(ConfigProperties.BROWSER).equalsIgnoreCase(BrowserType.FIREFOX)) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				// cap.setVersion(version);
				try {
					driver = new RemoteWebDriver(new URL(PropertyFileUtils.getValue(ConfigProperties.SELENIUMGRIDURL)),	cap);
				} catch (MalformedURLException e) {
					throw new InvalidPathForFilesException("Issue observed in Grid URL formation");
				}
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		} else if (PropertyFileUtils.getValue(ConfigProperties.BROWSER).equalsIgnoreCase(BrowserType.EDGE)) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				// cap.setVersion(version);
				try {
					driver = new RemoteWebDriver(new URL(PropertyFileUtils.getValue(ConfigProperties.SELENIUMGRIDURL)),	cap);
				} catch (MalformedURLException e) {
					throw new InvalidPathForFilesException("Issue observed in Grid URL formation");
				}
			} else {
				WebDriverManager.edgedriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}
