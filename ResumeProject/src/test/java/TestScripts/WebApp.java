package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class WebApp 
{
	@Test
	public void webapp() throws Throwable 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Redmi Note 4");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("UDID", "0ea2b52b9904");
		dc.setCapability("noReset", true);
		
		//open browser
		dc.setCapability("browserName", "Chrome");
		
		
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://m.facebook.com/login.php?next=https%3A%2F%2Fm.facebook.com%2Fsettings%2Faccount%2Ffallback%2Fsuggested%2F%3Fold_locale%3Dbn_IN&refsrc=deprecated");
		
		driver.findElement(By.xpath("//input[@id='m_login_email']")).sendKeys("roy");
		driver.findElement(By.xpath("//input[@id='m_login_password']")).sendKeys("lastname");
		
		driver.findElementByXPath("//button[@name='login']").click();
		driver.close();
		
		
	}
}
