package projectPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MyWishlistPage {

	WebDriver driver;
	WebElement wishlistName;
	WebElement saveButton;
	WebElement deleteWishList;
	
	
	public MyWishlistPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getWishlistName() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[@id=\"submitWishlist\"]"));
	}
	
	
	public WebElement getDeleteWishList() {
		return driver.findElement(By.className("icon"));
	}

	public void insertWishlistName(String name) {
		this.getWishlistName().clear();
		this.getWishlistName().sendKeys(name);
	}
	
	public boolean deleteWishListIsVisible() {
		this.getDeleteWishList().isDisplayed();
		return true;
	}
	
	public void saveButtonClick() {
		this.getSaveButton().click();
	}
	
	public void deleteWishListClick() {
		this.getDeleteWishList().click();
	}

	public int numberOfWishlists() {
		List <WebElement> listaWishListi = driver.findElements(By.className("wishlist_delete"));
		return listaWishListi.size();
				
	}

}
