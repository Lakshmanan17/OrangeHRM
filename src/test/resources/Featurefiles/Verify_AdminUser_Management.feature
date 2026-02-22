Feature: Admin User Management
Scenario: Search the system users

Given The user navigate to the admin page
When the user enter the usernme as "Admin"
When the user select the user Role as "Admin"
When the user enter Employee name as "mandaPriyansuPriyansu user"
When the user select the status as "Enabled"
And  user click search button
Then the user should see the admin page


Scenario: Add the job Titles

Given The User click the job dropdown 
And select to the job Title page
And User click the Add button to create job title
When Enter the job title as "QA User"
When Enter the job description as "a clear job title, summary, key responsibilities, qualifications, and company culture/benefits"
Then Upload job specification file
And Enter the note as "QA testing process"
And User click the save button