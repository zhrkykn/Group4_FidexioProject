package com.fidexio.step_defs;

import com.fidexio.pages.LoginPage;
import com.fidexio.pages.SurveysPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SurveysStepDefs {

    SurveysPage surveysPage= new SurveysPage();

    @Given("the user is logged in as posmanager")
    public void the_user_is_logged_in_as_posmanager() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        LoginPage loginPage= new LoginPage();
        loginPage.validLogin();





    }

    @When("the  user clicks on the  Surveys module")
    public void the_user_clicks_on_the_Surveys_module() {
        surveysPage.waitUntilLoaderScreenDisappear();
        surveysPage.surveysMenu.click();
        BrowserUtils.waitFor(3);


    }

    @When("the user clicks on the {string}")
    public void the_user_clicks_on_the(String buttonType) {

        surveysPage.clickOnButton(buttonType);


    }

    @Then("the user   navigates to {string}")
    public void the_user_navigates_to(String expectedPage) {

    }



}
