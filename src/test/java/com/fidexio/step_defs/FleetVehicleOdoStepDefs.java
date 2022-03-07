package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FleetVehicleOdoStepDefs {

    FleetPage fleetPage = new FleetPage();
    @Then("the user clicks to Vehicle Odometer")
    public void the_user_clicks_to_Vehicle_Odometer() {
        BrowserUtils.waitFor(2);
        fleetPage.vehiclesOdoButton.click();

    }

    @Then("Click on Create button")
    public void click_on_Create_button() {
        fleetPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        fleetPage.odoCreateButton.click();
    }

    @When("Choose the vehicle name")
    public void choose_the_vehicle_name() {
        BrowserUtils.waitForClickablility(fleetPage.vehicleOdoName,5);
        fleetPage.vehicleOdoName.click();
        BrowserUtils.waitFor(2);
        fleetPage.vehicleOdoSelect.click();
    }

    @Then("Enter odometer value")
    public void enter_odometer_value() {
        BrowserUtils.waitForVisibility(fleetPage.odoValue,5);
        fleetPage.odoValue.clear();
        fleetPage.odoValue.sendKeys("3000");
    }

    @Then("Enter date")
    public void enter_date() {
        BrowserUtils.waitFor(2);
        fleetPage.odoDate.clear();
        fleetPage.odoDate.sendKeys("02/22/2022");
    }

    @Then("Click on Save button")
    public void click_on_Save_button() {
        BrowserUtils.waitForClickablility(fleetPage.odoSaveButton,5);
        fleetPage.odoSaveButton.click();

    }

    @Then("Error message displayed")
    public void error_message_displayed() {
        /*
        String actualMessage ="The following fields are invalid:\n" +
                "Vehicle";
        String message = fleetPage.odoError2.getText();
        Assert.assertEquals(message,actualMessage);
        */
        String expect = "The following fields are invalid:";
        BrowserUtils.waitForVisibility(fleetPage.vehErr,5);
        String actual = fleetPage.vehErr.getText();
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Verify that error message",expect,actual);

    }

}
