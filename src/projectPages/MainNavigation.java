package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainNavigation {

	WebDriver driver;
	WebElement signInTab;
	
	
	public MainNavigation(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSignInTab() {
		return driver.findElement(By.className("login"));
	}
	
	public void signInTabClick() {
		this.getSignInTab().click();
	}

	
}
