#Author: Saravanakumar
@tag
Feature: Seperated Scorecard Report
  I want to use this template for my feature file

   #@Regression
  #Scenario: Individual Scorecard Seperated Groups - Verify Export of the Report as Data to Excel Using Dashlet Actions 
    #Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Foldericon and Driver Safety
    #And I clicked Scorecard Report - seperated groups
    #And I clicked Dashlet Actions on seperated groups
    #And I clicked Export As on seperated groups
    #And I clicked Data to Excel on seperated groups
    #Then Verify Export of the Report on seperated groups
    #
   #
 #@Regression
   #Scenario: Individual Scorecard Seperated Groups - Verify separated groups report opened shows the data for DOVER Group by default
   #	Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Foldericon and Driver Safety
    #And I clicked Scorecard Report - seperated groups
    #Then Verify separated groups report opened shows the data for DOVER Group by default
    
       #@Regression
#	Scenario: Individual Scorecard Seperated Groups - Verify that a new Notification is working ok
		#Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Foldericon and Driver Safety
    #And I clicked Scorecard Report - seperated groups
    #And I created a new notification center and ran it
    #Then I verified notification send successsfully
    	
   #	@Regression
#	Scenario: Individual Scorecard Seperated Groups - Verify that existing notification is working fine.
		#	Given I am logged into Application
    #Then I validate home page displayed correctly
    #And I clicked MySpaces & Dashboard
    #When I clicked Foldericon and Driver Safety
    #And I clicked Scorecard Report - seperated groups
    #And I open the Notification and ran an existing one
    #Then I delete an existing one
    
     @Regression
  Scenario: Individual Scorecard Seperated Groups - combined groups - Verify if 'Include Inactive Drivers' is set to yes then drivers with no scores data (for the selected report period) are shown at the end of the report
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Foldericon and Driver Safety
    And I clicked Scorecard Report - seperated groups
    And I checked Include Active Drivers as YES
    And I navigate to last page
    Then I verified  Include inactive Drivers are displayed 