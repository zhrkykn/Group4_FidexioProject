package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FleetContractStepDefs {
    FleetPage fleetPage = new FleetPage();

    @Then("user navigate to Vehicles Contracts")
    public void user_navigate_to_Vehicles_Contracts() {
        fleetPage.vehicleContractMenu.click();
        BrowserUtils.waitFor(5);


    }

    @When("user click to vehicle dropdown in vehicle contract menu")
    public void user_click_to_vehicle_dropdown_in_vehicle_contract_menu() {
        fleetPage.vehicleContractDropdown.click();
        BrowserUtils.waitFor(5);

    }


    @When("user select Audi option in vehicle dropdown")
    public void user_select_Audi_option_in_vehicle_dropdown() {
        fleetPage.vehicleAudiOption.click();
        BrowserUtils.waitFor(5);

    }


    @When("user click on Save Button")
    public void userClickOnContractSaveButton() {
        fleetPage.savedButton.click();

        //System.out.println(new FleetPage().warningsMessage.getAttribute("validationMessage"));



        WebElement element = new FleetPage().getWarningMessage;

        //WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        //wait.until(ExpectedConditions.visibilityOf(element));

        BrowserUtils.waitForVisibility(element,5);

        System.out.println(element.getText());
        System.out.println(element.getAttribute("value"));

        System.out.println(element.getAttribute("validationMessage"));


    }




}
