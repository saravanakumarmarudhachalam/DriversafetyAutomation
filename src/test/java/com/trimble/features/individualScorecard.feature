#Author: Saravanakumar
@tag
Feature: Individual Scorecard
  I want to use this template for my feature file

  #@Regression
  #Scenario: IndividualScorecard - Verify when you click on a Driver in Exec Console then Individual Scorecard for that driver is opened
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #And I clicked on driver name in Executive console
    #Then Verify Individual Scorecard is displayed for that driver
#
  #@Regression
  #Scenario: IndividualScorecard - Verify that Date filter settings are maintained on Individual Scorecard when you click on a driver in Exec Console
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #And I clicked on driver name in Executive console
    #Then Verify Individual Scorecard is displayed for that driver
    #Then I verified the Date filter settings is displayed correctly
#
  #@Regression
  #Scenario: IndividualScorecard - Verify Overall Score dashlet shows overall score for the selected driver for the selected Date Period range
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #And I clicked on driver name in Executive console
    #Then Verify Individual Scorecard is displayed for that driver
    #Then I verified overall score in dashlet in Individual Scorecard
#
  #@Regression
  #Scenario: IndividualScorecard - Verify Daily score for selected period dashlet shows Target/Trendline as per the Driver Safety Target filter set
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #And I clicked on driver name in Executive console
    #Then Verify Individual Scorecard is displayed for that driver
    #Then I Verify Target is enabled in the Bar chart in individual Scorecard
    #When I clicked the Target in individual Scorecard
    #Then I verify Target is disabled in the bar chart in individual Scorecard
#
  #@Regression
  #Scenario: IndividualScorecard - Verify value in Total Distance KPI is correct (for the selected Date Filter range)
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #And I clicked on driver name in Executive console
    #Then Verify Individual Scorecard is displayed for that driver
    #Then I verified total distance KPI in Individual Scorecard
#
  #@Regression
  #Scenario: IndividualScorecard - Verify value in Idling Duration (%) KPI is correct (for the selected Date Filter range)
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #And I clicked on driver name in Executive console
    #Then Verify Individual Scorecard is displayed for that driver
    #Then I verified Idling Duration in Individual Scorecard
#
   #@Regression
  #Scenario: IndividualScorecard - Verify export of the entire report via Export (menu) -> PDF (with Details)
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #And I clicked on driver name in Executive console
    #Then Verify Individual Scorecard is displayed for that driver  
    #When I clicked Exporticon
    #And I clicked ExportPDF
    #Then I verified file has been exported correctly
    #When I clicked Exporticon
    #And I clicked ExportPDFdetails
    #Then I verified file has been exported correctly
    
   @Regression
  Scenario: IndividualScorecard - Verify text for Events Per Mile changes appropriately based on the value set against the Distance Units filter
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    And I clicked on driver name in Executive console
    Then Verify Individual Scorecard is displayed for that driver
    And I Changed to Kilometers
    Then I verified Kilometer Text has been changed
    