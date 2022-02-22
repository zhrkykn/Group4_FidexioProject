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
