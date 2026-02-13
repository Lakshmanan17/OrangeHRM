Feature: This feature is to get pending timesheet
Scenario Outline: This test is to very the pending timesheet
Given user is on homepage
And the user clicks on the time option from the menu
And the user enter the name as "John Smith"
Then user should see the message as "<message>"
Examples:
|message|
|No timesheets found|

