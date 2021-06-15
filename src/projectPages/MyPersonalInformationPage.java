package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class MyPersonalInformationPage {

	WebDriver driver;
	WebElement socialTitle1RadioButton;
	WebElement socialTitle2RadioButton;
	WebElement firstNameInputField;
	WebElement lastNameInputField;
	Select dayDropDownList;
	Select monthDropDownList;
	Select yearDropDownList;
	WebElement emailAddress;
	WebElement currentPassword;
	WebElement saveButton;
	WebElement updatedDataLabel;
	
	
	public MyPersonalInformationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSocialTitle1RadioButton() {
		return driver.findElement(By.id("id_gender1"));
	}
    
	
	public WebElement getSocialTitle2RadioButton() {
		return driver.findElement(By.id("id_gender2"));
	}

	public WebElement getFirstNameInputField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameInputField() {
		return driver.findElement(By.id("lastname"));
	}

	public Select getDayDropDownList() {
		dayDropDownList = new Select(driver.findElement(By.id("days")));
		return dayDropDownList;
	}

	public Select getMonthDropDownList() {
		monthDropDownList =new Select(driver.findElement(By.id("months")));
		return monthDropDownList;
	}

	public Select getYearDropDownList() {
		yearDropDownList =new Select(driver.findElement(By.id("years")));
		return yearDropDownList;
	}

	public WebElement getEmailAddress() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getCurrentPassword() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button/span"));
	}
	
	
	
	public WebElement getUpdatedDataLabel() {
		return driver.findElement(By.cssSelector(".alert.alert-success"));
	}

	public void chooseSocialTitle1() {
		this.getSocialTitle1RadioButton().click();
	}
	public void chooseSocialTitle2() {
		this.getSocialTitle2RadioButton().click();
	}
	public void insertFirstName(String name) {
		this.getFirstNameInputField().clear();
		this.getFirstNameInputField().sendKeys(name);
	}
	
	public void insertLastName(String lastname) {
		this.getLastNameInputField().clear();
		this.getLastNameInputField().sendKeys(lastname);
	}
	
	public void insertEmailAddress(String email) {
		this.getEmailAddress().clear();
		this.getEmailAddress().sendKeys(email);
	}
	public void selectDayofBirth (String day) {
		this.getDayDropDownList().selectByValue(day);
	}
	public void selectMonthofBirth (String month) {
		this.getMonthDropDownList().selectByValue(month);
	}
	public void selectYearofBirth (String year) {
		this.getYearDropDownList().selectByValue(year);
	}
	
	public void insertCurrentPassword(String currentpassword) {
		this.getCurrentPassword().sendKeys(currentpassword);
	}
	public void saveButtonClick () {
		this.getSaveButton().click();
	}
	
	public String textFromUpdatedDataLabel() {
		return this.getUpdatedDataLabel().getText();
	}
	
	public boolean mrsIsSelected () {
		this.getSocialTitle2RadioButton().isSelected();
		return true;
	}
}
