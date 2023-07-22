package com.dsalgoproject.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {
	public static String APP_URL;
	public static String BROWSER;
	public static String UserName;
	public static String Password;
	public static String CHROME_DRIVER;
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
		
	}

}
