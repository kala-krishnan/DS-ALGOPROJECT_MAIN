package com.dsalgoproject.pageobjects;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dsalgoproject.utility.CommonUtils;

public class GraphPage_PageObject {
	
	WebDriver driver;
	Actions act;
	String title ="";
	private static final Logger LOG= LogManager.getLogger(GraphPage_PageObject.class);
	@FindBy(linkText = "Data Structures")
	private WebElement DataStrIntroGetStarted;
	
	@FindBy(xpath="//a[@class='list-group-item']")
	List<WebElement> GetStartedButtons;
	
	
	@FindBy(xpath="//a[@href='/tryEditor']")
	private WebElement tryHereButton;
	
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	private WebElement textAreaWorkSpace;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement RunButton;
	
	@FindBy(id="output")
	private WebElement output;
	
	@FindBy(xpath="//a[@href='/logout']")
	private WebElement logoutButton;
	
	String errorMessage;
	String message;
	String homePageURL = CommonUtils.getHomePage();
	String graphPageURL = CommonUtils.getGraphUrl();
	
	public GraphPage_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	public void homePage()
	{
		driver.get(homePageURL);
	}
	public void selectGraphOption() throws InterruptedException
	{
		DataStrIntroGetStarted.click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Graph")).click();
		title = driver.getTitle();
		
	}
	
	public void getGraphPage()
	{
		driver.get(graphPageURL);
		
	}
	public boolean click_GraphMenu_LinkForValid(String linkNameFromFeature)
	{
		
		//List<WebElement> GetStartedButtons = driver.findElements(By.xpath("//a[@class='list-group-item']"));
		boolean clicked =CommonUtils.webclick(GetStartedButtons, linkNameFromFeature);
		return clicked;
	}
	
	public void send_PythonCode_inGraph(boolean clickedMenu,String pythonCode)
	{
		
		if(clickedMenu)
		{
			act.moveToElement(tryHereButton);
			tryHereButton.click();
			textAreaWorkSpace.sendKeys(pythonCode);
		}
	}
	public void click_RunButton_ForValid_inGraph()
	{
		RunButton.click();
	}
	
	public void click_Logout()
	{
		logoutButton.click();
		title = driver.getTitle();
		
	}
	public String getTitle()
	{
		return title;
	}
	public String getMessage()
	{
		message = output.getText();
		driver.navigate().to(graphPageURL);
		LOG.info("The success message is:" +message);
		return message;
		
	}
	
	public String getErrorMessage()
	{
		errorMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		driver.navigate().to(homePageURL);
		LOG.info("The error message is:" +errorMessage);
		return errorMessage;
	}
	
}
