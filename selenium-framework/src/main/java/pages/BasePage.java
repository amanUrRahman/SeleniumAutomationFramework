package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitlyWaitFactory;

public class BasePage {
	
	protected void click(By by) {
		WebElement element = ExplicitlyWaitFactory.performExplicitWait(by, WaitStrategy.CLICKABLE);
		element.click();
	}
	
	protected void sendKeys(By by, String text) {
		WebElement element = ExplicitlyWaitFactory.performExplicitWait(by, WaitStrategy.VISIBLE);
		element.sendKeys(text);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
