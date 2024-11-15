@GetEmployeeName
Feature: This feature is to get the Employee Name from OrangeHRM App
Scenario Outline: This scenario is used for verify Employee Name
Given User should be logged on home page of OrangeHRM Appsuccessfully
When User clicks on the directory option from home menu bar
And User enters the employee name as "Peter Mac Anderson"
And User click the search button of directory page 
Then User can see the Employee name as "Peter Mac Anderson"  