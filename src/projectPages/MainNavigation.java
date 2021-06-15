package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainNavigation {

	WebDriver driver;
	WebElement signInTab;
	WebElement dressesTab;
	
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

	public WebElement getDressesTab() {
		return driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
	}
	
	public void dressesTabClick() {
		this.getDressesTab().click();
	}
}
