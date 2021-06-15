package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;
	WebElement myAccountLabel;
	WebElement myAddresses;
	WebElement myPersonalInformation;
	WebElement myWishlists;
	WebElement authenticationLabel;
	WebElement signOutButton;
	
	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getMyAccountLabel() {
		return driver.findElement(By.className("info-account"));
	}

	public WebElement getMyAddresses() {
		return driver.findElement(By.className("icon-building"));
	}

	public WebElement getMyPersonalInformation() {
		return driver.findElement(By.className("icon-user"));
	}

	public WebElement getMyWishlists() {
		return driver.findElement(By.className("icon-heart"));
	}
	
	
	public WebElement getAuthenticationLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}

	public void myAddressesButtonClick () {
		this.getMyAddresses().click();
	}
	public void myPersonalInformationClick () {
		this.getMyPersonalInformation().click();
	}
	public void myWishlistsClick () {
		this.getMyWishlists().click();
	}
	
	public String textFromMyAccountLabel () {
		return this.getMyAccountLabel().getText();
	}
	public String textFromMyAuthenticationLabel () {
		return this.getAuthenticationLabel().getText();
	}
	
	public void signOutButtonClick () {
		this.getSignOutButton().click();
	}
	
  
	
}
