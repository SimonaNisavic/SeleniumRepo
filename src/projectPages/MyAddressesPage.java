package projectPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAddressesPage {

	WebDriver driver;
	WebElement updateButton;
	WebElement deleteButton;
	WebElement addANewAddressButton;
	WebElement firstNameInputField;
	WebElement lastNameInputField;
	WebElement addressInputField;
	WebElement cityInputField;
	Select stateDropDownList;
	WebElement postalCodeInputField;
	Select countryDropDownList;
	WebElement mobilePhoneInputField;
	WebElement addressTitle;
	WebElement saveButton;
	WebElement addressLabel;
	WebElement secondAddressTitleLabel;

	
	
	
	public MyAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
				
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[2]"));
	}

	public WebElement getAddANewAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a/span"));
	}
	public WebElement getFirstNameInputField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameInputField() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getAddressInputField() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getCityInputField() {
		return driver.findElement(By.id("city"));
	}

	public Select getStateDropDownList() {
		stateDropDownList = new Select (driver.findElement(By.id("id_state")));
		return stateDropDownList;
	}

	public WebElement getPostalCodeInputField() {
		return driver.findElement(By.id("postcode"));
	}

	public Select getCountryDropDownList() {
		countryDropDownList = new Select (driver.findElement(By.id("id_country")));
		return countryDropDownList;
	}

	public WebElement getMobilePhoneInputField() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getAddressTitle() {
		return driver.findElement(By.id("alias"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	
	
	public WebElement getAddressLabel() {
		return driver.findElement(By.className("address_address1"));
	}

	
	public WebElement getSecondAddressTitleLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[1]/h3"));
	}
	

	public void updateButtonClick () {
		this.getUpdateButton().click();
	}
	
	public void deleteButtonClick () {
		this.getDeleteButton().click();
	}
	public void addANewAddressButtonClick () {
		this.getAddANewAddressButton().click();
	}

	public void insertFirstName(String name) {
		this.getFirstNameInputField().clear();
		this.getFirstNameInputField().sendKeys(name);
	}
	
	public void insertLastName(String lastname) {
		this.getLastNameInputField().clear();
		this.getLastNameInputField().sendKeys(lastname);
	}
	
	public void insertAddress(String address) {
		this.getAddressInputField().clear();
		this.getAddressInputField().sendKeys(address);
	}
	public void insertCity(String city) {
		this.getCityInputField().clear();
		this.getCityInputField().sendKeys(city);
	}
	
	public void insertPostalCode(int postalCode) {
		this.getPostalCodeInputField().clear();
		this.getPostalCodeInputField().sendKeys(String.valueOf(postalCode));
	}
	public void insertMobilePhone(int mobilePhone) {
		this.getMobilePhoneInputField().clear();
		this.getMobilePhoneInputField().sendKeys(String.valueOf(mobilePhone));
	}
	public void insertAddressTitle(String alias) {
		this.getAddressTitle().clear();
		this.getAddressTitle().sendKeys(alias);
	}
	
	public void selectStateFromDropDownList (String state) {
		this.getStateDropDownList().selectByVisibleText(state);
	}
	
	public void selectCountryFromDropDownList (String country) {
		this.getCountryDropDownList().selectByVisibleText(country);
	}
	
	public void saveButtonClick () {
		this.getSaveButton().click();
	}
	
	public String textFromAddressLabel() {
		return this.getAddressLabel().getText();
	}
	public String textFromSecondAddressTitleLabel() {
		return this.getSecondAddressTitleLabel().getText();
	}
	
	public int numberOfAddresses() {
		List <WebElement> listAddresses = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[2]"));
		return listAddresses.size();
				
	}
	
}
