package com.fidexio.pages;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PointOfSalePage extends BasePage {

    Faker faker= new Faker();
   // Select dropdown= new Select(OperationType);


    @FindBy(xpath = "//Input[contains(@placeholder, 'Create')]")
    public WebElement CreateButton;

    @FindBy(xpath ="//div[@class=\"o_form_buttons_edit\"]/button[1]")
    public WebElement SaveButton;

    @FindBy(xpath = "//div[@class=\"btn-group o_dropdown open\"]//a[1]")
    public WebElement ActionsDelete;

    @FindBy(xpath = "//div[@class=\"o_form_buttons_edit\"]/button[2]")
    public WebElement DiscardButton;

    @FindBy(xpath="//button[contains(text(),'Edit')]")
    WebElement EditButton;

    @FindBy(xpath ="//input[contains(@name, 'name')]")
    public WebElement NameBox;

    @FindBy(xpath= "//div[@class=\"btn-group btn-group-sm o_cp_switch_buttons\"]/button[2]")
    public WebElement KanbanButton;

    @FindBy(id= "(//div[@class=\"content-group mt16\"]//input)[2]")
    public WebElement OperationType;

    @FindBy(xpath="(//table//td[2])[1]") //tables
    public WebElement PointOfSale;

    @FindBy (xpath="//button[.='Ok']")
    public WebElement popupOK;



   // public void DropDown(){

    //    dropdown.selectByIndex(1);


  //  }



    public void clickButtons(String buttonName){

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
        else if (buttonName.equals("Delete under Actions dropdown")){
            ActionsDelete.click();
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

   }