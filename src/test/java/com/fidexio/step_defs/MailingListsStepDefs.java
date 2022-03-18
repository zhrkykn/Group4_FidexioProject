package com.fidexio.step_defs;

import com.fidexio.pages.DashboarPage;
import com.fidexio.pages.MailingListsPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class MailingListsStepDefs {

    MailingListsPage mailingLists=new MailingListsPage();

    @And("user enters Mailing List name")
    public void userEntersMailingListName()  {

        mailingLists.getFakerListName();

       BrowserUtils.waitFor(6);

    }

    @Then("verify that the list has been created by searching")
    public void verifyThatTheListHasBeenCreatedBySearching() throws InterruptedException {


        String newListName = mailingLists.createdName.getText();
        BrowserUtils.waitForPageToLoad(5);

        mailingLists.navMailingList();

        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitFor(5);


        mailingLists.searchFunction(newListName);

        BrowserUtils.waitFor(5);

        List<String> actualMailingLists = BrowserUtils.getElementsText(mailingLists.mailingListList);

        System.out.println("actualMailingLists = " + actualMailingLists);

        for (String eachList : actualMailingLists) {

            Assert.assertTrue(eachList.contains(newListName));
        }

    }



    @When("user clicks on a random Mailing List")
    public void userClicksOnARandomMailingList() {

        mailingLists.getRandomMailingList();

        mailingLists.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);

    }


    @And("user clicks recipients and Create button")
    public void userClicksRecipientsAndCreateButton() throws InterruptedException {
        
        mailingLists.recipientsButton.click();
        BrowserUtils.waitForPageToLoad(6);
        BrowserUtils.waitForVisibility(mailingLists.CreateButton,6);

//        mailingLists.CreateButton.click();
//        BrowserUtils.waitForPageToLoad(6);

        
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

    @And("user edits the name of the list")
    public void userEditsTheNameOfTheList() {

        mailingLists.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);

        mailingLists.editMailingList();

        BrowserUtils.waitFor(5);
    }
}
