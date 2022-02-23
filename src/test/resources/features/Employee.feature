@nkd
  Feature: User create a new Employee

    Background:Login as a user with valid credentials
      Given the user is on the login page
      Then Enter the user credentials
      Then User should be able to login
      When User should go to Employee page

    Scenario: Create button work as expected

      When Click on create button
      Then User should see "New - Odoo" title

    Scenario: Import button work as expected

      When Click on import button
      Then User should see "Import a File - Odoo" title


    Scenario: Follow button work as expected

      When Click on follow button
      Then User should see "Following" information

    Scenario: "Employee Created" message should be seen

      When Click on create button
      And User enter a Employee Name
      Then User click on Save Button
      Then User should see "Employee created" message

    Scenario:  User should see new Employee on the page
      When User search for "Rachael Taylor" and see the name


