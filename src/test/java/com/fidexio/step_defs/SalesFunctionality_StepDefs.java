package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.pages.SalesFunctionaltyPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SalesFunctionality_StepDefs {
SalesFunctionaltyPage salesFunctionaltyPage=new SalesFunctionaltyPage();
FleetPage fleetPage = new FleetPage();

    @Given("sales manager should be logged in")
    public void sales_manager_should_be_logged_in() {

        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login(ConfigurationReader.get("salesManager"), ConfigurationReader.get("passwordSales"));
    }

    @And("sales manager clicks on Sales and Customers")
    public void salesManagerClicksOnSalesAndCustomers() {
//            salesFunctionalityPage.waitUntilLoaderScreenDisappear();
//            salesFunctionalityPage.nav("sales","Functionality");
//            salesFunctionalityPage.waitUntilLoaderScreenDisappear();
       salesFunctionaltyPage.waitUntilLoaderScreenDisappear();
      salesFunctionaltyPage.salesMenu.click();

        BrowserUtils.waitForPageToLoad(5);
      salesFunctionaltyPage.waitUntilLoaderScreenDisappear();

       salesFunctionaltyPage.customersMenu.click();
        salesFunctionaltyPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(6);
    }


}

