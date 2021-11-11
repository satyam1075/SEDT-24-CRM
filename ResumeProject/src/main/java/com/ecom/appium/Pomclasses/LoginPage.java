package com.ecom.appium.Pomclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitAudioContext;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage 
{
	
	AndroidDriver driver;
	//@AndroidFindBy(xpath = "//android.widget.TetView[@resource-id='android:1d/text1']")
	@AndroidFindBy(id ="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryDD;
	
	@AndroidFindBy( id= "com.androidsample.generalstore:id/nameField")
	private WebElement nameTF;
	
	@AndroidFindBy(  id= "com.androidsample.generalstore:id/radioMale")
	private WebElement maleRB;
	
	@AndroidFindBy( id= "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleRB;
	
//	@AndroidFindBy (xpath="//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")
//	private WebElement loginBtn;
	
	@AndroidFindBy (id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement loginBtn;
	
	public LoginPage(AndroidDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);		
//		PageFactory.initElements(driver,this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='India']")
	public WebElement indtaText;

	public WebElement getCountryDD() {
		return countryDD;
	}

	public void setCountryDD(WebElement countryDD) {
		this.countryDD = countryDD;
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getNameTF() {
		return nameTF;
	}

	public WebElement getMaleRB() {
		return maleRB;
	}

	public WebElement getFemaleRB() {
		return femaleRB;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login() 
	{
		maleRB.click();
		nameTF.sendKeys("name");
		loginBtn.click();
		
	}
	
	public WebElement getIndtaText() {
		return indtaText;
	}

	public void clickDD() 
	{
		countryDD.click();
	}
	
	public void loginSendValue(String name) 
	{
		femaleRB.click();
		nameTF.sendKeys(name);
		loginBtn.click();
		
	}
	
	public static void scrollToElement(AndroidDriver driver, String an,String av)
	{
		driver.findElementsByAndroidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
		//driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		
	}
	public void cilickIndia()
	{
		indtaText.click();
	}
	
}
