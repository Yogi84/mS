package Pages;

import org.openqa.selenium.By;

import Pages.InputPages.BaseClass;
import Pages.InputPages.ILogLevel;
import io.appium.java_client.AppiumDriver;
import pageObject.HomePageObject;

public class HomePage extends BaseClass{

	public HomePage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickLandingButton() {
		if(isElementPresent(By.xpath(HomePageObject.landingButton_xpath))) {
		takeScreenshot("landing");
		click(By.xpath(HomePageObject.landingButton_xpath));
		}
		else {
			takeScreenshot("landing");
			click(By.xpath(HomePageObject.landingButton1_xpath));
		}
		log("Click on Home Landing button", ILogLevel.TEST);
	}
	
	public boolean verifyLandingButton() {
		boolean ele = isElementPresent(By.xpath(HomePageObject.landingButton_xpath));
		if(ele) {
			return true;
		}
		return false;
	}

}
