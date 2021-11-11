package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;

public class Orientation 
{
	@Test
	public static void orientation() throws Throwable 
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Redmi Note 4");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("UDID", "0ea2b52b9904");
		//dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "ApiDemos");
		
		
		
		
		URL url = new URL("http://localhost:4723/wd/hub");
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		
		org.openqa.selenium.ScreenOrientation currentOrientation = driver.getOrientation();
		System.out.println(currentOrientation);
		Thread.sleep(2000);
		driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		org.openqa.selenium.ScreenOrientation finalOrientation = driver.getOrientation();
		System.out.println(finalOrientation);
		Thread.sleep(2000);
		driver.closeApp();
		
		
		
	}
}
