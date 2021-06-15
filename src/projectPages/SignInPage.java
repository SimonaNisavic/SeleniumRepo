package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	WebDriver driver;
	WebElement emailAddressFiled;
	WebElement passwordField;
	WebElement signIn;
	
	public SignInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getEmailAddressFiled() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignIn() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	
	
	public void insertEmailAddress (String emailAddress) {
		this.getEmailAddressFiled().sendKeys(emailAddress);
	}
	
	public void insertPassword (String password) {
		this.getPasswordField().sendKeys(password);
	}

	public void signInButtonClick() {
		this.getSignIn().click();
	}
	
	public String textFromSignInButton () {
		return this.getSignIn().getText();
	}
}
