package TestScripts;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class GeneralStores 
{
	@Test
	public void letsShop() throws Throwable 
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
		
		WebElement letsshop = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		letsshop.click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("satyam");
		
		driver.hideKeyboard();
		//driver.pressKeyCode(AndroidKeyCode.BACK);
		letsshop.click();
		
		Thread.sleep(3000);
		
		//takeScreenshot(driver, "letsShop");
		
		
	}
	
	public String takeScreenshot(WebDriver driver, String screenShotName) throws Throwable 
	{
		String screenShotPath = "./"+screenShotName+".PNG";
		TakesScreenshot sc = (TakesScreenshot)driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File  dest= new File(screenShotPath);
		Files.copy(src, dest);
		
		return screenShotPath;
		
	}
}
