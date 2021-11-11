package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TapActionCalculator 
{
	public class tapactioncalculator {
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
			WebElement five = driver.findElement(By.id("id"));
			driver.tap(1, five, 500);
			WebElement plus = driver.findElement(By.id("plus"));//plus button
			driver.tap(1, plus, 500);
			WebElement seven = driver.findElement(By.id("2nd id"));//7
			driver.tap(1, seven, 500);
			WebElement equals = driver.findElement(By.id("euals")); // equals button
			driver.tap(1,equals, 500);
			String text = driver.findElement(By.id("result")).getText();
			System.out.println(text);
			}
		}
	
}
