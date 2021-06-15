package projectTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonlaInformationTests extends BaseTests{
	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void changeSocialTitle() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myPersonalInformationClick();
		if (myPersonalInfoPage.mrsIsSelected()==true) {
			myPersonalInfoPage.chooseSocialTitle1();
		} else {
			myPersonalInfoPage.chooseSocialTitle2();
		}
	
		myPersonalInfoPage.insertCurrentPassword(password);
		myPersonalInfoPage.saveButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("MyAccountTests", 43, 2);
		String actualText = myPersonalInfoPage.textFromUpdatedDataLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 5)
	public void changeFirstName() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myPersonalInformationClick();
	    String name = citacIzExcela.getStringData("MyAccountTests", 49, 2);
		myPersonalInfoPage.insertFirstName(name);
		myPersonalInfoPage.insertCurrentPassword(password);
		myPersonalInfoPage.saveButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("MyAccountTests", 52, 2);
		String actualText = myPersonalInfoPage.textFromUpdatedDataLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 10)
	public void changeLastName() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myPersonalInformationClick();
	    String lastname = citacIzExcela.getStringData("MyAccountTests", 58, 2);
		myPersonalInfoPage.insertLastName(lastname);
		myPersonalInfoPage.insertCurrentPassword(password);
		myPersonalInfoPage.saveButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("MyAccountTests", 61, 2);
		String actualText = myPersonalInfoPage.textFromUpdatedDataLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 15)
	public void changeDateOfBirth() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myPersonalInformationClick();
		myPersonalInfoPage.selectDayofBirth("3");
	    //myPersonalInfoPage.selectDayofBirth(String.valueOf(citacIzExcela.getIntegerData("MyAccountTest", 67, 2)));
	    myPersonalInfoPage.selectMonthofBirth("9");
	    //myPersonalInfoPage.selectMonthofBirth(String.valueOf(citacIzExcela.getIntegerData("MyAccountTest", 68, 2)));
	    myPersonalInfoPage.selectYearofBirth("1985");
		//myPersonalInfoPage.selectYearofBirth(String.valueOf(citacIzExcela.getIntegerData("MyAccountTest", 69, 2)));
	
		myPersonalInfoPage.insertCurrentPassword(password);
		myPersonalInfoPage.saveButtonClick();
		
		String textForAssertion = citacIzExcela.getStringData("MyAccountTests", 72, 2);
		String actualText = myPersonalInfoPage.textFromUpdatedDataLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 20)
	public void backToDefaultData() throws InterruptedException {
     setDefaultPersonalInfo();
	
	}
	
	
	public void logInFormFilling(String emailAddress, String password) {
		mainNavigation.signInTabClick();
		signInPage.insertEmailAddress(emailAddress);
		signInPage.insertPassword(password);
		signInPage.signInButtonClick();
	}
	
	
	public void setDefaultPersonalInfo() {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myPersonalInformationClick();
		myPersonalInfoPage.chooseSocialTitle2();
		myPersonalInfoPage.insertFirstName("Simona");
		myPersonalInfoPage.insertLastName("Lugumerski");
		myPersonalInfoPage.selectDayofBirth("29");
		myPersonalInfoPage.selectMonthofBirth("11");
		myPersonalInfoPage.selectYearofBirth("1984");
		String currentpassword = citacIzExcela.getStringData("LogInTests", 7, 2);
		myPersonalInfoPage.insertCurrentPassword (currentpassword);
		myPersonalInfoPage.saveButtonClick();
	}
	
	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
