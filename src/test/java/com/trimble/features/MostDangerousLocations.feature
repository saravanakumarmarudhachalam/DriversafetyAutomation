#Author: Saravanakumar
@tag
Feature: Most Dangerous Locations Report
  I want to use this template for my feature file

  @Regression
  Scenario: Most Dangerous Locations Report - Verify the dashboard is set to display data for Last '30' Days by default
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Foldericon and Driver Safety Events
    And I clicked Most Dangerous Locations Report
    Then I verified Last 30 days is displayed in Date filter in Most Dangerous Locations report

  @Regression
  Scenario: Most Dangerous Locations Report - Verify sorting based on any column (in the grid section) works correctly
    Then I verified all the sorting column are working correctly

  @Regression
  Scenario: Most Dangerous Locations Report - Verify the grid values change appropriately as per Date Period filter set for the dashboard
    Then I changed the time period to last month in the Most Dangerous Locations Report

  @Regression
  Scenario: Most Dangerous Locations Report - Verify that when you click on approx address link to drill down to 'Event Location Hotspot Map' then Date Period filter settings are maintained
    Then I click on approx address link to drill down to 'Event Location Hotspot Map'

  @Regression
  Scenario: Most Dangerous Locations Report - Verify that Most Dangerous Locations dashboard shows the top 10 dangerous locations with the location having highest number of Total Events at the top of the list
    Then I find the number of columns in the Approimate Address table in the Most Dangerous Locations Report

  @Regression
  Scenario: Most Dangerous Locations Report - Verify that the 'Event Location Hotspot Map' is opened for the correct Lat/Longs as specified in the approx address location in Most Dangeous Locations report
    Then I find the number of columns in the Approimate Address table in the Most Dangerous Locations Report
