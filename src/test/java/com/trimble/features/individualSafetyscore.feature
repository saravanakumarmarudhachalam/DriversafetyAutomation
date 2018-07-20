#Author: prakash_sah@trimble.com

@tag
Feature: Individual Safety Score card
  I want to use this template for my feature file

  #@Regression
  #Scenario: Verify Individual Score card page loads successfully
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Individual Safety Score card
    #Then Verify Individual Scorecard is displayed
    #
   @Regression
   Scenario: Verify click on a Driver in Exec Console then Individual Scorecard for that driver is opened
   Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    And I clicked on driver name in Executive console
    Then Verify Individual Scorecard is displayed for that driver
    
#@Regression
  #Scenario: Verify export of the entire report via Export (menu) -> PDF (with Details)
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Individual Safety Score card
    #Then Verify Individual Scorecard is displayed
    #When I clicked Exporticon
    #And I clicked ExportPDF
    #Then I verified file has been exported correctly
    #When I clicked Exporticon
    #And I clicked ExportPDFdetails
    #Then I verified file has been exported correctly
    #Then I validated PDF has been exported corretly - Not to use this method