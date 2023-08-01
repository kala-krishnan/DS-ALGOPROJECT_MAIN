package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.LinkedListPage_PageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedListPage_StepDefinitions {
	private WebDriver driver;
	LinkedListPage_PageObject linkedListPageObj;
	boolean linkedlist_Click;
	String title;
	String actualMessage;
	
	public LinkedListPage_StepDefinitions() {
		 driver = Hooks.getDriver();
		 linkedListPageObj =  new LinkedListPage_PageObject(driver);		
	}
	@Given("The user logs into login page to enter details")
	public void the_user_logs_into_login_page_to_enter_details() {
	    linkedListPageObj.loginPage();
	}

	@When("The user is giving {string} for uname and {string} for pwd")
	public void the_user_is_giving_for_uname_and_for_pwd(String string, String string2) {
	   linkedListPageObj.enterUserNamePassword(string, string2);
	}

	@When("the user presses Login Button to successfully login")
	public void the_user_presses_login_button_to_successfully_login() {
	    linkedListPageObj.clickLoginButton();
	}
	@Then("The user is successfully logged into the homepage test for linked list")
	public void the_user_is_successfully_logged_into_the_homepage_test_for_linked_list() {
		title = linkedListPageObj.getTitle();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(title, expectedTitle);
	}
	
	@Given("The user is in the Home page after logged in")
	public void the_user_is_in_the_home_page_after_logged_in() {
	      linkedListPageObj.homePage();
	}
	@When("The user selecting linkedlist item from the drop down menu")
	public void the_user_selecting_linkedlist_item_from_the_drop_down_menu() throws InterruptedException {  
		linkedListPageObj.selectLinkedListOption();
	}
	@Then("The user should be directed to {string} Page")
	public void the_user_should_be_directed_to_page(String string) {
		title = linkedListPageObj.getTitle();
		String expectedTitle = driver.getTitle();
		System.out.println("The title after linked list is" +expectedTitle);
		Assert.assertEquals(title, expectedTitle);
	}

	@Given("The user is in Linked List Data Structure Page")
	public void the_user_is_in_linked_list_data_structure_page() {
	    linkedListPageObj.getLinkedListPage();
	}

	@When("The user click {string} under LinkedList Page")
	public void the_user_click_under_linked_list_page(String string) {
		linkedlist_Click = linkedListPageObj.click_LinkedListMenu_LinkForValid(string);
	    
	}

	@When("click Try Here button for Linked List and enter {string} in TryEditor")
	public void click_try_here_button_for_linked_list_and_enter_in_try_editor(String string) {
		linkedListPageObj.send_PythonCode_inLinkedList(linkedlist_Click, string);
	    
	}

	@When("runs code in the TryEditor for Linked List")
	public void runs_code_in_the_try_editor_for_linked_list() {
	   linkedListPageObj.click_RunButton_ForValid_inLinkedList();
	}

	@Then("the user gets the valid {string} for Linked List")
	public void the_user_gets_the_valid_for_linked_list(String string) {
		actualMessage = linkedListPageObj.getMessage();
		Assert.assertEquals(actualMessage, string);
		
	}
	
	@Given("The user is present in Linked List Data Structure Page")
	public void the_user_is_present_in_linked_list_data_structure_page() {
		linkedListPageObj.getLinkedListPage();
	}

	@When("The user clicks {string} under Linked List Page")
	public void the_user_clicks_under_Linked_List_Page (String string) {
		linkedlist_Click = linkedListPageObj.click_LinkedListMenu_LinkForValid(string);
	}

	@When("click Try Here button in Linked List and enter invalid {string} in TryEditor")
	public void click_try_here_button_in_linked_list_and_enter_invalid_in_try_editor(String string) {
		linkedListPageObj.send_PythonCode_inLinkedList(linkedlist_Click, string);
	  
	}
	@When("run code in the TryEditor for Linked List")
	public void run_code_in_the_try_editor_for_linked_list() {
	    linkedListPageObj.click_RunButton_ForValid_inLinkedList();
	}
	@Then("the user gets the error {string} for Linked List")
	public void the_user_gets_the_error_for_linked_list(String string) {
		actualMessage = linkedListPageObj.getErrorMessage();
		Assert.assertEquals(actualMessage, string);
	}



}

	