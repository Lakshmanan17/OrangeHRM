Feature: Admin User Management
Scenario: Search the system users

Given The user navigate to the admin page
When the user enter the usernme as "Admin"
When the user select the user Role as "Admin"
When the user enter Employee name as "mandaPriyansuPriyansu user"
When the user select the status as "Enabled"
And  user click search button
Then the user should see the admin page