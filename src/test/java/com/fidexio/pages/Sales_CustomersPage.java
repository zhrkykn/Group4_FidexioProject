package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;


public class Sales_CustomersPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement CreateButton;

    @FindBy(xpath = "//button[contains(text(),'Import')]")
    public WebElement ImportButton;

    @FindBy(className = "btn btn-icon fa fa-lg fa-th-large o_cp_switch_kanban active")
    public WebElement KanbanButton;

    @FindBy(className = "btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list")
    public WebElement ListButton;

    @FindBy(className = "fa fa-chevron-left btn btn-icon o_pager_previous")
    public WebElement previousButton;

    @FindBy(className = "fa fa-chevron-right btn btn-icon o_pager_next")
    public WebElement nextButton;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement SaveButton;

    @FindBy(xpath = "//button[contains(text(),'Discard')]")
    public WebElement DiscardButton;

    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    public WebElement EditButton;

    @FindBy(xpath = "//div[1]/div[1]/img")
    public WebElement firstCustomerLink;

    @FindBy(xpath = "//Input[contains(@placeholder, 'Street...')]")
    public WebElement streetBox;

    @FindBy(xpath = "//Input[contains(@placeholder, 'City')]")
    public WebElement cityBox;

    @FindBy(xpath = "//Input[contains(@placeholder, 'Name')]")
    public WebElement nameBox;

    @FindBy(xpath = "//Input[contains(@placeholder, 'Search...')]")
    public WebElement searchBox;

    @FindBy(xpath = "kanban assertion://div[1]/div[1]/img")
    public WebElement kanbanImage;

    @FindBy(xpath = "//table/thead/tr/th[2]/text()")
    public WebElement listNameHead;

    @FindBy(xpath = "//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[6]/a/span")
    public WebElement salesMenu;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[6]/ul[1]/li[3]/a/span")
    public WebElement customersMenu;

    @FindBy(css = "o_kanban_record_title oe_partner_heading")
    public WebElement kanbanRecord;

    @FindBy(xpath = "//h1/span")
    public WebElement createdName;

    @FindBy(xpath = "//span[contains(text(),'Ok')]")
    public WebElement discardOK;

    Faker faker = new Faker();

    public void fillCustomer() {

        nameBox.sendKeys(faker.name().firstName());
        streetBox.sendKeys(faker.country().name());
        cityBox.sendKeys(faker.country().capital());
    }


    public void clickButtons(String buttonName) {

        if (buttonName.equalsIgnoreCase("create")) {
            CreateButton.click();
        } else if (buttonName.equalsIgnoreCase("import")) {
            ImportButton.click();
        } else if (buttonName.equalsIgnoreCase("edit")) {
            EditButton.click();
        } else if (buttonName.equalsIgnoreCase("save")) {
            SaveButton.click();
        } else if (buttonName.equalsIgnoreCase("previous")) {
            previousButton.click();
        } else if (buttonName.equalsIgnoreCase("kanban")) {
            KanbanButton.click();
        } else if (buttonName.equalsIgnoreCase("list")) {
            ListButton.click();
        } else if (buttonName.equalsIgnoreCase("next")) {
            nextButton.click();
        } else if (buttonName.equalsIgnoreCase("discard")) {
            DiscardButton.click();
        }


    }

}









