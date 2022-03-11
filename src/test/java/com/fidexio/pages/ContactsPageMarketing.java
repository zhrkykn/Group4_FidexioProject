package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPageMarketing extends BasePage{

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[13]")
    public WebElement emailMarketing;

    @FindBy(xpath = "//div[@data-menu-parent='180']/ul[2]/li[2]/a")
    public WebElement contactsButton;

    @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input']")
    public WebElement input;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//button[@accesskey='c'][@class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement createButton;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveContacts;

    @FindBy(xpath = "//button[@accesskey='k']")
    public WebElement kanbanView;

    @FindBy(xpath = "//button[@accesskey='j']")
    public WebElement discard;

    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement editContacts;

    @FindBy(xpath = "//*[@class='btn-group o_dropdown'][3]")
    public WebElement actionButton;

    @FindBy(xpath = "//a[@data-section='other']")
    public WebElement deleteButton;

    @FindBy(xpath = "//tr[@class='o_data_row']")
    public WebElement firstContact;

    @FindBy(xpath = "//*[@class='o_notification_manager']")
    public WebElement warningMessage;







}
