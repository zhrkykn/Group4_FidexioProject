package com.fidexio.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SurveysPage extends BasePage{

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

    @FindBy(xpath = "//input[@*='o_field_input_46']")
    public WebElement surveyTitleBox;


    public void clickOnButton(String buttonType){

        switch (buttonType) {
            case "Create" -> createButton.click();
            case "Kanban" -> kanbanButton.click();
            case "List" -> listButton.click();
            case "Import" -> importButton.click();
        }

    }






}
