package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class CreateVehicleModelStepDefs {

    FleetPage fleetPage=new FleetPage();

    @When("user click the Fleet menu")
    public void user_click_the_Fleet_menu() {
        fleetPage.clickFleet();
    }
    @When("click Vehicle Model menu")
    public void click_Vehicle_Model_menu() {
        fleetPage.vehicle_Model.click();
        BrowserUtils.waitFor(5);
    }
}

