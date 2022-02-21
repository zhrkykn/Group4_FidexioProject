package com.fidexio.step_defs;

import com.fidexio.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SurveysStepDefs {

    @Given("the user is logged in as posmanager")
    public void the_user_is_logged_in_as_posmanager() {
        LoginPage loginPage= new LoginPage();
        loginPage.validLogin();

    }

    @When("the  user clicks on the  Surveys module")
    public void the_user_clicks_on_the_Surveys_module() {

    }

    @Then("the user clicks on the {string} and  navigates to  {string}")
    public void the_user_clicks_on_the_and_navigates_to(String string, String string2) {

    }



}
