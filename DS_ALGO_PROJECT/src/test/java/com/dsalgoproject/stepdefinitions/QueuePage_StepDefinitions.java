package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.QueuePage_PageObject;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QueuePage_StepDefinitions {
	
	private WebDriver driver;
	QueuePage_PageObject queuePageObj;
	boolean queue_click;
	String title;
	String actualMessage;
	
	
	public QueuePage_StepDefinitions()
	{
		 driver = Hooks.getDriver();
		 queuePageObj =  new QueuePage_PageObject(driver);
			
	}
		
	@Given("The user enter login details")
	public void the_user_enter_login_details() {
	  
		queuePageObj.Logindetails_Queue();
	}

	@When("The user enters the username and password and clicks Login button")
	public void the_user_enters_the_username_and_password_and_clicks_login_button() {
	
		queuePageObj.correctusernameandpswd_Queue();
	}

	@Given("The user is on the home page")
	public void the_user_is_on_the_home_page() {
		
		queuePageObj.HomePage_Queue();
	    
	}

	@When("the user is able to click on the drop down menu to select Queue")
	public void the_user_is_able_to_click_on_the_drop_down_menu_to_select_queue() {
		
		queuePageObj.queueDropdown_Queue();;
	}

	@Then("the user is navigating to the Queue data structure page")
	public void the_user_is_navigating_to_the_queue_data_structure_page() {

		title= queuePageObj.getTitle();

		String expectedTitle= driver.getTitle();

		Assert.assertEquals(title, expectedTitle);
			
	}

	@Given("The user is in Queue Data Structure Page")
	public void the_user_is_in_queue_data_structure_page() {
	    
		queuePageObj.getQueuePage();
	}

	@When("The user click {string}")
	public void the_user_click(String string) {
	  
		queue_click= queuePageObj.click_QueueMenu_LinkForValid(string);
	}

	@When("click Try Here button and enter valid {string} in TryEditor")
	public void click_try_here_button_and_enter_valid_in_try_editor(String string) {
		
		
		queuePageObj.send_PythonCode_inQueue(queue_click, string);
	}

	@When("the user clicks the run button for valid Python code")
	public void the_user_clicks_the_run_button_for_valid_python_code() {
		
		 queuePageObj.click_RunButton_ForValid_inQueue(); 
	}

	@Then("the user gets the valid {string}")
	public void the_user_gets_the_valid(String string) {
		
		
		  actualMessage= queuePageObj.getMessage_Queue();

		   Assert.assertEquals(actualMessage, string);
	}

	@When("The user clicks {string}")
	public void the_user_clicks(String string) {
		
		 queue_click=queuePageObj.click_QueueMenu_LinkForValid(string);
	}

	@When("The user clicks Try Here button and enter inValid {string} in TryEditor")
	public void the_user_clicks_try_here_button_and_enter_in_valid_in_try_editor(String string) {
		
		queuePageObj.send_PythonCode_inQueue(queue_click, string);
	}

	@When("The user runs inValid code in the TryEditor by clicking run button.")
	public void the_user_runs_in_valid_code_in_the_try_editor_by_clicking_run_button() {
		
		queuePageObj.click_RunButton_ForValid_inQueue(); 
	}

	@Then("the user gets the invalid {string}")
	public void the_user_gets_the_invalid(String string) {
		
		
		actualMessage=queuePageObj.getErrorMessage_Queue();
		Assert.assertEquals(actualMessage, string);
	}


}