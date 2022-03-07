package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.pages.Sales_CustomersPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.core.internal.gherkin.ast.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class Sales_Customers_StepDefs {

    Sales_CustomersPage salesCustomersPage = new Sales_CustomersPage();
    FleetPage fleetPage = new FleetPage();


    @Given("sales manager should be logged in")
    public void sales_manager_should_be_logged_in() {

        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login(ConfigurationReader.get("salesManager"), ConfigurationReader.get("passwordSales"));
    }

    @And("sales manager clicks on Sales and Customers")
    public void salesManagerClicksOnSalesAndCustomers() {

//            salesCustomersPage.waitUntilLoaderScreenDisappear();
//            salesCustomersPage.nav("sales","Customers");
//            salesCustomersPage.waitUntilLoaderScreenDisappear();
//
//        }THIS DID NOT WORK


        salesCustomersPage.waitUntilLoaderScreenDisappear();
        salesCustomersPage.salesMenu.click();

        BrowserUtils.waitForPageToLoad(5);
        salesCustomersPage.waitUntilLoaderScreenDisappear();

        salesCustomersPage.customersMenu.click();
        salesCustomersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(6);
    }

    @When("sales manager clicks the first result link from customers list")
    public void salesManagerClicksTheFirstResultLinkFromCustomersList() {

        salesCustomersPage.firstCustomerLink.click();

    }

    @And("sales manager clicks {string} button")

    public void salesManagerClicksButton(String buttonName) {

        salesCustomersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);

        salesCustomersPage.clickButtons(buttonName);

        salesCustomersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);


    }

    String name = "";
    String testName;

    @And("sales manager enters {string} name")
    public void salesManagerEntersName(String name) {

        testName = name;
        BrowserUtils.waitForPageToLoad(3);
        salesCustomersPage.nameBox.clear();
        salesCustomersPage.nameBox.sendKeys(name);
        BrowserUtils.waitFor(3);
    }

    @Then("it is displayed the edited customer name on the title.")
    public void itIsDisplayedTheEditedCustomerNameOnTheTitle() {
        salesCustomersPage.waitUntilLoaderScreenDisappear();
        String actualTitle = Driver.get().getTitle();

        BrowserUtils.waitFor(2);
        Assert.assertEquals("Test - Odoo", actualTitle);

    }

    @Then("verify it is listed the new customer")
    public void verifyItIsListedTheNewCustomer() {


        String actualName = salesCustomersPage.nameBox.getText();

    }


    @Then("verify it is listed the new customer by searching the name")
    public void verifyItIsListedTheNewCustomerBySearchingTheName() {
        String createdName = salesCustomersPage.createdName.getText();
        salesCustomersPage.customersMenu.click();
        salesCustomersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);


        salesCustomersPage.searchBox.sendKeys(createdName);
        salesCustomersPage.searchBox.sendKeys(Keys.ENTER);

        BrowserUtils.waitFor(5);
        salesCustomersPage.waitUntilLoaderScreenDisappear();
        List<WebElement> elements = Driver.get().findElements(By.xpath("//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']//strong/span"));
        List<String> elementString = BrowserUtils.getElementsText(elements);

        Assert.assertTrue("verify that ", elementString.contains(createdName));
    }


    @Then("sales manager verifies discard message is displayed")
    public void salesManagerVerifiesDiscardMessageIsDisplayed() {

        salesCustomersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);


        Assert.assertTrue("Discard message's ok button is displayed", salesCustomersPage.discardOK.isDisplayed());

    }

    @Then("the title changes to {string}")
    public void theTitleChangesTo(String newTitle) {

        String expectedTitle = newTitle;

        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals("Verify that new title matches", expectedTitle, actualTitle);

    }

    @And("sales manager enters the name and the address")
    public void salesManagerEntersTheNameAndTheAddress() {


        salesCustomersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(6);
        salesCustomersPage.fillCustomer();
//        Assertion from the title
//        String testName=Driver.get().getTitle();
//        String createdName=testName.substring(0,testName.indexOf(testName.length()-7));


    }
}



