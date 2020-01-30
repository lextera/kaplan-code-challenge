package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import utilities.Util;

public class EmailMainPage extends BasePage{
	
	public WebDriver driver;
	
	public EmailMainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String EMAIL_LIST = "xpath=>//div[@ng-repeat='conversation in conversations track by conversation.ID']";
	public String COMPOSE_BUTTON = "xpath=>//button[@class='compose pm_button sidebar-btn-compose']";
	public String TO_RECIPIENT = "xpath=>//form[@data-key='ToList']//input[contains(@id,'autocomplete')]";
	public String EMAIL_SUBJECT = "xpath=>//input[@ng-model='message.Subject']";
	public String EMAIL_BODY = "xpath=>//body[@contenteditable='true']";
	public String SEND_EMAIL_BUTTON = "xpath=>//button[text()='Send']";
	public String EMAIL_BODY_CONTENT = "xpath=>//div[@class='bodyDecrypted email message-body-container']/div[1]";
	public String EMAIL_SUBJECT_LIST = "xpath=>//div[@class='row top']//span[@class='subject-text ellipsis']";
	
	public String HEADER_SUBJ = "xpath=>//header[@id='conversationHeader']//span";
	public String BODY_TEXT = "xpath=>//div[@class='bodyDecrypted email message-body-container']";
	
	
	public boolean isThereAnEmail() {
		
		return isElementPresent(EMAIL_LIST, "Counting list of email");
	}
	
	public void composeEmail(String to, String sbj, String body) {
		
		elementClick(COMPOSE_BUTTON, "Clicking \'Compose\' button");
		waitForElement(TO_RECIPIENT, 3);
		sendData(TO_RECIPIENT, to, "Entering EMAIL recipient");
		waitForElement(EMAIL_SUBJECT, 3);
		sendData(EMAIL_SUBJECT, sbj, "Entering Email Subject");
		driver.switchTo().frame(0);
		sendData(EMAIL_BODY, body, "Entering Email text body");
		driver.switchTo().defaultContent();
		waitForElement(SEND_EMAIL_BUTTON, 3);
		elementClick(SEND_EMAIL_BUTTON, "Clicking \'SEND\' button");
		
		
	}
	
	public boolean verifyEmail_Subject_Body(String subj, String body) {
		
		
		waitForLoading(EMAIL_SUBJECT_LIST, 6);
		selectFromListofEmail(EMAIL_SUBJECT_LIST, "Clicking the subject", subj);
		
		String subjcOutput = getText(HEADER_SUBJ, "Caprturing Subject text");
		String headerOutput = getText(BODY_TEXT,"Capturing body text");
		
		return  subj.equalsIgnoreCase(getText(HEADER_SUBJ, "Caprturing Subject text")) && body.equalsIgnoreCase(getText(BODY_TEXT,"Capturing body text"));

		
		
	}

}
