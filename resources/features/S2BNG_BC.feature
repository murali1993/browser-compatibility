@s2bng 
Feature: Verify s2bng features for browser compatibility 

@dashboard @bc @mandate @done
Scenario: Verify user able to customize the dashboard
	Given user successfully login as "s2bUser" to the S2BNG application
	And user navigate to manage dashboard menu
	When user drag and drop the "quick payment" widget
	Then verify user able to view dashboard with "quick payment" widget
	
 
@messages @bc 
Scenario: Verify the tooltip when Hover on Messages 
	Given user successfully login as "s2bUser" to the S2BNG application
	When user click on messages icon in the home page
	Then user navigate to S2B Messages Screen 
	When user filter with dates
	Then  user should see messages for applied filters
	When user clicks on a message
	Then verify selected message is displayed in the right pane 
	And verify message count is reduced by 1 
	
@fundTransfer @bc @mandate
Scenario: Verify user can Search the pay From and Payee with a minimum search character of three and Add Invoice 

	Given user successfully login as "s2bUser" to the S2BNG application 
	And user click on fund transfer option from cash create menu
	When user search with minimum of three letters in payee textbox
	Then user should see the suggestion box
	When user select the payee from PayTo search box
	Then user verify Invoice detail section is displayed
	And user able to select option from Invoice Type dropdown
	And user click on Add Invoice button
	Then user should see Add Invoice Records overlay
    And user save the invoice records 
	Then user should see the added details in the invoice details section 
	
	
@OADreport @bc @mandate @done
Scenario: Verify the column drag and drop, column edit and run the report for editable Operating Account Details report
    Given user successfully login as "s2bCol1User" to the S2BNG application
    When user navigates to S2B reports Screen
    And user able to add new column by drag and drop
    And user able to edit the column name
    And user able to save the report
    Then verify user able to run the report
    And verify column name is updated in the report
    And verify new column is added in the report
	
@OASreport @bc
Scenario: verify the column drag and drop, column edit and run the report for editable Operating Account Settlement report 
	Given user successfully login as "s2bUser" to the S2BNG application
	When user clicks S2B Menu Button 
	When user navigates to S2B reports Screen 
	When user able to add new column by Drag and Drop 
	When user able to edit the specified column name 
	When user able to save the edited report 
	Then verify user able to run the edited report 
	Then verify new column is added to the report 
	Then verify modified column name is updated in the report 
	
		
@downloadreport @bc 
Scenario: Verify user able to download the Operating Account Statement Report 
	Given user successfully login as "s2bUser" to the S2BNG application 
	And user navigates to Myreports by selecting cash view report option
	Then verify user landed on to the Myreports screen 
	And verify user able to download the Operating Account Statement Report 
	
@transactionlist @bc @mandate
Scenario: verify payments transaction list Page 
	Given user successfully login as "s2bColUser" to the S2BNG application
	And user navigates to payments transaction screen 
	Then verify user is able to click payment reference to navigate to payment summary 
	And verify user able to navigate between pages 		
	And verify user is able to apply filter conditions 	
	And verify user is able to sort transaction list 
	When the user multiselects the transaction 
	Then verify user should view actions and show selected tab
    And verify the appropriate amount has been added 	 
	And verify user is able to traverse between columns
    And verify user is able to click the vertical dots to view the menu 
	And verify user should be able to export transaction list 
	And verify user is able to customize the transaction list in settings option using drag and drop feature 
	And verify user should able to view the newly added column
	And verify user should able to reset the added column
	                                                        
@collections @bc @mandate @done
Scenario: verify transaction list in collections
   Given user successfully login as "s2bColUser" to the S2BNG application
    Then user should see Direct Debit Instructions under collection menu
    And user navigates to DDI screen on clicking DDI menu
    When user selects credit Account
    And user click on Add Direct Debit button
    Then user navigates to Add Direct Debit Batch Screen
    And user picks date from calendar after navigating to and fro
    When user inputs mandatory fields with direct debit purpose selected
    Then user saves the batch by clicking on save button
    And user should view the entered details with submit button
    And user land on to the confirmation screen with batch reference number
    When user clicks on the created batch reference number
    Then user verify newly added batch is displayed in the batch list
    And user click on the down arrow of the added transaction
    Then user should see the added debit purpose in the additional information section
	

@downloadreportingMsg @bc @done
Scenario: verify download of message attachments greater than 2mb
Given user successfully login as "s2bUser" to the S2BNG application
When user click on messages icon in the home page
Then user navigate to S2B Messages Screen 
And user selects reporting category from the left pane 
Then user should able to download message attachment greater than 2MB

	
    