package com.fidexio.pages;


import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {


    @FindBy(css = "div[class='o_loading']")
    @CacheLookup
    protected WebElement loading;

    @FindBy(css = "span[class='oe_topbar_name']")
    public WebElement userName;

    //save button for all vehicle page
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement saveButton;

    @FindBy(linkText = "Log out")
    public WebElement logOutLink;

    @FindBy(css = ".o_user_menu>a")
    public WebElement userProfileMenu;

    @FindBy(xpath = "//span[contains(text(),'Discuss')]/../../../li/a")
    public List<WebElement> menuItemsList;

    @FindBy(css = "#menu_more_container>a")
    public WebElement menuMore;

    @FindBy(css = "#menu_more_container>li")
    public List<WebElement> menuMoreList;


    public BasePage() {

        PageFactory.initElements(Driver.get(), this);
    }

    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loading));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }

    public void logOut() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }

    public void nav(String a){
        BrowserUtils.waitFor(2);
        List<WebElement> elements = Driver.get().findElements(By.xpath("//span[contains(text(),'Discuss')]/../../../li/a"));
        List<WebElement> elementsMore = new ArrayList<>();
        if( Driver.get().findElement(By.cssSelector("#menu_more_container>a")).isEnabled()){
            Driver.get().findElement(By.cssSelector("#menu_more_container>a")).click();
            elementsMore = Driver.get().findElements(By.cssSelector("#menu_more_container>ul>li>a>span"));
        }
        elements.addAll(elementsMore);
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(a)){
                element.click();
                break;
            }
        }

    }
    public void nav(String moduleName,String leftSideMenu){
        BrowserUtils.waitFor(2);
        List<WebElement> elements = Driver.get().findElements(By.xpath("//span[contains(text(),'Discuss')]/../../../li/a"));
        List<WebElement> elementsMore = new ArrayList<>();
        if( Driver.get().findElement(By.cssSelector("#menu_more_container>a")).isEnabled()){
            Driver.get().findElement(By.cssSelector("#menu_more_container>a")).click();
            elementsMore = Driver.get().findElements(By.cssSelector("#menu_more_container>ul>li>a>span"));
        }
        elements.addAll(elementsMore);
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(moduleName)){
                element.click();
                break;
            }
        }

        List<WebElement> sideMenus = Driver.get().findElements(By.xpath("//div[@class='oe_secondary_menu']//li"));
        BrowserUtils.waitFor(2);
        for (WebElement sideMenu : sideMenus) {
            if (sideMenu.getText().equalsIgnoreCase(leftSideMenu)){
                sideMenu.click();
                return;
            }
        }

        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
    }




}

