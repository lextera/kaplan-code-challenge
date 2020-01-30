package pageclasses;

import org.openqa.selenium.WebDriver;

import base.BasePage;

public class EmailLogInPage extends BasePage{
	
	public WebDriver driver;
	
	public EmailLogInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}
	
	private String USERNAME = "id=>username";
	private String PASSWORD = "id=>password";
	private String LOGIN = "id=>login_btn";
	
	public EmailMainPage clickLogIn(String usr, String pwd) {
		
		sendData(USERNAME, usr, "Entering username");
		sendData(PASSWORD, pwd, "Entering password");
		elementClick(LOGIN, "Clicking \'LOGIN\' button");
		
		return new EmailMainPage(driver);
	}

}
