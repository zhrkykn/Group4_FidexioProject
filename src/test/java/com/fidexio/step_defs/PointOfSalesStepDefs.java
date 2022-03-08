package com.fidexio.step_defs;


import com.fidexio.pages.PointOfSalePage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class PointOfSalesStepDefs{

    PointOfSalePage pointOfSalePage= new PointOfSalePage();

    static String InitialName;




    @When("User should go to PointOfSale page and click PointOfSale sideMenu")
    public void userShouldGoToPointOfSalePageAndClickPointOfSaleSideMenu() {
        pointOfSalePage.nav("Point of Sale", "Point of Sale");

    }

    @Then("User click on {string} button")
    public void user_click_on_button(String buttonName) {
        BrowserUtils.waitFor(3);
        pointOfSalePage.clickButtons(buttonName);
        BrowserUtils.waitFor(5);
    }


    @And("User enter {string} for Point of Sale")
    public void userEnterForPointOfSale(String arg0) {

        pointOfSalePage.enterName();
        BrowserUtils.waitFor(3);
    }

    @And("User choose Operation Type")
    public void userChooseOperationType() {
        pointOfSalePage.OperationType.click();
        BrowserUtils.waitFor(2);
        pointOfSalePage.OperationTypeDropDowns.get(4).click();

    }

    @Then("Page title should contain {string}")
    public void pageTitleShouldContain(String name) {
        BrowserUtils.waitFor(3);
        pointOfSalePage.EditButton.click();
        BrowserUtils.waitFor(2);
        String expectedName=pointOfSalePage.NameBox.getText();
        BrowserUtils.waitFor(2);
        Assert.assertTrue("faker name is seen", Driver.get().getTitle().contains(expectedName));

    }


    @Then("User should verify that page link includes Kanban")
    public void userShouldVerifyThatPageLinkIncludesKanban() {
        BrowserUtils.waitFor(3);

        String name= "kanban";
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(name));

        BrowserUtils.waitFor(3);

    }

    @Then("User get the name of the Point of Sale")
    public void userGetTheNameOfThePointOfSale() {
        BrowserUtils.waitFor(3);
       InitialName= Driver.get().getTitle();
        BrowserUtils.waitFor(3);

    }
    @Then("Name of the PointOfSale should not be changed")
    public void nameOfThePointOfSaleShouldNotBeChanged() {
        BrowserUtils.waitFor(3);

        String afterName= Driver.get().getTitle();

        Assert.assertTrue("title should be same", InitialName.equalsIgnoreCase(afterName));
        BrowserUtils.waitFor(3);

    }


    @Then("Name of the PointOfSale should be changed")
    public void nameOfThePointOfSaleShouldBeChanged() {

        BrowserUtils.waitFor(3);
        String afterName= Driver.get().getTitle();
        BrowserUtils.waitFor(2);
        Assert.assertFalse("title should be different", InitialName.equalsIgnoreCase(afterName));
        //Assert.assertNotEquals(InitialName, afterName);
        BrowserUtils.waitFor(3);

    }


    @Then("User click on Delete under Actions dropdown button")
    public void userClickOnDeleteUnderActionsDropdownButton() {

        pointOfSalePage.DropDown();


    }

    @Then("User should see the message")
    public void userShouldSeeTheMessage() {

     Assert.assertTrue(pointOfSalePage.ErrorMessage.isDisplayed());


    }


}


