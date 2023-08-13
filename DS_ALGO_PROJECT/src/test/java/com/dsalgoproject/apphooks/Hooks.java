package com.dsalgoproject.apphooks;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
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
	private static final Logger LOG=LogManager.getLogger(Hooks.class);
	
    @Before
    public void beforeScenario() {
    	
    	try {
    		CommonUtils.loadProperties();
    	
    	if(driver== null) {
    		driver = DriverManager.launchBrowser();
    		driver.manage().window().maximize();
    	
    	}
    	LOG.info("Browser is launched");
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
    		LOG.error("Scenario failed");
    		String ScreenShotName = scenario.getName().replaceAll(" ", "_");
    		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(sourcePath, "image/png", ScreenShotName);
    		
    	}
    }
    
    public static WebDriver getDriver() {
        return driver;
    }

//    @AfterAll
//    public static void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//            LOG.info("Browser session closed.");
//        }
//    }

}
