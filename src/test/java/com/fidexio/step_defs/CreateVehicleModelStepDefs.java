package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CreateVehicleModelStepDefs {

    FleetPage fleetPage=new FleetPage();
    String makeName;


    @When("user click the Fleet menu")
    public void user_click_the_Fleet_menu() {
        fleetPage.nav("Fleet","Vehicles Contracts");
    }

    @When("click Vehicle Model menu")
    public void click_Vehicle_Model_menu() {
        fleetPage.vehicle_Model_Menu.click();
        BrowserUtils.waitFor(5);
    }
    @When("click Create button in vehicle model menu")
    public void click_Create_button() {
         fleetPage.vehMod_CreateButton.click();
        BrowserUtils.waitFor(5);
    }


    @When("write Model name to input {string}")
    public void write_Model_name_to_input(String modelName) {
        fleetPage.modelName_Input.sendKeys(modelName);
        BrowserUtils.waitFor(5);

    }
    @When("Click make type dropdown menu")
    public void click_make_type_dropdown_menu() {
        fleetPage.vehMod_MakeDropdown.click();
    }



    @When("Choose {string} for make type on dropdown menu")
    public void choose_for_make_type_on_dropdown_menu(String makeType) {
        fleetPage.vehMod_dropdownMeth(makeType).click();
        makeName=makeType;
    }


    @When("Click Save button in the vehicle model menu")
    public void click_Save_button_in_the_vehicle_model_menu() {
        fleetPage.vehMod_SaveButton.click();
        BrowserUtils.waitFor(1);
    }


    @Then("verify that vehicle model created")
    public void verify_that_vehicle_model_created() {
        String modelName=fleetPage.dynamicModelName.getText();
        String expectedTitle=makeName+"/"+modelName+" - Odoo";
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }


    @Then("verify that -The following fields are invalid: Model name- alert display")
    public void verify_that_The_following_fields_are_invalid_Model_name_alert_display() {

        String actualError = fleetPage.odoError2.getText();
        String expectedError = "The following fields are invalid:\n" +
                "Model name";

        Assert.assertEquals(expectedError,actualError);
    }



    @Then("verify that -The following fields are invalid: Make- alert display")
    public void verify_that_The_following_fields_are_invalid_Make_alert_display() {
        String actualError = fleetPage.odoError2.getText();
        String expectedError = "The following fields are invalid:\n" +
                "Make";

        Assert.assertEquals(expectedError,actualError);
    }



    @Then("verify that -The following fields are invalid: Model name Make- alert display")
    public void verify_that_The_following_fields_are_invalid_Model_name_Make_alert_display() {
        String actualError = fleetPage.odoError2.getText();
        String expectedError = "The following fields are invalid:\n" +
                "Model name\n"+
                "Make";

        Assert.assertEquals(expectedError,actualError);
    }


}

