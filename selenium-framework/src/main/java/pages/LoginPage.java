package pages;

import org.openqa.selenium.By;

public final class LoginPage extends BasePage {

	private final By textBoxUername = By.id("email");
	private final By testBoxPassword = By.id("pass");
	private final By ButtonLogin = By.name("login");
	private final By LinkForgottenPassword = By.xpath("//a[text()='Forgotten password?']");
	private final By ButtonNewAccount = By.name("login");

	public LoginPage enterUsername(String name) {
		sendKeys(textBoxUername, name, "Username");
		return this;
	}

	public LoginPage enterPassword(String pass) {
		sendKeys(testBoxPassword, pass, "Password");
		return this;
	}

	public HomePage clickLogin() {
		click(ButtonLogin, "Login Button");
		return new HomePage();
	}

	public ForgottenPasswordPage clickForgottenPassword() {
		click(LinkForgottenPassword, "Forgotten Password Link");
		return new ForgottenPasswordPage();
	}

	public void clickCreateNewAccount() {
		click(ButtonNewAccount, "Create New Account Button");
	}

}
