Feature: Point Of Sale Configuration

  Background: Login as a user with valid credentials
    Given the user is on the login page
    Then Enter the user credentials
    Then User should be able to login
    When User should go to PointOfSale page and click PointOfSale sideMenu
@FIDE-745
  Scenario: User should be able to create new Point Of Sale
    Then User click on "Create" button
    And User enter "A name" for Point of Sale
    And User choose Operation Type
    Then User click on "Save" button
    Then Page title should contain "A name"
@FIDE-746
  Scenario: User should be able to switch Kanban-List view
    When User click on "Kanban" button
    Then User should verify that page link includes Kanban
@FIDE-747
  Scenario: User should be able to discard changes
    When User click on "one of the PointOfSale" button
    Then User get the name of the Point of Sale
    Then User click on "Edit" button
    Then User enter "A name" for Point of Sale
    And  User click on "Discard" button
    Then User click on "pop-up OK" button
    Then Name of the PointOfSale should not be changed
@FIDE-748
  Scenario: User should be able to edit Point of Sale
    When User click on "one of the PointOfSale" button
    Then User get the name of the Point of Sale
    Then User click on "Edit" button
    Then User enter "A name" for Point of Sale
    And  User click on "Save" button
    Then Name of the PointOfSale should be changed
@FIDE-749
  Scenario: User should not be able to delete Point of Sale
    When User click on "one of the PointOfSale" button
    Then User click on Delete under Actions dropdown button
    Then User click on "pop-up OK" button
    Then User should see the message
