package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import Pages.InputPages.BaseClass;
import Pages.InputPages.ILogLevel;
import configProperties.Config;
import io.appium.java_client.AppiumDriver;
import pageObject.LoginPageObject;


public class LoginPage extends BaseClass{

	public LoginPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterMobileNUmber() {
	waitForElementDisplayed(By.xpath(LoginPageObject.mobileNumber_xpath));
	sendKeys(By.xpath(LoginPageObject.mobileNumber_xpath), Config.MobileNo);
	/*pause(5);
	if(driver.findElement(By.xpath("//*[@text='OK']")).isEnabled()) {
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		sendKeys(By.xpath(LoginPageObject.mobileNumber_xpath), Config.MobileNo);
	}*/
	/*if(isElementPresent(By.id("android:id/button1"))) {
	click(By.id("android:id/button1"));
	}
	else if(isAlertPresent()) {
		acceptAlert();
	}
	else {
		click(By.id("android:id/button2"));
	}*/
	log("Enter mobile number", ILogLevel.TEST);
	takeScreenshot("mobile");
	}
	
	public void acceptAndroidPopup() {
		waitForElementDisplayed(By.xpath(LoginPageObject.mobileNumber_xpath));
		try {	
		click(By.xpath(LoginPageObject.mobileNumber_xpath));	
		click(By.id("android:id/button1"));
		log("Android popup clicked", ILogLevel.TEST);
		}
		catch(Exception e) {
			
		}
	}
	
	public void clickCheckbox() {
		if(isElementPresent(By.xpath(LoginPageObject.checkbox_xpath))) {
			click(By.xpath(LoginPageObject.checkbox_xpath));
			}
			else {
				click(By.xpath(LoginPageObject.checkbox1_xpath));
			}
		log("Cliked Term and condition checkbox", ILogLevel.TEST);
		takeScreenshot("checkbox");
		
		
	}
	
	public void enterTokenNUmber() {
	waitForElementDisplayed(By.xpath(LoginPageObject.tokenNumber_xpath));
	sendKeys(By.xpath(LoginPageObject.tokenNumber_xpath), Config.Token);
	log("Enter Token number", ILogLevel.TEST);
	takeScreenshot("token");
	}
	
	public void acceptPopup() {
		takeScreenshot("popup");
		waitForElementDisplayed(By.xpath(LoginPageObject.popupButton_xpath));
		click(By.xpath(LoginPageObject.popupButton_xpath));
		log("Please check the box to proceed clikced", ILogLevel.TEST);
	}
	public void handleAlert() {
		pause(10);
		try {
		if(isAlertPresent()) {
			acceptAlert();
		}
		}
		catch(Exception e) {
			
		}
	}
}
