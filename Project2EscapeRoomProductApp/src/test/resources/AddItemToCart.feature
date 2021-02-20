Feature: Adding items to the shopping cart

	Scenario: User adds an item to the cart
		Given the user is on the item detail page
		When the user clicks add to cart
		Then the user is on the shopping cart page
		And the cart has the item in it
		