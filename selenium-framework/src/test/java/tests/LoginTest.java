package tests;

import java.util.Map;

import org.testng.annotations.Test;

import pages.LoginPage;

public final class LoginTest extends BaseTest {

	private LoginTest() {
		// avoid inheriting this class
		// avoid creating objects for this class
	}

	@Test
	public void test1(Map<String, String> data) throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		lp.enterUsername(data.get("Username")).enterPassword(data.get("Password")).clickLogin();
		
	}

	@Test
	public void test2(Map<String, String> data) throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		lp.enterUsername("Adnan").enterPassword("Adnan123").clickLogin();
	}
}
