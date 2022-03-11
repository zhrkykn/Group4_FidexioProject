@FIDE-733
Feature: Expense Report Summary

  Background:
    Given The user logged in as a "expenses manager"
    When The user clicks on the Expenses from modules

  @FIDE-730
  Scenario:  Verify that the Expense Manager is able to create Expenses Report Summary by selecting "Create" option for each Employee.
    When The user clicks on the Summary Report to Approve button
    When The user creates an expense report before list
    When The user clicks on the Expense Report button
    When The user clicks on the Create button
    And The user enters the summary
    Then The user clicks on the employee input
    Then The user selects an employee from dropdown
    And The user clicks on the Save button
    And The user clicks on the Summary Report to Approve button
    Then The user creates an expense report after list
    Then Verify that the after list's size is one more before list's size
    And The user removes the first element of after list
    Then Verify that two lists' elements are exactly same
    Then The user deletes the created report


  @FIDE-731
  Scenario: Verify that the "The following fields are invalid  * field name " error message is displayed when mandatory field left blank
    When The user clicks on the Expense Report button
    When The user clicks on the Create button
    Then The user clicks on the employee input
    Then The user selects an employee from dropdown
    And The user clicks on the Save button
    Then Verify that the "The following fields are invalid:" "Expense Report Summary" error message is displayed
    When The user clicks on the Discard button
    When The user clicks on the Okay button
    When The user clicks on the Create button
    And The user enters the summary
    And The user clicks on the Save button
    Then Verify that the "The following fields are invalid:" "Employee" error message is displayed

  @FIDE-732
  Scenario: Verify that the "You cannot add expense lines of another employee" error message is displayed when selecting expenses of another employee when approving an expense on Expenses to Approve page.
    When The user clicks on the Expense Report button
    When The user clicks on the Create button
    And The user enters the summary
    Then The user clicks on the employee input
    Then The user selects an employee from dropdown
    And The user holds the selected employee name
    Then The user clicks on the selected employee name
    And The user clicks on the Add Item Expense
    And The user clicks on the list of an unmatched employee name
    And The user clicks on the Save button
    Then Verify that the "You cannot add expense lines of another employee." error message should be displayed
