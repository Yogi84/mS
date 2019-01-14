package Pages.InputPages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import configProperties.Config;

public class TestCore extends Page{

	public static Properties object = new Properties();
	public static Properties config = new Properties();
	public static AndroidDriver driver;
	public static String SCREENSHOT_FOLDER = "target/Screenshots/";
	public static final String SCREENSHOT_FORMAT = ".png";

	
	@BeforeMethod
	public void beforMethod(Method method) throws MalformedURLException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(Config.deviceName.equalsIgnoreCase("android")) {
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY3223FG76");
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.ignatiuz.byersstation");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "md5c1f42330f250ba5b1ebed8603446c59a.MainActivity");
		//capabilities.setCapability("deviceName", "3204a822185f2173");//note 3- 3204a822185f2173// s3-4df1b3c606d75f11//android//ZY3223FG76
		//capabilities.setCapability("appPackage", "com.ignatiuz.byersstation");
		//capabilities.setCapability("appActivity", "md5c1f42330f250ba5b1ebed8603446c59a.MainActivity");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(Config.deviceName.equalsIgnoreCase("aws")) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
			capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.ignatiuz.byersstation");
			capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "md5c1f42330f250ba5b1ebed8603446c59a.MainActivity");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		
		log("--------------------------------------------------------", ILogLevel.TESTCASE);
		log("---------Test ["+method.getName()+"] Started------------", ILogLevel.TESTCASE);
		log("--------------------------------------------------------", ILogLevel.TESTCASE);
		
		
	}

	@AfterMethod
	public void setScreenshot(ITestResult result,Method method) {

		log("--------------------------------------------------------", ILogLevel.TESTCASE);
		log("---------Test ["+method.getName()+"] Finished------------", ILogLevel.TESTCASE);
		log("--------------------------------------------------------", ILogLevel.TESTCASE);

		if(!result.isSuccess()||result.isSuccess()){
			BaseClass.captureScreenshot();
			BaseClass.takeScreenshot("Captured");
		}
		
		driver.quit();

	}

}


