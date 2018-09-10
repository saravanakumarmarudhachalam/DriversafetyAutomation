Author: Saravanakumar
@tag
Feature: Supervisor Console Report
  I want to use this template for my feature file

  @Regression
Scenario: Supervisor console - Verify that a new Notification is working ok
		Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Foldericon and Driver Safety
    And I clicked Supervisor Console
    And I created a new notification center and ran it
    Then I verified notification send successsfully
    	
   	@Regression
		Scenario: Supervisor console - Verify that existing notification is working fine.		
    And I open the Notification and ran an existing one
    Then I delete an existing one
    
    @Regression
 		Scenario: Supervisor console - Verify drivers are shown in ascending order of their Overall Score in Driver Ranking by Scores grid i.e. driver having lowest Overall Score is at the top
    Then I verified overall score is displayed in ascending order in Supervisor Console
    
    @Regression
  	Scenario: Supervisor console - Verify drivers are shown in descending order of their Overall Score in Driver Ranking by Scores grid i.e. driver having highest Overall Score is at the top
    Then I verified all the sorting column are working correctly in Supervisor Console
      
    @Regression
    Scenario: Supervisor console - Verify export of the entire report via Export (menu) -> PDF (with Details)
    When I clicked Exporticon
    And I clicked ExportPDF
    Then I verified file has been exported correctly
    When I clicked Exporticon
   	And I clicked ExportPDFdetails
    Then I verified file has been exported correctly