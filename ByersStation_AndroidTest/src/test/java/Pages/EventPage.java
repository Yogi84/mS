package Pages;

import org.openqa.selenium.By;

import Pages.InputPages.BaseClass;
import Pages.InputPages.ILogLevel;
import io.appium.java_client.AppiumDriver;
import pageObject.EventPageObject;

public class EventPage extends BaseClass{

	public EventPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void SearchEvent(String _text) {
		pause(10);
		if(isElementPresent(By.id(EventPageObject.searchField_id))) {
		waitForElementDisplayed(By.id(EventPageObject.searchField_id));
		sendKeys(By.id(EventPageObject.searchField_id), _text);
		log("Enter event name "+ _text +"in search field", ILogLevel.TEST);
		takeScreenshot("searchEvent");
		pause(5);
		}
	}
	
	public void clickEvent() {
		pause(5);
		if(isElementPresent(By.xpath(EventPageObject.eventImage_xpath))) {
		click(By.xpath(EventPageObject.eventImage_xpath));
		log("Clicked on searched event", ILogLevel.TEST);
		takeScreenshot("Event");
		}
		else {
			click(By.xpath(EventPageObject.eventImage1_xpath));
			log("Clicked on searched event", ILogLevel.TEST);
			takeScreenshot("Event");
			}
	}
	
	public void clickRSVP() {
		waitForElementDisplayed(By.xpath(EventPageObject.RSVP_xpath));
		takeScreenshot("RSVP");
		click(By.xpath(EventPageObject.RSVP_xpath));
		log("Clicked on RSVP button", ILogLevel.TEST);
	}
	
	public void clickYesOption() {
		waitForElementDisplayed(By.xpath(EventPageObject.RSVPYes_option_xpath));
		click(By.xpath(EventPageObject.RSVPYes_option_xpath));
		log("Clicked Yes option on RSVP", ILogLevel.TEST);
		takeScreenshot("Yes");
	}
	
	public void selectMember() {
		waitForElementDisplayed(By.xpath(EventPageObject.member_xpath));
		click(By.xpath(EventPageObject.member_xpath));
		log("member selected", ILogLevel.TEST);
		takeScreenshot("members");
	}
	
	public void clickSendResposeButton() {
		waitForElementDisplayed(By.xpath(EventPageObject.sendResponse_xpath));
		takeScreenshot("before response");
		click(By.xpath(EventPageObject.sendResponse_xpath));
		log("Clicked on Send button On RSVP", ILogLevel.TEST);
	}
	
	public String Respose() {
		return getText(By.xpath(EventPageObject.responseText_xpath));
	}
	

}
