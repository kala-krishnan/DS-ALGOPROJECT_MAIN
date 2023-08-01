package com.dsalgoproject.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgoproject.utility.CommonUtils;
import com.dsalgoproject.utility.ExcelUtils;

import org.openqa.selenium.interactions.Actions;



public class QueuePage_PageObject {
	

	String message = "";
	String title ="";

	String errorMessage;
	

	
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement Signin;
	
	@FindBy(name="username")
 	WebElement Username;
 	
 	@FindBy(name="password")
 	WebElement password;
 	
 	@FindBy (xpath= "//input[@value='Login']")
 	WebElement loginButton;
 	
 	@FindBy (xpath="//div[@class='alert alert-primary']")
 	WebElement loginMsg;
	
	@FindBy(xpath="//div[@class='dropdown-menu show']")
	 WebElement DSdropdown;
    
	@FindBy(xpath="//a[@href='queue']")
 	WebElement queue;
	
	@FindBy(xpath="//a[@class='list-group-item']")
	List<WebElement> GetStartedButtons;
    
   @FindBy(xpath="//h4[@class='bg-secondary text-white']")
   WebElement queueHeading;
    
   @FindBy(id="output")
   WebElement output;
   
   
  // driver.findElement(By.xpath("//form[@id='answer_form']/div/div/div/textarea")).sendKeys("print 'hello'");
	// Thread.sleep(3000);
 //   @FindBy(xpath="//a[@href='implementation-lists']")
//    WebElement implementationofQueue;
    
    
   @FindBy(xpath="//a[@href='/tryEditor']") 
   WebElement tryHereButton;
   
   @FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
   WebElement  textAreaWorkSpace;
    
    
    @FindBy(xpath="//button[text()='Run']")
    WebElement runButton;
    
    
    public QueuePage_PageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    
    public void HomePage_Queue()
    
    {
    	
    	driver.get("https://dsportalapp.herokuapp.com/home");
    	Signin.click();
    	String path=System.getProperty("user.dir");
		ExcelUtils excel= new ExcelUtils(path+"//src//test//resources//ExcelData//ExcelData.xlsx","Login");
		String sUsername= excel.getCellDataString(1,0);
		String sPassword= excel.getCellDataNumber(1,1);
		Username.sendKeys(sUsername);
		password.sendKeys(sPassword);
		loginButton.click();
		message= loginMsg.getText();
    	title=driver.getTitle();
    
    }
	
    public void queueDropdown_Queue() 
		{
		
	Actions action = new Actions(driver);
	action.moveToElement(DSdropdown).click();
	queue.click();
	title = driver.getTitle();
		}
	
    public boolean click_QueueMenu_LinkForValid(String linkNameFromFeature)

	{
    	System.out.println(" The link name from feature is   "  +linkNameFromFeature);
    	boolean clicked =CommonUtils.webclick(GetStartedButtons, linkNameFromFeature);
    	return clicked;

	}
    
    public void send_PythonCode_inQueue(boolean clickedMenu,String pythonCode)
    
	{
    	Actions act = new Actions(driver);
		if(clickedMenu)

		{
			act.moveToElement(tryHereButton);
			tryHereButton.click();
			textAreaWorkSpace.sendKeys(pythonCode);

		}

	}

	public void click_RunButton_ForValid_inQueue()

	{
		runButton.click();

	}

	public String getTitle()

	{

		return title;

	}

	public String getMessage_Queue()

	{

		message = output.getText();
		driver.navigate().to("https://dsportalapp.herokuapp.com/queue/");
		return message;

	}

	public String getErrorMessage_Queue()

	{

		errorMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		driver.navigate().to("https://dsportalapp.herokuapp.com/queue");
		return errorMessage;

	}

    
}


