#Author: Prakash Sah
@tag
Feature: Combined Scorecard Report
  I want to use this template for my feature file

   @Regression
  Scenario: Combined Scorecard - Verify Export of the Report as Data to Excel Using Dashlet Actions 
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Foldericon and Driver Safety
    And I clicked Scorecard Report - combined groups
    And I clicked Dashlet Actions
    And I clicked Export As
    And I clicked Data to Excel
    Then Verify Export of the Report
    
   
