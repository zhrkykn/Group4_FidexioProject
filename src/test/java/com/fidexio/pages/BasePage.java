package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    @FindBy(css = "div[class='o_loading']")
    @CacheLookup
    protected WebElement loading;

    @FindBy(css = "span[class='oe_topbar_name']")
    public WebElement userName;

    @FindBy(linkText = "Log out")
    public WebElement logOutLink;


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
    public String getUserName(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }

    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }

}
