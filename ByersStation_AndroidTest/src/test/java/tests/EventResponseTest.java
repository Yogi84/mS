package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Pages.InputPages.BaseClass;
import Pages.InputPages.ILogLevel;
import Pages.InputPages.TestCore;
import configProperties.Config;
import Pages.ByersStationPage;
import Pages.EventPage;
import Pages.HomePage;
import Pages.LoginPage;

public class EventResponseTest extends TestCore{
	
	@Test(enabled=true)
	public void eventResposeTest(){
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		ByersStationPage byers = new ByersStationPage(driver);
		EventPage eventPage = new EventPage(driver);
		BaseClass basePage = new BaseClass(driver);
		
		log("Test Started [Send Event Response ] test", ILogLevel.TESTCASE);
		BaseClass.takeScreenshot("launch");
		loginPage.acceptAndroidPopup();
		loginPage.clickCheckbox();
		loginPage.enterMobileNUmber();
		loginPage.enterTokenNUmber();
		homePage.clickLandingButton();
		byers.clickEventitem();
		eventPage.SearchEvent(Config.EventName);
		eventPage.clickEvent();
		eventPage.clickRSVP();
		eventPage.clickYesOption();
		eventPage.selectMember();
		eventPage.clickSendResposeButton();
		assertEquals(eventPage.Respose(), "Visiting (Total members: 3)", "Visiting response does not present on page");
		basePage.navigateToBack();
		basePage.navigateToBack();
		basePage.navigateToBack();
		homePage.clickLandingButton();
		byers.clickEventitem();
		eventPage.SearchEvent(Config.EventName);
		eventPage.clickEvent();
		assertEquals(eventPage.Respose(), "Visiting (Total members: 3)", "Visiting response does not present on page");
		log("Test Completed Successfully", ILogLevel.TESTCASE);
	}

}
