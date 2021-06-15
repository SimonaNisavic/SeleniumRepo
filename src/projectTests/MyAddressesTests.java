package projectTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressesTests extends BaseTests{
	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 10)
	public void updateAddress() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myAddressesButtonClick();
		myAddressesPage.updateButtonClick();
		String address = citacIzExcela.getStringData("MyAccountTests", 8, 2);
		myAddressesPage.insertAddress(address);
		String alias = citacIzExcela.getStringData("MyAccountTests", 9, 2);
		myAddressesPage.insertAddressTitle(alias);
		myAddressesPage.saveButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("MyAccountTests", 11, 2);
		String actualText = myAddressesPage.textFromAddressLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 0)
	public void addANewAddress() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myAddressesButtonClick();
		myAddressesPage.addANewAddressButtonClick();
		
		String address = citacIzExcela.getStringData("MyAccountTests", 18, 2);
		myAddressesPage.insertAddress(address);
		String city = citacIzExcela.getStringData("MyAccountTests", 19, 2);
		myAddressesPage.insertCity(city);
	    myAddressesPage.selectStateFromDropDownList(citacIzExcela.getStringData("MyAccountTests", 20, 2));
	    myAddressesPage.insertPostalCode(citacIzExcela.getIntegerData("MyAccountTests", 21, 2));
	    myAddressesPage.insertMobilePhone(citacIzExcela.getIntegerData("MyAccountTests", 22, 2));
	    myAddressesPage.insertAddressTitle(citacIzExcela.getStringData("MyAccountTests", 23, 2));
	    myAddressesPage.saveButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("MyAccountTests", 25, 2);
		String actualText = myAddressesPage.textFromSecondAddressTitleLabel();
		assertEquals(actualText, textForAssertion);
	}
	

	@Test(priority = 5)
	public void deleteAddress() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myAddressesButtonClick();
		myAddressesPage.deleteButtonClick();
		driver.switchTo().alert().accept();
		
		int numberOfAddresses = myAddressesPage.numberOfAddresses();
		assertEquals(numberOfAddresses, 1);
		//String textForAssertion = citacIzExcela.getStringData("MyAccountTests", 33, 2);
		//String actualText = myAddressesPage.textFromAddressLabel();
		//assertEquals(actualText, textForAssertion);
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
