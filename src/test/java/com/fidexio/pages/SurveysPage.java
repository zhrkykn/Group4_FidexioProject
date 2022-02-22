package com.fidexio.pages;


import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SurveysPage extends BasePage {

    @FindBy(css = "a[data-menu='475']")
    public WebElement surveysMenu;


    @FindBy(xpath = "//button[@*='c']")
    public WebElement createButton;


    @FindBy(xpath = "//button[@*='k']")
    public WebElement kanbanButton;

    @FindBy(xpath = "//button[@*='l']")
    public WebElement listButton;

    @FindBy(css = "button.btn.btn-sm.btn-default.o_button_import")
    public WebElement importButton;

    @FindBy(xpath = "//button[@*='s']")
    public WebElement saveButton;

    @FindBy(css= ".o_field_char.o_field_widget.o_input.o_required_modifier")
    public WebElement surveyTitleBox;

    @FindBy(xpath = "(//div//p)[2]")
    public  WebElement surveyCreatedMessage;



    public void clickOnButton(String buttonType) {

        switch (buttonType) {
            case "Create" -> createButton.click();
            case "Kanban" -> kanbanButton.click();
            case "List" -> listButton.click();
            case "Import" -> importButton.click();
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


}
