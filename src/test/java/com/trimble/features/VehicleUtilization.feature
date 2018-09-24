#Author: Saravanakumar
@tag
Feature: Verify Vehicle Utilization report
  I want to use this template for my feature file

  @Regression
  Scenario: Vehicle Utilization - Verify that Utlization report is opened for the current month by default
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    And I clicked Foldericon
    Then I clicked Vehicle Utilization

  @Regression
  Scenario: Vehicle Utilization - Verify that Utlization report is opened for the current month by default
    Then Verify that Utlization report is opened for the current month by default

  @Regression
  Scenario: Vehicle Utilization - Verify that value for Utilization change appropriately based on the value selected in the Month filter
    Then I changed the time period to last month in the Vehicle Utilization Report

  @Regression
  Scenario: Vehicle Utilization - Verify export of the entire report via Export (menu) -> PDF (with Details)
    When I clicked Exporticon
    And I clicked ExportPDF
    Then I verified file has been exported correctly
    When I clicked Exporticon
    And I clicked ExportPDFdetails
    Then I verified file has been exported correctly

  @Regression
  Scenario: Vehicle Utilization - Verify Target/Trend line is shown correctly set as per the Utilization Target filter value (in Daily Utilization dashlet)
    Then I Verify Target is enabled in the Bar chart
    When I clicked the Target
    Then I verify Target is disabled in the bar chart

  @Regression
  Scenario: Vehicle Utilization - Verify the Utilization column values are color coded as per the filter values set for Utilization Target filter in the grid dashlet
    Then I verify color coding of Utilization percentage

  @Regression
  Scenario: Vehicle Utilization - Verify export of the entire report via Export (menu) -> PDF (with Details)
    When I clicked Exporticon
    And I clicked ExportPDF
    Then I verified file has been exported correctly
    When I clicked Exporticon
    And I clicked ExportPDFdetails
    Then I verified file has been exported correctly
