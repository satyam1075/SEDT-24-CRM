package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class SwitchApps 
{
	@Test
	public void switchapp() throws Throwable 
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Redmi Note 4");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("UDID", "0ea2b52b9904");
		
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");
		
		URL url =  new URL("http://localhost:4723/wd/hub");
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.startActivity("io.appium.android.apis", "ApiDemos");
		
		Thread.sleep(3000);
		driver.startActivity("com.androidsample.generalstore", ".SplashActivity");
		
		Thread.sleep(3000);
		driver.startActivity("io.appium.android.apis", "ApiDemos");
		
		
		//driver.closeApp();
		
		driver.pressKeyCode(AndroidKeyCode.HOME);
		
		driver.launchApp();
		
		driver.pressKeyCode(AndroidKeyCode.HOME);
		
		driver.launchApp();	
		
		//driver.quit();
	}
}
