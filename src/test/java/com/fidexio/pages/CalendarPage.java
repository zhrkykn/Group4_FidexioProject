package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CalendarPage extends BasePage {

    public CalendarPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//nav/div[2]/ul[1]/li[2]/a")
    public WebElement calendarButton;

    @FindBy(xpath = "//div[1]/div[2]/div[1]/ol/li")
    public WebElement calendarDisplayText;

    @FindBy(xpath = "//button[contains(@class,'button_week')]")
    public WebElement weekButton;

    @FindBy(xpath = "//button[contains(@class,'button_day')]")
    public WebElement dayButton;

    @FindBy(xpath = "//button[contains(@class,'button_month')]")
    public WebElement monthButton;

    @FindBy(xpath = "//tr/td/div[2]/div/div[2]/table/tbody/tr[25]/td[2]")
    public WebElement timeBoxToClick;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement createButton;

    @FindBy(xpath = "//table/tbody/tr/td[5]/div/div[2]/a")
    public WebElement createdTimeBoxBefore;

    @FindBy(xpath = "//table/tbody/tr/td[5]/div/div[2]/a")
    public WebElement createdTimeBoxAfter;

    @FindBy(xpath = "//h4[@class='modal-title']")
    public WebElement meetingSubject;

    @FindBy(css = "[name=name]")
    public WebElement meetingSubjectInput;

    @FindBy(xpath = "(//input[@class='o_datepicker_input o_input'])[5]")
    public WebElement startingAtInput;

    @FindBy(css = "[name=duration]")
    public WebElement durationInput;

    @FindBy(xpath = "//th[@class='fc-day-header fc-widget-header fc-wed']")
    public WebElement dateTimeCell;

    @FindBy(xpath = "//span[@class='o_field_date o_field_widget']")
    public WebElement dateTimeText;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement saveButton;

    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "(//button[@class='btn btn-sm btn-default'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "(//button[@class='btn btn-sm btn-default'])[2]")
    public WebElement closeButton;

    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary'])[2]")
    public WebElement okayButton;


    public void navigateToCalendar() {
            BrowserUtils.waitFor(4);
            calendarButton.click();
            System.out.println("The paged navigated to Calendar");
    }

    public String displayAs(){
        String actualDisplayAs = calendarDisplayText.getText();
        if(actualDisplayAs.contains("Week")){
            return "Week";
        }
        else if(actualDisplayAs.contains(",")){
            return "Day";
        }
        else return "Month";
    }
}
