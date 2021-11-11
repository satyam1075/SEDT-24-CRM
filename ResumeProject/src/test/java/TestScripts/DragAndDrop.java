
package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragAndDrop 
{
	static AndroidDriver driver;
		
	@Test
	public void drag() throws Throwable 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		//common  Dc Android or IOS
		dc.setCapability("deviceName", "Redmi Note 4");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("UDID", "0ea2b52b9904");
		
		//Dc for Android
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "ApiDemos");
		
//		//Android port
		URL url = new URL("http://localhost:4723/wd/hub");
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
//		//tap after every action
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
		WebElement start = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement end = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
//		
		TouchAction to = new TouchAction(driver);
		to.longPress(start).waitAction(2000).moveTo(end).release().perform();
		driver.closeApp();
		
	}

	public void tapOnElement(WebElement element) {
		driver.tap(1, element, 1000);
		
	}

}
