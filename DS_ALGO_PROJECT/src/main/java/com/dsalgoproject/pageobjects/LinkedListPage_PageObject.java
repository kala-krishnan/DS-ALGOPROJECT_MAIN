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

public class LinkedListPage_PageObject {
		WebDriver driver;
		Actions acts;
		String errorMessage;
		String message;
		String title ="";
		private static final Logger LOG= LogManager.getLogger(LinkedListPage_PageObject.class); 
		@FindBy(linkText = "Data Structures")
		private WebElement DataStrIntroGetStarted;
		
		@FindBy(xpath="//a[@class='list-group-item']")
		List<WebElement> GetStartedButtons;
	
		@FindBy(xpath="//a[@href='/tryEditor']")
		private WebElement tryHereButton;
		
		@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
		private WebElement textAreaWorkSpace;
		
		@FindBy(xpath="//button[text()='Run']")
		private WebElement RunButton;
		
		@FindBy(id="output")
		private WebElement output;
		String homePageURL = CommonUtils.getHomePage();
		String linkedListURL = CommonUtils.getLinkedListUrl();
		
		public LinkedListPage_PageObject (WebDriver driver) {
	 			this.driver = driver;
	 			PageFactory.initElements(driver, this);
	 			acts= new Actions(driver);	
	 	}
		
	 	public void homePage()
		{
			driver.get(homePageURL);
		}
	 	public void selectLinkedListOption() throws InterruptedException
		{
			DataStrIntroGetStarted.click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Linked List")).click();
			title = driver.getTitle();
		}
		
		public void getLinkedListPage()
		{
			driver.get(linkedListURL);
			
		}
		public boolean click_LinkedListMenu_LinkForValid(String linkNameFromFeature)
		{
			
			
			boolean clicked =CommonUtils.webclick(GetStartedButtons, linkNameFromFeature);
			return clicked;
		}
		
		public void send_PythonCode_inLinkedList(boolean clickedMenu,String pythonCode)
		{
			
			if(clickedMenu)
			{
				acts.moveToElement(tryHereButton);
				tryHereButton.click();
				textAreaWorkSpace.sendKeys(pythonCode);
			}
		}
		public void click_RunButton_ForValid_inLinkedList()
		{
			RunButton.click();
		}
		public String getTitle()
		{
			return title;
		}
		public String getMessage()
		{
			message = output.getText();
			driver.navigate().to(linkedListURL);
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


