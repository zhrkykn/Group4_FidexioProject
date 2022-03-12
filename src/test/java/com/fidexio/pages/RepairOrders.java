package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class RepairOrders extends BasePage {
    Random random = new Random();

    @FindBy(xpath = "//div//table//tr[2]//td[2]//div[@name='product_id']//div//input")
////div[@name='product_id']//div//input
    public WebElement dropDown;
    @FindBy(xpath = "//div[@class='o_loading']/following-sibling::*[1]//li[@class='ui-menu-item']")
    public List<WebElement> productMenuItem;

    public void getMenuItem() {
        int menuItem = random.nextInt(productMenuItem.size());
        productMenuItem.get(menuItem).click();

    }


    public static String beforeRepairSize;

    @FindBy(css = ".o_pager_value")
    public WebElement listCounter;
    @FindBy(xpath = "//*[.='Repair Order created']")

    public WebElement createdMessage;
    @FindBy(xpath = "//*[@name='product_id']")
    public WebElement AfterEdited;
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> repairList;

    public void getRandomList() {

        int menuItem = random.nextInt(repairList.size());
        repairList.get(menuItem).click();
    }


}
