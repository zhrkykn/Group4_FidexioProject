package com.fidexio.step_defs;

import com.fidexio.pages.ExpensesPage;
import com.fidexio.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
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
        Faker faker = new Faker();
        System.out.println("\n---- Starting to create an expense report ----");
        page.expenseReports.click();
        System.out.println("expenseReports clicked");
        BrowserUtils.waitFor(2);
        page.createButton.click();
        System.out.println("createButton clicked");
        BrowserUtils.waitFor(2);
        String expectedExpenseReportSummary = faker.commerce().productName();
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


    @When("The {string} {string} error message is displayed when Expense Report Summary left blank")
    public void the_error_message_is_displayed_when_Expense_Report_Summary_left_blank(String expectedErrorMessage1,String expectedErrorMessage2) {
        System.out.println("\n----- Navigating to Expense Page ------");
        BrowserUtils.waitFor(2);
        page.expensesModule.click();
        System.out.println("expensesModule clicked");


        // creates expense report
        System.out.println("\n---- Starting to create an expense report with a blank summary----");
        BrowserUtils.waitFor(2);
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
        BrowserUtils.waitFor(1);

        // this part for assertion
        //System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        String actualErrorMessage = page.notification.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Verify that error message is as expected", actualErrorMessage, expectedErrorMessage1 + "\n" + expectedErrorMessage2);
        System.out.println("---- The Blank Summary test PASSED -----");
    }

    @Then("The {string} {string} error message is displayed when Employee left blank")
    public void the_error_message_is_displayed_when_Employee_left_blank(String expectedErrorMessage1,String expectedErrorMessage2) {
        Faker faker = new Faker();
        // creates expense report with a blank employee
        System.out.println("\n---- Starting to create an expense report with a blank employee----");
        BrowserUtils.waitFor(1);
        page.discardButton.click();
        BrowserUtils.waitFor(1);
        page.okayButton.click();
        BrowserUtils.waitFor(1);
        page.createButton.click();
        BrowserUtils.waitFor(1);
        String expectedExpenseReportSummary = faker.commerce().material();
        BrowserUtils.waitFor(1);
        page.summaryInput.sendKeys(expectedExpenseReportSummary);
        System.out.println("summaryInput sent");
        BrowserUtils.waitFor(1);
        page.saveButton.click();
        System.out.println("saveButton clicked");
        BrowserUtils.waitFor(1);

        // this part for assertion
        String actualErrorMessage = page.notification.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        BrowserUtils.waitFor(2);

        Assert.assertEquals("Verify that error message is as expected", actualErrorMessage, expectedErrorMessage1 + "\n" + expectedErrorMessage2);
        System.out.println("---- The Blank Employee test PASSED -----");
    }



    @Then("The {string} error message is displayed when selecting expenses of another employee when approving an expense on Expenses to Approve page.")
    public void the_error_message_is_displayed_when_selecting_expenses_of_another_employee_when_approving_an_expense_on_Expenses_to_Approve_page(String expectedErrorMessage) {
        System.out.println("----- Navigating to Expense Page ------");
        BrowserUtils.waitFor(2);
        page.expensesModule.click();
        System.out.println("expensesModule clicked");
        BrowserUtils.waitFor(2);
        Faker faker = new Faker();

        // creates expense report
        System.out.println("\n---- Starting to create an expense report with the expense line with an unmatched employee ----");
        page.expenseReports.click();
        System.out.println("expenseReports clicked");
        BrowserUtils.waitFor(2);
        page.createButton.click();
        System.out.println("createButton clicked");
        BrowserUtils.waitFor(2);
        String expectedExpenseReportSummary = faker.commerce().material();
        BrowserUtils.waitFor(1);
        page.summaryInput.sendKeys(expectedExpenseReportSummary);
        System.out.println("summaryInput sent");
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

        for (WebElement e: page.employeeList) {
            if (!e.getText().equals(employeeName)) {
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
        BrowserUtils.waitFor(1);

        // this part for assertion
        String actualErrorMessage = page.expenseLinesErrorMessage.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Verify that error message is as expected", actualErrorMessage, expectedErrorMessage);
        System.out.println("\n---- The expense line with an unmatched employee test PASSED -----");
    }

}
