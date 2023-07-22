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
	WebElement passWord;
	@FindBy(name ="password2")
	WebElement password2;
	@FindBy(xpath="//input[@value='Register']")
	WebElement registerButton; 
	
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
		passWord.sendKeys("Numpy@1234");
		registerButton.click();
	}
	public void clickafterGivingInvalidCredentials(String usrName,String userPassword,String confirmPassword)
	{
		userName.sendKeys(usrName);
		passWord.sendKeys(userPassword);
		password2.sendKeys(confirmPassword);
		
	}
	public void clickRegisterButton()
	{
		registerButton.click();
	}

}
