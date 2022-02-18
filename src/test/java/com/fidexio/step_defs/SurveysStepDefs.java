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
    @When("the  user clicks on the  {string} module")
    public void the_user_clicks_on_the_module(String SurveysModule) {

    }

    @When("the user clicks on the {string}")
    public void the_user_clicks_on_the(String button) {

    }




    @Then("the user navigates to  {string}")
    public void the_user_navigates_to(String expectedUrl) {

    }
}
