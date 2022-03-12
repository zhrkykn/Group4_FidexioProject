Feature: POS Manager should be able to create new Repair Orders
  #Verify that the user can create new Repair Order
  #Verify that the user can switch Kanban-List view
  #Verify that the user can discard changes
 #Verify that the user can edit Repair Order
  #Verify that the user can delete Repair Order
  Background:
    Given the user is logged in as posmanager
    When the  user clicks on the  "Repairs"


  Scenario: verify that "Create" button work as expected in the repairs page
    When user clicks on the "Create" button
    And Fill the  new repair orders form
    And user clicks on the "Save" button
    Then user able to see the created message


  Scenario: Verify that Kanban button works as expected

    When user clicks on the "Kanban" button
    Then verify that it switched to "Kanban" view

  Scenario: Verify that List button works as expected

    When user clicks on the "List" button
    Then verify that it switched to "List" view


    Scenario: Verify that the user can discard changes
      Then the user clicks on the "Create" button
      And Fill the  new repair orders form
      And user clicks on the "Discard" button
      And user clicks on the "ok" button
      And The user should be able to see list not changed


      Scenario:Verify that the user can edit Repair Order
        When user choose any item
        And user clicks on the "Edit" button
        And Fill the  new repair orders form
        And user clicks on the "Save" button
        And the  user clicks on the  "Repairs"
        Then  verify  edited


  Scenario: Verify that the user can delete Repair orders
    Then user choose any item
    And user opens Actions dropdown and clicks Delete
    And user clicks on the "Ok" button
    And The user should be able to see list decreased








