package com.dsalgoproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgoproject.utility.CommonUtils;
import com.dsalgoproject.utility.ExcelUtils;

public class StackPage_PageObject {
	
	WebDriver driver;
	
 	
	
	@FindBy(xpath ="html/body/div[2]/div/div[2]/form/input[2]")
 	WebElement Username;
 	
 	@FindBy(xpath ="html/body/div[2]/div/div[2]/form/input[3]")
 	WebElement password;
 	
 	@FindBy (xpath = "html/body/div[2]/div/div[2]/form/input[4]")
 	WebElement logInButton;;

   @FindBy(linkText = "Data Structures")
    public WebElement dataStrDropDown;

   @FindBy(xpath = "html/body/div/nav/div/div/div/div/a[3]")
   public WebElement stackButton;
	
   @FindBy(linkText = "Data Structures")
	private WebElement DataStrIntroGetStarted;
	   
   @FindBy (linkText = "Try here>>>")
   private WebElement tryHereButton;
  
   
   @FindBy (xpath = "//form/div/div/div/textarea")
   private WebElement tryEditor;
   
   @FindBy (xpath = "//button[text()='Run']")
   private WebElement RunButton;
   
   @FindBy (id = "output")
   private WebElement editorMsg;
   

   
   
   ExcelUtils excel;
   private Actions act;
   String title="";
   String message="";
   String errorMessage="";
	
	@FindBy(xpath="//a[@class='list-group-item']")
	List<WebElement> GetStartedButtons;
	
	public StackPage_PageObject(WebDriver driver) {
        this.driver = driver;
        this.act = new Actions(driver);
        PageFactory.initElements(driver, this);
        
    }
	
	
	
	public void signInPage () {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	
	public void CorrectUsernameAndPassword()
 	{
 		
 		//Username.click();
    Username.sendKeys("Numpysdet84");
		//password.click();
	password.sendKeys("sdet84batch");
	logInButton.click();
	title = driver.getTitle();
 	}
	public void HomePage () {
		driver.get("https://dsportalapp.herokuapp.com/home");
	}
	
	public void checkSelectBox() throws InterruptedException {
		DataStrIntroGetStarted.click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Stack")).click();
		title = driver.getTitle();
		
	}
	
	public void StackDataStructurePage()
	{
		driver.get("https://dsportalapp.herokuapp.com/stack");
	}
	
	public boolean click_StackMenu_LinkForValid(String linkNameFromFeature)
	{
		
		//List<WebElement> GetStartedButtons = driver.findElements(By.xpath("//a[@class='list-group-item']"));
		boolean clicked =CommonUtils.webclick(GetStartedButtons, linkNameFromFeature);
		return clicked;
	}
	public void send_PythonCode_inStack(boolean clickedMenu,String pythonCode)
	{
		
		if(clickedMenu)
		{
			act.moveToElement(tryHereButton);
			tryHereButton.click();
			tryEditor.sendKeys(pythonCode);
		}
	}
	public void click_RunButton_ForValid_inStack()
	{
		RunButton.click();
	}
	public String getMessage()
	{
		message = editorMsg.getText();
		driver.navigate().to("https://dsportalapp.herokuapp.com/stack/");
		return message;
	}
	public String getErrorMessage()
	{
		errorMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		driver.navigate().to("https://dsportalapp.herokuapp.com/stack/");
		return errorMessage;
	}
	public String getTitle()
	{
		return title;
	}




	
	
	
}