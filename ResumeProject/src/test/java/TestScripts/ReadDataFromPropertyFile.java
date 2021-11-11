package TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.ecom.appium.GenericUtils.IpathConstant;

public class ReadDataFromPropertyFile 
{
	@Test
	public String getPropertyeyValue(String key) throws Throwable 
	{
		FileInputStream file = new FileInputStream(IpathConstant.PROPERTY_FILEPATH);
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
		
	}
	
	
	
	@Test
	public String getProperty(String key) throws Throwable, Throwable 
	{
		Properties p = new Properties();
		p.load(new FileInputStream(".//Data//CommonData.properties"));
		return p.getProperty(key);
		
	}
	
	@Test
	public void execute() throws Throwable, Throwable 
	{
		String device = getProperty("deviceName");
		System.out.println(device);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	