package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Notification 
{
	@Test
	public void notification() throws Throwable 
	{
DesiredCapabilities dc= new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Redmi Note 4");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("UDID", "0ea2b52b9904");
		
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "ApiDemos");
		
		URL url =  new URL("http://localhost:4723/wd/hub");
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		
		//driver.findElement(By.id("android:id/big_text")).click();
		
		driver.findElementByAccessibilityId("App").click();
		driver.findElementByAccessibilityId("Notification").click();
		driver.findElementByAccessibilityId("IncomingMessage").click();
		driver.findElementByAccessibilityId("Show App Notification").click();
		
		driver.openNotifications();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		
		//api demos--> app  -->notifications-->incoming massage--> show app notification
	}
}
