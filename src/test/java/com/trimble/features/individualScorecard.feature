#Author: Saravanakumar
@tag
Feature: Individual Scorecard
  I want to use this template for my feature file

  #@Regression
  #Scenario: Verify when you click on a Driver in Exec Console then Individual Scorecard for that driver is opened
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #And I clicked on driver name in Executive console
    #Then Verify Individual Scorecard is displayed for that driver

  #@Regression
  #Scenario: Verify that Date filter settings are maintained on Individual Scorecard when you click on a driver in Exec Console
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #And I clicked on driver name in Executive console
    #Then Verify Individual Scorecard is displayed for that driver
    #Then I verified the Date filter settings is displayed correctly

  @Regression
  Scenario: Verify Overall Score dashlet shows overall score for the selected driver for the selected Date Period range
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    And I clicked on driver name in Executive console
    Then Verify Individual Scorecard is displayed for that driver
    Then I verified overall score in dashlet in Individual Scorecard