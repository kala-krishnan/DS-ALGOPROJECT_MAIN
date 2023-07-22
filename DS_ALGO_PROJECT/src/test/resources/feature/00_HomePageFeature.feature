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
Feature: To Test the HomePage

	
	 Scenario: User launch home page of an DSALgo Project
    Given  The User opens DS Algo portal link
    When The User clicks the "Get Started" button
    Then The User should be redirected to homeage
    
  Scenario Outline: User is clicking Data Structures
  
  Given  The User is in HomePage
  When The user Chooses "<options>" without login
 	Then the user will get the "<errormessage>"
 	
 	 Examples:
 | options        | errormessage  |
 | Arrays      | You are not logged in  |
 | Linked List | You are not logged in  |
 | Stack    | You are not logged in     |
 | Queue    | You are not logged in     |
 | Tree    | You are not logged in      |
 | Graph    | You are not logged in     |   


 