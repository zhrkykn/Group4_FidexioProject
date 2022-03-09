package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExpensesPage extends BasePage{
    public ExpensesPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//nav/div[2]/ul[1]/li[9]/a")
    public WebElement expensesModule;

    @FindBy(xpath = "//div[9]/ul[1]/li[3]/a")
    public WebElement expenseReports;

    @FindBy(xpath = "//div[1]/div[9]/ul[2]/li/a")
    public WebElement toApprove;

    @FindBy(css = ".btn.btn-primary.btn-sm.o_list_button_add")
    public WebElement createButton;

    @FindBy(css = "[name=name]")
    public WebElement summaryInput;

    @FindBy(xpath = "//div[3]/table/tbody/tr[1]/td[2]/div/div/input")
    public WebElement employeeDropdown;

    @FindBy(xpath = "/html/body/ul[1]/li")
    public List<WebElement> employeeDropdownOptions;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@accesskey='j']")
    public WebElement discardButton;

    @FindBy(xpath = "//div[1]/div[2]/div[2]/div/div/div/table/tbody/tr")
    public List<WebElement> reportList;

    @FindBy(xpath = "/html/body/div[2]")
    public WebElement notification;

    @FindBy(xpath = "//div[2]/table/tbody/tr[1]/td/a")
    public WebElement addItemExpense;

    @FindBy(xpath = "//div/table/tbody/tr/td[4]")
    public List<WebElement> employeeList;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]")
    public WebElement expenseLinesErrorMessage;

    @FindBy(xpath = "//div/table/tbody/tr[1]/td[1]/div/input")
    public WebElement tickboxCreatedExpenseReport;

    @FindBy(xpath = "//div[1]/div[2]/div[2]/div/div[2]/button")
    public WebElement actionButton;

    @FindBy(xpath = "//div[2]/div[2]/div/div[2]/ul/li[2]")
    public WebElement deleteAction;

    @FindBy(xpath = "//div[5]/div/div/div[3]/button[1]")
    public WebElement okayButton;

    @FindBy(xpath = "(//button[@accesskey='n'])[2]")
    public WebElement nextPageExpenseLines;


}
