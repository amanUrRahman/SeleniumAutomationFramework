package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.DriverManager;

public final class LoginTest extends BaseTest {

	private LoginTest() {
		// avoid inheriting this class
		// avoid creating objects for this class
	}

	@Test
	public void test1() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Aman");
		DriverManager.getDriver().findElement(By.name("q")).submit();
		Thread.sleep(2000);

	}

}
