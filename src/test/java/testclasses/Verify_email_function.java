package testclasses;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pageclasses.EmailLogInPage;

public class Verify_email_function extends BaseTest{
	
	
	String emailSubject = "Selenium Challenge";
	String emailBody = "Hello World";
	
	// requirement # 3
	@DataProvider(name = "userCredentials" )
	public Object [][] testData(){
		return new Object [][]{
			
			{"selenium_user1@protonmail.com", "Mcl12345"},
			{"selenium_user2@protonmail.com", "Mcl12345"}
			
		};
		
	}
	
	
	@Test (dataProvider = "userCredentials")
	public void testCase1(String userEmail, String pass) {
		emailLoginPage = new EmailLogInPage(driver);
		emailMainPage = emailLoginPage.clickLogIn(userEmail, pass);
		boolean result = emailMainPage.isThereAnEmail(); // requirement # 1
		Assert.assertTrue(result);
		
		emailMainPage.composeEmail(userEmail, emailSubject, emailBody);
		boolean result1 = emailMainPage.verifyEmail_Subject_Body(emailSubject, emailBody); // requirement # 2
		Assert.assertTrue(result1);
	}

	

}
