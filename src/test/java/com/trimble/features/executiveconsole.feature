#Author: Saravanakumar
@tag
Feature: Executive Console
  I want to use this template for my feature file

  @Regression
  Scenario: Exectiveconsole - Verify drivers are shown in ascending order of their Overall Score in Driver Ranking by Scores grid i.e. driver having lowest Overall Score is at the top
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I verified overall score is displayed in ascending order

  @Regression
  Scenario: Exectiveconsole - Verify donut chart shows Overall Score for Allen Myers by default
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I verified Allen Myers text and overall score is displayed correctly

  @Regression
  Scenario: Exectiveconsole - Verify sorting based on any column (in Driver Ranking by Scores grid) works correctly
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I verified all the sorting column are working correctly

  @Regression
  Scenario: Exectiveconsole - Verify all Score values are shown rounded i.e. without any decimals (applicable to Overall Score, Accel, Braking, Speeding, Turning columns)
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I verified all the displayed without decimal point in the score grid

  @Regression
  Scenario: Exectiveconsole - Verify Target/Trend line is shown correctly set as per the Driver Safety Target filter value (in Org Units/Groups dashlet)
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I Verify Target is enabled in the Bar chart
    When I clicked the Target
    Then I verify Target is disabled in the bar chart

  @Regression
  Scenario: Exectiveconsole - Verify that a new Notification is working ok
    Then I validate the Executive Driversafety console page is displayed correctly
    And I created a new notification center and ran it
    Then I verified notification send successsfully

  @Regression
  Scenario: Exectiveconsole - Verify that existing notification is working fine.
    Then I validate the Executive Driversafety console page is displayed correctly
    And I open the Notification and ran an existing one
    Then I delete an existing one    
    
  @Regression
  Scenario: Exectiveconsole - Verify export of the entire report via Export (menu) -> PDF (with Details)
    Then I validate the Executive Driversafety console page is displayed correctly
    When I clicked Exporticon
    And I clicked ExportPDF
    Then I verified file has been exported correctly
    When I clicked Exporticon
    And I clicked ExportPDFdetails
    Then I verified file has been exported correctly

