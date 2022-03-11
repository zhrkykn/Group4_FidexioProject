package com.fidexio.step_defs;

import com.fidexio.pages.RepairOrders;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RepairOrderStep {
    RepairOrders repair = new RepairOrders();

    @When("the  user clicks on the  {string}")
    public void theUserClicksOnThe(String arg0) {

        repair.nav("Repairs");
        //repair.CreateButton.click();

       // repair.dropDown.click();


        repair.beforeRepairSize=repair.listCounter.getText();
    }

    @And("Fill the  new repair orders form")
    public void fillTheNewRepairOrdersForm() {
       repair.dropDown.click();
       BrowserUtils.waitFor(2);
        repair.getMenuItem();


    }

    @Then("user able to see the created message")
    public void userAbleToSeeTheCreatedMessage() {
        String note=repair.createdMessage.getText();
        Assert.assertTrue(repair.createdMessage.isDisplayed());
    }

    @And("The user should be able to see list not changed")
    public void theUserShouldBeAbleToSeeListNotChanged() {
        String afterListCounter=repair.listCounter.getText();
        Assert.assertEquals(afterListCounter,repair.beforeRepairSize);
    }

    @When("user choose any item")
    public void userChooseAnyItem() {
        repair.getRandomList();
    }

    @Then("verify  edited")
    public void verifyEdited() {

        String actualEdited=repair.AfterEdited.getText();
        repair.nav("Repairs");
        BrowserUtils.waitFor(2);
        for (WebElement eachList : repair.repairList ) {
            if(eachList.getText().equals(actualEdited)){
                Assert.assertEquals(eachList.getText(),actualEdited);

        }
        }
    }
}
