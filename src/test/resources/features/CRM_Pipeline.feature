Feature: Pos Manager should be able to create CRM/Pipeline
  Background:
    Given the user is on the login page
    And Enter the user credentials
    And the user navigates to "CRM" and "Pipeline"

Scenario: Verify that the user can create new Pipeline
   When user click on the create button
   And  enter the opportunity title
   And  user click the create button
   Then user verifies the pipeline has been created

Scenario:Verify that the user can switch Kanban-List view
  When user click on the kanban view
  Then user should be able to see kanban view
  When user click on list view
  Then user should be able to see list view

Scenario:Verify that the user can discard changes
  When user click the create button
  And user enter the opportunity title
  And user click on the Discard button
  Then  user verifies the opportunity title has not changed

Scenario:Verify that the user can edit Pipeline
  When user click on a random pipeline
  And  user click on the edit button
  And  user edits opportunity title
  And  user click on the save button
  Then user verifies the pipeline has been edited



