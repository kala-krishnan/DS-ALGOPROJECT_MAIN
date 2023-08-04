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
import com.dsalgoproject.utility.ExcelUtils;

public class ArrayPage_PageObject {
	WebDriver driver;
	
	private static final Logger LOG= LogManager.getLogger(ArrayPage_PageObject.class);
	@FindBy(linkText = "Data Structures")
	private WebElement DataStrIntroGetStarted;
	
	@FindBy(xpath="//a[@class='list-group-item']")
	private List<WebElement> menuLinks;
	String title ="";
	
	@FindBy(xpath="//a[@href='/tryEditor']")
	private WebElement tryHereButton;
	
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	private WebElement textAreaWorkSpace;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement RunButton;
	
	@FindBy(id="output")
	private WebElement output;
	
	@FindBy(xpath="//a[@class='list-group-item list-group-item-light text-info']")
	private WebElement  practiceQuestions;
	
	@FindBy(xpath="//div/a[@class='list-group-item']")
	private List<WebElement> practiceExerciseLinks;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	String message="";
	String javaScriptMessage ="";
	Actions act;
	String messageinPractice="";
	String errmessageinPractice="";
	
	
	public ArrayPage_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
			}
	
	
	public void loginPage()
	{
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	public void enterUserNamePassword(String userName ,String passWord)
	{
		driver.findElement(By.id("id_username")).sendKeys(userName);
		driver.findElement(By.id("id_password")).sendKeys(passWord);
		
	}
	public void clickLoginButton()
	{
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		title = driver.getTitle();
	}
	
	public void homePage()
	{
		driver.get("https://dsportalapp.herokuapp.com/home");
	}
	public void selectArrayOption() throws InterruptedException
	{
		DataStrIntroGetStarted.click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Arrays")).click();
		LOG.info("Array is clicked");
		title = driver.getTitle();
	}
	
	public void arrayDataStructurePage()
	{
		driver.get("https://dsportalapp.herokuapp.com/array");
	}
	
	
	public boolean click_ArrayMenu_LinkForValid(String linkNameFromFeature)
	{
		
		List<WebElement> GetStartedButtons = driver.findElements(By.xpath("//a[@class='list-group-item']"));
		boolean clicked =CommonUtils.webclick(GetStartedButtons, linkNameFromFeature);
		return clicked;
	}
	
	public void send_PythonCode_inArray(boolean clickedMenu,String pythonCode)
	{
		
		if(clickedMenu)
		{
			act.moveToElement(tryHereButton);
			tryHereButton.click();
			textAreaWorkSpace.sendKeys(pythonCode);
			LOG.info("Valid Python Code is sent" + pythonCode);
		}
	}
	public void click_RunButton_ForValid_inArray()
	{
		RunButton.click();
		message = output.getText();
		driver.navigate().to("https://dsportalapp.herokuapp.com/array");
	}
	
	public boolean click_ArrayMenu_LinkForInvalid(String linkName)
	{
		List<WebElement> GetStartedButtons = driver.findElements(By.xpath("//a[@class='list-group-item']"));
		boolean clickValue =CommonUtils.webclick(GetStartedButtons, linkName);
		return clickValue;
	}
	public void send_InvalidPythonCode_inArray(boolean clickedValue,String invalidPythonCode)
	{
		if(clickedValue)
		{
			act.moveToElement(tryHereButton);
			tryHereButton.click();
			textAreaWorkSpace.sendKeys(invalidPythonCode);
			LOG.info("InValid Python Code is sent" + invalidPythonCode);
			
		}
	}
	public void click_runButton_ForInvalid_InArray()
	{
		RunButton.click();
		javaScriptMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/arrays-in-python/");
	}
	
	public void goToArray_Practicepage()
	{
		driver.get("https://dsportalapp.herokuapp.com/array/arrays-in-python/");
	}
	public void clickPracticePage()
	{
		practiceQuestions.click();
		title = driver.getTitle();
	}
	public void goToPracticePage()
	{
		driver.get("https://dsportalapp.herokuapp.com/array/practice");
	}
	
	public boolean clickExerciseName(String linkName)
	{
		
		boolean clickValueForExercise =CommonUtils.webclick(practiceExerciseLinks, linkName);
		return clickValueForExercise;
		
	}
	public void validExerciseCode(boolean exerciseMenu,String SheetName,int RowNumber )
	{
		String path=System.getProperty("user.dir");
		ExcelUtils excel= new ExcelUtils(path+"//src//test//resources//ExcelData//ExcelData.xlsx",SheetName);
		String exerecisePythonCode= excel.getCellDataString(RowNumber,0);
		if(exerciseMenu)
		{
			
			CommonUtils.enterCodePractice(driver,exerecisePythonCode,textAreaWorkSpace);
		}
	}
	
	public void click_Run_ForExerciseCode()
	{
		RunButton.click();
		
	}
//	public void click_Submit_ForExerciseCode()
//	{
//		submitButton.click();
//		message = "Submission Success";
//	}
	public String getJavaScriptMessage()
	{
		return javaScriptMessage;
	}
	public String getMEssage()
	{
		return message;
	}
	
	public String getTitle()
	{
		return title;
	}
	public String getMeesageinPractice()
	{
		messageinPractice = output.getText();
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/practice");
		return messageinPractice;
	}
	public String geterrMeesageinPractice()
	{
		errmessageinPractice = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/practice");
		return errmessageinPractice;
	}
}
