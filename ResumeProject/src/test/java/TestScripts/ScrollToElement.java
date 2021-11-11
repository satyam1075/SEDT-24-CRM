package TestScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;

public class ScrollToElement 
{
	@Test
	public void scroll() throws Throwable 
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
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		scrollToElement(driver,"text","India");
		scrollToElement(driver,"text","India");
		
		//List names = driver.findElements(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		takeScrrenshot(driver,"General");
		
		//List names = driver.findElements(By.className("android.widget.TextView"));
		
//		for(Object country:names) 
//		{
//			System.out.println(country);
//		}
		
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jit");
//		WebElement male = driver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
//		driver.tap(1, male, 500);
//		WebElement shop = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
//		driver.tap(1, shop, 500);
//		WebElement retro = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]"));
//		driver.tap(1, retro, 500);
//		WebElement cart = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
//		driver.tap(1, cart, 500);
//		WebElement amt = driver.findElement(By.xpath("//android.widget.LinearLayout[@class='android.widget.LinearLayout']"));
//		System.out.println(amt);
	}
	
	public static void scrollToElement(AndroidDriver driver, String an,String av)
	{
		driver.findElementsByAndroidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}
	
	
	public static String takeScrrenshot(WebDriver driver,String screenshotName) throws Throwable
	{
    	String screenshotPath="./screenshot"+screenshotName+".PNG";
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File(screenshotPath);
    	Files.copy(src, dest);
    	return screenshotPath;
    }
}
