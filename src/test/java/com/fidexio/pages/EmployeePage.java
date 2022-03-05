package com.fidexio.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeePage extends BasePage {

    @FindBy(xpath = "//a[@data-menu=\"157\"]/span")
    public WebElement Employees;

    @FindBy(css = "button.btn.btn-primary.btn-sm.o-kanban-button-new.btn-default")
    public WebElement createButton;

    @FindBy(css = "button.btn.btn-sm.btn-default.o_button_import")
    public WebElement importButton;

    @FindBy(css = " button.o_follow_btn.o_follow_btn.btn-sm.btn-primary.oe_kanban_action_button")
    public WebElement followButton;

    @FindBy(xpath = "//span[@class='o_following']")
    public WebElement Following;

    @FindBy(css = "input.o_field_char.o_field_widget.o_input.o_required_modifier")
    public WebElement EmployeeNameInput;

    @FindBy(css = "button.btn.btn-primary.btn-sm.o_form_button_save")
    public WebElement SaveButton;

    @FindBy(xpath = "(//div//p)[8]")
    public WebElement EmployeeCreatedMessage;

    @FindBy(xpath = "//*[text()='Rachael Taylor']")
    public WebElement newEmployee;

    public void clickButtons(String buttonName){


        if(buttonName.equals("create")){
            createButton.click();
        }
        else if(buttonName.equals("import")){
            importButton.click();
        }
        else if(buttonName.equals("follow")){
            followButton.click();
        }
        else if(buttonName.equals("save")){
            SaveButton.click();
        }

    }
    public void clickEmployees() {

        Employees.click();
    }


    public String FollowingInfo() {
        return Following.getText();
    }



    public void enterName() {
        String name = "Rachael Taylor";
        EmployeeNameInput.sendKeys(name);
    }

    public String MessageCreated() {
        return EmployeeCreatedMessage.getText();
    }

}