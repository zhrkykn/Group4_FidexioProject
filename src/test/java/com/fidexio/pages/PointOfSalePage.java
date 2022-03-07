package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import com.github.dockerjava.api.model.Driver;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PointOfSalePage extends BasePage {

    Faker faker= new Faker();
   // Select dropdown= new Select(OperationType);



    @FindBy(xpath = "//button[contains(text(), 'Create')]")
    public WebElement CreateButton;

    @FindBy(xpath ="//div[@class=\"o_form_buttons_edit\"]/button[1]")
    public WebElement SaveButton;

    @FindBy(xpath = "(//button[@data-toggle=\"dropdown\"])[3]")
    public WebElement ActionsDropDown;

    @FindBy( xpath= "//a[@data-section=\"other\"]")
    public List<WebElement> DropDownElements;

    @FindBy(xpath = "//div[@class=\"o_form_buttons_edit\"]/button[2]")
    public WebElement DiscardButton;

    @FindBy(xpath="//button[contains(text(),'Edit')]")
    public WebElement EditButton;

    @FindBy(xpath ="//input[contains(@name, 'name')]")
    public WebElement NameBox;

    @FindBy(xpath= "//div[@class=\"btn-group btn-group-sm o_cp_switch_buttons\"]/button[2]")
    public WebElement KanbanButton;

    @FindBy(xpath= "(//input[@class=\"o_input ui-autocomplete-input\"])[16]")
    public WebElement OperationType;

    @FindBy(xpath="//li[@class=\"ui-menu-item\"]")
    public List<WebElement> OperationTypeDropDowns;

    @FindBy(xpath="(//table//td[2])[1]") //tables
    public WebElement PointOfSale;

    @FindBy (xpath="//button[.='Ok']")
    public WebElement popupOK;

    @FindBy(xpath="//h4[@class=\"modal-title\"]")
    public WebElement ErrorMessage;




        public void DropDown(){

           ActionsDropDown.click();
           BrowserUtils.waitFor(3);

           DropDownElements.get(0).click();


        }

   // String buttonName;

    public void clickButtons (String buttonName){

        if(buttonName.equals("Create")){
            CreateButton.click();
        }
        else if(buttonName.equals("Discard")){
            DiscardButton.click();
        }
        else if(buttonName.equals("Edit")){
            EditButton.click();
        }
        else if(buttonName.equals("Save")){
            SaveButton.click();
        }
        else if (buttonName.equals("Kanban")){
            KanbanButton.click();
        }
        else if (buttonName.equals("one of the PointOfSale"))
            PointOfSale.click();

        else if (buttonName.equals("pop-up OK")){
            popupOK.click();
        }
    }


    public void enterName() {

        String name= faker.company().name();
        NameBox.clear();
        NameBox.sendKeys(name);

    }
    //public String currentName(){
      // BrowserUtils.waitFor(3);
       //EditButton.click();
       //String name= NameBox.getText();
       //BrowserUtils.waitFor(2);
        //SaveButton.click();
        //return name;
    //}

   }