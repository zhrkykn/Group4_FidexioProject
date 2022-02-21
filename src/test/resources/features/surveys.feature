@wip
Feature: Buttons Functionality

  Background:
    Given the user is logged in as posmanager
    When the  user clicks on the  Surveys module

  Scenario Outline: verify that all the buttons work as expected in the survey design page


    Then the user clicks on the "<button>" and  navigates to  "<expectedPage>"

    Examples:

      | button | expectedPage   |
      | Create | createPage     |
      | Kanban | kanbanViewPage |
      | List   | listViewPage   |
      | Import | loadFilePage  |



