package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
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


    @FindBy(xpath = "(//li[@class='active'])[2]")
    public WebElement NewEmployeePage;

    @FindBy(xpath = "(//li[@class='active'])[2]")
    public WebElement ImportaFilePage;

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


    public void clickEmployees() {

        Employees.click();
    }

    public void clickcreate() {
        createButton.click();
    }

    public void clickimport() {
        importButton.click();
    }

    public void clickfollow() {
        followButton.click();
    }

    public String FollowingInfo() {
        String actualText = Following.getText();
        return actualText;
    }

    public void clickSave() {
        SaveButton.click();
    }

    public void enterName() {
        String name = "Rachael Taylor";
        EmployeeNameInput.sendKeys(name);
    }

    public String MessageCreated() {
        String actualText = EmployeeCreatedMessage.getText();
        return actualText;
    }

}
