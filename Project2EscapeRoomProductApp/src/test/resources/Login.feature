Feature: User Logging In

	Background:
		Given The User is at the Excape Login Page
	
	Scenario Outline: The User tries to log in
		When The User types in "<username>" and "<password>" and clicks log in button
		Then The title of the current page should be "<title>"
		
	Examples:
	|	username					|	password	|				title				|
	|	contact@escapecrowpeak.com	|	password	|	Excape - Escape Room Supplies	|
	|	dftest@email.com			|	password	|	Excape - Employee Portal		|
	