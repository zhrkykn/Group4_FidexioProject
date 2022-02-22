package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class CreateVehicleModelStepDefs {

    FleetPage fleetPage=new FleetPage();

    @When("user click the Fleet menu")
    public void user_click_the_Fleet_menu() {
        fleetPage.clickFleet2();
    }

    @When("click Vehicle Model menu")
    public void click_Vehicle_Model_menu() {
        fleetPage.vehicle_Model_Menu.click();
        BrowserUtils.waitFor(5);
    }
    @When("click Create button")
    public void click_Create_button() {
         fleetPage.vehMod_CreateButton.click();
        BrowserUtils.waitFor(5);
    }

    @When("write Model name")
    public void write_Model_name() {
        fleetPage.modelName_Input.sendKeys("some");

        BrowserUtils.waitFor(5);
    }
}

