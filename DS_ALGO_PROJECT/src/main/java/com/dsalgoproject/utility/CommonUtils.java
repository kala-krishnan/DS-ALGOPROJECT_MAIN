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
	static Properties properties = new Properties();
	
	
	public static void loadProperties() {
		
		//FileReader reader= null;
		FileInputStream inputstr = null;
		
		try {
		 inputstr = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config.properties");
		//reader = new FileReader("config.properties");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	
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
	public static String getApplicationPage() {
		String appurl = properties.getProperty("applicationURL");
		if (appurl != null)
			return appurl;
		else
			throw new RuntimeException("Homeurl not specified in the Configuration.properties file.");
	}
	public static String getHomePage() {
		String homeurl = properties.getProperty("homepage");
		if (homeurl != null)
			return homeurl;
		else
			throw new RuntimeException("Homeurl not specified in the Configuration.properties file.");
	}
	public static String getLoginPage() {
		String loginurl = properties.getProperty("loginpage");
		if (loginurl != null)
			return loginurl;
		else
			throw new RuntimeException("Loginurl not specified in the Configuration.properties file.");
	}
	public static String getRegisterPage() {
		String registerurl = properties.getProperty("registerurl");
		if (registerurl != null)
			return registerurl;
		else
			throw new RuntimeException("Register url not specified in the Configuration.properties file.");
	}
	public static String getexcelfilepath() {
		String excelfilelpath = properties.getProperty("excelfilepath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}
	public static String getDSPageUrl() {
		String dsPageurl = properties.getProperty("DataStructuresIntroduction");
		if (dsPageurl != null)
			return dsPageurl;
		else
			throw new RuntimeException("linked list url not specified in the Configuration.properties file.");
	}
	public static String getDSPageTimeCompUrl() {
		String timeCompurl = properties.getProperty("TimeComplexity");
		if (timeCompurl != null)
			return timeCompurl;
		else
			throw new RuntimeException("linked list Time Complexity url not specified in the Configuration.properties file.");
	}
	public static String getArrayPageUrl() {
		String arrayPageurl = properties.getProperty("Arraypage");
		if (arrayPageurl != null)
			return arrayPageurl;
		else
			throw new RuntimeException("ArrayPage url not specified in the Configuration.properties file.");
	}
	public static String getArrayinPythonUrl() {
		String arrayinPythonurl = properties.getProperty("ArrayinPython");
		if (arrayinPythonurl != null)
			return arrayinPythonurl;
		else
			throw new RuntimeException("Array in Python url not specified in the Configuration.properties file.");
	}
	public static String getTryEditor() {
		String tryEditorurl = properties.getProperty("tryeditor");
		if (tryEditorurl != null)
			return tryEditorurl;
		else
			throw new RuntimeException("Array in Python url not specified in the Configuration.properties file.");
	}
	public static String getArrayPracticeUrl() {
		String arrayPracticeurl = properties.getProperty("ArrayPractice");
		if (arrayPracticeurl != null)
			return arrayPracticeurl;
		else
			throw new RuntimeException("Array Practice url not specified in the Configuration.properties file.");
	}
	public static String getLinkedListUrl() {
		String linkedlisturl = properties.getProperty("LinkedListpage");
		if (linkedlisturl != null)
			return linkedlisturl;
		else
			throw new RuntimeException("Linked List url not specified in the Configuration.properties file.");
	}
	public static String getStackUrl() {
		String StackPageurl = properties.getProperty("Stackpage");
		if (StackPageurl != null)
			return StackPageurl;
		else
			throw new RuntimeException("Stack url not specified in the Configuration.properties file.");
	}
	public static String getQueueUrl() {
		String queueurl = properties.getProperty("queueurl");
		if (queueurl != null)
			return queueurl;
		else
			throw new RuntimeException("Queue url not specified in the Configuration.properties file.");
	}
	public static String getGraphUrl() {
		String graphurl = properties.getProperty("graphurl");
		if (graphurl != null)
			return graphurl;
		else
			throw new RuntimeException("Graph url not specified in the Configuration.properties file.");
	}
	public static String getTreeUrl() {
		String treeurl = properties.getProperty("treeurl");
		if (treeurl != null)
			return treeurl;
		else
			throw new RuntimeException("Tree url not specified in the Configuration.properties file.");
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
