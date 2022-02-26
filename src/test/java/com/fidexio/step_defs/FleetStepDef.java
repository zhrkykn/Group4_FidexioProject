package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FleetStepDef {
    FleetPage fleetPage = new FleetPage();
    @When("the user clicks on fleet link")
    public void the_user_clicks_on_fleet_link() {
        fleetPage.clickFleet();
    }


    @Then("the user clicks on Vehicles Fuel Logs")
    public void the_user_clicks_on(){
        new FleetPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        fleetPage.vehicleFuelLog.click();
    }


    @And("the user clicks on create button for vehicle")
    public void theUserClicksOnCreateButton() {
        new FleetPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        fleetPage.setCreateButton();
        BrowserUtils.waitFor(2);
    }

    @Then("the user clicks on vehicle dropdown")
    public void the_user_clicks_on_vehicle_dropdown() {
        new FleetPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        fleetPage.dropdownVehicle.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the user chooses any car")
    public void the_user_chooses_any_car() {
        new FleetPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        fleetPage.vehicle.click();
    }

    @Then("the user fills out liters")
    public void the_user_fills_out_liters() {
        new FleetPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        fleetPage.liter.clear();
        fleetPage.liter.sendKeys("150");
    }

    @Then("the user fills out price per liter")
    public void the_user_fills_out_price_per_liter() {
        new FleetPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        fleetPage.pricePerLiter.clear();
        fleetPage.pricePerLiter.sendKeys("1.5");
    }

    @Then("the user fills out odometer value")
    public void the_user_fills_out_odometer_value() {
        new FleetPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        fleetPage.odometer.clear();
        fleetPage.odometer.sendKeys("200");
    }

    @Then("the user clicks on save button")
    public void the_user_clicks_on_save_button() {
        new FleetPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        fleetPage.saveButton.click();
        BrowserUtils.waitFor(1);
    }


    @And("the user is able to see warning message")
    public void theUserIsAbleToSeeWarningMessage() {
        new FleetPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        fleetPage.warningMessage.isDisplayed();
    }
}
