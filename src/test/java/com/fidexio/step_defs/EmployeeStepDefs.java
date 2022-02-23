package com.fidexio.step_defs;

import com.fidexio.pages.EmployeePage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class EmployeeStepDefs {
    EmployeePage employeePage= new EmployeePage();

    @When("User should go to Employee page")
    public void user_should_go_to_Employee_page() {

        BrowserUtils.waitFor(3);
        employeePage.clickEmployees();
        BrowserUtils.waitFor(3);
    }
    @When("Click on create button")
    public void click_on_create_button() {
      employeePage.clickCreate();
        BrowserUtils.waitFor(3);
    }

    @When("Click on import button")
    public void click_on_import_button() {
       employeePage.clickImport();
        BrowserUtils.waitFor(3);
    }

    @Then("User should see {string} title")
    public void user_should_see_title(String expectedTitle) {

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        BrowserUtils.waitFor(2);
    }

    @When("Click on follow button")
    public void click_on_follow_button() {
        employeePage.clickFollow();
        BrowserUtils.waitFor(5);

    }
    @Then("User should see {string} information")
    public void user_should_see_information(String expectedText) {
        String actualText= employeePage.FollowingInfo();
        BrowserUtils.waitFor(5);
        Assert.assertEquals(actualText,expectedText);

    }

    @When("User enter a Employee Name")
    public void user_enter_a_Employee_Name() {
        employeePage.enterName();
        BrowserUtils.waitFor(2);
    }

    @Then("User click on Save Button")
    public void user_click_on_Save_Button() {
    employeePage.saveButton.click();
    //employeePage.clickSave();
        BrowserUtils.waitFor(2);
    }
    @Then("User should see {string} message")
    public void user_should_see_message(String expectedText) {
        String actualText= employeePage.MessageCreated();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(actualText,expectedText);
        BrowserUtils.waitFor(2);

    }

    @When("User search for {string} and see the name")
    public void user_search_for_and_see_the_name(String ExpectedEmployee) {

        String ActualEmployee= employeePage.newEmployee.getText();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(ExpectedEmployee, ActualEmployee);
        BrowserUtils.waitFor(2);
    }








}
