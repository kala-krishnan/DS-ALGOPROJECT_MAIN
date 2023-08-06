#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Feature file to test register  

    Scenario: The user is presented with error message for empty fields below username textbox
    Given The user opens Register page
    When The user clicks "Register" button with all fields empty
    Then It should display an error "Please fill out this field." 
    
    Scenario: The user is presented with error message for empty fields below Password textbox
    Given The user opens Register page
    When The user clicks "Register" button after giving username with other fields empty
    Then It should throws an error "Please fill out this field." 
    
    Scenario: The user is presented with error message for empty fields below Password1 textbox
    Given The user opens Register page
    When The user clicks "Register" button after giving the username and password with password confirmation field empty
    Then The user can see the error message "Please fill out this field." 
    
	  Scenario Outline: The user is presented with an error message
	  Given The user opens Register page
    When The user enters "<username>", "<password>", and "<password1>"
    And  the user clicks the register button
    Then the user should see the error message indicating "<errormessage>"
  
 
 Examples:
 | username        | password   | password1  | errormessage                                                      |
 | Numpy@123       | Numpy@123  | Numpy@123  | Please enter valid username                                       |
 | Numpy@SDET84_1  | Numpy@123  | Numpy@123  | Username already exists                                           |
 | kalasdet118     | Numpy@123  | Numpy@1234 | password_mismatch:The two password fields didn’t match.           |
 | kalasdet118     | Numpy      | Numpy      | Password should contain at least 8 characters                     |
 | kalasdet118     | 12345678   | 12345678   | Password cannot be entirely numeric                               |                              
 | kalasdet118     | sdet@123   | sdet@123   | Password cannot be too similar to your other personal information |
 | kalasdet118     | Test@1     | Test@1     | Password cannot be commonly used password                         |              

 		Scenario: The user is presented with success message when the user giving correct username and password
    Given The user opens Register page
    When The user clicks "Register" button after giving correct "coolcucumberteam","Kind@123" and "Kind@123" 
    And the user clicks the register button
    Then It should display the success message "New Account Created. You are logged in as coolcucumberteam" 
 	