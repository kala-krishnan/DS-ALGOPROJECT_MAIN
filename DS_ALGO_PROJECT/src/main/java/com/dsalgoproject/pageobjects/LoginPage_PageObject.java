package com.dsalgoproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgoproject.utility.CommonUtils;
import com.dsalgoproject.utility.ExcelUtils;



public class LoginPage_PageObject {
	WebDriver driver;
	
	String message = "";
	
 	@FindBy(id ="id_username")
 	WebElement Username;
 	
 	@FindBy(id="id_password")
 	WebElement password;
 	
 	@FindBy (xpath= "//input[@value='Login']")
 	WebElement loginButton;
 	
 	@FindBy (xpath="//div[@class='alert alert-primary']")
 	WebElement loginMsg;
 	
 	@FindBy(xpath="//a[@href='/logout']") 
 	 WebElement SignoutButton;
 	String loginPageURL = CommonUtils.getLoginPage();
 	String excelURL = CommonUtils.getexcelfilepath();

	public LoginPage_PageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void Login()
	{
		driver.get(loginPageURL);
	}
	public void IncorrectUserNameAndPassword()
	{
		
		Username.sendKeys("PurnimaSDE119");
		password.sendKeys(" Numpy");
		loginButton.click();
		message= loginMsg.getText();
		
	}

	public void CorrectUsernameAndPassword()
 	{
 
		String path=System.getProperty("user.dir");
		ExcelUtils excel= new ExcelUtils(path+excelURL,"Login");
		String sUsername= excel.getCellDataString(1,0);
		String sPassword= excel.getCellDataNumber(1,1);
		Username.sendKeys(sUsername);
		password.sendKeys(sPassword);
		loginButton.click();
		message= loginMsg.getText();
		
 	}
	
	public void SignOut()
 	{
 		
 		SignoutButton.click();
 		message= loginMsg.getText();
 		
 	}
 	
	public String getMessage() {
		return message;
		}
}
