package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(xpath = "/html/body/nav/div[2]/ul[1]/li[9]/ul/li[2]/a/span")
    public WebElement inventory;
    @FindBy(xpath = "(//span[contains(text(),'Products')])[7]")
    public WebElement product;
    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement create;
    @FindBy(css=".o_field_char.o_field_widget.o_input.o_required_modifier")
    public WebElement productName;
    @FindBy(xpath ="//table//select")
    public WebElement ProductType;
@FindBy(xpath = "//table[2]//tbody//tr//td[2]//div//input")
    public WebElement SalesPrice;
@FindBy(css=".btn.btn-primary.btn-sm.o_form_button_save")
    public WebElement SaveButton;
@FindBy(xpath ="//*[.='Product Template created']")
    public WebElement CreatedMessage;
@FindBy(css=".o_notification_title")
    public WebElement errorMessage;
@FindBy(css = ".o_searchview_input")
    public WebElement search;
@FindBy(xpath = "//span[text()='Scientific Calculator']")
    public WebElement scCalculator;
@FindBy(xpath = "//*[@name='lst_price']")
    public WebElement price;
}
