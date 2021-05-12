package factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;

public final class ExplicitlyWaitFactory {

	private ExplicitlyWaitFactory() {
	}

	public static WebElement performExplicitWait(By by, WaitStrategy wait) {
		WebElement element = null;
		WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait());
		switch (wait) {
		case CLICKABLE:
			element = explicitWait.until(ExpectedConditions.elementToBeClickable(by));
		case PRESENCE:
			element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(by));
		case VISIBLE:
			element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		case NONE:
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
