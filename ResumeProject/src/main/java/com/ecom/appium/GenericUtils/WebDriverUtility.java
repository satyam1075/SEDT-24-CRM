package com.ecom.appium.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.google.common.io.Files;
import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import io.appium.java_client.android.AndroidDriver;

public class WebDriverUtility 
{
	public static AndroidDriver driver;
	
	/**
	 * 
	 * @param element
	 */
	public void tapOnElement(WebElement element) 
	{
		driver.tap(1, element, 100);	
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitUntilElementisVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitUntilPageLoad(WebDriver driver, WebElement element)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException 
	{
		int count = 0;
		while(count<40)
		{
			try 
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void waitAndClick(WebDriver driver, WebElement element) throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * 
	 * @param element
	 * @param text
	 */
	public void selectOptions(WebElement element, String text) 
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void selectOptions(WebElement element, int index) 
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	
	/**
	 * 
	 * @param value
	 * @param element
	 */
	public void selectOptions(String value,WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * 
	 * @param driver
	 * @param toElement
	 */
	public void mouseHover(WebDriver driver,WebElement toElement) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(toElement).perform();
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) 
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchTab(WebDriver driver,String partialWinTitle) 
	{
		Set<String> urls = driver.getWindowHandles();
		java.util.Iterator<String> it = urls.iterator();
		
		while(it.hasNext()) 
		{
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle)) 
			{
				break;
			}
		}
		
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void acceptAleart(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * 
	 * @param driver
	 */
	public void dismissAleart(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBar(WebDriver driver, int x, int y,WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 int z = element.getLocation().getY();
		js.executeScript("window.scrllBy(+x+,+y+)");
	}
	
	
	public void switchFrame(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}
	
	public void switchFrame(WebDriver driver,WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	
	public void switchFrame(WebDriver driver,String nameOrId) 
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchBack(WebDriver driver) 
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Throwable
	 */
	public String takeScreenShot(WebDriver driver,String screenshotName) throws Throwable 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String screenshotPath="./screenshot"+screenshotName+JavaUtilitY.getCurrentdate()+".PNG";
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath);
		Files.copy(src, dest);
		return screenshotPath;
		
	}
	
	public void pressEnterKey() throws Throwable 
	{
		Robot rc = new Robot();
		//rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(0);
	}
	
}
