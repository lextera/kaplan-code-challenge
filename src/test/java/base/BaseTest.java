package base;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageclasses.EmailLogInPage;
import pageclasses.EmailMainPage;
import utilities.Constants;

public class BaseTest {
	
	protected WebDriver driver;
	protected String baseURL;
	protected EmailLogInPage emailLoginPage;
	protected EmailMainPage emailMainPage;

	@BeforeMethod
	//there was a parameter here from testng
	public void commonSetUp() {

		driver = WebDriverFactory.getInstance().getDriver("chrome");
		baseURL = Constants.BASE_URL;
		driver.get(baseURL);
		

	}
	
	@AfterMethod
	public void commonTearDown() {
		//driver.quit();
		WebDriverFactory.getInstance().quitDriver();
	}
}
