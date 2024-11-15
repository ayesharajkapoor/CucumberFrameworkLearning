Feature: This feature is used to get the pending timesheet
Scenario Outline: This scenario is verify the pending timesheet
Given User should be looged on home page successfully
When  User clicks Time option from menu bar
And User enters the employee name in Timesheet page as "Orange Test"
And USer clicks the view button
Then User should see the message as "<Message>" 
Examples:
|Message|
|No Timesheets Found|

 