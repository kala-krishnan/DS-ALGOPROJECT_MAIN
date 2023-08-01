package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.StackPage_PageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Tha;

public class StackPage_StepDefinitions {
	private WebDriver driver;
	StackPage_PageObject StackObj;
	
	public StackPage_StepDefinitions() {
		driver = Hooks.getDriver();
		StackObj = new StackPage_PageObject(driver);
		
	}
	
	String title; 
	String actualMessage;
	
	boolean Stackmanuclick;
	
	@Given("The user is on the Signin page of DS Algo portal")
	public void the_user_is_on_the_signin_page_of_ds_algo_portal() {
	    StackObj.signInPage();
	}

	@When("The user enters valid {string} and {string}")
	public void the_user_enters_valid_and(String string, String string2) {
	   StackObj.CorrectUsernameAndPassword();
	}

	@Then("The user is successfully login to the homepage")
	public void the_user_is_successfully_login_to_the_homepage() {
		title = StackObj.getTitle();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(title, expectedTitle);
	}

	@Given("The user is on the home page after being logged in")
	public void the_user_is_on_the_home_page_after_being_logged_in() {
		StackObj.HomePage();
	}

	@When("The user selects the stack item from the drop-down menu")
	public void the_user_selects_the_stack_item_from_the_drop_down_menu() throws InterruptedException {
		StackObj.checkSelectBox();
	}

	@Then("The user should be directed to the {string} Page")
	public void the_user_should_be_directed_to_the_page(String string) {
		title = StackObj.getTitle();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(title, expectedTitle);
	}

	@Given("The user is in the Stack Data Structure Page")
	public void the_user_is_in_the_stack_data_structure_page() {
	  StackObj.StackDataStructurePage();
	}

	@When("the user clicks {string} in Stack Data Structure page")
	public void the_user_clicks_in_stack_data_structure_page(String string) {
		Stackmanuclick=StackObj.click_StackMenu_LinkForValid(string);
	}

	@When("the user enter valid {string} for Stack")
	public void the_user_enter_valid_for_stack(String string) {
		StackObj.send_PythonCode_inStack(Stackmanuclick, string);
	}

	@When("the user clicks Run button for the Python code for Stack module")
	public void the_user_clicks_run_button_for_the_python_code_for_stack_module() {
		StackObj.click_RunButton_ForValid_inStack();
	}

	@Then("the user see the Stack module excepted {string}")
	public void the_user_see_the_stack_module_excepted(String string) {
		actualMessage = StackObj.getMessage();
		Assert.assertEquals(actualMessage, string);
	}

	@Given("The user is present in the Stack Data Structure Page")
	public void the_user_is_present_in_the_stack_data_structure_page() {
		StackObj.StackDataStructurePage();
	}

	@When("the user click {string} in Stack Data Structure page")
	public void the_user_click_in_stack_data_structure_page(String string) {
		Stackmanuclick=StackObj.click_StackMenu_LinkForValid(string);
	}

	@When("the user enters inValid {string} for Stack")
	public void the_user_enters_in_valid_for_stack(String string) {
		StackObj.send_PythonCode_inStack(Stackmanuclick, string);
	}

	@When("the user clicks Run button in the tryEditor Page for the Python code for Stack module")
	public void the_user_clicks_run_button_in_the_try_editor_page_for_the_python_code_for_stack_module() {
		StackObj.click_RunButton_ForValid_inStack();
	}

	@Then("the user will get the Stack module {string}")
	public void the_user_will_get_the_stack_module(String string) {
		actualMessage = StackObj.getErrorMessage();
		Assert.assertEquals(actualMessage, string);
	}



}

	