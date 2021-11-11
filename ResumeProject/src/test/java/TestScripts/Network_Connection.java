package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class Network_Connection 
{
	@Test
	public void connection() throws Throwable 
	{
DesiredCapabilities dc= new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Redmi Note 4");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("UDID", "0ea2b52b9904");
//		dc.setCapability("appPackage", "com.androidsample.generalstore");
//		dc.setCapability("appActivity", ".SplashActivity");
		
		URL url =  new URL("http://localhost:4723/wd/hub");
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("satyam");
		
		Connection currentConnection = driver.getConnection();
		System.out.println(currentConnection);
		Thread.sleep(2000);
		//driver.setConnection(Connection.WIFI);
		//System.out.println(driver.getConnection());
		//Thread.sleep(2000);
		//driver.setConnection(Connection.DATA);
		driver.setConnection(Connection.DATA);
		System.out.println(driver.getConnection());
		//Thread.sleep(2000);
		//driver.setConnection(Connection.AIRPLANE);
		//System.out.println(driver.getConnection());
		
	}
}
