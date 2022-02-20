package com.fidexio.step_defs;

import com.fidexio.pages.DashboarPage;
import com.fidexio.pages.FleetPage;
import com.fidexio.pages.Test;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.*;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogOutDefs {
    DashboarPage dash = new DashboarPage();
    @When("the user logged out")
    public void the_user_logged_out() {

        dash.logOut();
        BrowserUtils.waitFor(2);
    }
    @Then("user should be logged out of account")
    public void user_should_be_logged_out_of_account() {

        String expectedURL = "https://qa.fidexio.com/web/login";
        Assert.assertEquals("Verify that user is logged out", expectedURL, Driver.get().getCurrentUrl());
        BrowserUtils.waitFor(2);
    }
    @When("try to back after successfully logged out")
    public void try_to_back_after_successfully_logged_out() {
        Driver.get().navigate().back();

    }

    @Then("user should see warning mesage")
    public void user_should_see_warning_mesage() {
        Assert.assertTrue(Driver.get().findElement(By.cssSelector(".o_dialog_warning")).isDisplayed());
        BrowserUtils.waitFor(2);
    }



}
