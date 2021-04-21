package factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;

public class ExplicitlyWaitFactory {

	public static WebElement performExplicitWait(By by, WaitStrategy wait) {
		WebElement element = null;
		switch (wait) {
		case CLICKABLE:
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.elementToBeClickable(by));
		case PRESENCE:
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		case VISIBLE:
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		case NONE:
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
