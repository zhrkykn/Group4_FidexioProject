package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FleetVehicleDefs {
    FleetPage fleet = new FleetPage();
    Faker faker = new Faker();
    String fakeString;

    @Given("User navigate to {string}")
    public void user_navigate_to(String string) {
        fleet.waitUntilLoaderScreenDisappear();
        fleet.nav(string);
    }

    @When("User enter required info for Vehicle")
    public void user_enter_required_info_for_Vehicle() {
        fleet.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(2);
        fleet.carModelVehicle.click();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//li[@class='ui-menu-item'][3]")).click();
        fakeString = faker.pokemon().name();
        System.out.println("fakeString = " + fakeString);
        fleet.licensePlateVehicle.sendKeys(fakeString);
    }

    @Then("User should be able to see new vehicle in list")
    public void user_should_be_able_to_see_new_vehicle_in_list() {
        fleet.navInFleet("Vehicles");
        BrowserUtils.waitForPageToLoad(3);
        List<WebElement> licenseList = Driver.get().findElements(By.xpath("//div[@class='oe_kanban_details']/strong/span[1]"));
        List<String> licenseListStr = BrowserUtils.getElementsText(licenseList);
        BrowserUtils.waitFor(2);
        Assert.assertTrue("Verify that new car added.", licenseListStr.contains("This is group4."));


    }
    @When("user enters missing information required to create tool {string} {string}")
    public void user_enters_missing_information_required_to_create_tool(String carName, String license) {
        fleet.carModelVehicle.sendKeys(carName);
        fleet.licensePlateVehicle.sendKeys(license);
    }

}