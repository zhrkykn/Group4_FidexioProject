package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public class FleetPage extends BasePage{
    @FindBy(css = "#menu_more_container>a")
    public WebElement menuMore;

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[21]")
    public WebElement fleet_Menu;

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

    @FindBy(xpath ="(//div[@data-menu-parent='134']//li/a)[9]")
    public WebElement vehicle_Model_Menu;

    @FindBy(xpath = "(//div/button)[5]")
    public WebElement vehMod_CreateButton;

    @FindBy(xpath = "(//*[@placeholder=\"e.g. Model S\"])")
    public WebElement modelName_Input;

}
