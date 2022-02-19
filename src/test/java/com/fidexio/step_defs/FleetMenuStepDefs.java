package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class FleetMenuStepDefs {

    FleetPage fleetPage=new FleetPage();



    @When("the user clicks to fleetPage")
    public void the_user_clicks_to_fleetPage() {

        fleetPage.clickFleet();
    }

    @Then("the side menu contains")
    public void the_side_menu_contains(List<String> fleetSideMenuExpected) {

        BrowserUtils.waitFor(2);

        //get the list of webelement and convert them to list of string and assert

        List<String> actualSideMenu = BrowserUtils.getElementsText(fleetPage.fleetSideMenuOptions);

      Assert.assertEquals(fleetSideMenuExpected,BrowserUtils.getElementsText(fleetPage.fleetSideMenuOptions));
        System.out.println("Expected fleet side menu options = " + fleetSideMenuExpected);
        System.out.println("actual fleet side menu options = " + actualSideMenu);

    }

}