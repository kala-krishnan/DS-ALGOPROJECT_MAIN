package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.GraphPage_PageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GraphPage_StepDefinitions {
	private WebDriver driver;
	GraphPage_PageObject graphPageObj;
	boolean graph_Click;
	String title;
	String actualMessage;
	public GraphPage_StepDefinitions()
	{
		 driver = Hooks.getDriver();
		 graphPageObj =  new GraphPage_PageObject(driver);
	}
	
	@Given("The user is in the HomePage")
	public void the_user_is_in_the_home_page() {
		graphPageObj.homePage();
	}

	@When("the user is selecting the Graph item from the drop down menu")
	public void the_user_is_selecting_the_graph_item_from_the_drop_down_menu() throws InterruptedException {
		graphPageObj.selectGraphOption();
	}

	@Then("the user navigates to the Graph Data Structure Page")
	public void the_user_navigates_to_the_graph_data_structure_page() {
		title = graphPageObj.getTitle();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(title, expectedTitle);
	}

	@Given("The user is in the Graph Data Structure Page")
	public void the_user_is_in_the_graph_data_structure_page() {
		graphPageObj.getGraphPage();
	}

	@When("the user clicks {string} in Graph Data Structure page")
	public void the_user_clicks_in_graph_data_structure_page(String string) {
		 graph_Click = graphPageObj.click_GraphMenu_LinkForValid(string);
	}

	@When("the user enter valid {string} for Graph")
	public void the_user_enter_valid_for_graph(String string) {
		graphPageObj.send_PythonCode_inGraph(graph_Click, string);
	}

	@When("the user clicks Run button for the Python code for Graph module")
	public void the_user_clicks_run_button_for_the_python_code_for_graph_module() {
		graphPageObj.click_RunButton_ForValid_inGraph();
	}

	@Then("the user see the graph module excepted {string}")
	public void the_user_see_the_graph_module_excepted(String string) {
		actualMessage = graphPageObj.getMessage();
		Assert.assertEquals(actualMessage, string);
	}

	@Given("The user is present in the Graph Data Structure Page")
	public void the_user_is_present_in_the_graph_data_structure_page() {
		graphPageObj.getGraphPage();
	}

	@When("the user click {string} in Graph Data Structure page")
	public void the_user_click_in_graph_data_structure_page(String string) {
		 graph_Click = graphPageObj.click_GraphMenu_LinkForValid(string);
		 }

	@When("the user enters inValid {string} for Graph")
	public void the_user_enters_in_valid_for_graph(String string) {
		graphPageObj.send_PythonCode_inGraph(graph_Click, string);
	}

	@When("the user clicks Run button in the tryEditor Page for the Python code for Graph module")
	public void the_user_clicks_run_button_in_the_try_editor_page_for_the_python_code_for_graph_module() {

		graphPageObj.click_RunButton_ForValid_inGraph();
		}

	@Then("the user will get the graph module {string}")
	public void the_user_will_get_the_graph_module(String string) {
		actualMessage = graphPageObj.getErrorMessage();
		Assert.assertEquals(actualMessage, string);
		
	}




}
