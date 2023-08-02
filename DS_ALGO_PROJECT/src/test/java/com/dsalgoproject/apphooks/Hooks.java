package com.dsalgoproject.apphooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dsalgoproject.driverfactory.DriverManager;
import com.dsalgoproject.utility.CommonUtils;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

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
    
    @AfterStep
    public void addScreenShot(Scenario scenario)
    {
    	if(scenario.isFailed())
    	{
    		String ScreenShotName = scenario.getName().replaceAll(" ", "_");
    		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(sourcePath, "image/png", ScreenShotName);
    	}
    }
    
    
    public static WebDriver getDriver() {
        return driver;
    }

}
