package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.TreePage_PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TreePage_StepDefintions {

	WebDriver driver;
	TreePage_PageObject treePageObj;
	boolean tree_click;
	String title;
	String actualMessage_tree;

	public TreePage_StepDefintions() {
		driver = Hooks.getDriver();
		treePageObj = new TreePage_PageObject(driver);
	}

	@Given("The user is in the login page of DS Algo")
	public void the_user_is_in_the_login_page_of_ds_algo() {

		treePageObj.loginPage_tree();
	}

	@When("the user gives the username and password from the excel sheet")
	public void the_user_gives_the_username_and_password_from_the_excel_sheet() {

		treePageObj.logindetails_tree();
	}

	@When("then clicks the login button for logging into the page")
	public void then_clicks_the_login_button_for_logging_into_the_page() {

		treePageObj.clickLoginButton_tree();
	}

	@Then("the user goes to the home page of the project")
	public void the_user_goes_to_the_home_page_of_the_project() {

		treePageObj.homePage_tree();
	}

	@Given("The user in the homepage of DS Tree dropdown page")
	public void the_user_in_the_homepage_of_ds_tree_dropdown_page() {

		title = treePageObj.getTitle_tree();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(title, expectedTitle);
	}

	@When("The user selects Tree item from the dropdown menu")
	public void the_user_selects_tree_item_from_the_dropdown_menu() throws InterruptedException {

		treePageObj.Dropdown_tree();
	}

	@Then("the user navigates to the Tree Data Structure page")
	public void the_user_navigates_to_the_tree_data_structure_page() {

		title = treePageObj.getTitle_tree();

		String expectedTitle = driver.getTitle();

		Assert.assertEquals(title, expectedTitle);
	}

	@Given("The user is in Tree Data Structure Page")
	public void the_user_is_in_tree_data_structure_page() {

		treePageObj.getTreePage();

	}

	@When("The user clicks the {string} from the Tree Data Structure Page")
	public void the_user_clicks_the_from_the_tree_data_structure_page(String string) {

		tree_click = treePageObj.click_TreeMenu_LinkForValid(string);
	}

	@When("clicks Try Here button and enter valid {string} in TryEditor from Tree DS Page")
	public void clicks_try_here_button_and_enter_valid_in_try_editor_from_tree_ds_page(String string) {

		treePageObj.send_PythonCode_inTree(tree_click, string);

	}

	@When("the user clicks the run button for valid Python code in the Tree option DS page")
	public void the_user_clicks_the_run_button_for_valid_python_code_in_the_tree_option_ds_page() {

		treePageObj.click_RunButton_ForValid_inTree();
	}

	@Then("the user gets the valid {string} for Tree DataStructure")
	public void the_user_gets_the_valid_for_tree_data_structure(String string) {

		actualMessage_tree = treePageObj.getMessage_tree();
		Assert.assertEquals(actualMessage_tree, string);

	}

	@Given("The user is in Tree Data Structures Page")
	public void the_user_is_in_tree_data_structures_page() {

		treePageObj.getTreePage();
	}

	
	@When("The user clicks the {string} from the Tree Data Structure Page in DS Algo")
	public void the_user_clicks_the_from_the_tree_data_structure_page_in_ds_algo(String string) {
		tree_click = treePageObj.click_TreeMenu_LinkForValid(string);
	}

	@When("clicks Try Here button and enter invalid {string} in TryEditor from Tree DS page")
	public void clicks_try_here_button_and_enter_invalid_in_try_editor_from_tree_ds_page(String string) {

		treePageObj.send_PythonCode_inTree(tree_click, string);

	}

	@When("the user clicks the run button for the Python code under the Tree Data structure page")
	public void the_user_clicks_the_run_button_for_the_python_code_under_the_tree_data_structure_page() {

		treePageObj.click_RunButton_ForValid_inTree();
	}

	@Then("the user gets the message {string} for invalid code entered in Tree data structure page")
	public void the_user_gets_the_message_for_invalid_code_entered_in_tree_data_structure_page(String string) {

		actualMessage_tree = treePageObj.getErrorMessage_tree();
		Assert.assertEquals(actualMessage_tree, string);

	}

}
