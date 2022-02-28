package com.fidexio.step_defs;


import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.service.DriverCommandExecutor;


public class LoginStepDefs {

    LoginPage loginPage=new LoginPage();
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
       String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("Enter the user credentials")
    public void enter_the_user_credentials() {

        loginPage.validLogin();

    }

    @Then("User should be able to login")
    public void user_should_be_able_to_login() {

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Odoo",actualTitle);


    }
    @When("the user enters invalid user information {string} {string}")
    public void the_user_enters_invalid_user_information(String user, String pass) {
        loginPage.login(user,pass);
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {



        String actualErrorMessage = "Wrong login/password";
        Assert.assertEquals(loginPage.errorMessage.getText(),actualErrorMessage);
    }

    @When("the user enters blank user information {string} {string}")
    public void the_user_enters_blank_user_information(String userName,String passWord) {

      loginPage.login(userName,passWord);
    }

    @Then("alert message should be displayed for username")
    public void alert_message_should_be_displayed_for_username() {
        loginPage.validationMessage();

    }

    @Then("alert message should be displayed for password")
    public void alert_message_should_be_displayed_for_password() {
        loginPage.validationMessage();

    }



}
