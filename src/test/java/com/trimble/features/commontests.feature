#Author: Saravanakumar
@tag
Feature: Common Tests
  I want to use this template for my feature file

  @Regression
  Scenario: Verify dashboards are set to display data for Last 30 Days by default (where applicable)
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I verified Last 30days is displayed in Date filter

  @Regression
  Scenario: Verify date filters are consistent across dashboards
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I verified Last 30days, Startdate and Enddate filter is displayed correctly
    And I clicked Foldericon and Individual Scorecard
    Then I verified Last 30days, Startdate and Enddate filter is displayed correctly
    And I clicked Foldericon and Scorecard Report - combined groups
    Then I verified Last 30days, Startdate and Enddate filter is displayed correctly
    And I clicked Foldericon and Scorecard Report - separated groups
    Then I verified Last 30days, Startdate and Enddate filter is displayed correctly

  @Regression
  Scenario: Verify Banner, Trimble Pulse Logo look consistent across all dashboards (where applicable)
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I verified Trimble pulse logo and banner is displayed correctly
    And I clicked Foldericon and Individual Scorecard
    Then I verified Trimble pulse logo and banner is displayed correctly

  @Regression
  Scenario: Verify Date filter settings are maintained when you drill down from one dashboard to another e.g. from Exec Console to Individual Scorecard
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I verified Last 30days, Startdate and Enddate filter is displayed correctly
    And I clicked Foldericon and Individual Scorecard
    Then I verified the data of Last30days,startdate and enddate after switching one dash board to anotherdashboard is displayed correctly
