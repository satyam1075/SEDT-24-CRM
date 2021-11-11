package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallApplication 
{
@Test
public void installApplication() throws Throwable 
{

	
	ReadDataFromPropertyFile x = new ReadDataFromPropertyFile();
	String platformname = x.getPropertyeyValue("platformName");
	
	DesiredCapabilities dc = new DesiredCapabilities();
	//common  Dc Android or IOS
	
	//dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
	// no reset = true start from the current page where it got stuck while executing the script
	//full reset = true starts from the beginning
	
	
	//jdc.setCapability(MobileCapabilityType.NO_RESET, true);
	
	
	dc.setCapability("deviceName", "Redmi Note 4");
	dc.setCapability("automationName", "appium");
	dc.setCapability("platformName", "Android");
	dc.setCapability("platformVersion", "7.0");
	dc.setCapability("UDID", "0ea2b52b9904");
	//installing app in my phone
	//dc.setCapability("app", "C:\\Users\\surya\\Desktop\\appium_apk_files\\com.davemorrissey.labs.subscaleview.sample.apk");
	//dc.setCapability("app", "C:\\Users\\surya\\Desktop\\appium_apk_files\\Activity Launcher.apk");
	//dc.setCapability("app", "C:\\Users\\surya\\Desktop\\appium_apk_files\\ApiDemos-debug.apk");
	dc.setCapability("app", "C:\\Users\\surya\\Desktop\\appium_apk_files\\General-Store.apk");
	//dc.setCapability("app", "C:\\Users\\surya\\Desktop\\appium_apk_files\\Touch Screen Test_v1.7.14_apkpure.com.apk");
	
	//Android port
	URL url = new URL("http://localhost:4723/wd/hub");
	@SuppressWarnings("rawtypes")
	AndroidDriver driver = new AndroidDriver(url, dc);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
