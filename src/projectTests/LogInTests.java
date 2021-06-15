package projectTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTests{

	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void logInValidCredentials() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		String textForAssertion = citacIzExcela.getStringData("LogInTests", 9, 2);
		logInFormFilling(emailAddress, password);
		String actualText = myAccountPage.textFromMyAccountLabel();
		assertEquals(actualText, textForAssertion);
	}
	

	@Test(priority = 5)
	public void logInInvalidEmailAddress() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 4);
		String password = citacIzExcela.getStringData("LogInTests", 7, 4);
		String textForAssertion = citacIzExcela.getStringData("LogInTests", 9, 4);
		logInFormFilling(emailAddress, password);
		String actualText = myAccountPage.textFromMyAuthenticationLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 10)
	public void logInInvalidPassword() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 6);
		String password = citacIzExcela.getStringData("LogInTests", 7, 6);
		String textForAssertion = citacIzExcela.getStringData("LogInTests", 9, 6);
		logInFormFilling(emailAddress, password);
		String actualText = myAccountPage.textFromMyAuthenticationLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 15)
	public void logInEmptyCredentials() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 8);
		String password = citacIzExcela.getStringData("LogInTests", 7, 8);
		String textForAssertion = citacIzExcela.getStringData("LogInTests", 9, 8);
		logInFormFilling(emailAddress, password);
		String actualText = myAccountPage.textFromMyAuthenticationLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 20)
	public void logOut() throws InterruptedException {
		logInValidCredentials();
		myAccountPage.signOutButtonClick();
		String textForAssertion = citacIzExcela.getStringData("LogInTests", 26, 2);
		String actualText = signInPage.textFromSignInButton();
		assertEquals(actualText, textForAssertion);
	}
	
	public void logInFormFilling(String emailAddress, String password) {
		mainNavigation.signInTabClick();
		signInPage.insertEmailAddress(emailAddress);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
	}
	
	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	
}
