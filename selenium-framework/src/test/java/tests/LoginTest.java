package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import reports.ExtentLogger;

public final class LoginTest extends BaseTest {

	private LoginTest() {
		// avoid inheriting this class
		// avoid creating objects for this class
	}

	@Test
	public void test1() throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		lp.enterUsername("Aman").enterPassword("Aman123").clickLogin();
		
	}

	@Test
	public void test2() throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		lp.enterUsername("Saba").enterPassword("Saba123").clickLogin();
	}
}
