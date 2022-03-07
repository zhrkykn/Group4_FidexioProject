package com.fidexio.pages;


import com.fidexio.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SurveysPage extends BasePage {

    @FindBy(css = "a[data-menu='475']")
    public WebElement surveysMenu;


    @FindBy(xpath = "//button[@*='c']")
    public WebElement createButton;


    @FindBy(xpath = "//button[@*='k']")
    public WebElement kanbanButton;

    @FindBy(xpath = "//button[@*='l']")
    public WebElement listButton;

    @FindBy(xpath = "//button[contains(text(),'Import')]")
    public WebElement importButton;

    @FindBy(xpath = "//button[@*='s']")
    public WebElement saveButton;

    @FindBy(css= ".o_field_char.o_field_widget.o_input.o_required_modifier")
    public WebElement surveyTitleBox;

    @FindBy(xpath = "(//div//p)[2]")
    public  WebElement surveyCreatedMessage;

    @FindBy(css = ".o_notification.undefined.o_error")
    public  WebElement surveyError;

    @FindBy(xpath = "//div[@class='o_kanban_record_top']")
    public List<WebElement> createdSurveyList;

    @FindBy(xpath = "//span[text()='Draft']")
    public WebElement kanbanTitle;

    @FindBy(xpath ="/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[2]")
    public  WebElement listTitle;



    public void clickOnButton(String buttonType) {

        switch (buttonType) {
            case "Create":
                BrowserUtils.waitForClickablility(createButton,5);
                createButton.click();
                BrowserUtils.waitFor(5);
                break;

            case "Import" :
                BrowserUtils.waitForClickablility(importButton,5);
                importButton.click();
                BrowserUtils.waitFor(5);
                break;
            default:
                System.out.println("Button not found");
        }



    }

    public void clickCreate() {
        createButton.click();

    }




    public void clickSave() {
        saveButton.click();
    }

    public String  surveyCreated(){
        String actualMessage;
       return  actualMessage = surveyCreatedMessage.getText();



    }

    public void surveyListed(){
        String expectedSurveyTitle="Customer Survey3";

        String actualSurveyTitle=createdSurveyList.get(createdSurveyList.size()-1).getText();

        Assert.assertEquals(expectedSurveyTitle,actualSurveyTitle);
    }


}
