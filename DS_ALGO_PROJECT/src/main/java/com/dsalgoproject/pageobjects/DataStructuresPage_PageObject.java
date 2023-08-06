package com.dsalgoproject.pageobjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.dsalgoproject.utility.CommonUtils;
import com.dsalgoproject.utility.ExcelUtils;

public class DataStructuresPage_PageObject {
	WebDriver driver;
	private static final Logger LOG= LogManager.getLogger(DataStructuresPage_PageObject.class);
	
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
 	String loginPageURL = CommonUtils.getLoginPage();
 	String homePageURL = CommonUtils.getHomePage();
 	String dataStructurePage= CommonUtils.getDSPageUrl();
 	String dataStructuresTimeComp=CommonUtils.getDSPageTimeCompUrl();
 	String tryEditorPage=CommonUtils.getTryEditor();
	String excelURL = CommonUtils.getexcelfilepath();

	public DataStructuresPage_PageObject (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		acts= new Actions(driver);
	}
	public void Login()
	{
		driver.get(loginPageURL);
	}
	public void CorrectUsernameAndPassword()
 	{
		Username.sendKeys("coolcukes");
		password.sendKeys("Selenium@123");
		loginButton.click();
		successMessage=loginSuccessMessage.getText();
		LOG.info("The Login is successful:" +successMessage );
 	}
	public void homePage()
	{
		driver.get(homePageURL);
	}
	
	public void dataStructuresIntroPage()
	{
		driver.get(dataStructurePage);
	}
	
	public void clickTimeComplexity()
	{
		
		acts.moveToElement(timeComplexityButton);
		timeComplexityButton.click();
		title= driver.getTitle();
		
	}
	
	public void timeComplexityPage()
	{
		driver.get(dataStructuresTimeComp);
	}
	
	public void tryHereEditorPage()
	{
		driver.get(tryEditorPage);
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
		driver.get(tryEditorPage);
	}
	
	public void getPythonCode(String SheetName, int RowNumber) 
	{
			
		  path=System.getProperty("user.dir");
		  excel= new ExcelUtils(path+excelURL,SheetName);
		  pythonvalidcode= excel.getCellDataString(RowNumber,0);
		 tryEditor.sendKeys(pythonvalidcode);
	     runButton.click();
	     acts.scrollToElement(editorMsg);
		 printMsg= editorMsg.getText();  
		 LOG.info("The message when a valid pytho code is entered is:" +printMsg );
	}
	public void invalidPythonCode( String SheetName, int RowNumber)
	{
		 path=System.getProperty("user.dir");
		 excel= new ExcelUtils(path+excelURL,SheetName);
		  pythonvalidcode= excel.getCellDataString(RowNumber,0);
		 tryEditor.sendKeys(pythonvalidcode);
	     runButton.click();
	     printMsg=driver.switchTo().alert().getText();
		 System.out.println("The error message is "+driver.switchTo().alert().getText());
	     driver.switchTo().alert().accept(); 
	     driver.navigate().to(homePageURL);
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
	   	return printMsg;
	}
	
    
}
