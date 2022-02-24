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

    @Given("the user logged in as a {string}")
    public void the_user_logged_in_as_a(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username =null;
        String password =null;

//        if(userType.equals("driver")){
//            username = ConfigurationReader.get("driver_username");
//            password = ConfigurationReader.get("driver_password");
//        }else if(userType.equals("sales manager")){
//            username = ConfigurationReader.get("sales_manager_username");
//            password = ConfigurationReader.get("sales_manager_password");
//        }
        if(userType.equals("store manager")){
            username = ConfigurationReader.get("username");
            password = ConfigurationReader.get("password");
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
        Assert.assertEquals("verify the page displayed as Week", expectedDisplayAs, actualDisplayAs);

    }

    @Given("the user changes the display to Day")
    public void the_user_changes_the_display_to_Day() {
        BrowserUtils.waitFor(1);
        page.dayButton.click();
        BrowserUtils.waitFor(1);
        String actualDisplayAs = page.displayAs();
        String expectedDisplayAs = "Day";
        Assert.assertEquals("verify the page displayed as Day", expectedDisplayAs, actualDisplayAs);
    }

    @When("the user changes the display to Month")
    public void the_user_changes_the_display_to_Month() {
        BrowserUtils.waitFor(1);
        page.monthButton.click();
        BrowserUtils.waitFor(1);
        String actualDisplayAs = page.displayAs();
        String expectedDisplayAs = "Month";
        Assert.assertEquals("verify the page displayed as Month", expectedDisplayAs, actualDisplayAs);
    }

    @Then("the user changes the display to Week")
    public void the_user_changes_the_display_to_Week() {
        BrowserUtils.waitFor(1);
        page.weekButton.click();
        BrowserUtils.waitFor(1);
        String actualDisplayAs = page.displayAs();
        String expectedDisplayAs = "Week";
        Assert.assertEquals("verify the page displayed as Week", expectedDisplayAs, actualDisplayAs);
    }

    @Then("the user creates an event")
    public void the_user_creates_an_event() {
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = datetime.format(format);
        String dateFixed = currentDateTime.substring(3,5) + "/" + currentDateTime.substring(0,3) + currentDateTime.substring(6);
        System.out.println("dateFixed = " + dateFixed);
        BrowserUtils.waitFor(1);
        page.listButton.click();
        System.out.println("listButton found and clicked!!!");
        BrowserUtils.waitFor(1);
        page.createButton.click();
        System.out.println("createButton found and clicked!!!");
        BrowserUtils.waitFor(1);
        String eventsSubject = "Test Meeting Subject";
        page.meetingSubjectInput.sendKeys(eventsSubject);
        System.out.println("meetingSubjectInput done!!!");
        BrowserUtils.waitFor(1);
        page.startingAtInput.sendKeys(dateFixed);
        System.out.println("startingAtInput done!!!");
        BrowserUtils.waitFor(1);
        page.durationInput.clear();
        BrowserUtils.waitFor(1);
        String eventsDuration = "01:00";
        page.durationInput.sendKeys(eventsDuration);
        System.out.println("durationInput done!!!");
        BrowserUtils.waitFor(1);
        page.saveButton.click();
        System.out.println("saveButton found and clicked!!!");
        BrowserUtils.waitFor(1);
        page.navigateToCalendar();
        BrowserUtils.waitFor(1);
        System.out.println("The paged navigated to " + Driver.get().getTitle());
        BrowserUtils.waitFor(3);
        page.listButton.click();
        System.out.println("listButton found and clicked!!!");
        BrowserUtils.waitFor(1);
        List<String> listOfEventsDetails = page.getRowsInList();
        String actualEvent = eventsSubject + " " + dateFixed + " " + dateFixed.substring(0,12) + (Integer.parseInt(dateFixed.substring(12,13))+1) + dateFixed.substring(13) + " 1 record 01:00";
        System.out.println("detailsOfEvent = " + actualEvent);
        String expectedEvent = "";
        for (String s: listOfEventsDetails) {
            if (s.equals(actualEvent)) {
                expectedEvent = s;
            }
        }
        Assert.assertTrue("verify that the event created is presence in the list", expectedEvent.equals(actualEvent));
    }

    @When("the user edits Meeting Subject")
    public void the_user_edits_Meeting_Subject() {
        System.out.println("\n--------- Meeting Subject Changing Test -------");
        page.listButton.click();
        System.out.println("listButton found and clicked!!!");
        BrowserUtils.waitFor(1);
        String firstEventsDetails = page.getRowsInList().get(0);
        page.rowsEventCreated.get(0).click();
        BrowserUtils.waitFor(1);
        page.editButton.click();
        BrowserUtils.waitFor(1);
        page.meetingSubjectInput.clear();
        BrowserUtils.waitFor(1);
        String eventsSubjectNew = "Test Meeting Subject changed";
        page.meetingSubjectInput.sendKeys(eventsSubjectNew);
        System.out.println("meetingSubjectInput changed!!!");
        BrowserUtils.waitFor(1);
        page.saveButton.click();
        System.out.println("saveButton found and clicked!!!");
        BrowserUtils.waitFor(1);

        // this part is for asserting
        page.navigateToCalendar();
        BrowserUtils.waitFor(1);
        System.out.println("The page navigated to " + Driver.get().getTitle());
        BrowserUtils.waitFor(3);
        page.listButton.click();
        System.out.println("listButton found and clicked!!!");
        BrowserUtils.waitFor(1);
        String actualFirstEventsSubjectChanged = page.getRowsInList().get(0).substring(0,28);
        String expectedFirstEventsSubjectChanged =  eventsSubjectNew;
        System.out.println("detailsOfEvent = " + expectedFirstEventsSubjectChanged);
        Assert.assertTrue("verify that the subject of the first event in the list was changed", actualFirstEventsSubjectChanged.equals(expectedFirstEventsSubjectChanged));
        System.out.println("\n---------Meeting Subject Changing Test Done-------");
    }

    @Then("the user edits meeting schedule")
    public void the_user_edits_meeting_schedule() {
        System.out.println("\n---------Meeting Schedule Changing-------");
        page.listButton.click();
        System.out.println("listButton found and clicked!!!");
        BrowserUtils.waitFor(1);
        System.out.println("expectedFirstEventsDateBeforeChanged = " + page.getFirstEventsDate());
        page.rowsEventCreated.get(0).click();
        BrowserUtils.waitForVisibility(page.editButton,3);
        page.editButton.click();
        BrowserUtils.waitFor(1);
        page.startingAtInput.clear();
        BrowserUtils.waitFor(1);
        String eventsDateNew = "02/22/2022 11:11:11";
        page.startingAtInput.sendKeys(eventsDateNew);
        System.out.println("meetingDateTime changed!!!");
        BrowserUtils.waitFor(1);
        page.durationInput.clear();
        BrowserUtils.waitFor(1);
        String eventsDuration = "01:00";
        page.durationInput.sendKeys(eventsDuration);
        System.out.println("durationInput done!!!");
        BrowserUtils.waitFor(1);
        page.saveButton.click();
        System.out.println("saveButton found and clicked!!!");
        BrowserUtils.waitFor(1);

        // this part is for asserting
        page.navigateToCalendar();
        BrowserUtils.waitFor(1);
        System.out.println("The page navigated to " + Driver.get().getTitle());
        BrowserUtils.waitFor(3);
        page.listButton.click();
        System.out.println("listButton found and clicked!!!");
        BrowserUtils.waitFor(1);
        String actualFirstEventsSubjectChanged = page.getFirstEventsDate();
        System.out.println("expectedFirstEventsDateAfterChanged = " + eventsDateNew);
        Assert.assertTrue("verify that the subject of the first event in the list was changed", actualFirstEventsSubjectChanged.equals(eventsDateNew));
        System.out.println("\n---------Meeting Schedule Changing Test Done-------");

    }
}
