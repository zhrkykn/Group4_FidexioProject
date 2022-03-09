@FIDE-733
Feature: Expense Report Summary

  Background:
    Given the user logged in as a "expenses manager"
    When The user navigates to Expenses Report

  @FIDE-730
  Scenario:  Verify that the Expense Manager is able to create Expenses Report Summary by selecting "Create" option for each Employee.
    When The user enters summary details
    Then The expense report summary should be created

  @FIDE-731
  Scenario: Verify that the "The following fields are invalid  * field name " error message is displayed when mandatory field left blank
    When The user enters summary details with a blank summary
    Then The "The following fields are invalid:" "Expense Report Summary" error message should be displayed
    When The user enters summary details with a blank employee
    Then The "The following fields are invalid:" "Employee" error message should be displayed

  @FIDE-732
  Scenario: Verify that the "You cannot add expense lines of another employee" error message is displayed when selecting expenses of another employee when approving an expense on Expenses to Approve page.
    When The user enters summary details
    And The user adds an expense line with an employee name unmatched
    Then The "You cannot add expense lines of another employee." error message should be displayed
