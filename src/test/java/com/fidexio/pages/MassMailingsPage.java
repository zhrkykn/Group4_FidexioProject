package com.fidexio.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class MassMailingsPage extends BasePage {
    Faker faker=new Faker();
    Random random=new Random();


    @FindBy (css = "input[name='name']")
    public WebElement subjectBox;

    @FindBy (css = ".o_kanban_view.o_kanban_ungrouped>div.oe_kanban_color_0.oe_kanban_card.oe_kanban_global_click.oe_kanban_mass_mailing.o_kanban_record")
    public List<WebElement> massMailingList;


    @FindBy(xpath = "//span[@name='name']")
    public WebElement editedName;

    @FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement countMailings;


   public static String beforeMassSize;



    public void getRandomMassMailing(){

        int randomMassMailings = random.nextInt(massMailingList.size());
        massMailingList.get(randomMassMailings).click();
    }






}
