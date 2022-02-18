package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeePage extends BasePage{

        @FindBy( xpath = "//a[@data-menu=\"157\"]/span")
        public WebElement Employees;

       @FindBy( css = " button.btn.btn-primary.btn-sm.o-kanban-button-new.btn-default")
       public WebElement createButton;

       @FindBy( css= "button.btn.btn-sm.btn-default.o_button_import")
       public WebElement importButton;

       @FindBy( css= " button.o_follow_btn.o_follow_btn.btn-sm.btn-primary.oe_kanban_action_button")
       public WebElement followButton;


        @FindBy (xpath = "(//li[@class='active'])[2]")
        public WebElement NewEmployeePage;

        @FindBy(xpath = "(//li[@class='active'])[2]")
        public WebElement ImportaFilePage;

        @FindBy( xpath = "//span[@class='o_following']")
        public WebElement Following;

        @FindBy ( id= "o_field_input_2666")
        public WebElement EmployeeNameInput;

        @FindBy(css= "button.btn.btn-primary.btn-sm.o_form_button_save")
        public WebElement SaveButton;

        @FindBy(linkText = "Employee created")
        public WebElement EmploteeCreatedMessage;









}
