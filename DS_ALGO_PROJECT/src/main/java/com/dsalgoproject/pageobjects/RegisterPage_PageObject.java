package com.dsalgoproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage_PageObject {
WebDriver driver;
	
	@FindBy(name ="username")
	WebElement userName;
	@FindBy(name ="password1")
	WebElement passWord1;
	@FindBy(name ="password2")
	WebElement passWord2;
	@FindBy(xpath="//input[@value='Register']")
	WebElement registerButton; 
	@FindBy(xpath ="//div[@class='alert alert-primary']")
	WebElement alertMsg;
     			     	
	String successMessage="";
	String errorMessage ="";
	String validationMsg="";
	
	public RegisterPage_PageObject(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	public void registerLogin()
	{
		driver.get("https://dsportalapp.herokuapp.com/register");
	}
	
	public void clickWithoutGivingUserNameAndPassword()
	{
		registerButton.click();
		
	}
	
	public void clickWithoutGivingPasswords()
	{
		userName.sendKeys("Kala@SDET118");
		registerButton.click();
	}
	public void clickWithoutGivingConfirmPassword()
	{
		userName.sendKeys("Kala@SDET118");
		passWord1.sendKeys("Numpy@1234");
		registerButton.click();
	}
	public void clickafterGivingInvalidCredentials(String usrName,String userPassword,String confirmPassword)
	{
		userName.sendKeys(usrName);
		passWord1.sendKeys(userPassword);
		passWord2.sendKeys(confirmPassword);
	}
	public void clickRegisterButton()
	{
		registerButton.click();
		
	}
	public String unameGetAttribute()
    {
    	validationMsg=userName.getAttribute("validationMessage");
    	return validationMsg;
    	
    }
    public String pwd1GetAttribute()
    {
    	validationMsg=passWord1.getAttribute("validationMessage");
	    return validationMsg;
    }
    public String pwd2GetAttribute()
    {
    	validationMsg=passWord2.getAttribute("validationMessage");
	    return validationMsg;
    }
    public String geterrorMessage()
	{
	    errorMessage = alertMsg.getText();
    	return errorMessage;
	}
    public String getSuccessMessage()
    {
    	successMessage = alertMsg.getText();
    	return successMessage;
    }
    }

