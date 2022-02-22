@wip
Feature: As a Posmanager, I should be able to create and design a new survey from "Surveys" module

  Background:
    Given the user is logged in as posmanager
    When the  user clicks on the  Surveys module

  Scenario Outline: verify that "<buttonType>" button work as expected in the survey design page


    When the user clicks on the "<buttonType>"
    Then the user   navigates to "<expectedPage>"

    Examples:

      | buttonType | expectedPage  |
      | Create | createPage     |
      | Kanban | kanbanViewPage |
      | List   | listViewPage   |
      | Import | loadFilePage  |

    Scenario:Verify that the "Survey created" message appears

      When the user clicks on create button
      And the user enters  a "Survey Title"
      And the user clicks on Save Button
      Then the user should see "Survey created" message



