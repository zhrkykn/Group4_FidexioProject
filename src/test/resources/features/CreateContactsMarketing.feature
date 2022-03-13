  @cp
  Feature: Sales manager creates contacs

    Background:
      Given the user is on the login page
      When Enter the user credentials
      Then user clicks on Email Marketing Button
      And user clicks on Contacts button

    @cp2
    Scenario: Sales Manager should be able to create Email marketing / Contacts
      And user switchs from list to kanban
      Then user clicks on Create button
      When user enters a name and click create button
      And user enters an email
      Then user clicks on Save Button

    @cp3
    Scenario: Sales Manager should be able to discard changes
      Then user clicks on Create button
      When user enters a name and click create button
      And user enters an email
      And user clicks on Discard button

    @cp4
    Scenario: Sales Manager should be able to edit and delete Contacts
      When user clicks on any contact
      Then user clicks on Edit button
      And user enters new name and create it
      Then user clicks on Save Button
      And clicks on Action button
      Then user clisk on Delete button

    @cp5
    Scenario: Sales Manager should NOT be able to create Email marketing / Contacts without Name
      Then user clicks on Create button
      When user enters a name and click create button
      Then user clicks on Save Button
      And user should be able to see warning message










