package com.fidexio.step_defs;

import com.fidexio.pages.ContactPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ContactsDefs {
    Random random = new Random();
    String delName;
    ContactPage contact = new ContactPage();

    static Faker fakir = new Faker();
    static String name;
    static {
        name = fakir.name().fullName();
    }

    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String string) {
        contact.nav("Contacts");
        contact.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("user enters required info for new Contact")
    public void user_enters_required_info_for_new_Contact() {
        //name = fakir.name().fullName();
        contact.nameForNewContact.sendKeys(name);
    }

    @Then("user should be able to see new contact in list")
    public void user_should_be_able_to_see_new_contact_in_list() {
        contact.nav("Contacts");
        contact.searchingName(name);
        Assert.assertEquals("Verify that new contact is crated", name, contact.searchedName.getText());

    }

    @When("Click on List view")
    public void click_on_List_view() {
        contact.viewAsList.click();
        contact.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(1);
    }

    @Then("user should be able to see List view")
    public void user_should_be_able_to_see_List_view() {

        List<String> listViewHeader = BrowserUtils.getElementsText(contact.listViewHeader.subList(1, contact.listViewHeader.size()));
        List<String> listViewHeaderExpected = Arrays.asList("Name", "Phone", "Email");
        Assert.assertEquals("Verify that it is a List view", listViewHeaderExpected, listViewHeader);

    }

    @When("Click on Kanban view")
    public void click_on_Kanban_view() {
        contact.viewAsKanban.click();
        BrowserUtils.waitFor(2);
        contact.waitUntilLoaderScreenDisappear();
    }

    @Then("user should be able to see Kanban view")
    public void user_should_be_able_to_see_Kanban_view() {
        BrowserUtils.waitForVisibility(contact.kanbanDiv, 5);
        Assert.assertTrue("Verify that it is kanban view.", contact.kanbanDiv.isEnabled());
    }

    @When("Click on Discard")
    public void click_on_Discard() {
        contact.discardButton.click();
        contact.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(contact.okeyButton, 5);
        contact.okeyButton.click();
    }

    @Then("User should able to quit without saving")
    public void user_should_able_to_quit_without_saving() {
        contact.nav("Contacts");
        contact.searchingName(name);
        Assert.assertTrue("Verify that new contact is not  crated", contact.listOfContacts.size() == 0);
    }

    @When("user click any contact")
    public void user_click_any_contact() {
        int i = random.nextInt(10,88);
        String path = "(//div[@class='o_view_manager_content']//img)[" + i + "]";
        WebElement anyImage = Driver.get().findElement(By.xpath(path));
        BrowserUtils.waitForClickablility(anyImage, 5);
        anyImage.click();
    }

    @When("Click on Edit button")
    public void click_on_Edit_button() {
        BrowserUtils.waitForClickablility(contact.editButton, 5);
        contact.editButton.click();

    }

    @When("user changes the name")
    public void user_changes_the_name() {
        BrowserUtils.waitFor(2);
        contact.nameForNewContact.clear();
        name = fakir.name().fullName();
        contact.nameForNewContact.sendKeys(name);
    }

    @Then("Verify that changed name appear in contact list")
    public void verify_that_changed_name_appear_in_contact_list() {
        contact.nav("Contacts");
        contact.searchingName(name);
        Assert.assertTrue(contact.searchedName.getText().contains(name));
    }


    @When("click to Delete")
    public void click_to_Delete() {
        delName = Driver.get().findElement(By.xpath("//span[@name='name']")).getText();
        contact.actionButton.click();
        BrowserUtils.waitFor(1);
        contact.deleteSelection.click();
        Driver.get().findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
    }

    @Then("user shouldn't see name")
    public void user_shouldn_t_see_name() {
        contact.nav("Contacts");
        contact.waitUntilLoaderScreenDisappear();
        contact.searchingName(delName);
        Assert.assertTrue(Driver.get().findElements(By.xpath("//tr[@class='o_data_row']/td[2]")).size()==0);
    }

}
