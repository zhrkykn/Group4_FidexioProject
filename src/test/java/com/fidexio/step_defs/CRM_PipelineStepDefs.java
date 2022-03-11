package com.fidexio.step_defs;

import com.fidexio.pages.CRM_QuotationsPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Random;

public class CRM_PipelineStepDefs {


    CRM_QuotationsPage page = new CRM_QuotationsPage();
    Random random = new Random();

    @Given("the user navigates to {string} and {string}")
    public void the_user_navigates_to_and(String string, String string2) {
        page.nav("CRM","Pipeline");
        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);

    }

    @When("user click on the create button")
    public void user_click_on_the_create_button() {
        page.PipecreatButton.click();
        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);

    }

    @When("enter the opportunity title")
    public void enter_the_opportunity_title() {
        page.OpportunityTitle.sendKeys(page.getUserName());
        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);

    }

    @When("user click the create button")
    public void user_click_the_create_button() {
        page.OpportunityCreate.click();
        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);


    }

    @Then("user verifies the pipeline has been created")
    public void user_verifies_the_pipeline_has_been_created() {
        page.nav("Pipeline");
        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);


    }

    @When("user click on the kanban view")
    public void user_click_on_the_kanban_view() {
        BrowserUtils.waitFor(2);
        page.kanbanButton.click();
        BrowserUtils.waitFor(10);
    }

    @Then("user should be able to see kanban view")
    public void user_should_be_able_to_see_kanban_view() {
        String url = Driver.get().getCurrentUrl();
        Assert.assertTrue(url.contains("kanban"));
        BrowserUtils.waitFor(10);
    }

    @When("user click on list view")
    public void user_click_on_list_view() {
        page.PipeList.click();
        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(10);

    }

    @Then("user should be able to see list view")
    public void user_should_be_able_to_see_list_view() {
        String url = Driver.get().getCurrentUrl();
        Assert.assertTrue(url.contains("list"));
        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(10);
    }


    @When("user click on the Discard button")
    public void user_click_on_the_Discard_button() {
        BrowserUtils.waitFor(3);
        page.DiscardButton.click();
        BrowserUtils.waitFor(3);

    }

    @Then("user verifies the opportunity title has not changed")
    public void user_verifies_the_opportunity_title_has_not_changed() {

        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);

    }

    @When("user click on a random pipeline")
    public void user_click_on_a_random_pipeline() {
        if(page.EditList.size()!=0){
            int randomEdit=random.nextInt(page.EditList.size());
            page.EditList.get(randomEdit).click();
        }
    }

    @When("user click on the edit button")
    public void user_click_on_the_edit_button() {
        BrowserUtils.waitFor(2);
        page.PipeEdit.click();
        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("user edits opportunity title")
    public void user_edits_opportunity_title() {
        page.OpportunityTitle.clear();
        page.OpportunityTitle.sendKeys("test1");
        page.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("user click on the save button")
    public void user_click_on_the_save_button() {
        page.PipeSaveButton.click();
       BrowserUtils.waitFor(3);

    }

    @Then("user verifies the pipeline has been edited")
    public void user_verifies_the_pipeline_has_been_edited() {
        page.nav("pipeline");
      BrowserUtils.waitFor(3);

    }


}
