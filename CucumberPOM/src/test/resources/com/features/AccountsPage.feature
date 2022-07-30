Feature: Account Page Feature

Background:
Given User has already logged in the application
| username | password |
|varshaguptajune@gmail.com | amazingworld |

Scenario: Accounts page title
Given User is on Accounts Page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Accounts section count
Given User is on Accounts Page
Then user gets accounts section
| ORDER HISTORY AND DETAILS |
| MY CREDIT SLIPS |
| MY ADDRESSES |
| MY PERSONAL INFORMATION |
| MY WISHLISTS |
| Home |
And Account section count should be 6