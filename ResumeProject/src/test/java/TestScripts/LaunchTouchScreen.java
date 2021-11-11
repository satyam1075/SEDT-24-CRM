package TestScripts;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LaunchTouchScreen 
{
	
	/**
	 * 
	 * @throws Throwable
	 */
	@Test
	public static void launchTouchScreen() throws Throwable 
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Redmi Note 4");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("UDID", "0ea2b52b9904");
		dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity", "TouchScreenTestActivity");
		
		
		
		URL url = new URL("http://localhost:4723/wd/hub");
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//swipe by coordinates
		
//		driver.swipe(1058, 213, 13, 1893, 2000);
//		driver.swipe(50, 213, 1064, 1893, 2000);
//		driver.swipe(1, 853, 1061, 853, 2000);
//		driver.swipe(527, 213, 527, 1893, 2000);
		
		//WebElement tapping = driver.findElement(By.id("jp.rallwell.siriuth.touchscreentest:id/surfaceView"));
		//driver.tap(1,500 , 1500, 1000);
		
		
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		
		System.out.println("Height: "+height+" and width: "+width);
	
		//driver.swipe(width/2, (int)(height*0.25), (int)width/2, (int)(height*0.8), 1000);
		//driver.swipe((int)(width*0.25),(int)(height/2), (int)(width*0.8), (int)(height/2), 1000);
		
//		driver.swipe(5, (int)(height/5), 1080, (int)(height/5), 1000);
//		driver.swipe(5, (int)(height/3), 1080, (int)(height/3), 1000);
//		driver.swipe(5, (int)(height/2), 1080, (int)(height/2), 1000);
//		driver.swipe(5, (int)(height/4), 1080, (int)(height/4), 1000);
		
		//Thread.sleep(20000);
		//driver.closeApp();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
