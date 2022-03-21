package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductNumbersPage  extends BasePage{

@FindBy(xpath = "//a[@data-menu='347']")
    public WebElement inventoryBtn;
@FindBy(xpath = "//a[@data-menu='378']")
    public WebElement inventoryProducts;
@FindBy(xpath = "//a[@data-menu='445']")
    public WebElement salesBtn;
@FindBy(xpath = "//a[@data-menu='457']")
    public WebElement salesProducts;
@FindBy(xpath = "//a[@data-menu='382']")
    public WebElement websiteBtn;
@FindBy(xpath = "//a[@data-menu='550']")
    public WebElement websiteProducts;
@FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement itemsOfAll;
@FindBy(xpath = "//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement removeBtn;


}
