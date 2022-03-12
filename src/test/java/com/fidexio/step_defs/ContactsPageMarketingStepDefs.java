package com.fidexio.step_defs;

import com.fidexio.pages.ContactsPageMarketing;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class ContactsPageMarketingStepDefs {

    ContactsPageMarketing CP = new ContactsPageMarketing();

    @Then("user clicks on Email Marketing Button")
    public void user_clicks_on_Email_Marketing_Button() {
        CP.emailMarketing.click();
        BrowserUtils.waitFor(2);
    }

    @Then("user clicks on Contacts button")
    public void user_clicks_on_Contacts_button() {
        CP.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        CP.contactsButton.click();
    }

    @Then("user switchs from list to kanban")
    public void user_switchs_from_list_to_kanban() {
        CP.kanbanView.click();
        BrowserUtils.waitFor(1);
    }

    @Then("user clicks on Create button")
    public void user_clicks_on_Create_button() {
        CP.createButton.click();
    }

    @When("user enters a name and click create button")
    public void user_enters_a_name_and_click_create_button() {
        CP.input.sendKeys("Jack Sparrow");
    }

    @When("user enters an email")
    public void user_enters_an_email() {
        CP.email.sendKeys("asdf@hotmail.com");
        BrowserUtils.waitFor(1);
    }

    @Then("user clicks on Save Button")
    public void user_clicks_on_Save_Button() {
        CP.saveContacts.click();
    }

    @When("user clicks on Discard button")
    public void user_clicks_on_Discard_button() {
        CP.discard.click();
    }

    @When("user clicks on any contact")
    public void user_clicks_on_any_contact() {
        CP.firstContact.click();
    }

    @Then("user clicks on Edit button")
    public void user_clicks_on_Edit_button() {
        CP.editContacts.click();
    }

    @Then("user enters new name and create it")
    public void user_enters_new_name_and_create_it() {
        CP.input.clear();
        CP.input.sendKeys("Tony Stark");
    }

    @Then("clicks on Action button")
    public void clicks_on_Action_button() {
        CP.actionButton.click();
    }

    @Then("user clisk on Delete button")
    public void user_clisk_on_Delete_button() {
        CP.deleteButton.click();
    }

    @Then("user should be able to see warning message")
    public void user_should_be_able_to_see_warning_message() {
        CP.warningMessage.isDisplayed();
    }


}
