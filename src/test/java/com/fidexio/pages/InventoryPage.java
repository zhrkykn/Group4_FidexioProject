package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(xpath = "(//input[@class='o_input'])[2]")
    public WebElement costForProduct;
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
@FindBy(css=".o_thread_message_content>p")
    public WebElement errorMessage;
@FindBy(css = ".o_searchview_input")
    public WebElement search;
@FindBy(xpath = "//span[text()='Scientific Calculator']")
    public WebElement scCalculator;
@FindBy(xpath = "//*[@name='lst_price']")
    public List<WebElement> priceS;
}
