package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import io.cucumber.java.en.*;

public class VehicleServicesLogsdef {
    FleetPage page=new FleetPage();

    @Given("User on the new vehicle services logs under the fleet page")
    public void user_on_the_new_vehicle_services_logs_under_the_fleet_page() {
        page.nav("fleet");
        page.vehicleServicesLogs.click();

    }

    @When("click the create button")
    public void click_the_create_button() {
        page.createButton.click();

    }

    @When("enter the vehicle services logs information")
    public void enter_the_vehicle_services_logs_information() {
      page.vehicleType.sendKeys("Audi/A1/1-AUD-001");
      page.serviceType.sendKeys("Snow tires");
      page.purchaserName.sendKeys("This is a test message");
    }

    @When("the user click the save button")
    public void the_user_click_the_save_button() {
      page.saveButton.click();

    }

    @Then("user should be able to create a new vehicle services logs")
    public void user_should_be_able_to_create_a_new_vehicle_services_logs() {
      page.vehicleServicesLogs.click();

    }

    @When("enters credential {string} {string}")
    public void enters_credential(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("error message should be displayed on the screen")
    public void error_message_should_be_displayed_on_the_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
