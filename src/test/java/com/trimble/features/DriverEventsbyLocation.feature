#Author: Saravanakumar
@tag
Feature: Driver Events by Location Report
  I want to use this template for my feature file

  @Regression
  Scenario: Driver Events by Location - Verify the grid below the Map dashlet show the events for the selected driver for the selected Date Filter range correctly
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Foldericon and Driver Safety Events
    And I clicked Driver Events by Location
    And I Selected the AL HIGGS
    Then I verified AL HIGGS driver and Event date and time in the grid

  @Regression
  Scenario: Driver Events by Location - Verify Map dashlet shows Driver event(s) located at the correct Lat/Long values specified in the filter
    Then I verified Map Dashlet is displayed correctly

  @Regression
  Scenario: Driver Events by Location - Verify that when you click on Address to drill down to 'Driver Event Map' report then Date Period filter settings are maintained
    And I clicked driver address
    Then I verified Driver name and Address displayed correctly in Driver Event Map

  @Regression
  Scenario: Driver Events Map - Verify that when you click on Address in 'Driver Events By Location' report then the 'Driver Event Map' report is opened showing events located at the correct Lat/Long
    Then I verified Map Dashlet is displayed correctly in Driver Event Map
