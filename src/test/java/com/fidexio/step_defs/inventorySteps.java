package com.fidexio.step_defs;

import com.fidexio.pages.InventoryPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class inventorySteps {
     InventoryPage invent=new InventoryPage();
    LoginPage loginPage=new LoginPage();
    @Given("the user is on the login in")
    public void the_user_is_on_the_login_in() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        loginPage.validLogin();

        BrowserUtils.waitFor(2);
    }

    @Given("the user is clicked inventory button")
    public void the_user_is_clicked_inventory_button() {
     invent.nav("Inventory");

    }

    @Given("the user clicked the product button")
    public void the_user_clicked_the_product_button() {

        invent.product.click();
    }

    @Then("the create button seen")
    public void the_create_button_seen() {
        BrowserUtils.waitFor(3);

       invent.create.click();

    }


}
