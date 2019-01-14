package Pages;

import org.openqa.selenium.By;

import Pages.InputPages.BaseClass;
import Pages.InputPages.ILogLevel;
import io.appium.java_client.AppiumDriver;
import pageObject.ByersStationPageObject;

public class ByersStationPage extends BaseClass{

	public ByersStationPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickEventitem() {
		waitForElementDisplayed(By.xpath(ByersStationPageObject.event_xpath));
		takeScreenshot("Event items");
		click(By.xpath(ByersStationPageObject.event_xpath));
		log("Clicked on event item", ILogLevel.TEST);
	}

}
