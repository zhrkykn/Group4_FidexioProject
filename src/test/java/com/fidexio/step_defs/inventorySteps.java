package com.fidexio.step_defs;

import com.fidexio.pages.FleetPage;
import com.fidexio.pages.InventoryPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

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

    @When("Click the create button")
    public void click_the_create_button() {
        invent.create.click();
    }
    @When("Click the create button.")
    public void clickTheCreateButton() {
        invent.create.click();
    }


    @Then("Add product name")
    public void add_product_name() {
        invent.productName.clear();
        invent.productName.sendKeys("Scientific Calculator");

    }

    @Then("Add product Type")
    public void add_product_Type() {
        Select dropProductType=new Select(invent.ProductType);
        dropProductType.selectByVisibleText("Consumable");

    }

    @Then("Add sales price")
    public void add_sales_price() {

        invent.SalesPrice.clear();
        invent.SalesPrice.sendKeys("20.00");
    }

    @Then("Click on product save button")
    public void click_on_product_save_button() {
invent.SaveButton.click();
    }

    @Then("Get the created message")
    public void get_the_created_message() {
        String actualMessage ="Product Template created";

        String message = invent.CreatedMessage.getText();
        Assert.assertEquals(message,actualMessage);

    }




    @Then("Add Product Type")
    public void add_Product_Type() {
        Select dropProductType=new Select(invent.ProductType);
        dropProductType.selectByVisibleText("Consumable");
    }

    @Then("Error message is displayed")
    public void error_message_is_displayed() {
        String actualMessage ="The following fields are invalid:\n" +
                "Name";
        String message = invent.errorMessage.getText();
        Assert.assertEquals(message,actualMessage);
    }



}
