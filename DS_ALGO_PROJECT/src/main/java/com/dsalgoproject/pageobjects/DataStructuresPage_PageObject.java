package com.dsalgoproject.pageobjects;

import java.time.Duration;

import org.apache.poi.xdgf.usermodel.section.geometry.MoveTo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dsalgoproject.utility.ExcelUtils;

public class DataStructuresPage_PageObject {
	WebDriver driver;
	
	@FindBy(id ="id_username")
 	WebElement Username;
 	
 	@FindBy(id="id_password")
 	WebElement password;
 	
 	@FindBy (xpath= "//input[@value='Login']")
 	WebElement loginButton;
 	
 	@FindBy(xpath="//div[contains(@class, 'alert alert-primary')]")
    private WebElement loginSuccessMessage;
 	
 	@FindBy(xpath="//a[@href='data-structures-introduction']")
 	WebElement dataStructuresGetStartedButton;
 	
 	@FindBy(linkText = "Time Complexity")
 	WebElement timeComplexityButton;
 	
 	@FindBy(linkText = "Try here>>>")
 	WebElement tryHereButton;
 	
 	@FindBy(xpath="//form/div/div/div/textarea")
    WebElement tryEditor;
 	
 	@FindBy(xpath="//button[text()='Run']")
 	WebElement runButton;
 	
 	@FindBy(id="output")
 	WebElement editorMsg;
 	
 	
 	String path, pythonvalidcode;
 	ExcelUtils excel;
 	Actions acts;
 	
 	String printMsg;
 	
 	 	
 	String title="";
 	
 	String successMessage="";

	public DataStructuresPage_PageObject (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		acts= new Actions(driver);
	}
	public void Login()
	{
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	public void CorrectUsernameAndPassword()
 	{
		Username.sendKeys("Purnima1345@gmail.com");
		password.sendKeys("Kind@123");
		loginButton.click();
		successMessage=loginSuccessMessage.getText();
 	}
	public void homePage()
	{
		driver.get("https://dsportalapp.herokuapp.com/home");
	}
	
	public void dataStructuresIntroPage()
	{
		driver.get("https://dsportalapp.herokuapp.com/data-structures-introduction/");
	}
	
	public void clickTimeComplexity()
	{
		
		acts.moveToElement(timeComplexityButton);
		timeComplexityButton.click();
		title= driver.getTitle();
		
	}
	
	public void timeComplexityPage()
	{
		driver.get("https://dsportalapp.herokuapp.com/data-structures-introduction/time-complexity/");
	}
	
	public void tryHereEditorPage()
	{
		driver.get("https://dsportalapp.herokuapp.com/tryEditor");
	}
	
	public void clickTryHere() {
		acts.moveToElement(tryHereButton);
		tryHereButton.click();
		title= driver.getTitle();
	}
	
	public void clickDataStructuresGetStarted()
	{
		dataStructuresGetStartedButton.click();
		title= driver.getTitle();
	}
	
	public void clickRunTryEditor()
	{
		driver.get("https://dsportalapp.herokuapp.com/tryEditor");
	}
	
	public void getPythonCode(String SheetName, int RowNumber) 
	{
			
		  path=System.getProperty("user.dir");
		  excel= new ExcelUtils(path+"//src//test//resources//ExcelData//ExcelData.xlsx",SheetName);
		  pythonvalidcode= excel.getCellDataString(RowNumber,0);
		 tryEditor.sendKeys(pythonvalidcode);
	     runButton.click();
	     acts.scrollToElement(editorMsg);
		 printMsg= editorMsg.getText();    
	}
	public void invalidPythonCode( String SheetName, int RowNumber)
	{
		 path=System.getProperty("user.dir");
		 excel= new ExcelUtils(path+"//src//test//resources//ExcelData//ExcelData.xlsx",SheetName);
		  pythonvalidcode= excel.getCellDataString(RowNumber,0);
		 tryEditor.sendKeys(pythonvalidcode);
	     runButton.click();
	     printMsg=driver.switchTo().alert().getText();
		 System.out.println("The error message is "+driver.switchTo().alert().getText());
	     driver.switchTo().alert().accept(); 
	     driver.navigate().to("https://dsportalapp.herokuapp.com/home");
	}
	
	
	public String getTitle()
	{
		return title;
	}
	
	public String getLoginSuccessMessage()
	{
		return successMessage;
	}
	
	public String getSuccessMessage()
	{
	   
	   System.out.println("The success message printed is" +printMsg);
		return printMsg;
	}
	
    
}
