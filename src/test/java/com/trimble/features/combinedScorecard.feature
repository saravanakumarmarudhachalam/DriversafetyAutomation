#Author: Saravanakumar
@tag
Feature: Combined Scorecard Report
  I want to use this template for my feature file

   #@Regression
  #Scenario: Scorecard Report - combined groups - Verify Export of the Report as Data to Excel Using Dashlet Actions 
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Foldericon and Driver Safety
    #And I clicked Scorecard Report - combined groups
    #And I clicked Dashlet Actions on combined groups
    #And I clicked Export As on combined groups
    #And I clicked Data to Excel on combined groups
    #Then Verify Export of the Report on combined groups
    
   
   @Regression
  Scenario: Scorecard Report - combined groups - Verify if Include Inactive Drivers is set to yes then drivers with no scores data (for the selected report period) are shown at the end of the report
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Foldericon and Driver Safety
    And I clicked Scorecard Report - combined groups
    And I checked Include Active Drivers as YES
    And I nagative to last page
    Then I verified  Include inactive Drivers are displayed