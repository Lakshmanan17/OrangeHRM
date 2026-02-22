@GetCEOName
Feature: this feature is to get the CEO name from the OrangeHRM app
Scenario Outline: this test is to verify the CEO name
Given the user is logged in successfully and is on home page
When the user clicks on the directory option from the menu bar
And the user selects the job title as "Automaton Tester" from the drop down
And clicks the search button
Then the user should see the CEO name as "<CEO_Name>"         
Examples:
|CEO_Name|
|No Records Found |
