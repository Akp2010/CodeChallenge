@tag
Feature: AutoTrader Basic Testing
  
  @Sanity1
  Scenario: Verify the presence of element types in AutoTrader home page
    Given I launch AutoTrade in Chrome Browser
    When I verify home page is displayed    
    Then I verify the following details
    |Browse by Make|
    |Browse by Style|
    |Advanced Search| 
    |Search |
    |Any Make|
    |Any Model|

	  @Sanity2
	  Scenario: Advanced Search on Make BMW
	  	Given I select Advanced Search from home page
	  	When I enter the following details	
	  	|ZipCode|30004|
	  	|Condition|Certified|
	  	|Style|Convertible|
	  	|From Year|2017|
	  	|To Year|2020|
	  	|Make|BMW|
	    Then I click Search button
	    
	   @Sanity3
	    Scenario: BMW Search results verification and count
	    Given I am in the Search Results page
	  	Then I verify only "BMW" cars are in the results
	   	And Log the total number of listings in the page
	  	
