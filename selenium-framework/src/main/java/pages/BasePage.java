package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitlyWaitFactory;
import reports.ExtentLogger;

public class BasePage {
	
	protected void click(By by, String elementName) {
		WebElement element = ExplicitlyWaitFactory.performExplicitWait(by, WaitStrategy.CLICKABLE);
		element.click();
		ExtentLogger.pass(elementName + " is successfully clicked");
	}
	
	protected void sendKeys(By by, String text, String elementName) {
		WebElement element = ExplicitlyWaitFactory.performExplicitWait(by, WaitStrategy.VISIBLE);
		element.sendKeys(text);
		ExtentLogger.pass(text + " is entered successfully into " + elementName);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
