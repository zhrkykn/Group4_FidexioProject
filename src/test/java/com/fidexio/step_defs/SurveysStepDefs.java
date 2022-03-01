package com.fidexio.step_defs;

import com.fidexio.pages.LoginPage;
import com.fidexio.pages.SurveysPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Objects;

public class SurveysStepDefs {

    SurveysPage surveysPage = new SurveysPage();


    @Given("the user is logged in as posmanager")
    public void the_user_is_logged_in_as_posmanager() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.validLogin();


    }

    @When("the  user clicks on the  Surveys module")
    public void the_user_clicks_on_the_Surveys_module() {

        surveysPage.surveysMenu.click();
        surveysPage.waitUntilLoaderScreenDisappear();


    }




    @When("the user clicks on create button")
    public void the_user_clicks_on_create_button() {
    surveysPage.clickCreate();

    }

    @When("the user enters survey title as {string}")
    public void the_user_enters_survey_title_as(String title) {
        BrowserUtils.waitFor(5);
       surveysPage.surveyTitleBox.sendKeys(title);

    }

    @And("the user clicks on Save Button")
    public void the_user_clicks_on_Save_Button() {

        surveysPage.clickSave();
    }

    @Then("the user should see {string} message")
    public void the_user_should_see_message(String expectedMessage) {
        Assert.assertEquals(surveysPage.surveyCreated(),expectedMessage);
        BrowserUtils.waitFor(2);


    }

    @Then("the user should see error message")
    public void the_user_should_see_error_message() {

        String expectedMessage="The following fields are invalid:\n" +
                "Title";
        String actualMessage= surveysPage.surveyError.getText();

        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Then("the user should be able to see created survey is listed")
    public void the_user_should_be_able_to_see_created_survey_is_listed() {
    surveysPage.surveyListed();
    }


    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonType) {
        surveysPage.waitUntilLoaderScreenDisappear();
        surveysPage.clickOnButton(buttonType);

    }

    @Then("the user  sees the  title {string}")
    public void theUserSeesTheTitle(String expectedTitle) {
        surveysPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }





    }







