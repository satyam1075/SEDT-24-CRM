package TestScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class CreateServer 
{
	
	public static AndroidDriver driver;
	
	@Test
	public static void createServer() throws Throwable {
	
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		//AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()).withArgument(GeneralServerFlag.SESSION_OVERRIDE).usingPort(4723).withLogFile(new File("../ResumeProject/Logs.text"));
		//service.stop();
		service.start();

//	DesiredCapabilities dc= new DesiredCapabilities();
//	
//	dc.setCapability("deviceName", "Redmi Note 4");
//	dc.setCapability("automationName", "appium");
//	dc.setCapability("platformName", "Android");
//	dc.setCapability("platformVersion", "7.0");
//	dc.setCapability("UDID", "0ea2b52b9904");
//	dc.setCapability(MobileCapabilityType.NO_RESET, true);
////	dc.setCapability("appPackage", "com.androidsample.generalstore");
////	dc.setCapability("appActivity", ".SplashActivity");
//
//		
//		
//	URL url = new URL("http://localhost:4723/wd/hub");
//	@SuppressWarnings("rawtypes")
//	AndroidDriver driver = new AndroidDriver(url, dc);
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	
//	
//	//battery info
//	System.out.println(driver.executeScript("mobile:batteryInfo"));
	
	service.stop();
}
}
