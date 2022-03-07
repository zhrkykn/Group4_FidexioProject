package com.fidexio.step_defs;

import com.fidexio.pages.CRM_QuotationsPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Random;

public class CRM_QuotationsStepDefs {

    CRM_QuotationsPage quotationsPage = new CRM_QuotationsPage();
    Random random = new Random();


    @And("user navigates to {string} and {string}")
    public void userNavigatesToAnd(String moduleName, String leftSideMenu) {

        quotationsPage.nav(moduleName, leftSideMenu);

        quotationsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(6);
    }

    @When("user clicks on the {string} button")
    public void userClicksOnTheButton(String buttonName) {

        quotationsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);

        quotationsPage.clickButtons(buttonName);

        quotationsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);
    }

    @Then("verify that it switched to {string} view")
    public void verifyThatItSwitchedToView(String viewName) {

        BrowserUtils.waitFor(6);

        String currentUrl = Driver.get().getCurrentUrl();

        if (viewName.equalsIgnoreCase("kanban")) {
            Assert.assertTrue(currentUrl.contains("kanban"));

        } else if (viewName.equalsIgnoreCase("list")) {
            Assert.assertTrue(currentUrl.contains("list"));
        }

    }


    @When("user clicks on a random quotation")
    public void userClicksOnARandomQuotation() {

        quotationsPage.getRandomQuotation();
    }


    @And("user opens Actions dropdown and clicks Delete")
    public void userOpensActionsDropdownAndClicksDelete() {

        quotationsPage.getActionDelete();

        quotationsPage.beforeQuotationSize = quotationsPage.quotationCounter.getText();
        System.out.println("Before Quotation Size = " + quotationsPage.beforeQuotationSize);
    }


    @And("user edits quotation customer")
    public void userEditsQuotationCustomer() {

        quotationsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(6);

        quotationsPage.editQuotation();

        BrowserUtils.waitForPageToLoad(6);
        quotationsPage.waitUntilLoaderScreenDisappear();


    }

    @Then("user verifies the quotation has been deleted")
    public void userVerifiesTheQuotationHasBeenDeleted() {


        String afterQuotationSize = quotationsPage.quotationCounter.getText();

        Assert.assertNotEquals(afterQuotationSize, quotationsPage.beforeQuotationSize);
    }

    @Then("Verify that quotation has been edited")
    public void verifyThatQuotationHasBeenEdited() {

        Assert.assertTrue(quotationsPage.nowTimeStamp.isDisplayed());

    }


    @And("user gets number of quotes and clicks on Create")
    public void userGetsNumberOfQuotesAndClicksOnCreate() {

        quotationsPage.beforeQuotationSize = quotationsPage.quotationCounter.getText();
        System.out.println("Before Quotation Size = " + quotationsPage.beforeQuotationSize);

        quotationsPage.CreateButton.click();

        quotationsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);

    }



    @Then("user verifies the quotation list number has not changed")
    public void userVerifiesTheQuotationListNumberHasNotChanged() {

        BrowserUtils.waitForPageToLoad(6);
        quotationsPage.waitUntilLoaderScreenDisappear();

        quotationsPage.afterQuotationSize = quotationsPage.quotationCounter.getText();
        System.out.println("After Quotation Size = " + quotationsPage.quotationCounter.getText());

        Assert.assertEquals( quotationsPage.beforeQuotationSize,quotationsPage.afterQuotationSize);
    }
}
