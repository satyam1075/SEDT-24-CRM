package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Camera 
{
	@Test
	public static void camera() throws Throwable 
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Redmi Note 4");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("UDID", "0ea2b52b9904");
		dc.setCapability("appPackage", "com.android.camera");
		dc.setCapability("appActivity", ".Camera");
		
		
		URL url = new URL("http://localhost:4723/wd/hub");
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		int backSpace= AndroidKeyCode.BACKSPACE;
		System.out.println(backSpace);
		System.out.println(AndroidKeyCode.BACK);
		System.out.println(AndroidKeyCode.BACKSPACE);
		System.out.println(AndroidKeyCode.ENTER);
		System.out.println(AndroidKeyCode.HOME);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_UP);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_MUTE);
		System.out.println(AndroidKeyCode.KEYCODE_CAMERA);
		System.out.println(AndroidKeyCode.KEYCODE_CALCULATOR);
		
	}
}
