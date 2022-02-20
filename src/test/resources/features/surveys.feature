@wip
Feature: Buttons Functionality

  Background:
    Given the user is logged in as posmanager
    When the  user clicks on the  "Surveys" module

  Scenario Outline: verify that all the buttons work as expected in the survey design page


    And the user clicks on the "<button>"
    Then the user navigates to  "<expectedUrl>"

    Examples:

      | button | expectedUrl                                                                 |
      | Create | https://qa.fidexio.com/web?#id=&view_type=form&model=survey.survey&action=641  |
      | Kanban | https://qa.fidexio.com/web?#view_type=kanban&model=survey.survey&action=641 |
      | List   | https://qa.fidexio.com/web?#view_type=list&model=survey.survey&action=641   |
      | Import | https://qa.fidexio.com/web?#model=survey.survey&action=import               |



