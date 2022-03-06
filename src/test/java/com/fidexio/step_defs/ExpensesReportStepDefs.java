package com.fidexio.step_defs;

import com.fidexio.pages.ExpensesPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ExpensesReportStepDefs {

    ExpensesPage page = new ExpensesPage();

    @Then("The user creates an Expenses Report Summary for each employee")
    public void the_user_creates_an_Expenses_Report_Summary_for_each_employee() {
        System.out.println("----- Navigating to Expense Report Create display ------");
        BrowserUtils.waitFor(2);
        page.expensesModule.click();
        System.out.println("expensesModule clicked");
        BrowserUtils.waitFor(2);

        // holds expense report size
        page.toApprove.click();
        System.out.println("toApprove clicked");
        BrowserUtils.waitFor(1);
        List<String> expenseReportToApproveListBefore = BrowserUtils.getElementsText(page.reportList);
        BrowserUtils.waitFor(2);

        // creates expense report
        System.out.println("\n---- Starting to create an expense report ----");
        page.expenseReports.click();
        System.out.println("expenseReports clicked");
        BrowserUtils.waitFor(2);
        page.createButton.click();
        System.out.println("createButton clicked");
        BrowserUtils.waitFor(2);
        String expectedExpenseReportSummary = "Trip to London";
        BrowserUtils.waitFor(1);
        page.summaryInput.sendKeys(expectedExpenseReportSummary);
        BrowserUtils.waitFor(2);
        System.out.println("summaryInput sent");
        page.employeeDropdown.click();
        BrowserUtils.waitFor(1);
        WebElement employeeSelected = page.employeeDropdownOptions.get((int) ((Math.random() * 6)+1));
        BrowserUtils.waitFor(1);
        String employeeName = employeeSelected.getText();
        BrowserUtils.waitFor(1);
        employeeSelected.click();
        System.out.println("employee selected AS " + employeeName);
        BrowserUtils.waitFor(1);
        page.addItemExpense.click();
        System.out.println("addItemExpense clicked");
        BrowserUtils.waitFor(2);
        List<String> employeeNameList = BrowserUtils.getElementsText(page.employeeList);

        while (!employeeNameList.contains(employeeName)) {
            page.nextPageExpenseLines.click();
            System.out.println("nextPageExpenseLines clicked");
            BrowserUtils.waitFor(2);
            employeeNameList = BrowserUtils.getElementsText(page.employeeList);
            BrowserUtils.waitFor(2);
        }

        for (WebElement e: page.employeeList) {
            if (e.getText().equals(employeeName)) {
                String name = e.getText();
                System.out.println("employeeName on the Expense Lines found AS " + name);
                BrowserUtils.waitFor(1);
                e.click();
                break;
            }
        }

        BrowserUtils.waitFor(1);
        page.saveButton.click();
        System.out.println("saveButton clicked");
        BrowserUtils.waitFor(2);

        // this part for assertion
        page.toApprove.click();
        BrowserUtils.waitFor(1);
        List<String> expenseReportToApproveListAfter = BrowserUtils.getElementsText(page.reportList);
        BrowserUtils.waitFor(1);
//        for (String s: expenseReportToApproveListAfter) {
//            System.out.println("expenseReportToApproveListAfter = " + s);
//        }
//        System.out.println("");
//        for (String s: expenseReportToApproveListBefore) {
//            System.out.println("expenseReportToApproveListBefore = " + s);
//        }
        Assert.assertEquals("Verify that expense report list is increased 1", expenseReportToApproveListBefore.size(), expenseReportToApproveListAfter.size()-1);
        BrowserUtils.waitFor(1);
        expenseReportToApproveListAfter.remove(0);
        Assert.assertTrue("Verify that new expense report is created", CollectionUtils.isEqualCollection(expenseReportToApproveListBefore, expenseReportToApproveListAfter));
        BrowserUtils.waitFor(1);
        System.out.println("\n----- The Expense Report has been created ------");

        // this part for deleting the event created
        BrowserUtils.waitFor(1);
        page.tickboxCreatedExpenseReport.click();
        BrowserUtils.waitFor(1);
        page.actionButton.click();
        BrowserUtils.waitFor(1);
        page.deleteAction.click();
        BrowserUtils.waitFor(1);
        page.okayButton.click();
        System.out.println("\n----- The created Expense Report has been deleted ------");

    }


    @When("The {string} error message is displayed when Expense Report Summary left blank")
    public void the_error_message_is_displayed_when_Expense_Report_Summary_left_blank(String string) {
        System.out.println("----- Navigating to Expense Report Create display ------");
        BrowserUtils.waitFor(2);

        // creates expense report
        System.out.println("\n---- Starting to create an expense report with a blank summary----");
        page.expenseReports.click();
        System.out.println("expenseReports clicked");
        BrowserUtils.waitFor(2);
        page.createButton.click();
        System.out.println("createButton clicked");
        BrowserUtils.waitFor(2);
        page.employeeDropdown.click();
        BrowserUtils.waitFor(1);
        WebElement employeeSelected = page.employeeDropdownOptions.get((int) ((Math.random() * 6)+1));
        BrowserUtils.waitFor(1);
        String employeeName = employeeSelected.getText();
        BrowserUtils.waitFor(1);
        employeeSelected.click();
        System.out.println("employee selected AS " + employeeName);
        BrowserUtils.waitFor(1);
        page.addItemExpense.click();
        System.out.println("addItemExpense clicked");
        BrowserUtils.waitFor(2);
        List<String> employeeNameList = BrowserUtils.getElementsText(page.employeeList);

        while (!employeeNameList.contains(employeeName)) {
            page.nextPageExpenseLines.click();
            System.out.println("nextPageExpenseLines clicked");
            BrowserUtils.waitFor(2);
            employeeNameList = BrowserUtils.getElementsText(page.employeeList);
            BrowserUtils.waitFor(2);
        }

        for (WebElement e: page.employeeList) {
            if (e.getText().equals(employeeName)) {
                String name = e.getText();
                System.out.println("employeeName on the Expense Lines found AS " + name);
                BrowserUtils.waitFor(1);
                e.click();
                break;
            }
        }

        BrowserUtils.waitFor(1);
        page.saveButton.click();
        System.out.println("saveButton clicked");
        BrowserUtils.waitFor(2);
    }

    @Then("The {string} error message is displayed when Employee left blank")
    public void the_error_message_is_displayed_when_Employee_left_blank(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Then("The {string} error message is displayed when selecting expenses of another employee when approving an expense on Expenses to Approve page.")
    public void the_error_message_is_displayed_when_selecting_expenses_of_another_employee_when_approving_an_expense_on_Expenses_to_Approve_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
