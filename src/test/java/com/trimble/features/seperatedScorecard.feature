#Author: Saravanakumar
@tag
Feature: Seperated Scorecard Report
  I want to use this template for my feature file

  @Regression
  Scenario: Scorecard Report - separated groups - Verify Export of the Report as Data to Excel Using Dashlet Actions
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Foldericon and Driver Safety
    And I clicked Scorecard Report - seperated groups
    And I clicked Dashlet Actions on seperated groups
    And I clicked Export As on seperated groups
    And I clicked Data to Excel on seperated groups
    Then Verify Export of the Report on seperated groups

  @Regression
  Scenario: Scorecard Report - separated groups - Verify separated groups report opened shows the data for DOVER Group by default
    Then Verify separated groups report opened shows the data for DOVER Group by default

  @Regression
  Scenario: Scorecard Report - separated groups - Verify that a new Notification is working ok
    And I created a new notification center and ran it
    Then I verified notification send successsfully

  @Regression
  Scenario: Scorecard Report - separated groups - Verify that existing notification is working fine.
    And I open the Notification and ran an existing one
    Then I delete an existing one

  @Regression
  Scenario: Scorecard Report - separated groups - Verify if 'Include Inactive Drivers' is set to yes then drivers with no scores data (for the selected report period) are shown at the end of the report
    And I checked Include Active Drivers as YES
    And I navigate to last page
    Then I verified  Include inactive Drivers are displayed
    
  @Regression
  Scenario: Scorecard Report - separated groups - Verify the Score values are color coded as per the filter values set for Driver Safety Lower & Target filters (in Driver Safety Scorecard Report Grid)
     And I set Driver safety lower & target filters  
     Then I verified score values are color coded as per the Filter values
