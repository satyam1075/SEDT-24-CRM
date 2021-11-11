package com.ecom.appium.GenericUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.vtiger.pom.HomePage;
import com.crm.vtiger.pom.LoginPage;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
	{
	
	public WebDriver driver;
	public static WebDriver staticDriver;
	public ExcelUtility eUtil = new ExcelUtility();
	public FileUtils futils = new FileUtils();
	public WebDriverUtility wenUtil = new WebDriverUtility();
	public DatabaseUtilities dataUtils = new DatabaseUtilities();
	public HomePage home;
	public LoginPage login;
	

//		@BeforeSuite(groups = {"smokeTest","regressionTest"})
//		public void database() {
//		System.out.println("connect to database");
////	}
//		@BeforeTest
//		public void parallel() {
//		System.out.println("parallel");
//	}
//		@BeforeClass
//		public void openbrowser() {
//		System.out.println("open browser");
//	}
//		@BeforeMethod
//		public void logintoapp() {
//		System.out.println("login to application");
//	}
//		@Test
//		public void createorg() {
//		System.out.println("organization created");
//	}
//		@AfterMethod
//		public void logoutapp() {
//		System.out.println("logout from application");
//	}
//		@AfterClass
//		public void closebrowser() {
//		System.out.println("close browser");
//	}
//		@AfterTest
//		public void parparellel() {
//		System.out.println("parallel");
//	}
//		@AfterSuite
//		public void closedatabase() {
//		System.out.println("close connection");
//	}
	
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws Throwable 
	{
		//connect to db
		dataUtils.connectToDatabase();
	}
	
	
	//@Parameters("browser")
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void configBT()
	{
		//launch browser in parallel mode
	}
	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable 
	{
		String browse = futils.getPropertyeyValue("browser");	
		if(browse.equalsIgnoreCase("Chrome")) 
		{
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browse.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if(browse.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		staticDriver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable, Throwable 
	{
		String url = futils.getDataFromJson("url");
		driver.get(url);
		login.logIn();
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() 
	{
		
		//logout here
	}
	
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void conficAF() 
	{
		driver.quit();
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void configAT()
	{
		//close driver ref for parallel mode
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws Throwable 
	{
		dataUtils.closeDB();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}