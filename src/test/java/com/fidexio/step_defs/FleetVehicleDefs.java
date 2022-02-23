package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FleetVehicleDefs {
    FleetPage fleet = new FleetPage();

    @Given("User navigate to {string}")
    public void user_navigate_to(String string) {
        fleet.nav("Fleet");
    }

    @Given("User click {string} menu in FleetPage")
    public void user_click_menu_in_FleetPage(String string) {
        fleet.navInFleet(string);
        BrowserUtils.waitForPageToLoad(2);
    }

    @When("User click to create")
    public void user_click_to_create() {
        BrowserUtils.waitForPageToLoad(2);
        fleet.waitUntilLoaderScreenDisappear();
        fleet.createButtonVehicle.click();
        BrowserUtils.waitFor(2);
    }

    @When("User enter required info for Vehicle")
    public void user_enter_required_info_for_Vehicle() {
        BrowserUtils.waitForPageToLoad(2);
        fleet.carModelVehicle.click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//li[@class='ui-menu-item'][3]")).click();
        fleet.licensePlateVehicle.sendKeys("This is group4.");
    }

    @Then("User should be able to see new vehicle in list")
    public void user_should_be_able_to_see_new_vehicle_in_list() {
        fleet.navInFleet("Vehicles");
        BrowserUtils.waitForPageToLoad(3);

        List<WebElement> licenseList = Driver.get().findElements(By.xpath("//div[@class='oe_kanban_details']/strong/span[1]"));

        List<String> licenseListStr = BrowserUtils.getElementsText(licenseList);
        System.out.println(licenseListStr);
        BrowserUtils.waitFor(3);
        Assert.assertTrue("Verify that new car added.", licenseListStr.contains("This is group4."));

    }
    @When("user enters missing information required to create tool {string} {string}")
    public void user_enters_missing_information_required_to_create_tool(String carName, String license) {
        fleet.carModelVehicle.sendKeys(carName);
        fleet.licensePlateVehicle.sendKeys(license);
    }

}