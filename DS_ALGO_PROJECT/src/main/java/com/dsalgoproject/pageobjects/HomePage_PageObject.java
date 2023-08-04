package com.dsalgoproject.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgoproject.utility.CommonUtils;
import com.dsalgoproject.utility.LoggerLoad;

public class HomePage_PageObject {
	WebDriver driver;
	private final static Logger LOG = LogManager.getLogger(HomePage_PageObject.class);
	@FindBy(xpath = "html/body/div/div/div/a/button")
	private WebElement getStartedButton;

	@FindBy(linkText = "Data Structures")
	private WebElement DataStrIntroGetStarted;

	@FindBy(xpath = "//div[contains(@class, 'alert alert-primary')]")
	private WebElement loginErrorMessage;

	@FindBy(xpath ="//div[contains(@class,'card-body d-flex flex-column')]/a")
	private List<WebElement> GetStartedButtons;
	
	@FindBy(xpath="//a[@href='data-structures-introduction']")
	private WebElement dataStructureGetStartedButton;
	
	@FindBy(xpath="//a[@href='array']")
	private WebElement arrayGetStartedButton;
	
	@FindBy(xpath="//a[@href='linked-list']")
	private WebElement linkedListGetStartedButton;
	
	@FindBy(xpath="//a[@href='stack']")
	private WebElement stackGetStartedButton;
	
	@FindBy(xpath="//a[@href='queue']")
	private WebElement queueGetStartedButton;
	
	@FindBy(xpath="//a[@href='tree']")
	private WebElement treeGetStartedButton;
	
	@FindBy(xpath="//a[@href='graph']")
	private WebElement graphGetStartedButton;

	String errorMessage;

	
	
	public HomePage_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void homePageLogin() {
		driver.get("https://dsportalapp.herokuapp.com/");
		LOG.info("DS ALGO Page Opened");
	}

	public void clickGetStartedButton() {
		getStartedButton.click();
		errorMessage = driver.getTitle();

	}

	public void homePage() {
		driver.get("https://dsportalapp.herokuapp.com/home");

	}

	public void checkSelectBox(String dataStructureValue) throws InterruptedException {
		DataStrIntroGetStarted.click();
		Thread.sleep(1000);
		driver.findElement(By.linkText(dataStructureValue)).click();
		errorMessage = loginErrorMessage.getText();
		LOG.info("The error text is:" +errorMessage);
	}
	

	public void dataStrGetStartedButtonClick(String optionValue) throws InterruptedException {
		
			if (optionValue.equals(CommonUtils.DATASTRUCTURESOPTIONS)) {
				dataStructureGetStartedButton.click();
				errorMessage = loginErrorMessage.getText();
			}
			else if(optionValue.equals(CommonUtils.ARRAYSOPTIONS))
			{
				arrayGetStartedButton.click();
				errorMessage = loginErrorMessage.getText();
			}
			else if(optionValue.equals(CommonUtils.LINKEDLISTOPTIONS))
			{
				linkedListGetStartedButton.click();
				errorMessage = loginErrorMessage.getText();
			}
			else if(optionValue.equals(CommonUtils.STACKOPTIONS))
			{
				stackGetStartedButton.click();
				errorMessage = loginErrorMessage.getText();
			}
			else if(optionValue.equals(CommonUtils.QUEUEOPTIONS))
			{
				queueGetStartedButton.click();
				errorMessage = loginErrorMessage.getText();
			}
			else if(optionValue.equals(CommonUtils.TREEOPTIONS))
			{
				treeGetStartedButton.click();
				errorMessage = loginErrorMessage.getText();
			}
			else if(optionValue.equals(CommonUtils.GRAPHOPTIONS))
			{
				graphGetStartedButton.click();
				errorMessage = loginErrorMessage.getText();
			}
			else if(optionValue.equals(CommonUtils.GRAPHOPTIONS))
			{
				getStartedButton.click();
				errorMessage = loginErrorMessage.getText();
			}
	}
	
	public void goToSignPage()
	{
		driver.get("https://dsportalapp.herokuapp.com/login");
		errorMessage = driver.getTitle();
	}
	public void goToRegisterPage()
	{
		driver.get("https://dsportalapp.herokuapp.com/register");
		errorMessage = driver.getTitle();
	}
	public String getErrormessage() {
		return errorMessage;
	}

}
