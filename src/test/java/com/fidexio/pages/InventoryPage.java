package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(xpath = "/html/body/nav/div[2]/ul[1]/li[9]/ul/li[2]/a/span")
    public WebElement inventory;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[10]/ul[2]/li[1]/a/span")
    public WebElement product;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/button[1]")
    public WebElement create;
}
