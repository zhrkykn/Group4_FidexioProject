package com.fidexio.step_defs;

import com.fidexio.pages.ExpensesPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExpensesRepStepDefs {

    static List<String> expenseReportToApproveListBefore;
    static List<String> expenseReportToApproveListAfter;
    static String employeeName;
    static WebElement employeeSelected;

    ExpensesPage expensesPage = new ExpensesPage();
    Faker faker = new Faker();

    @When("The user clicks on the Expenses from modules")
    public void the_user_clicks_on_the_Expenses_from_modules() {
        System.out.println("\n----- Navigating to Expense Page ------");
        BrowserUtils.waitFor(2);

        try{
            expensesPage.expensesModule.click();
        }
        catch (Exception e){
            expensesPage.nav("Expenses");
        }

        System.out.println("expensesModule clicked");
        BrowserUtils.waitFor(2);
    }

    @When("The user clicks on the Summary Report to Approve button")
    public void the_user_clicks_on_the_Summary_Report_to_Approve_button() {
        BrowserUtils.waitFor(1);
        expensesPage.toApprove.click();
        System.out.println("toApprove clicked");
    }

    @When("The user creates an expense report before list")
    public void the_user_creates_an_expense_report_before_list() {
        BrowserUtils.waitFor(1);
        expenseReportToApproveListBefore = BrowserUtils.getElementsText(expensesPage.reportList);
    }

    @When("The user clicks on the Expense Report button")
    public void the_user_clicks_on_the_Expense_Report_button() {
        BrowserUtils.waitFor(1);
        expensesPage.expenseReports.click();
        System.out.println("expenseReports clicked");
    }

    @When("The user clicks on the Create button")
    public void the_user_clicks_on_the_Create_button() {
        BrowserUtils.waitFor(1);
        expensesPage.createButton.click();
        System.out.println("createButton clicked");
    }

    @When("The user enters the summary")
    public void the_user_enters_the_summary() {
        String expectedExpenseReportSummary = faker.commerce().productName();
        BrowserUtils.waitFor(1);
        expensesPage.summaryInput.sendKeys(expectedExpenseReportSummary);
        BrowserUtils.waitFor(2);
        System.out.println("summaryInput sent");
    }


    @Then("The user clicks on the employee input")
    public void the_user_clicks_on_the_employee_input() {
        BrowserUtils.waitFor(1);
        expensesPage.employeeDropdown.click();
    }
    @Then("The user selects an employee from dropdown")
    public void the_user_selects_an_employee_from_dropdown() {
        int indexEmployee = (int) ((Math.random() * 6)+1);
        employeeSelected = expensesPage.employeeDropdownOptions.get(indexEmployee);
        System.out.println("employee Selected");
    }

    @Then("The user holds the selected employee name")
    public void the_user_holds_the_selected_employee_name() {
        BrowserUtils.waitFor(1);
        employeeName = employeeSelected.getText();
        System.out.println("employee selected AS " + employeeName);
    }

    @Then("The user clicks on the selected employee name")
    public void the_user_clicks_on_the_selected_employee_name() {
        BrowserUtils.waitFor(1);
        employeeSelected.click();
        System.out.println("employee clicked");
    }

    @Then("The user clicks on the Save button")
    public void the_user_clicks_on_the_Save_button() {
        BrowserUtils.waitFor(1);
        expensesPage.saveButton.click();
        System.out.println("saveButton clicked");
        BrowserUtils.waitFor(1);
    }

    @Then("The user creates an expense report after list")
    public void the_user_creates_an_expense_report_after_list() {
        BrowserUtils.waitFor(1);
        expenseReportToApproveListAfter = BrowserUtils.getElementsText(expensesPage.reportList);
    }


    @Then("Verify that the after list's size is one more than before list's size")
    public void verify_that_the_after_list_s_size_is_one_more_than_before_list_s_size() {
        BrowserUtils.waitFor(1);
        System.out.println("expenseReportToApproveListAfter.size() = " + expenseReportToApproveListAfter.size());
        System.out.println("expenseReportToApproveListBefore.size() = " + expenseReportToApproveListBefore.size());
        Assert.assertEquals("Verify that expense report list is increased 1", expenseReportToApproveListBefore.size(), expenseReportToApproveListAfter.size()-1);
    }


    @Then("The user removes the first element of after list")
    public void the_user_removes_the_first_element_of_after_list() {
        BrowserUtils.waitFor(1);
        expenseReportToApproveListAfter.remove(0);
    }

    @Then("Verify that two lists' elements are exactly same")
    public void verify_that_two_lists_elements_are_exactly_same() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue("Verify that new expense report is created", CollectionUtils.isEqualCollection(expenseReportToApproveListBefore, expenseReportToApproveListAfter));
    }

    @Then("Verify that the {string} {string} error message is displayed")
    public void verify_that_the_error_message_is_displayed(String expectedErrorMessage1,String expectedErrorMessage2) {
        // this part for assertion
        String actualErrorMessage = expensesPage.notification.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Verify that error message is as expected", actualErrorMessage, expectedErrorMessage1 + "\n" + expectedErrorMessage2);
        System.out.println("---- The blank detail test PASSED -----");
    }

    @Then("The user deletes the created report")
    public void the_user_deletes_the_created_report() {
        // this part for deleting the event created
        BrowserUtils.waitFor(1);
        expensesPage.tickboxCreatedExpenseReport.click();
        BrowserUtils.waitFor(1);
        expensesPage.actionButton.click();
        BrowserUtils.waitFor(1);
        expensesPage.deleteAction.click();
        BrowserUtils.waitFor(1);
        expensesPage.okayButton.click();
        System.out.println("\n----- The created Expense Report has been deleted ------");
    }

    @When("The user clicks on the Discard button")
    public void the_user_clicks_on_the_Discard_button() {
        BrowserUtils.waitFor(1);
        expensesPage.discardButton.click();
    }

    @When("The user clicks on the Okay button")
    public void the_user_clicks_on_the_Okay_button() {
        BrowserUtils.waitFor(1);
        expensesPage.okayButton.click();
    }


    @Then("The user clicks on the Add Item Expense")
    public void the_user_clicks_on_the_Add_Item_Expense() {
        BrowserUtils.waitFor(1);
        expensesPage.addItemExpense.click();
        System.out.println("addItemExpense clicked");
    }

    @Then("The user clicks on the list of an unmatched employee name")
    public void the_user_clicks_on_the_list_of_an_unmatched_employee_name() {
        BrowserUtils.waitFor(1);
        List<String> employeeNameList = BrowserUtils.getElementsText(expensesPage.employeeList);

        for (WebElement e: expensesPage.employeeList) {
            if (!e.getText().equals(employeeName)) {
                String name = e.getText();
                System.out.println("employeeName on the Expense Lines found AS " + name);
                BrowserUtils.waitFor(1);
                e.click();
                break;
            }
        }
    }

    @Then("Verify that the {string} error message should be displayed")
    public void verify_that_the_error_message_should_be_displayed(String expectedErrorMessage) {
        // this part for assertion
        String actualErrorMessage = expensesPage.expenseLinesErrorMessage.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Verify that error message is as expected", actualErrorMessage, expectedErrorMessage);
        System.out.println("\n---- The expense line with an unmatched employee test PASSED -----");
    }
}
