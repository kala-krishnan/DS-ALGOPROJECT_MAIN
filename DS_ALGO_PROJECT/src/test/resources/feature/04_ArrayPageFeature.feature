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
Feature: To test the Array Page




Scenario: The User is able to navigate to Array Data Structure Page
Given The user is in Home Page of DSAlGO Project
When The user is selecting Array item from the drop down menu
Then The user navigates to Array Data Structure Page



Scenario Outline: The user is able to navigate to Arrays Page and run code in tryEditor page
Given The user is in Array Data Structure Page 
When The user click "<Arrayoption>" in Array DS Page`
And click Try Here button and enter "<PythonCode>" in TryEditor of Array Page
And run code in the TryEditor of ArrayPage
Then the user gets the valid "<message>" in ArrayPage

Examples:
 | Arrayoption                    |   PythonCode           |  message  |
 | Arrays in Python               | print('Hello, World!') |  Hello, World! |
 | Arrays Using List              | print('Hello, World!') |  Hello, World! |
 | Basic Operations in Lists      | print('Hello, World!') |  Hello, World! |
 | Applications of Array          | print('Hello, World!') |  Hello, World! |
 
 Scenario Outline: The user is in Arrays Page and run code in tryEditor page
Given The user is in Array Data Structure Page 
When The user clicks "<Arrayoption>" in Array DataStructure Page
And the user clicks TryHere button and enter "<PythonCode>" in TryEditor Array DS Page
And and try to invalid run code in the TryEditor textarea of ArrayPage
Then the user will see the valid "<errormessage>" in ArrayPage

Examples:
 | Arrayoption                    |   PythonCode           |  errormessage  |
 | Arrays in Python               | abcd            |  NameError: name 'abcd' is not defined on line 1 |
 | Arrays Using List              | abcd            |  NameError: name 'abcd' is not defined on line 1 |
 | Basic Operations in Lists      | abcd            |  NameError: name 'abcd' is not defined on line 1 |
 | Applications of Array          | abcd            |  NameError: name 'abcd' is not defined on line 1 |
 
 Scenario: The User navigates to practice page in Arrays
 Given The user is in Arrays in Python Page
 When The user clicks Practice Questions in Array Page
 Then the user navigates to Array Practice Page
 
 Scenario Outline: The user is in Array Practice Page and run code for each examples
 Given The user is in Practice Page
 When The user clicks "<exerciselink>" in Practice Page
 And the user enters validCode from "<sheetName>" and <RowNumber> in the Array Practice Page Textarea
 And the user clicks Run button in Practice Page
 Then the user should be presented with Run result "<message>" in Practice Page
 When the user clicks submit button in Practice page
 Then the user sees the success message
 Examples:
 | exerciselink                             |   sheetName       |  RowNumber  | message       |
 | Search the array                         | DataStructures    |   1         | hello World   |
 | Max Consecutive Ones                     | DataStructures    |   1         | hello World   |
 | Find Numbers with Even Number of Digits  | DataStructures    |   1         | hello World   |
 | Squares of a Sorted Array                | DataStructures    |   1         | hello World   | 
 
 Scenario Outline: The user is in Array Practice Page and run invalid code for each examples
 Given The user is in Practice Page to check invalid code for each examples
 When The user clicks "<exerciselink>" in Practice Page to check invalid code for each examples
 And the user enters invalid Code from "<sheetName>" and <RowNumber> in the Array Practice Page Textarea
 And the user clicks Run button in Practice Page to check invalid code for each examples
 Then the user should be presented with Run result "<errormessage>" in Practice Page to check invalid code for each examples
  When the user clicks submit button for invalid python code in Practice page
 Then the user sees the error message

 Examples:
 | exerciselink                             |   sheetName       |  RowNumber  |         errormessage                     |
 | Search the array                         | DataStructures    |   2         | SyntaxError: bad input on line 1         | 
 | Max Consecutive Ones                     | DataStructures    |   2         | SyntaxError: bad input on line 1         |
 | Find Numbers with Even Number of Digits  | DataStructures    |   2         | SyntaxError: bad input on line 1         |
 | Squares of a Sorted Array                | DataStructures    |   2         | SyntaxError: bad input on line 1         | 
 
 
 
 
 