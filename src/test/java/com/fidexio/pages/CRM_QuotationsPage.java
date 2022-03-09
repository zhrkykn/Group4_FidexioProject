package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class CRM_QuotationsPage extends BasePage{


    @FindBy(xpath = "//tr[@class='o_data_row']")
    public List<WebElement> quotationsCheckBoxes;

    @FindBy(xpath = "//button[@accesskey='k']")
    public WebElement kanbanButton;

    @FindBy(xpath = "//button[@data-view-type='list']")
    public WebElement listButton;

    @FindBy(xpath = "//table[1]/tbody/tr[1]/td[2]/div")
    public WebElement requiredCustomer;

    @FindBy(xpath="//div[@class='o_loading']/following-sibling::*[1]//li[@class='ui-menu-item']")
    public List<WebElement> dropdownMenuItems;

    @FindBy (xpath="//button[contains(text(),'Action')]")
    public WebElement actionButton;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteButton;

    @FindBy(className = "o_pager_limit")
    public WebElement quotationCounter;

    @FindBy(xpath = "//span[contains(text(),'Ok')]")
    public WebElement okButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement cancelButton;

    @FindBy(xpath = "// small[contains(text(), 'now')]")
    public WebElement nowTimeStamp;

    @FindBy(xpath = "//*[@class=\"o_form_uri o_field_widget o_required_modifier\"]")
    public WebElement discardedCustomer;

    public static String beforeQuotationSize;
    public static String afterQuotationSize;
    public static String customer;



    public void clickButtons(String buttonName) {

        if (buttonName.equalsIgnoreCase("create")) {
            CreateButton.click();
        } else if (buttonName.equalsIgnoreCase("import")) {
            ImportButton.click();
        } else if (buttonName.equalsIgnoreCase("edit")) {
            EditButton.click();
        } else if (buttonName.equalsIgnoreCase("save")) {
            saveButton.click();
        } else if (buttonName.equalsIgnoreCase("discard")) {
            DiscardButton.click();
        } else if (buttonName.equalsIgnoreCase("delete")){
            deleteButton.click();
        }else if (buttonName.equalsIgnoreCase("Ok")){
            okButton.click();
        }else if (buttonName.equalsIgnoreCase("kanban")){
            kanbanButton.click();
        }else if (buttonName.equalsIgnoreCase("list")){
            listButton.click();
        }else if (buttonName.equalsIgnoreCase("cancel")) {
            cancelButton.click();
        }
    }



    Random random=new Random();


    public void getRandomQuotation(){

            int randomQuotation = random.nextInt(quotationsCheckBoxes.size());
            quotationsCheckBoxes.get(randomQuotation).click();
    }

    public void getActionDelete(){

        actionButton.click();
        deleteButton.click();
    }

    public void getRandomMenuItem(){

        int randomDropdownCustomer=random.nextInt(dropdownMenuItems.size());
        dropdownMenuItems.get(randomDropdownCustomer).click();
    }

    public void editQuotation(){

        requiredCustomer.click();
        getRandomMenuItem();
        waitUntilLoaderScreenDisappear();
    }

    public void searchFunction(String toBeSearched){

        searchBox.sendKeys(toBeSearched);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void getQuotationSize(){
        quotationCounter.getText();

    }


    //    public void getViewType(String viewName) {
//
//        if (viewName.equalsIgnoreCase("kanban")){
//            waitUntilLoaderScreenDisappear();
//            kanbanButton.click();
//        }else if (viewName.equalsIgnoreCase("list")){
//            listButton.click();
//        }
//    }



}
