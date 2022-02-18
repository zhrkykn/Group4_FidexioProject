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

import java.util.List;

public abstract class BasePage {


    @FindBy(css = "div[class='o_loading']")
    @CacheLookup
    protected WebElement loading;

    @FindBy(css = "span[class='oe_topbar_name']")
    public WebElement userName;

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
        List<WebElement> elements = Driver.get().findElements(By.xpath("//span[contains(text(),'Discuss')]/../../../li/a"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
            if(element.getText().equalsIgnoreCase(a)) {
                element.click();
                return;
            }
            else if(element.getText().equalsIgnoreCase("More")){
                Driver.get().findElement(By.cssSelector("#menu_more_container>a")).click();

                List<WebElement> elementsMore = Driver.get().findElements(By.cssSelector("#menu_more_container>ul>li>a>span"));

                for (WebElement webElement : elementsMore) {
                    System.out.println("webElement = " + webElement.getText());
                    if(webElement.getText().equalsIgnoreCase(a)) {
                        webElement.click();
                        return;
                    }
                }
            }
        }
    }
}


