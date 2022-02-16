package com.fidexio.step_defs;

import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.filefilter.ConditionalFileFilter;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage=new LoginPage();
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
       String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("Enter the user credentials")
    public void enter_the_user_credentials() {
        loginPage.login(ConfigurationReader.get("store_manager_username"),ConfigurationReader.get("store_manager_password"));
    }

    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
       String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Odoo",actualTitle);
    }

}
