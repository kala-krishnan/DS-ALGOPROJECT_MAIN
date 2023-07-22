package com.dsalgoproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageObject {
WebDriver driver;
	
 	@FindBy(id ="id_username")
 	WebElement Username;
 	
 	@FindBy(id="id_password")
 	WebElement password;
 	
 	@FindBy (xpath= "//input[@value='Login']")
 	WebElement loginButton;
 	
 	@FindBy (xpath="//div[@class='alert alert-primary']")
 	WebElement loginMsg;
	
	public LoginPage_PageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void Login()
	{
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	public void IncorrectUserNameAndPassword()
	{
		//Username.click();
		Username.sendKeys("PurnimaSDE119");
		//password.click();
		password.sendKeys(" Numpy");
		loginButton.click();
	}

	public void CorrectUsernameAndPassword()
 	{
 		
 		//Username.click();
		Username.sendKeys("Purnima1345@gmail.com");
		//password.click();
		password.sendKeys("Kind@123");
		loginButton.click();
 	}
	
	

}
