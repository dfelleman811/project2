Feature: Item Detail Page Displays Item

	Scenario Outline:
		Given the user is on the shop page
		When the user clicks on an "<item>"
		Then the current page title should be "<title>"
		And the page header should be "<header>"
		And the item image should be "<image>"
		
	Examples:
	|		item		|		title						|			header			|		image		|
	|	Dot-to-Dot		|	Dot-to-Dot Puzzle - Excape		|	Dot-to-Dot Puzzle		|		img/8.jpg	|
	