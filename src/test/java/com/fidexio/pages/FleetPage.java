package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;
import java.util.NoSuchElementException;

public class FleetPage extends BasePage{
    @FindBy(css = "#menu_more_container>a")
    public WebElement menuMore;


    //Vehicle module
    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement createButtonVehicle;

    @FindBy(xpath = "//div[@name='model_id']//input")
    public WebElement carModelVehicle;

    @FindBy(xpath = "//input[@name='license_plate']")
    public WebElement licensePlateVehicle;


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


    @FindBy(css = ".o_notification_title")
    public WebElement vehErr;

    @FindBy(xpath = "(//div[@data-menu-parent='134']//li/a)[3]")
    public WebElement vehicleCostsMenu;

    @FindBy(xpath = "(//*[@class=\'btn btn-primary btn-sm o_list_button_add\'])")
    public WebElement vehicleCostsCreate;

    @FindBy(xpath = "(//*[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement vehicleCostsVehicleDropdown;

    @FindBy(linkText = "Bmw/Serie 1/1-BMW-001")
    public WebElement vehicleCostsBmwSelect;

    @FindBy(xpath = "(//*[@class='o_input ui-autocomplete-input'])[2]")
    public WebElement vehicleCostsTypeDropdown;

    @FindBy(linkText = "Tax roll")
    public WebElement vehicleCostsTaxSelect;

    @FindBy(xpath = "(//*[@class='o_datepicker_input o_input'])")
    public WebElement vehicleCostsDate;

    @FindBy(xpath = "(//*[@class='o_field_float o_field_number o_field_widget o_input'])")
    public WebElement vehicleCostsTotalPrice;

    @FindBy(xpath = "(//*[@class='btn btn-primary btn-sm o_form_button_save'])")
    public WebElement vehicleCostsSave;

    @FindBy(xpath = "(//*[@class='active'])")
    public WebElement vehicleCostsSuccess;

    @FindBy(xpath = "(//*[@class='o_notification undefined o_error'])")
    public WebElement vehicleCostsErrorMessage;



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


    public void navInFleet(String leftSideMenuName){
        BrowserUtils.waitFor(2);
        for (WebElement menuName : fleetSideMenuOptions) {
            if(menuName.getText().equalsIgnoreCase(leftSideMenuName))
                menuName.click();
        }
    }


    @FindBy(xpath ="(//div[@data-menu-parent='134']//li/a)[9]")
    public WebElement vehicle_Model_Menu;

    @FindBy(xpath = "(//div/button)[5]")
    public WebElement vehMod_CreateButton;

    @FindBy(xpath = "(//*[@placeholder=\"e.g. Model S\"])")
    public WebElement modelName_Input;

    @FindBy(xpath = "//*[@class='o_input ui-autocomplete-input']")
    public WebElement vehMod_MakeDropdown;

    @FindBy(xpath = "(//*[@class=\"ui-menu-item\"])")
    public List<WebElement> vehMod_dropdownSelect;

    public WebElement vehMod_dropdownMeth(String makeType){

        WebElement forElse=null;
        for (WebElement element : vehMod_dropdownSelect) {
            if(element.getText().equalsIgnoreCase(makeType)){

                forElse=element;
            }

        }
        return forElse;

    }


    @FindBy(xpath = "//*[@class=\"btn btn-primary btn-sm o_form_button_save\"]")
    public WebElement vehMod_SaveButton;

    @FindBy(xpath = "//*[@class=\"o_field_char o_field_widget o_required_modifier\"]")
    public WebElement dynamicModelName;

    @FindBy(xpath = "(//div[@data-menu-parent='134']//li/a) [4]")
    public WebElement vehicleContractMenu;

    @FindBy(xpath = "(//*[@class=\"o_input ui-autocomplete-input\"])[1]")
    public WebElement vehicleContractDropdown;

    @FindBy(xpath = "(//*[@class=\"o_input ui-autocomplete-input\"])[1]")
    public WebElement vehicleAudiOption;


    @FindBy(xpath = "(//*[@class=\"btn btn-primary btn-sm o_form_button_save\"]")
    public WebElement saveButton;

    //@FindBy(xpath = "//*[@class=\"ui-menu-item\"])[2]")
    //public WebElement vehicleAudiOption;












}
