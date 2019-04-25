Feature:  Login Action Test with SA flow
Description: This feature will test the Login and Logout Functionalty


Scenario Outline: Verify that user is able to login with a valid username and password 

	Given User is on XYZ generic Login page
	And Continue button is displayed
	When user enters "<IBD>" and "<username>" and "<password>"		
	And user clicks Continue button
	And Security Question message is displayed
	And user enters last word of the question
	And user selects No as the response
	And user clicks Continue button
	Then Logout link is displayed
	
	Examples: 
			|IBD|username |password|
			|511|vishadxat|Password0123|
			|3cr|vishadxat|Password01234|
