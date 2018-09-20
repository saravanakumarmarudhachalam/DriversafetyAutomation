#Author: Saravanakumar
@tag
Feature: Event Location Hotspot Map
  I want to use this template for my feature file

  @Regression
  Scenario: Event Location Hotspot Map - Verify the dashboard is set to display data for 'Last 30 Days' by default OR the Date Period filter settings from Most Dangerous Locations are maintained
    Given I am logged into Application
    Then I validate home page displayed correctly
    And I clicked MySpaces & Dashboard
    When I clicked Foldericon and Driver Safety Events
    And I clicked Event Location Hotspot Map
    Then I verified Last 30 days is displayed in Date filter in Event Location Hotspot Map

  @Regression
  Scenario: Event Location Hotspot Map - Verify Map dashlet shows Driver event(s) located at the correct Lat/Long values specified in the filter
    Then I verified Map dashlet Icon is displayed in the Event Location Hotspot Map

  @Regression
  Scenario: Event Location Hotspot Map - Verify that Event Location Hotspot Map report shows the filtered Lat/Long location with the drivers (at this location) having highest number of Total Events at the top
    Then I verified the filtered Lat/Long location with the drivers having highest number of Total Events at the top

  @Regression
  Scenario: Event Location Hotspot Map - Verify the grid values change appropriately as per Date Period filter set for the dashboard
    Then I changed the time period to last month in the Event Location Hotspot Map
    
  @Regression
  Scenario: Event Location Hotspot Map - Verify sorting based on any column (in the grid section) works correctly
    Then I verified all the sorting column are working correctly
    
  @Regression
  Scenario: Event Location Hotspot Map - Verify export of the entire report via Export (menu) -> PDF (with Details)
    When I clicked Exporticon
    And I clicked ExportPDF
    Then I verified file has been exported correctly
    When I clicked Exporticon
    And I clicked ExportPDFdetails
    Then I verified file has been exported correctly

  @Regression
  Scenario: Event Location Hotspot Map - Verify that when you click on a driver to drill down to 'Driver Events By Location' report then Date Period filter settings are maintained
    Then I click the driver opens the Driver Events By Location report with Date Period filter settings are maintained
