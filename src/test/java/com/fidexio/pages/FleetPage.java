package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FleetPage extends BasePage {


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

}
