package com.dsalgoproject.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.ArrayPage_PageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArrayPage_StepDefinitions {
	private WebDriver driver;
	ArrayPage_PageObject arrayPageObj;
	boolean clickedMenu;
	boolean clickedMenu1;
	boolean exerciseMenu;
	String ActualMessage;
	private static final Logger LOG=LogManager.getLogger(ArrayPage_StepDefinitions.class);
	public ArrayPage_StepDefinitions()
	{
		 driver = Hooks.getDriver();
		 arrayPageObj =  new ArrayPage_PageObject(driver);
	}
	@Given("The user is in login page")
	public void the_user_is_in_login_page() {
		arrayPageObj.loginPage();
	}

	@When("The user is entering {string} and {string}")
	public void the_user_is_entering_and(String string, String string2) {
		arrayPageObj.enterUserNamePassword(string, string2);
	}

	@When("The user clicks login button")
	public void the_user_clicks_login_button() {
		arrayPageObj.clickLoginButton();
	}

	@Then("the user is successfully logged in")
	public void the_user_is_successfully_logged_in() {
		String title = arrayPageObj.getTitle();
		String expectedTitle = driver.getTitle();
			
		Assert.assertEquals(title, expectedTitle);
		LOG.info("Logged in Successfully" );
	}


	@Given("The user is in Home Page of DSAlGO Project")
	public void the_user_is_in_home_page_of_dsalgo_project() {
		arrayPageObj.homePage();
		LOG.info("The user is in the homepage");
		
	}

	@When("The user is selecting Array item from the drop down menu")
	public void the_user_is_selecting_array_item_from_the_drop_down_menu() throws InterruptedException {
		arrayPageObj.selectArrayOption();
	}

	@Then("The user navigates to Array Data Structure Page")
	public void the_user_navigates_to_array_data_structure_page() {
		String title = arrayPageObj.getTitle();
		String expectedTitle = driver.getTitle();	
		Assert.assertEquals(title, expectedTitle);
	}
	@Given("The user is in Array Data Structure Page")
	public void the_user_is_in_array_data_structure_page() {
		arrayPageObj.arrayDataStructurePage();
	}
	@When("The user click {string} in Array DS Page`")
	public void the_user_click_in_array_ds_page(String string) {
		clickedMenu=arrayPageObj.click_ArrayMenu_LinkForValid(string);
	}
	@When("click Try Here button and enter {string} in TryEditor of Array Page")
	public void click_try_here_button_and_enter_in_try_editor_of_array_page(String string) {
		arrayPageObj.send_PythonCode_inArray(clickedMenu,string);
		
	}
	@When("run code in the TryEditor of ArrayPage")
	public void run_code_in_the_try_editor_of_arraypage() {
		arrayPageObj.click_RunButton_ForValid_inArray();
	}
	@Then("the user gets the valid {string} in ArrayPage")
	public void the_user_gets_the_valid_in_arraypage(String string) {
		ActualMessage = arrayPageObj.getMEssage();
		Assert.assertEquals(ActualMessage, string);
		LOG.info("The user gets the valid message: " +string);
		
	}
	@When("The user clicks {string} in Array DataStructure Page")
	public void the_user_clicks_in_array_data_structure_page(String string) {
		clickedMenu1 = arrayPageObj.click_ArrayMenu_LinkForInvalid(string);
	}
	@When("the user clicks TryHere button and enter {string} in TryEditor Array DS Page")
	public void the_user_clicks_try_here_button_and_enter_in_try_editor_array_ds_page(String string) {
		arrayPageObj.send_InvalidPythonCode_inArray(clickedMenu1,string);
	}
	@When("and try to invalid run code in the TryEditor textarea of ArrayPage")
	public void and_try_to_invalid_run_code_in_the_try_editor_textarea_of_arraypage() {
		arrayPageObj.click_runButton_ForInvalid_InArray();
	}
	@Then("the user will see the valid {string} in ArrayPage")
	public void the_user_will_see_the_valid_in_arraypage(String string) {
		ActualMessage = arrayPageObj.getJavaScriptMessage();
		Assert.assertEquals(ActualMessage, string);
		LOG.info("The user gets the error message for invalid python code: " +string);
		
	}
	@Given("The user is in Arrays in Python Page")
	public void the_user_is_in_arrays_in_python_page() {
		arrayPageObj.goToArray_Practicepage();
	}
	@When("The user clicks Practice Questions in Array Page")
	public void the_user_clicks_practice_questions_in_array_page() {
		arrayPageObj.clickPracticePage();
	}
	

	@Then("the user navigates to Array Practice Page")
	public void the_user_navigates_to_array_practice_page() {
		String title = arrayPageObj.getTitle();
		String expectedTitle = driver.getTitle();
		
		Assert.assertEquals(title, expectedTitle);
		
	}

	@Given("The user is in Practice Page")
	public void the_user_is_in_practice_page() {
		arrayPageObj.goToPracticePage();
	}

	@When("The user clicks {string} in Practice Page")
	public void the_user_clicks_in_practice_page(String string) {
		exerciseMenu=arrayPageObj.clickExerciseName(string);
	}
	@When("the user enters validCode from {string} and {int} in the Array Practice Page Textarea")
	public void the_user_enters_valid_code_from_and_in_the_array_practice_page_textarea(String string, Integer int1) {
		arrayPageObj.validExerciseCode(exerciseMenu,string,int1);
	}
	@When("the user clicks Run button in Practice Page")
	public void the_user_clicks_run_button_in_practice_page() {
		arrayPageObj.click_Run_ForExerciseCode();
	}
	@Then("the user should be presented with Run result {string} in Practice Page")
	public void the_user_should_be_presented_with_run_result_in_practice_page(String string) {
		ActualMessage = arrayPageObj.getMeesageinPractice();
		Assert.assertEquals(ActualMessage, string);
		LOG.info("The user gets the message for valid python code in practice page: " +string);
	}
	
//	@When("the user clicks on submit button in Practice Page")
//	public void the_user_clicks_on_submit_button_in_practice_page() {
//		arrayPageObj.click_Submit_ForExerciseCode();
//	}
//	@Then("the user should be presented with successful submission message {string} in Practice Page")
//	public void the_user_should_be_presented_with_successful_submission_message_in_practice_page(String string) {
//		ActualMessage = arrayPageObj.getMeesageinPractice();
//		Assert.assertEquals(ActualMessage, string);
//	}
	@Given("The user is in Practice Page to check invalid code for each examples")
	public void the_user_is_in_practice_page_to_check_invalid_code_for_each_examples() {
		arrayPageObj.goToPracticePage();
	}

	@When("The user clicks {string} in Practice Page to check invalid code for each examples")
	public void the_user_clicks_in_practice_page_to_check_invalid_code_for_each_examples(String string) {
		exerciseMenu=arrayPageObj.clickExerciseName(string);
	}
	@When("the user enters invalid Code from {string} and {int} in the Array Practice Page Textarea")
	public void the_user_enters_invalid_code_from_and_in_the_array_practice_page_textarea(String string, Integer int1) {
		arrayPageObj.validExerciseCode(exerciseMenu,string,int1);
	}
	
	@When("the user clicks Run button in Practice Page to check invalid code for each examples")
	public void the_user_clicks_run_button_in_practice_page_to_check_invalid_code_for_each_examples() {
		arrayPageObj.click_Run_ForExerciseCode();
	}

	@Then("the user should be presented with Run result {string} in Practice Page to check invalid code for each examples")
	public void the_user_should_be_presented_with_run_result_in_practice_page_to_check_invalid_code_for_each_examples(String string) {
		ActualMessage = arrayPageObj.geterrMeesageinPractice();
		Assert.assertEquals(ActualMessage, string);
		LOG.info("The user gets the message for invalid python code in practice page: " +string);
	}

//	@When("the user clicks on submit button in Practice Page to check invalid code for each examples")
//	public void the_user_clicks_on_submit_button_in_practice_page_to_check_invalid_code_for_each_examples() {
//		arrayPageObj.click_Submit_ForExerciseCode();
//	}
//
//	@Then("the user should be presented with successful submission message {string} in Practice Page to check invalid code for each examples")
//	public void the_user_should_be_presented_with_successful_submission_message_in_practice_page_to_check_invalid_code_for_each_examples(String string) {
//		ActualMessage = arrayPageObj.geterrMeesageinPractice();
//		Assert.assertEquals(ActualMessage, string);
//	}



	



	




}
