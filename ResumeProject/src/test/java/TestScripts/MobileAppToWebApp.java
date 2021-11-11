package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class MobileAppToWebApp 
{
	@Test
	public void mobiletoweb() throws Throwable 
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
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("satyam");
		driver.hideKeyboard();
		
		WebElement letsshop = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		letsshop.click();
		
		driver.findElementById("com.androidsample.generalstore:id/productAddCart").click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
		Thread.sleep(3000);
		
		
		
		Set<String> eles = driver.getContextHandles();
		for(String ele:eles) 
		{
			System.out.println(ele);
			
		}
		
//		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys("success");
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
		driver.closeApp();
		
	}
}
