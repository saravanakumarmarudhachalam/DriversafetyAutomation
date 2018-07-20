#Author: Saravanakumar
@tag
Feature: Individual Scorecard
  I want to use this template for my feature file

  @Regression
  Scenario: Verify when you click on a Driver in Exec Console then Individual Scorecard for that driver is opened
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    And I clicked on driver name in Executive console
    Then Verify Individual Scorecard is displayed for that driver

