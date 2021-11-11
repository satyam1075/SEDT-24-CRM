package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TestScript1 
{
	@Test
	public void testscript() throws Throwable 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Redmi Note 4");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("UDID", "0ea2b52b9904");
		
		//dc app
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "ApiDemos");
		
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,dc);
		
		driver.findElementByAccessibilityId("Views").click();
		driver.findElementByAccessibilityId("Controls").click();
		driver.findElementByAccessibilityId("2. Dark Theme").click();
		driver.hideKeyboard();
		driver.findElementById("io.appium.android.apis:id/spinner1").click();
		
		List<WebElement> planets = driver.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));
//		
//		driver.findElementByXPath("//android.widget.CheckedTextView[@index='4']").click();
//		
//		System.out.println(planets.size());
//		
		for(WebElement planet:planets) 
		{
			//System.out.println("by");
			System.out.println(planet.getText());
			
		}
//		
//		for(int i=1;i<planets.size();i++)
//		{
//			System.out.println(((WebElement) planets.get(i)).getText());
//		}
		
//		List<WebElement> options = driver.findElements(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"));
//		for(WebElement element:options)
//		{
//			System.out.println(element.getText());
//		}
//		for(int i=1;i<options.size();i++)
//		{
//			System.out.println(((WebElement) options.get(i)).getText());
//		}
	}
	
	public static void tap(AndroidDriver driver,int fingers,WebElement element, int duration) 
	{
		driver.tap(fingers, element, duration);
	}
}
