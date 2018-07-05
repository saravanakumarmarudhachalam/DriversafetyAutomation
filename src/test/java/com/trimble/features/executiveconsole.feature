#Author: Saravanakumar
@tag
Feature: Executive Console
  I want to use this template for my feature file

  #@Regression
  #Scenario: Verify drivers are shown in ascending order of their Overall Score in Driver Ranking by Scores grid i.e. driver having lowest Overall Score is at the top
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #Then I validate the Executive Driversafety console page is displayed correctly
    #Then I verified overall score is displayed in ascending order

  @Regression
  Scenario: Verify donut chart shows Overall Score for 'Allen Myers' by default
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    Then I validate the Executive Driversafety console page is displayed correctly
    Then I verified Allen Myers text and overall score is displayed correctly

  @Regression
  Scenario: Verify export of the entire report via Export (menu) -> PDF (with Details)
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    Then I validate the Executive Driversafety console page is displayed correctly
    When I clicked Exporticon
    And I clicked ExportPDF
    Then I verified file has been exported correctly
    When I clicked Exporticon
    And I clicked ExportPDFdetails
    Then I verified file has been exported correctly
    Then I validated PDF has been exported corretly
    
    