package TestScripts;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class UninstallAppiumDemo 
{
	@Test
	public void installApplication() throws Throwable 
	{

		
		ReadDataFromPropertyFile x = new ReadDataFromPropertyFile();
		String platformname = x.getPropertyeyValue("platformName");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		//common  Dc Android or IOS
		dc.setCapability("deviceName", "realme 8");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "11");
		dc.setCapability("UDID", "something from adb device in cmd");
		
		
		//Android port
		URL url = new URL("http://localhost:4723/wd/hub");
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		 * is app installed takes argument as app package and returns boolean
		 * where as revoveapp method will uninstall the app from the phone and takes argument as app package
		 */
		if(driver.isAppInstalled("appPakage")) 
		{
			driver.removeApp("appPackage");
		}
		}
}
