package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.DataStructuresPage_PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataStructuresPage_StepDefinitions {
	private WebDriver driver;
	DataStructuresPage_PageObject  DataStructuresPageObj;
	
	public DataStructuresPage_StepDefinitions()
	{
		 driver = Hooks.getDriver();
		 DataStructuresPageObj =  new DataStructuresPage_PageObject (driver);
	}
	
	@Given("The user is on signon page of the DS-Algo page")
	public void the_user_is_on_signon_page_of_the_ds_algo_page() {
		DataStructuresPageObj.Login();
	}

	@When("The user enter valid username {string} and password {string}")
	public void the_user_enter_valid_username_and_password(String string, String string2) {
		DataStructuresPageObj.CorrectUsernameAndPassword();
	}

	@Then("It should display {string}")
	public void it_should_display(String string) {
		
		String getSuccessMessage = DataStructuresPageObj.getLoginSuccessMessage();
		System.out.println("getSuccessMessage" + getSuccessMessage);
		Assert.assertEquals(getSuccessMessage,string);
	    
	}
	
	@Given("The user is on the home page after successful login")
	public void the_user_is_on_the_home_page_after_successful_login() {
		
		DataStructuresPageObj.homePage();
	}

	@When("The user clicks the Get Started button under Data Structures introduction panel")
	public void the_user_clicks_the_get_started_button_under_data_structures_introduction_panel() {
	         DataStructuresPageObj.clickDataStructuresGetStarted();
	    
	}

	@Then("The user should be redirected to Data Structures introduction page")
	public void the_user_should_be_redirected_to_data_structures_introduction_page() {
		
		String actualTitle= DataStructuresPageObj.getTitle();
		Assert.assertEquals(actualTitle, "Data Structures-Introduction");
	   
	}
	
	@Given("The user is on Data Structures introduction page")
	public void the_user_is_on_data_structures_introduction_page() {
		
		DataStructuresPageObj.dataStructuresIntroPage();
		   
	}

	@When("The user clicks the Time Complexity link")
	public void the_user_clicks_the_time_complexity_link() {
		
		DataStructuresPageObj.clickTimeComplexity();
	    
	}

	@Then("The user should be redirected to the Time Complexity page")
	public void the_user_should_be_redirected_to_the_time_complexity_page() {
		
		String actualTitle= DataStructuresPageObj.getTitle();
		Assert.assertEquals(actualTitle, "Time Complexity");	
			    
	}
	@Given("The user is on the Time Complexity page after login")
	public void the_user_is_on_the_time_complexity_page_after_login() {
		
		DataStructuresPageObj.timeComplexityPage();
	    
	}

	@When("The user click Try Here on the Time Complexity page")
	public void the_user_click_try_here_on_the_time_complexity_page() {
		
		DataStructuresPageObj.clickTryHere();
	    
	}

	@Then("The user should be redirected to the TryEditor page")
	public void the_user_should_be_redirected_to_the_try_editor_page() {
	   
		String actualTitle= DataStructuresPageObj.getTitle();
		Assert.assertEquals(actualTitle, "Assessment");
	}
	@Given("The user is in a page having a tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_a_try_editor_with_a_run_button_to_test() {
		
		DataStructuresPageObj.clickRunTryEditor();
		
	    
	}
	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String string, int int1) throws InterruptedException {
		
		DataStructuresPageObj.getPythonCode(string, int1);
	    	}

	@Then("The user should be presented with the run result")
	public void the_user_should_be_presented_with_the_run_result() {
	   
		DataStructuresPageObj.getSuccessMessage();
	          
	}

	@When("The user enter invalid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_invalid_python_code_in_try_editor_from_sheet_and(String string, Integer int2) {
		DataStructuresPageObj.invalidPythonCode(string, int2);
		
	}
	
	@Then("The user should be presented with the error message box")
	public void the_user_should_be_presented_with_the_error_message_box() {
		DataStructuresPageObj.getSuccessMessage();
	}






}
