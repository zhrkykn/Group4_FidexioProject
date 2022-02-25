package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;


import com.fidexio.utilities.Driver;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class FleetPage extends BasePage{
    @FindBy(css = "#menu_more_container>a")
    public WebElement menuMore;

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[21]")
    public WebElement fleet_Menu;
    // --> halid
    @FindBy(xpath = "//span[contains(text(),'Vehicles Fuel Logs')]")
    public WebElement vehicleFuelLog;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public WebElement importButton;

    @FindBy(css = "button.btn.btn-primary.btn-sm.o_list_button_add")
    public WebElement createButton;

    @FindBy(xpath = "//div[@class='o_input_dropdown']/input")
    public WebElement dropdownVehicle;

    @FindBy(xpath = "(//li[@class='ui-menu-item']/a)[2]")
    public WebElement vehicle;

    @FindBy(xpath = "//input[@name='liter']")
    public WebElement liter;

    @FindBy(xpath = "//input[@name='price_per_liter']")
    public WebElement pricePerLiter;

    @FindBy(xpath = "//input[@name='odometer']")
    public WebElement odometer;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='o_notification_manager']")
    public WebElement warningMessage;

    public void setCreateButton(){
        Driver.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        createButton.click();
    }

    public void setImportButton(){
        BrowserUtils.waitForVisibility(importButton,10);
    }

    //<-- halid

    public void clickFleet(){

        try {
            fleet_Menu.click();

        }catch (Exception e){

            menuMore.click();
            BrowserUtils.waitFor(1);
            fleet_Menu.click();
            BrowserUtils.waitForPageToLoad(5);
        }
    }
    public void clickFleet2(){
        try{
            menuMore.click();
            fleet_Menu.click();
        }catch (NoSuchElementException e){
            fleet_Menu.click();
            BrowserUtils.waitForPageToLoad(5);
        }
    }


}
