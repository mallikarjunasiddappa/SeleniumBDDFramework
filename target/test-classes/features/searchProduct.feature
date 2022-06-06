Feature: Search and place the order for product

@OffersPage
Scenario Outline: Search experience for product search in both home and offers page with multiple values
Given user is on GreenCart landing page
When user searched with shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page
And validate product name in offers page matches with landing page

Examples:
| Name |
| Tom  |
| Beet |
