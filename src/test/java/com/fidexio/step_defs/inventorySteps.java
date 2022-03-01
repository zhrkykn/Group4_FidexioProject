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
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
//Verify that the user can create a product.
//Verify that a new product can be found in the search.
//Verify that all the saved details are listed correctly.

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

        invent.nav("Inventory","Products");


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

        BrowserUtils.waitForVisibility(invent.productName,5);
        invent.productName.clear();
        invent.productName.sendKeys("Scientific Calculator");
        Select dropProductType=new Select(invent.ProductType);
        BrowserUtils.waitFor(1);
        dropProductType.selectByVisibleText("Consumable");
        invent.SalesPrice.clear();
        invent.SalesPrice.sendKeys("$ 20.00");
        invent.costForProduct.sendKeys("12332");


    }

    @Then("Add product Type")
    public void add_product_Type() {
        BrowserUtils.waitFor(2);
        Select dropProductType=new Select(invent.ProductType);
        BrowserUtils.waitFor(2);
        dropProductType.selectByVisibleText("Consumable");

    }

    @Then("Add sales price")
    public void add_sales_price() {
        BrowserUtils.waitForClickablility(invent.SalesPrice,5);
        invent.SalesPrice.clear();
        invent.SalesPrice.sendKeys("$ 20.00");

    }

    @Then("Click on product save button")
    public void click_on_product_save_button() {
        invent.SaveButton.click();
    }

    @Then("Get the created message")
    public void get_the_created_message() {

       String expected ="Product Template created";
       BrowserUtils.waitForVisibility(invent.CreatedMessage,5);
       String message = invent.CreatedMessage.getText();
       Assert.assertEquals(message,expected);

    }




    @Then("Add Product Type")
    public void add_Product_Type() {
        Select dropProductType=new Select(invent.ProductType);
        BrowserUtils.waitFor(2);
        dropProductType.selectByVisibleText("Consumable");
    }



    @Then("click search button")
    public void click_search_button() {

        invent.search.click();

    }

    @Then("product name written")
    public void product_name_written() {
        invent.search.clear();
        BrowserUtils.waitFor(2);
        invent.search.sendKeys("Scientific Calculator");
        invent.search.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(2);

    }

    @Then("product name found on the list")
    public void product_name_found_on_the_list() {
        String actualMessage ="Scientific Calculator" ;
        BrowserUtils.waitFor(2);

        String message = invent.scCalculator.getText();
        System.out.println(message);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(message,actualMessage);
        BrowserUtils.waitFor(2);



    }




    @Then("product type and sales price seen")
    public void product_type_and_sales_price_seen() {

        String actualMessage ="$ 20.00";

        List<String> pricesString = BrowserUtils.getElementsText(invent.priceS);

        BrowserUtils.waitFor(2);
        Assert.assertTrue("Verify that new item in list", pricesString.contains(actualMessage));

    }




}
