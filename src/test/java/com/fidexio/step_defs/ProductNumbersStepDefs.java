package com.fidexio.step_defs;

import com.fidexio.pages.ProductNumbersPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ProductNumbersStepDefs {


    ProductNumbersPage pnp = new ProductNumbersPage();
    String inventoryProducts = "";
    String salesProducts = "";
    String websiteProducts = "";

    @Given("the user is on the inventory page")
    public void the_user_is_on_the_inventory_page() {
        pnp.inventoryBtn.click();
    }

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String product) {
        if (product.equalsIgnoreCase("inventory products")){
            pnp.inventoryProducts.click();
        }else if (product.equalsIgnoreCase("sales products")){
            pnp.salesProducts.click();
        }else if (product.equalsIgnoreCase("website products")){
            pnp.websiteProducts.click();
        }
    }

    @Then("the user gets the number of {string}")
    public void the_user_gets_the_number_of(String products) {
        if (products.equalsIgnoreCase("inventory products")){
            pnp.waitUntilLoaderScreenDisappear();
            BrowserUtils.waitFor(1);
            inventoryProducts = pnp.itemsOfAll.getText();
        }else if (products.equalsIgnoreCase("sales products")){
            pnp.waitUntilLoaderScreenDisappear();
            BrowserUtils.waitFor(1);
            salesProducts = pnp.itemsOfAll.getText();
        }else if (products.equalsIgnoreCase("website products")){
            pnp.waitUntilLoaderScreenDisappear();
            BrowserUtils.waitFor(1);
            websiteProducts = pnp.itemsOfAll.getText();
        }
    }


    @Given("the user is on the sales page")
    public void the_user_is_on_the_sales_page() {
        pnp.salesBtn.click();
    }

    @Given("the user is on the Website page")
    public void the_user_is_on_the_Website_page() {
        pnp.websiteBtn.click();
    }

    @Then("the user compares number of the products in Inventory, Sales and Website and result is wrong")
    public void the_user_compares_number_of_the_products_in_Inventory_Sales_and_Website_and_result_is_wrong() {
        Assert.assertNotEquals(inventoryProducts,websiteProducts);
        Assert.assertNotEquals(inventoryProducts,salesProducts);
        Assert.assertNotEquals(websiteProducts,salesProducts);

    }

    @And("the user clears search bar")
    public void theUserClearsSearchBar() {
        pnp.removeBtn.click();
        pnp.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(1);
    }


    @Then("the user compares number of the products in Inventory, Sales and Website and result is true")
    public void the_user_compares_number_of_the_products_in_Inventory_Sales_and_Website_and_result_is_true() {
        Assert.assertEquals(inventoryProducts,websiteProducts);
        Assert.assertEquals(inventoryProducts,salesProducts);
        Assert.assertEquals(websiteProducts,salesProducts);

    }




}


