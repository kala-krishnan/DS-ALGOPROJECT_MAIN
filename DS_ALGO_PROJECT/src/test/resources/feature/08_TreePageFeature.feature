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
Feature: To test Tree Data Structure Page
	Scenario: The user navigates to the Tree Data Structure page
	Given The user in the homepage of DS Tree dropdown page
	When The user selects Tree item from the dropdown menu
	Then the user navigates to the Tree Data Structure page
	
	Scenario Outline: The user is  navigating to Tree Page and runs code in tryEditor page
	Given The user is in Tree Data Structure Page
	When The user clicks the "<Treeoption>" from the Tree Data Structure Page
	And clicks Try Here button and enter valid "<PythonCode>" in TryEditor from Tree DS Page
	And the user clicks the run button for valid Python code in the Tree option DS page
	Then the user gets the valid "<output>" for Tree DataStructure
	Examples:
 	| Treeoption 				 				     | PythonCode 									| output |
	| Overview of Trees 				     | print('Hello, World!') | Hello, World! |
	| Terminologies 						     | print('Hello, World!') | Hello, World! |
	| Types of Trees 						     | print('Hello, World!') | Hello, World! |
	| Tree Traversals 					     | print('Hello, World!') | Hello, World! |
	| Traversals-Illustration 	     | print('Hello, World!') | Hello, World! |
	| Binary Trees 							     | print('Hello, World!') | Hello, World! |
	| Types of Binary Trees 				 | print('Hello, World!') | Hello, World! |
	| Implementation in Python 			 | print('Hello, World!') | Hello, World! |
	| Binary Tree Traversals 				 | print('Hello, World!') | Hello, World! |
	| Implementation of Binary Trees | print('Hello, World!') | Hello, World! |
 	| Applications of Binary trees   | print('Hello, World!') | Hello, World! |
 	| Binary Search Trees 					 | print('Hello, World!') | Hello, World! |
	| Implementation Of BST          | print('Hello, World!') | Hello, World! |
	
  Scenario Outline: The user is  navigating to Tree Page and runs invalid code in tryEditor page
	Given The user is in Tree Data Structures Page
	When The user clicks the "<TreeoptionValue>" from the Tree Data Structure Page in DS Algo
	And clicks Try Here button and enter invalid "<PythonCode>" in TryEditor from Tree DS page 
	And the user clicks the run button for the Python code under the Tree Data structure page
	Then the user gets the message "<errormessage>" for invalid code entered in Tree data structure page
	Examples:
 	| TreeoptionValue  						   | PythonCode 					| errormessage |
	| Overview of Trees 					   |HelloNumpyNinjas	 		|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
	| Terminologies 							   |HelloNumpyNinjas!  		|SyntaxError: bad token T_OP on line 1|
	| Types of Trees 							   |HelloNumpyNinjas   		|NameError: name 'HelloNumpyNinjas' is not defined on line 1|
	| Tree Traversals 						   |HelloNumpyNinjas  		|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
	| Traversals-Illustration 		   |HelloNumpyNinjas 			|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
	| Binary Trees 								   |HelloNumpyNinjas			|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
	| Types of Binary Trees 				 |HelloNumpyNinjas 			|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
	| Implementation in Python			 |HelloNumpyNinjas			|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
	| Binary Tree Traversals 				 |HelloNumpyNinjas			|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
	| Implementation of Binary Trees |HelloNumpyNinjas			|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
 	| Applications of Binary trees   |HelloNumpyNinjas 			|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
 	| Binary Search Trees            |HelloNumpyNinjas			|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |
	| Implementation Of BST          |HelloNumpyNinjas			|NameError: name 'HelloNumpyNinjas' is not defined on line 1 |