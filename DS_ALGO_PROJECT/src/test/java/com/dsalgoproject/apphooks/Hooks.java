package com.dsalgoproject.apphooks;

import org.openqa.selenium.WebDriver;

import com.dsalgoproject.driverfactory.DriverManager;
import com.dsalgoproject.utility.CommonUtils;

import io.cucumber.java.Before;

public class Hooks {
	public static WebDriver driver;
	
    @Before
    public void beforeScenario() {
    	
    	try {
    		CommonUtils.loadProperties();
    	
    	if(driver== null) {
    		driver = DriverManager.launchBrowser();
    	
    	}
    	
    }
    catch (Exception e) {
    	e.printStackTrace();
    }
    }
    
    
    public static WebDriver getDriver() {
        return driver;
    }

}
