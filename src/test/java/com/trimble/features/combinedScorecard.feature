#Author: Saravanakumar
@tag
Feature: Combined Scorecard Report
  I want to use this template for my feature file

   @Regression
  Scenario: Scorecard Report - combined groups - Verify Export of the Report as Data to Excel Using Dashlet Actions 
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Foldericon and Driver Safety
    And I clicked Scorecard Report - combined groups
    And I clicked Dashlet Actions on combined groups
    And I clicked Export As on combined groups
    And I clicked Data to Excel on combined groups
    Then Verify Export of the Report on combined groups
    
     @Regression
	Scenario: Scorecard Report - combined groups - Verify that a new Notification is working ok		
    And I created a new notification center and ran it
    Then I verified notification send successsfully
    	
   	@Regression
	Scenario: Scorecard Report - combined groups - Verify that existing notification is working fine.		    
    And I open the Notification and ran an existing one
    Then I delete an existing one
   
   @Regression
  Scenario: Scorecard Report - combined groups - Verify if Include Inactive Drivers is set to yes then drivers with no scores data (for the selected report period) are shown at the end of the report
    And I checked Include Active Drivers as YES
    And I navigate to last page
    Then I verified  Include inactive Drivers are displayed 
    
    
   @Regression
  Scenario: Scorecard Report - combined groups - Verify the Score values are color coded as per the filter values set for Driver Safety Lower & Target filters (in Driver Safety Scorecard Report Grid)
     And I set Driver safety lower & target filters  
     Then I verified score values are color coded as per the Filter values
    
   @Regression
  Scenario: Scorecard Report - combined groups - Verify that Scorecard report - combined groups report can be generated for a specific Org Unit & the data is shown correctly for that Org Unit for e.g. DUMP TRUCKS DE
    And I filtered the Org unit under the name DUMP TRUCKS DE  
    Then I verified DUMP TRUCKS DE data is displayed in the table
    
