Background:
Given the user is on the login page
And Enter the user credentials
And User navigate to “Purchases”

Scenario: Verify that the user can create new Vendor Bill
When User click to Vendor Bills
And user click to create
Then user enter credential of BillNew
Then User click on Save Button

Scenario: Verify that the user can switch Kanban-List view
When User click to Vendor Bills
And user click to Kanban button
Then Kanban-List view should be displayed

Scenario: Verify that the user can discard changes
When User click to create
And user enter credential of BillNew
And User click on Discard button
Then warning message should be displayed
Then User click OK

Scenario: Verify that the user can edit Vendor Bill
When User click to create
And user add credential
And user click Save button
Then Warning message should be displayed
Then user click Create and Edit button
Then User click Save button

Scenario: Verify that the user can delete Vendor Bill
When User is on Vendor Bills Page
And user choose existing vendor
And user click to action button
Then confirmation message should be display
Then user click OK button