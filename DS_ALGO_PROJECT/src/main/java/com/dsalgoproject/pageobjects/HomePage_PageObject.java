package com.dsalgoproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgoproject.utility.LoggerLoad;

public class HomePage_PageObject {
	WebDriver driver;
    @FindBy(xpath = "html/body/div/div/div/a/button")
    private WebElement getStartedButton;
    
    @FindBy(linkText  = "Data Structures")
    private WebElement DataStrIntroGetStarted;
    
//    @FindBy()
//    private List<WebElement> dataStructureList;
    
  
	
	public HomePage_PageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void homePageLogin()
	{
		driver.get("https://dsportalapp.herokuapp.com/");
		LoggerLoad.info("DS ALGO Page Opened");
	}
	public void clickGetStartedButton()
	{
		getStartedButton.click();
	}
	public void homePage()
	{
		driver.get("https://dsportalapp.herokuapp.com/home");
	}
	public void checkSelectBox(String dataStructureValue) throws InterruptedException 
	{
		DataStrIntroGetStarted.click();
		Thread.sleep(1000);
		driver.findElement(By.linkText(dataStructureValue)).click();
		
	}


}
