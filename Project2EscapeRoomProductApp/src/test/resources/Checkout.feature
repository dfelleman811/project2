Feature: the user checks out

	Scenario:
		Given the user is at the shopping cart page
		When the user clicks on checkout
		Then the title of the current page is Excape - Order Confirmation
		
	Scenario: 
		Given the user is at the shopping cart page
		When the user clicks on empty cart
		Then the cart is empty