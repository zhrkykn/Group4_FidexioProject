package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class FleetMenuStepDefs {

    FleetPage fleetPage=new FleetPage();

    @Given("The user should be logged in with valid credentials")
    public void theUserShouldBeLoggedInWithValidCredentials() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }

    @When("the user clicks to fleetPage")
    public void the_user_clicks_to_fleetPage() {

        fleetPage.nav("Fleet","Vehicles Odometer");
    }

    @Then("the side menu contains")
    public void the_side_menu_contains(List<String> fleetSideMenuExpected) {

        BrowserUtils.waitFor(2);

        //get the list of webelement and convert them to list of string and assert

        List<String> actualSideMenu = BrowserUtils.getElementsText(fleetPage.fleetSideMenuOptions);

      Assert.assertEquals(fleetSideMenuExpected,actualSideMenu);
        System.out.println("Expected fleet side menu options = " + fleetSideMenuExpected);
        System.out.println("actual fleet side menu options = " + actualSideMenu);

    }

}