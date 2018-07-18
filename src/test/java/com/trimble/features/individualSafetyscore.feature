#Author: prakash_sah@trimble.com

@tag
Feature: Individual Safety Score card
  I want to use this template for my feature file

  @Regression
  Scenario: Verify Individual Score card page loads successfully
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Individual Safety Score card
    Then Verify Individual Scorecard is displayed
