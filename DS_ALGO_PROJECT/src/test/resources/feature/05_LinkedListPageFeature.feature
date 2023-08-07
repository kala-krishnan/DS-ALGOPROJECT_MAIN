
#Sample Feature Definition Template
@tag
Feature: User navigates to the Linked list page and tests the various options under it



Scenario: User navigated to "linked list" page
Given The user is in the Home page after logged in
When The user selecting linkedlist item from the drop down menu
Then The user should be directed to "Linked List" Page


Scenario Outline: The user is able to navigate to Linked Lists Page and run code in tryEditor page
Given The user is in Linked List Data Structure Page
When The user click "<LinkedListoption>" under LinkedList Page
And click Try Here button for Linked List and enter "<PythonCode>" in TryEditor
And runs code in the TryEditor for Linked List
Then the user gets the valid "<message>" for Linked List

Examples:
 | LinkedListoption | PythonCode | message |
 |Introduction   | print('Hello World!') | Hello World! |
 |Creating Linked LIst | print('Hello World!') | Hello World! |
 |Types of Linked List | print('Hello World!') | Hello World! |
 |Implement Linked List in Python| print('Hello World!') | Hello World! |
 |Traversal|print('Hello World!')| Hello World!|
 |Insertion|print ('Hello World!')| Hello World!|
 |Deletion| print('Hello World!')| Hello World!|
 
Scenario Outline: The user is able to navigate to Linked Lists page and run invalid python code in tryEditor page
Given The user is present in Linked List Data Structure Page
When The user clicks "<LinkedListOptionValue>" under Linked List Page
And click Try Here button in Linked List and enter invalid "<PythonCode>" in TryEditor
And run code in the TryEditor for Linked List
Then the user gets the error "<errormessage>" for Linked List

Examples:
 | LinkedListOptionValue | PythonCode | errormessage |
 |Introduction   |invalid code| SyntaxError: bad input on line 1 |
 |Creating Linked LIst | invalid code | SyntaxError: bad input on line 1 |
 |Types of Linked List | invalid code | SyntaxError: bad input on line 1 |
 |Implement Linked List in Python| invalid code | SyntaxError: bad input on line 1 |
 |Traversal|invalid code| SyntaxError: bad input on line 1|
 |Insertion|invalid code| SyntaxError: bad input on line 1|
 |Deletion| invalid code| SyntaxError: bad input on line 1|
 