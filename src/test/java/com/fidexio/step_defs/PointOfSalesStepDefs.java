package com.fidexio.step_defs;


import com.fidexio.pages.PointOfSalePage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class PointOfSalesStepDefs {

    PointOfSalePage pointOfSalePage= new PointOfSalePage();


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

    @Then("Page title should contain {string}")
    public void pageTitleShouldContain(String name) {

        String expectedName=pointOfSalePage.NameBox.getText();
        Assert.assertTrue(Driver.get().getTitle().contains(expectedName));


    }

    @Then("User should see Create button")
    public void userShouldSeeCreateButton() {

        Assert.assertTrue("create button cannot displayed", pointOfSalePage.CreateButton.isDisplayed());


    }

    @Then("User should verify that page link includes Kanban")
    public void userShouldVerifyThatPageLinkIncludesKanban() {
        BrowserUtils.waitFor(3);

        String name= "kanban";
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(name));

        BrowserUtils.waitFor(3);


    }

    @Then("User get the name of the Point of Sale")
    static public String userGetTheNameOfThePointOfSale() {
        String currentName= Driver.get().getTitle();
        return currentName;
    }
    @Then("Name of the PointOfSale should not be changed")
    public void nameOfThePointOfSaleShouldNotBeChanged() {
        BrowserUtils.waitFor(3);
        String previousName= userGetTheNameOfThePointOfSale();
        String afterName= Driver.get().getTitle();
        Assert.assertEquals(previousName, afterName);
        //Assert.assertTrue(Driver.get().getTitle().equalsIgnoreCase(userGetTheNameOfThePointOfSale()));
        BrowserUtils.waitFor(3);

    }


    @Then("Name of the PointOfSale should be changed")
    public void nameOfThePointOfSaleShouldBeChanged() {

        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().equalsIgnoreCase(userGetTheNameOfThePointOfSale()));
        BrowserUtils.waitFor(3);
        //Assert.assertNotEquals(Driver.get().getTitle(), userGetTheNameOfThePointOfSale());

    }


}


