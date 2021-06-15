package projectTests;


	import java.io.IOException;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;


import projectPages.MainNavigation;
import projectPages.MyAccountPage;
import projectPages.MyAddressesPage;
import projectPages.MyPersonalInformationPage;
import projectPages.MyWishlistPage;
import projectPages.SignInPage;


	public class BaseTests {

		WebDriver driver;
	    MainNavigation mainNavigation;
	    SignInPage signInPage;
	    ExcelReader citacIzExcela;
		String homeURL;
		MyAccountPage myAccountPage;
		MyAddressesPage myAddressesPage;
		MyPersonalInformationPage myPersonalInfoPage;
		MyWishlistPage myWishlistPage;
		
		
		
		@BeforeClass
		public void preSihTestova() throws IOException {
			System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    mainNavigation = new MainNavigation (driver);
		    signInPage = new SignInPage (driver);
			citacIzExcela = new ExcelReader("data/Project- Simona Nisavic.xlsx");
			homeURL = " http://automationpractice.com/index.php";
			myAccountPage = new MyAccountPage (driver);
			myAddressesPage = new MyAddressesPage(driver);
			myPersonalInfoPage = new MyPersonalInformationPage(driver);
			myWishlistPage = new MyWishlistPage(driver);
			
		}
		
		@AfterClass
		public void posleSihTestova() {
			driver.close();
		}
		
	}

