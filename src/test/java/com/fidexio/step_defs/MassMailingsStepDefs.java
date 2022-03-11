package com.fidexio.step_defs;

import com.fidexio.pages.CRM_QuotationsPage;
import com.fidexio.pages.MassMailingsPage;
import com.fidexio.pages.SurveysPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class MassMailingsStepDefs {
    MassMailingsPage massMailingsPage=new MassMailingsPage();

    CRM_QuotationsPage massMailings= new CRM_QuotationsPage();

    @When("the user clicks on the {string} button in the Mass Mailings")
    public void theUserClicksOnTheButtonInTheMassMailings(String ButtonType) {
        BrowserUtils.waitFor(10);
        massMailings.clickButtons(ButtonType);
        BrowserUtils.waitFor(5);

    }


    @When("user enters subject name as {string}")
    public void user_enters_subject_name_as(String subjectTitle) {
        BrowserUtils.waitFor(5);
        massMailingsPage.subjectBox.sendKeys(subjectTitle);


    }

    @Then("verify that title changes to {string}")
    public void verify_that_title_changes_to(String expectedTitle) {
        massMailingsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        String actualTitle= Driver.get().getTitle();

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("user clicks on a random Mass mailings")
    public void user_clicks_on_a_random_Mass_mailings() {
        massMailingsPage.getRandomMassMailing();
    }

    @When("the user edits the name of the subject")
    public void the_user_edits_the_name_of_the_subject() {
        BrowserUtils.waitFor(5);

        massMailingsPage.subjectBox.clear();
        massMailingsPage.subjectBox.sendKeys("Fourth Newsletter");

    }

    @Then("Verify that the Subject name has been changed")
    public void verify_that_the_Subject_name_has_been_changed() {

      String expectedName=  massMailingsPage.editedName.getText();

      massMailingsPage.nav("Email Marketings", "Mass Mailings");

        for (WebElement list: massMailingsPage.massMailingList) {
            if(list.getText().equals(expectedName)){
                Assert.assertEquals(list.getText(),expectedName);
                System.out.println("expectedName = " + expectedName);
                System.out.println("list.getText() = " + list.getText());
            }

        }

    }


    @Then("user verifies the Subject name has not been changed")
    public void user_verifies_the_Subject_name_has_not_been_changed() {
        String actualName=  massMailingsPage.editedName.getText();
        String expectedName= "Fifth Newsletter";

        massMailingsPage.nav("Email Marketings", "Mass Mailings");

        for (WebElement list: massMailingsPage.massMailingList) {
            if(list.getText().equals(actualName)){
                Assert.assertNotEquals(list.getText(),expectedName);
                System.out.println("expectedName = " + expectedName);
                System.out.println("list.getText() = " + list.getText());
            }

        }

    }

    @When("the user opens Actions dropdown and clicks Delete")
    public void the_user_opens_Actions_dropdown_and_clicks_Delete() {
        massMailings.getActionDelete();

       MassMailingsPage.beforeMassSize = massMailingsPage.countMailings.getText();
            System.out.println("Before Mass Mailings Size = " + MassMailingsPage.beforeMassSize);

    }


    @Then("verify that  Mass Mailings  has been deleted")
    public void verify_that_Mass_Mailings_has_been_deleted() {
        BrowserUtils.waitFor(2);
        String afterMassSize = massMailingsPage.countMailings.getText();
        Assert.assertNotEquals(afterMassSize,MassMailingsPage.beforeMassSize);



    }



    }




