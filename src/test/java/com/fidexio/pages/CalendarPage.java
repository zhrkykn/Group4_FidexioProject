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

    @FindBy(xpath = "//button[@accesskey='l']")
    public WebElement listButton;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(css = "[name=name]")
    public WebElement meetingSubjectInput;

    @FindBy(xpath = "(//tbody/tr[6]/td[2]/div/input)[1]")
    public WebElement startingAtInput;

    @FindBy(css = "[name=duration]")
    public WebElement durationInput;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy(css = ".o_data_row")
    public List<WebElement> rowsEventCreated;

    @FindBy(xpath = "//div[1]/div[2]/div[2]/div/div/div/table/tbody/tr/td[3]")
    public List<WebElement> eventsDateList;

    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement editButton;


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

    public List<String> getRowsInList(){
        List<String> rowsAsStringInList = new ArrayList<>();
        for (WebElement e: rowsEventCreated) {
            rowsAsStringInList.add(e.getText().toString());
            //System.out.println(e.getText().toString());
        }
        return rowsAsStringInList;
    }

    public String getFirstEventsDate(){
        return eventsDateList.get(0).getText();
    }
}
