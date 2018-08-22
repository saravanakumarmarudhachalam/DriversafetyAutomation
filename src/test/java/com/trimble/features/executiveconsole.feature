#Author: Saravanakumar
@tag
Feature: Executive Console
  I want to use this template for my feature file

  #@Regression
  #Scenario: Exectiveconsole - Verify drivers are shown in ascending order of their Overall Score in Driver Ranking by Scores grid i.e. driver having lowest Overall Score is at the top
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #Then I validate the Executive Driversafety console page is displayed correctly
    #Then I verified overall score is displayed in ascending order
#
  #@Regression
  #Scenario: Exectiveconsole - Verify donut chart shows Overall Score for Allen Myers by default
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #Then I validate the Executive Driversafety console page is displayed correctly
    #Then I verified Allen Myers text and overall score is displayed correctly
#
  #@Regression
  #Scenario: Exectiveconsole - Verify export of the entire report via Export (menu) -> PDF (with Details)
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #Then I validate the Executive Driversafety console page is displayed correctly
    #When I clicked Exporticon
    #And I clicked ExportPDF
    #Then I verified file has been exported correctly
    #When I clicked Exporticon
    #And I clicked ExportPDFdetails
    #Then I verified file has been exported correctly
    #Then I validated PDF has been exported corretly - Not to use this method
    #
   #@Regression
  #Scenario: Exectiveconsole - Verify drivers are shown in descending order of their Overall Score in Driver Ranking by Scores grid i.e. driver having highest Overall Score is at the top
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #Then I validate the Executive Driversafety console page is displayed correctly
    #Then I verified all the sorting column are working correctly
#
     #@Regression
  #Scenario: Exectiveconsole - Verify all Score values are shown rounded i.e. without any decimals (applicable to Overall Score, Accel, Braking, Speeding, Turning columns)
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #Then I validate the Executive Driversafety console page is displayed correctly
    #Then I verified all the displayed without decimal point in the score grid
    #
   #@Regression
#	Scenario: Exectiveconsole - Verify Target/Trend line is shown correctly set as per the Driver Safety Target filter value (in Org Units/Groups dashlet)
#		Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Executive Driversafety console
    #Then I validate the Executive Driversafety console page is displayed correctly
    #Then I Verify Target is enabled in the Bar chart
    #When I clicked the Target
    #Then I verify Target is disabled in the bar chart
    
       @Regression
	Scenario: Exectiveconsole - Verify that a new Notification is working ok
		Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Executive Driversafety console
    Then I validate the Executive Driversafety console page is displayed correctly
   	And I created a new notification center and ran it
   	Then I verified notification send successsfully
   	
   	
   	
    
    
    