package com.fidexio.step_defs;

import com.fidexio.pages.CalendarPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class CalendarStepDefs {
    CalendarPage page = new CalendarPage();

    @Given("The user logged in as a {string}")
    public void The_user_logged_in_as_a(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.equals("store manager")){
            username = ConfigurationReader.get("username");
            password = ConfigurationReader.get("password");
        }
        else if (userType.equals("expenses manager")) {
            username = "expensesmanager10@info.com";
            password = "expensesmanager";
        }
        //send username and password and login
        new LoginPage().login(username,password);
        System.out.println("The user logged in as a " + userType);
    }

    @When("the user navigates to Calender")
    public void the_user_navigates_to_Calender() {
        page.navigateToCalendar();
    }

    @Then("the user first lands on weekly display")
    public void the_user_first_lands_on_weekly_display() {
        BrowserUtils.waitFor(3);
        String actualDisplayAs = page.displayAs();
        String expectedDisplayAs = "Week";
        BrowserUtils.waitFor(1);
        Assert.assertEquals("verify the page displayed as Week", expectedDisplayAs, actualDisplayAs);

    }

    @Given("the user changes the display to Day")
    public void the_user_changes_the_display_to_Day() {
        BrowserUtils.waitFor(2);
        page.dayButton.click();
        BrowserUtils.waitFor(2);
        String actualDisplayAs = page.displayAs();
        String expectedDisplayAs = "Day";
        BrowserUtils.waitFor(1);
        Assert.assertEquals("verify the page displayed as Day", expectedDisplayAs, actualDisplayAs);
    }

    @When("the user changes the display to Month")
    public void the_user_changes_the_display_to_Month() {
        BrowserUtils.waitFor(2);
        page.monthButton.click();
        BrowserUtils.waitFor(2);
        String actualDisplayAs = page.displayAs();
        String expectedDisplayAs = "Month";
        BrowserUtils.waitFor(1);
        Assert.assertEquals("verify the page displayed as Month", expectedDisplayAs, actualDisplayAs);
    }

    @Then("the user changes the display to Week")
    public void the_user_changes_the_display_to_Week() {
        BrowserUtils.waitFor(1);
        page.weekButton.click();
        BrowserUtils.waitFor(2);
        String actualDisplayAs = page.displayAs();
        String expectedDisplayAs = "Week";
        BrowserUtils.waitFor(2);
        Assert.assertEquals("verify the page displayed as Week", expectedDisplayAs, actualDisplayAs);
    }

    @Then("the user creates an event")
    public void the_user_creates_an_event() {

        BrowserUtils.waitFor(1);
        page.timeBoxToClick.click();
        System.out.println("timeBoxToClick found and clicked!!!");
        BrowserUtils.waitFor(2);
        String eventsSubject = "Test Meeting Subject " + (int)(Math.random() * 100);
        BrowserUtils.waitFor(2);
        page.meetingSubjectInput.sendKeys(eventsSubject);
        System.out.println("meetingSubjectInput done!!!");
        BrowserUtils.waitFor(2);
        page.createButton.click();
        System.out.println("createButton found and clicked!!!");

        BrowserUtils.waitFor(2);
        page.createdTimeBoxBefore.click();
        System.out.println("The created event is clicked!!!");
        BrowserUtils.waitFor(2);
        String actualEvent = page.meetingSubject.getText().substring(6);
        System.out.println("detailsOfEvent = " + actualEvent);
        BrowserUtils.waitFor(2);
        Assert.assertEquals("verify that the event created is present on the display", eventsSubject, actualEvent);
        page.closeButton.click();
        System.out.println("closeButton clicked");
        System.out.println("\n------ The event has been created successfully -------");

    }

    @When("the user edits Meeting Subject")
    public void the_user_edits_Meeting_Subject() {
        BrowserUtils.waitFor(1);
        System.out.println("\n--------- Meeting Subject Changing Test -------");
        page.createdTimeBoxBefore.click();
        System.out.println("The created event is clicked!!!");
        BrowserUtils.waitFor(2);
        page.editButton.click();
        System.out.println("editButton clicked");
        BrowserUtils.waitFor(2);
        page.meetingSubjectInput.clear();
        BrowserUtils.waitFor(2);
        String eventsSubjectNew = "Test Meeting Subject changed";
        page.meetingSubjectInput.sendKeys(eventsSubjectNew);
        System.out.println("meetingSubjectInput changed!!!");
        BrowserUtils.waitFor(2);
        page.saveButton.click();
        System.out.println("saveButton found and clicked!!!");
        BrowserUtils.waitFor(2);

        // this part is for asserting
        page.createdTimeBoxBefore.click();
        System.out.println("The created event is clicked!!!");
        BrowserUtils.waitFor(2);
        String actualEvent = page.meetingSubject.getText().substring(6);
        System.out.println("detailsOfEvent = " + actualEvent);
        BrowserUtils.waitFor(2);
        Assert.assertEquals("verify that the event created is present on the display", eventsSubjectNew, actualEvent);
        page.closeButton.click();
        System.out.println("closeButton clicked");
        System.out.println("\n---------Meeting Subject has been changed successfully-------");
    }

    @Then("the user edits meeting schedule")
    public void the_user_edits_meeting_schedule() {
        BrowserUtils.waitFor(1);
        System.out.println("\n---------Meeting Schedule Changing-------");
        page.createdTimeBoxBefore.click();
        System.out.println("The created event is clicked!!!");
        BrowserUtils.waitFor(2);
        page.editButton.click();
        System.out.println("editButton clicked");
        BrowserUtils.waitFor(2);
        page.startingAtInput.clear();
        BrowserUtils.waitFor(2);
        String eventsDateNew = page.dateTimeCell.getText().substring(4) + " 08:00:00";
        System.out.println("eventsDateNew = " + eventsDateNew);
        BrowserUtils.waitFor(2);
        page.startingAtInput.sendKeys(eventsDateNew);
        System.out.println("meetingDateTime changed!!!");
        BrowserUtils.waitFor(2);
        page.durationInput.clear();
        BrowserUtils.waitFor(2);
        String eventsDuration = "01:00";
        page.durationInput.sendKeys(eventsDuration);
        System.out.println("durationInput done!!!");
        BrowserUtils.waitFor(2);
        page.saveButton.click();
        System.out.println("saveButton found and clicked!!!");
        BrowserUtils.waitFor(2);

        // this part is for asserting
        page.createdTimeBoxAfter.click();
        BrowserUtils.waitFor(2);
        String actualDateTime = page.dateTimeText.getText();
        Assert.assertEquals("verify that the subject of the first event in the list was changed", actualDateTime, eventsDateNew);
        BrowserUtils.waitFor(2);
        page.closeButton.click();
        System.out.println("closeButton clicked");
        System.out.println("\n---------Meeting Schedule has been changed successfully-------");
        BrowserUtils.waitFor(2);

        // this part to delete the event
        page.createdTimeBoxAfter.click();
        BrowserUtils.waitFor(2);
        page.deleteButton.click();
        BrowserUtils.waitFor(1);
        page.okayButton.click();
        System.out.println("\n------- The event has been removed successfully -------");
    }
}
