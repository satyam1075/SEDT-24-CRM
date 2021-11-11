package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

	public class LaaunchApp {
	@Test
	public void lauchapp() throws MalformedURLException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		//common  Dc Android or IOS
		dc.setCapability("deviceName", "realme 8");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "11");
		dc.setCapability("UDID", "something from adb device in cmd");
		
		//Dc for Android
		dc.setCapability("appPackage", "com.oppo.camera");
		dc.setCapability("appActivity", ".Camera");
		
		//Android port
		URL url = new URL("http://localhost:4723/wd/hub");
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(url, dc);
		}
}
