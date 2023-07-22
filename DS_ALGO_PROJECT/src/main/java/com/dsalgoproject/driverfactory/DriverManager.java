package com.dsalgoproject.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.dsalgoproject.utility.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
private static WebDriver driver=null;
	
	public static WebDriver launchBrowser() {
		try {
			String browser_Name = CommonUtils.BROWSER;
			switch (browser_Name) {
			
			case "chrome":
				WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();
				driver= new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				
			default:
				WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	

}
