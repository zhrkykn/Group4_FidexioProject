
Feature: Expense Report Summary

  Background:
    Given the user logged in as a "expenses manager"

  Scenario:  Verify that the Expense Manager is able to create Expenses Report Summary by selecting "Create" option for each Employee.
    Then The user creates an Expenses Report Summary for each employee

  @expense
  Scenario: Verify that the "The following fields are invalid  * field name " error message is displayed when mandatory field left blank
    When The "The following fields are invalid:" "Expense Report Summary" error message is displayed when Expense Report Summary left blank
    Then The "The following fields are invalid:" "Employee" error message is displayed when Employee left blank


  Scenario: Verify that the "You cannot add expense lines of another employee" error message is displayed when selecting expenses of another employee when approving an expense on Expenses to Approve page.
    Then The "You cannot add expense lines of another employee." error message is displayed when selecting expenses of another employee when approving an expense on Expenses to Approve page.
