package TestScripts;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;

public class SelectValueFromDropdown 


{
	public static void main(String[] args) throws Throwable 
	{
		ReadDataFromPropertyFile x = new ReadDataFromPropertyFile();
		String platformname = x.getPropertyeyValue("platformName");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		//common  Dc Android or IOS
		dc.setCapability("deviceName", "realme 8");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", platformname);
		dc.setCapability("platformVersion", "11");
		dc.setCapability("UDID", "something from adb device in cmd");
		
		URL url = new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver = new AndroidDriver(url,dc);		
		driver.findElement(By.id("")).click();
		scrollToElement(driver, "text", "India");
		driver.findElement(By.xpath("")).click();
		takeScreenshot(driver, "General");
		
		
	}
	
	public static void scrollToElement(AndroidDriver driver, String an, String av ) 
	{
		driver.findElementByAndroidUIAutomator("new uiScrollable(new uiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}
	
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable 
	{
		String screenshotPath = "./screenshot"+screenshotName+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath);
		Files.copy(src, dest);
		return screenshotPath;
		}

}
