package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {


    @FindBy(xpath = "(//span[contains(text(),'Products')])[7]")
    public WebElement product;
    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement create;
}
