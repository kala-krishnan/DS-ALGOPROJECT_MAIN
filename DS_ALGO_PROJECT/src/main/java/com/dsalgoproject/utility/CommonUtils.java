package com.dsalgoproject.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {
	public static String APP_URL;
	public static String BROWSER;
	public static String UserName;
	public static String Password;
	public static String CHROME_DRIVER;
	public static String ARRAYSOPTIONS;
	public static String LINKEDLISTOPTIONS;
	public static String STACKOPTIONS;
	public static String QUEUEOPTIONS;
	public static String TREEOPTIONS;
	public static String GRAPHOPTIONS;
	public static String DATASTRUCTURESOPTIONS;
	
	public static void loadProperties() {
		
		//FileReader reader= null;
		FileInputStream inputstr = null;
		
		try {
		 inputstr = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config.properties");
		//reader = new FileReader("config.properties");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	 Properties properties = new Properties();
	try {
	    properties.load(inputstr);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	
	APP_URL = properties.getProperty("APP_URL");
	BROWSER = properties.getProperty("BROWSER");
	CHROME_DRIVER = properties.getProperty("CHROME_DRIVER");
	UserName = properties.getProperty("UserName");
	Password = properties.getProperty("Password");
	DATASTRUCTURESOPTIONS=properties.getProperty("DataStructuresValue");
	ARRAYSOPTIONS = properties.getProperty("ArrayOptionValue");
	LINKEDLISTOPTIONS = properties.getProperty("LinkedListOptionValue");
	STACKOPTIONS = properties.getProperty("StackOptionValue");
	QUEUEOPTIONS = properties.getProperty("QueueOptionValue");
	TREEOPTIONS = properties.getProperty("TreeOptionValue");
	GRAPHOPTIONS = properties.getProperty("GraphOptionValue");
	
	
		
	}
	
	public static boolean webclick(List<WebElement> elements,String optionValue)
	{
		WebElement matchingElement = elements.stream()
		        .filter(x -> x.getText().equals(optionValue))
		        .findFirst()
		        .get();
				
				if(matchingElement != null) {
					matchingElement.click();
					return true;
				}
				return false;
	}
	public static void enterCodePractice(WebDriver driver,String code, WebElement element) {
		Actions act = new Actions(driver);
				act.keyDown(Keys.COMMAND).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.COMMAND).perform();
		String[] str1 = code.split("\n");
		for (int i = 0; i < str1.length; i++) {
			if (str1[i].equalsIgnoreCase("\\b")) {
				element.sendKeys(Keys.BACK_SPACE);
			} else {
				element.sendKeys(str1[i]);
				element.sendKeys(Keys.RETURN);
			}
		}
	}

}
