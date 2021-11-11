package TestScripts1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.ecom.appium.Pomclasses.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class LoginTest 
{
	
	@Test
	public void loginTest() throws Throwable 
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
		
		
		Thread.sleep(5000);
		
		LoginPage lp = new LoginPage(driver);		
		lp.login();
		//lp.loginSendValue("satyam");
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		lp.clickDD();
		lp.scrollToElement(driver, "text", "India");
		
		driver.closeApp();
		
		
	}
}
