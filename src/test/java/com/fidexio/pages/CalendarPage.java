package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarPage extends BasePage {

    public CalendarPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//div[1]/div[2]/div[1]/ol/li")
    public WebElement calendarDisplayAs;

    @FindBy(xpath = "//button[contains(@class,'button_week')]/@class")
    public WebElement weekButton;

    @FindBy(xpath = "//button[contains(@class,'button_day')]/@class")
    public WebElement dayButton;

    @FindBy(xpath = "//button[contains(@class,'button_month')]/@class")
    public WebElement monthButton;

    @FindBy(xpath = "//button[@accesskey='l']")
    public WebElement listButton;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(css = "[name=name]")
    public WebElement meetingSubjectInput;

    @FindBy(css = "[name=start_datetime]")
    public WebElement startingAtInput;

    @FindBy(css = "[name=duration]")
    public WebElement durationInput;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy(css = ".o_data_row")
    public List<WebElement> rowsEventCreated;

    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement editButton;


}
