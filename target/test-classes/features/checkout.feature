Feature: place the order for product

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and Offers page	
Given user is on GreenCart landing page
When user searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
| Name |
| Tom  |

