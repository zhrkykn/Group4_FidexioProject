package com.fidexio.step_defs;

import com.fidexio.pages.RepairOrders;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;


public class RepairOrderStep {
    RepairOrders repair = new RepairOrders();

    @When("the  user clicks on the  {string}")
    public void theUserClicksOnThe(String arg0) {

        repair.nav("Repairs");
        repair.CreateButton.click();

        repair.dropDown.click();
    }

    @And("Fill the  new repair orders form")
    public void fillTheNewRepairOrdersForm() {
       repair.dropDown.click();
        repair.getMenuItem();
    }
}
