package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.HomePage_PageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage_StepDefinitions {
	private WebDriver driver;
	HomePage_PageObject homePageObj;
	
	public HomePage_StepDefinitions()
	{
		 driver = Hooks.getDriver();
		 homePageObj =  new HomePage_PageObject(driver);
	}
	@Given("The User opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() {
		homePageObj.homePageLogin();
	}

	@When("The User clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		homePageObj.clickGetStartedButton();
	}

	@Then("The User should be redirected to homeage")
	public void the_user_should_be_redirected_to_homeage() {
		String actualPageTitle = homePageObj.getErrormessage();
		String ExpectedPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, ExpectedPageTitle);
	}
	@Given("The User is in HomePage")
	public void the_user_is_in_home_page() {
		homePageObj.homePage();
	}

	@When("The user Chooses {string} without login")
	public void the_user_chooses_without_login(String string) throws InterruptedException {
		homePageObj.checkSelectBox(string);
	}

	@Then("the user will get the {string}")
	public void the_user_will_get_the(String string) {
		String actualErrorMessage = homePageObj.getErrormessage();
		Assert.assertEquals(actualErrorMessage, string);
	}

	@When("The user clicks GetStarted button in {string} without login")
	public void the_user_clicks_get_started_button_in_without_login(String string) throws InterruptedException {
		homePageObj.dataStrGetStartedButtonClick(string);
	}

	@Then("The user will get the following {string}")
	public void the_user_will_get_the_following(String string) {
		String actualErrorMessage = homePageObj.getErrormessage();
		Assert.assertEquals(actualErrorMessage, string);
	}

	@When("The user clicks sign in")
	public void the_user_clicks_sign_in() {
		homePageObj.goToSignPage();
	}

	@Then("The user should be redirected to sign in page")
	public void the_user_should_be_redirected_to_sign_in_page() {
		String actualPageTitle = homePageObj.getErrormessage();
		String ExpectedPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, ExpectedPageTitle);
	}

	@When("The User clicks Register")
	public void the_user_clicks_register() {
		homePageObj.goToRegisterPage();
	}

	@Then("The user should be redirected to register page")
	public void the_user_should_be_redirected_to_register_page() {
		String actualPageTitle = homePageObj.getErrormessage();
		String ExpectedPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, ExpectedPageTitle);
	}

}
