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


public class TreePage_PageObject {

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
	@FindBy(linkText="Data Structures")
	WebElement DSdropdown_tree;
	@FindBy(xpath="//a[@class='list-group-item']")
	List<WebElement> GetStartedButtons;
    @FindBy(xpath="//h4[@class='bg-secondary text-white']")
    WebElement queueHeading;
    @FindBy(id="output")
    WebElement output;
    @FindBy(xpath="//a[@href='/tryEditor']")
    WebElement tryHereButton;
    @FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
    WebElement  textAreaWorkSpace;
    @FindBy(xpath="//button[text()='Run']")
	WebElement runButton;
    String homePageURL = CommonUtils.getHomePage();
	String treePageURL = CommonUtils.getTreeUrl();
    
   public TreePage_PageObject(WebDriver driver)
  	{
  		this.driver = driver;
  		PageFactory.initElements(driver, this);
  	}
     
   public void homePage_tree()
	{
		driver.get(homePageURL);
	}
	
   public void Dropdown_tree() throws InterruptedException
		{
		DSdropdown_tree.click();
	    Thread.sleep(1000);
		driver.findElement(By.linkText("Tree")).click();
		title = driver.getTitle();
		}
   public void getTreePage()
	{
		driver.get(treePageURL);
		
	}
   
   public boolean click_TreeMenu_LinkForValid(String linkNameFromFeature)
  	{
      	boolean clicked =CommonUtils.webclick(GetStartedButtons, linkNameFromFeature);
      	return clicked;
  	}
   public void send_PythonCode_inTree(boolean clickedMenu,String pythonCode)
	{
   	Actions act = new Actions(driver);
		if(clickedMenu)
		{
			act.moveToElement(tryHereButton);
			tryHereButton.click();
			textAreaWorkSpace.sendKeys(pythonCode);
		}
	 }
		public void click_RunButton_ForValid_inTree()
		{
			runButton.click();
		}
		public String getTitle()
		{
			return title;
		}
		public String getMessage_tree()
		{
			message = output.getText();
			driver.navigate().to(treePageURL);
			return message;
		}
		public String getErrorMessage_tree()
		{
			errorMessage = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			driver.navigate().to(homePageURL);
			return errorMessage;
		}
	   
	}
	
