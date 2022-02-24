package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class vehicleCostsStepDefs {

    FleetPage fleetPage = new FleetPage();
    @Then("the user clicks to Vehicle Costs")
    public void the_user_clicks_to_Vehicle_Costs() {
        fleetPage.vehicleCostsMenu.click();
    }

    @Then("Click on Vehicle Costs Create button")
    public void click_on_Vehicle_Costs_Create_button() {
        fleetPage.vehicleCostsCreate.click();
    }

    @When("Choose the vehicle name in Vehicle Costs menu")
    public void choose_the_vehicle_name_in_Vehicle_Costs_menu() {
        fleetPage.vehicleCostsVehicleDropdown.click();
        fleetPage.vehicleCostsBmwSelect.click();

    }
    @Then("Choose the type in Vehicle Costs menu")
    public void choose_the_type_in_Vehicle_Costs_menu() {
        fleetPage.vehicleCostsTypeDropdown.click();
        fleetPage.vehicleCostsTaxSelect.click();
    }
    @Then("Enter date in Vehicle Costs menu")
    public void enter_date_in_Vehicle_Costs_menu() {
        fleetPage.vehicleCostsDate.clear();
        fleetPage.vehicleCostsDate.sendKeys("02/28/2022");
    }
    @Then("Enter total price in Vehicle Costs menu")
    public void enter_total_price_in_Vehicle_Costs_menu() {
       fleetPage.vehicleCostsTotalPrice.clear();
       fleetPage.vehicleCostsTotalPrice.sendKeys("10.000");
    }
    @Then("Click on Save button in Vehicle Costs menu")
    public void click_on_Save_button_in_Vehicle_Costs_menu() {
        fleetPage.vehicleCostsSave.click();
        BrowserUtils.waitFor(3);

    }
    @Then("the title should be Vehicle Costs")
    public void the_title_should_be_Vehicle_Costs() {
        String actualMessage = "Bmw/Serie 1/1-BMW-001 - Odoo";
        String message = Driver.get().getTitle();
        Assert.assertEquals(message,actualMessage);
        System.out.println("message = " + message);

    }

    @Then("Error message displayed in Vehicle Costs menu")
    public void error_message_displayed_in_Vehicle_Costs_menu() {
        String actualMessage = "The following fields are invalid:\n" +
                "Vehicle";
        String message = fleetPage.vehicleCostsErrorMessage.getText();
        System.out.println("message = " + message);
        Assert.assertEquals(message,actualMessage);

    }


}
