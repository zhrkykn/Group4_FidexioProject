package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class FleetPage extends BasePage{
    @FindBy(css = "#menu_more_container>a")
    public WebElement menuMore;


    @FindBy(xpath = "(//span[@class='oe_menu_text'])[21]")
    public WebElement fleet_Menu;

    @FindBy(xpath = "//div[@data-menu-parent='134']//li/a")
    public List<WebElement> fleetSideMenuOptions;

    @FindBy(xpath = "//span[contains(text(),'Vehicles Odometer')]")
    public WebElement vehiclesOdoButton;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement odoCreateButton;

    @FindBy(css = ".o_input_dropdown")
    public WebElement vehicleOdoName;

    @FindBy(linkText ="Opel/Astra/1-ACK-205")
    public WebElement vehicleOdoSelect;

    @FindBy(css=".o_field_float.o_field_number.o_field_widget.o_input.oe_inline")
    public WebElement odoValue;

    @FindBy(css=".o_datepicker_input.o_input")
    public WebElement odoDate;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement odoSaveButton;


    @FindBy(css =".o_notification.undefined.o_error")
    public WebElement odoError2;

    @FindBy(partialLinkText="Vehicles Services Logs")
    public WebElement vehicleServicesLogs;

    @FindBy(partialLinkText = "btn btn-primary btn-sm o_list_button_add")
    public WebElement createButton;

    @FindBy(id = "o_field_input_1159")
    public WebElement vehicleType;

    @FindBy(id = "o_field_input_1160")
    public WebElement serviceType;

    @FindBy(id ="o_field_input_1161")
    public WebElement totalPrice;

    @FindBy(id = "o_field_input_1162")
    public WebElement odometerValue;

    @FindBy(id = "o_field_input_1164")
    public WebElement date;

    @FindBy(id="o_field_input_1165")
    public WebElement purchaserName;

    @FindBy(id = "o_field_input_1166")
    public WebElement vendorName;

    @FindBy(id = "o_field_input_1167")
    public WebElement invoiceReference;

    @FindBy(partialLinkText = "btn btn-primary btn-sm o_form_button_save")
    public WebElement saveButton;

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
