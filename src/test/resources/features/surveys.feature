@wip
Feature: Buttons Functionality

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



