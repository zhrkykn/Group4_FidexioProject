package com.fidexio.step_defs;

import com.fidexio.pages.MailingListsPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MailingListsStepDefs {

    MailingListsPage mailingLists=new MailingListsPage();

    @And("user enters Mailing List name")
    public void userEntersMailingListName() {

        mailingLists.getFakerListName();
        mailingLists.name=mailingLists.listNameBox.getText();
    }

    @Then("verify that title changes to name")
    public void verifyThatTitleChangesToName() {

        String expectedTitle=mailingLists.name.concat(" Odoo");

        BrowserUtils.waitForPageToLoad(5);
        String actualTitle= Driver.get().getTitle();

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);

        Assert.assertEquals(expectedTitle,actualTitle);
    }


    @When("user clicks on a random Mailing List")
    public void userClicksOnARandomMailingList() {

        mailingLists.getRandomMailingList();
    }


    @And("user clicks recipients and Create button")
    public void userClicksRecipientsAndCreateButton() {
        
        mailingLists.recipientsButton.click();
        BrowserUtils.waitForPageToLoad(6);


        
        mailingLists.CreateButton.click();
        BrowserUtils.waitForPageToLoad(6);

        
    }

    @And("user fills the new contact form")
    public void userFillsTheNewContactForm() {

        mailingLists.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);


        mailingLists.fillTheForm();

        mailingLists.beforeSize=mailingLists.counter.getText();
    }

    @Then("Verify that the new contact is added in Recipients List")
    public void verifyThatTheNewContactIsAddedInRecipientsList() {



        mailingLists.afterSize=mailingLists.counter.getText();

        System.out.println("BeforeSize = " + mailingLists.beforeSize);
        System.out.println("AfterSize = " + mailingLists.afterSize);

        Assert.assertEquals(mailingLists.afterSize,mailingLists.beforeSize);


    }

    @Then("user verifies the Mailing List has been deleted")
    public void userVerifiesTheMailingListHasBeenDeleted() {
        mailingLists.afterSize=mailingLists.counter.getText();

        System.out.println("BeforeSize = " + mailingLists.beforeSize);
        System.out.println("AfterSize = " + mailingLists.afterSize);

        Assert.assertNotEquals(mailingLists.afterSize,mailingLists.beforeSize);

    }
}
