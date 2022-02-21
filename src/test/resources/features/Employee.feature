
  Feature: User create a new Employee

    Background:Login as a user with valid credentials
      Given  the user is on the login page
      When Enter the user credentials
      Then User should be able to login

    Scenario: Create button work as expected
      Given User should go to Employee page
      When Click on "create" button
      Then User should see "NewEmployeePage" title

    Scenario: Import button work as expected
      Given User should go to Employee page
      When Click on "import" button
      Then User should see "ImportaFilePage" title

    Scenario: Follow button work as expected
      Given User should go to Employee page
      When Click on "follow" button
      Then User should see "Following" title

    Scenario: "Employee Created" message should be seen
      Given User should go to Employee page
      When User click on Create button
      And User enter a Employee Name
      Then User click on Save Button
      Then User should see Employee Created message

    Scenario:  User should see new Employee on the page
      Given
      When
      Then

