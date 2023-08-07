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
Feature: To test the Graph Page
Scenario: The user navigates to Graph Data structure Page
Given The user is in the HomePage
When the user is selecting the Graph item from the drop down menu 
Then the user navigates to the Graph Data Structure Page

Scenario Outline: The user is able to navigate to Graph topic page and run code in the tryeditor
Given The user is in the Graph Data Structure Page
When the user clicks "<Graphoption>" in Graph Data Structure page
And the user enter valid "<PythonCode>" for Graph
And the user clicks Run button for the Python code for Graph module
Then the user see the graph module excepted "<output>"

Examples:
 | Graphoption                    |   PythonCode           |  output  |
 | Graph                          | print('Hello, World!') |  Hello, World! |
 | Graph Representations          | print('Hello, World!') |  Hello, World! |
 
 Scenario Outline: The user is able to navigate to Graph topic page and runs code in the tryeditor page
Given The user is present in the Graph Data Structure Page
When the user click "<GraphoptionValue>" in Graph Data Structure page
And the user enters inValid "<PythonCode>" for Graph
And the user clicks Run button in the tryEditor Page for the Python code for Graph module
Then the user will get the graph module "<errormessage>"

Examples:
 | GraphoptionValue               |   PythonCode   |  errormessage  |
 | Graph                          |    abcd        | NameError: name 'abcd' is not defined on line 1               |
 | Graph Representations          |    abcd        | NameError: name 'abcd' is not defined on line 1               |
 
 Scenario: The user logged out successfully from DS-ALGO Home Page
 Given The user is in homePage and trying to click Logout
 When the user clicks Logout in DS-Algo After testing the scenarios
 Then the user navigates to the application url page
 
