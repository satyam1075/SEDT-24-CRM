package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.appium.GenericUtils.BaseClass;

public class HomePage extends BaseClass
{
	@FindBy(xpath="//a[text()=\"Organizations\"]")
	private WebElement organistionBtn;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactsBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutMouseHover;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutBtn;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreMouseHover;
	
	public WebElement getMoreMouseHover() {
		return moreMouseHover;
	}

	public WebElement getContactsBtn() {
		return contactsBtn;
	}

	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrganisation() 
	{
		organistionBtn.click();
	}

	public WebElement getOrganistionBtn() {
		return organistionBtn;
	}
	
	public void clickContacts() 
	{
		contactsBtn.click();
	}

	public WebElement getSignoutMouseHover() {
		return signoutMouseHover;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	public void signOut() 
	{
		
	}
}
