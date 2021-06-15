package projectTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistTests extends BaseTests{

	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	
	@Test(priority = 0)
	public void addWishList() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myWishlistsClick();
		myWishlistPage.insertWishlistName(citacIzExcela.getStringData("MyAccountTests", 79, 2));
		myWishlistPage.saveButtonClick();
		boolean actual= myWishlistPage.deleteWishListIsVisible();
		assertEquals(actual, true);
	}
	
	@Test(priority = 5)
	public void addMultipleWishlist() throws InterruptedException {
		String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myWishlistsClick();	
		myWishlistPage.insertWishlistName(citacIzExcela.getStringData("MyAccountTests", 87, 2));
		myWishlistPage.saveButtonClick();
		myWishlistPage.insertWishlistName(citacIzExcela.getStringData("MyAccountTests", 89, 2));
		myWishlistPage.saveButtonClick();
		myWishlistPage.insertWishlistName(citacIzExcela.getStringData("MyAccountTests", 91, 2));
		myWishlistPage.saveButtonClick();
		
		int actualNumberOfLists = myWishlistPage.numberOfWishlists();
		assertEquals(actualNumberOfLists, 4);
				
	}
	
  @Test(priority = 10)
    public void deleteWishlist() throws InterruptedException {
    	String emailAddress = citacIzExcela.getStringData("LogInTests", 6, 2);
		String password = citacIzExcela.getStringData("LogInTests", 7, 2);
		logInFormFilling(emailAddress, password);
		myAccountPage.myWishlistsClick();
		myWishlistPage.deleteWishListClick();
	    driver.switchTo().alert().accept();
	    
	    Thread.sleep(2000);
	   
	    int actualNumberOfLists = myWishlistPage.numberOfWishlists();
		assertEquals(actualNumberOfLists, 3);
				
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
