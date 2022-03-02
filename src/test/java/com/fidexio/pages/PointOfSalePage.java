package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PointOfSalePage extends BasePage {

    @FindBy(xpath = "//a[@data-menu=\"484\"]/span")
    public WebElement PointOfSales;

    @FindBy(xpath= "//a[@data-menu=\"496\"]/span")
    public WebElement PointOfSalesLeft;

    @FindBy(xpath = "//div[@class=\"o_list_buttons\"]/button[1]")
    public WebElement CreateButton;

    @FindBy(xpath ="//div[@class=\"o_form_buttons_edit\"]/button[1]")
    public WebElement SaveButton;

    @FindBy(xpath = "//div[@class=\"btn-group o_dropdown open\"]//a[1]")
    public WebElement ActionsDelete;

    @FindBy(xpath = "//div[@class=\"o_form_buttons_edit\"]/button[2]")
    public WebElement DiscardButton;

    @FindBy(xpath = "//div[@class=\"oe_title\"]//input")
    public WebElement PointOfSaleName;

    @FindBy(xpath= "//div[@class=\"btn-group btn-group-sm o_cp_switch_buttons\"]/button[2]")
    public WebElement KanbanButton;

    @FindBy(id= "(//div[@class=\"content-group mt16\"]//input)[2]")
    public List<WebElement> OperationType;








}
