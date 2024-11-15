@GetCEOName
Feature: This feature is to get the CEO Name from OrangeHRM App
Scenario Outline: This scenario is used for verify CEO Name
Given User should be logged on home page successfully
When User clicks on the directory option from menu bar
And User selects the Job title as "Chief Executive Officer"
And User click the search button
Then User can see the CEO  name as "CEO_Name"  

Examples:
|CEO_Name|
|Maria Landa|

