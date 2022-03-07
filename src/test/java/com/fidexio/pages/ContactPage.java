package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class ContactPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement nameForNewContact;

    @FindBy(css = ".o_searchview_input")
    public WebElement searchBar;

    @FindBy(xpath = "//tr[@class='o_data_row']/td[2]")
    public WebElement searchedName;

    @FindBy(css = ".o_data_input")
    public List<WebElement> listOfContacts;

    @FindBy(xpath = "//button[@aria-label='list']")
    public WebElement viewAsList;

    @FindBy(xpath = "//button[@aria-label='kanban']")
    public WebElement viewAsKanban;

    @FindBy(xpath = "//div[@class='table-responsive']//th")
    public List<WebElement> listViewHeader;

    @FindBy(xpath = "//div[@class='o_kanban_view o_res_partner_kanban o_kanban_ungrouped']")
    public WebElement kanbanDiv;

    @FindBy(xpath = "//button[contains(text(),'Discard')]")
    public WebElement discardButton;

    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    public WebElement editButton;

    @FindBy(xpath = "//div[@class='modal-footer']//button[1]")
    public WebElement okeyButton;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement actionButton;

    @FindBy(linkText = "Delete")
    public WebElement deleteSelection;

    public void searchingName(String name){
        waitUntilLoaderScreenDisappear();
        viewAsList.click();
        waitUntilLoaderScreenDisappear();
        searchBar.sendKeys(name, Keys.ENTER);
        BrowserUtils.waitFor(2);
    }
}
