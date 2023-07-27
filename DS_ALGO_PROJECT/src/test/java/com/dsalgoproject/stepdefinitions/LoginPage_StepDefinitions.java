package com.dsalgoproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.LoginPage_PageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPage_StepDefinitions {
	private WebDriver driver;
	LoginPage_PageObject loginPageObj;
	public LoginPage_StepDefinitions()
	{
		driver = Hooks.getDriver();
		loginPageObj =  new LoginPage_PageObject(driver);
	}
	
	
	@Given("The user opens the Login page")
	public void the_user_opens_the_login_page() {
		loginPageObj.Login();
	}

	@When("The user clicks on the Login page with incorrect username and password")
	public void the_user_clicks_on_the_login_page_with_incorrect_username_and_password() {
		loginPageObj.IncorrectUserNameAndPassword();
	}

	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String string) {
		String message = loginPageObj.getMessage();
		System.out.println("message" +message);
		Assert.assertEquals(message,string);
	}

	@When("The user enters the correct username and password and clicks Login button")
	public void the_user_enters_the_correct_username_and_password_and_clicks_login_button() {
		loginPageObj.CorrectUsernameAndPassword();
	}

	@Then("The user can see the  message {string}")
	public void the_user_can_see_the_message(String string) {
		String message = loginPageObj.getMessage();
		System.out.println("message" +message);
		Assert.assertEquals(message,string);
	}
	
	@When("The user clicks on the Signout button")
	public void the_user_clicks_on_the_signout_button() {
		loginPageObj.SignOut();
	}
	
	@Then("It should display a logoutmessage {string}")
	public void it_should_display_a_logoutmessage(String string) {
		String message = loginPageObj.getMessage();
		 System.out.println("message" +message);
		 Assert.assertEquals(message,string);
	   
	}
}
