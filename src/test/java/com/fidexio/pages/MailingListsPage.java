package com.fidexio.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Timestamp;
import java.util.List;
import java.util.Random;

public class MailingListsPage extends BasePage {

    Faker faker=new Faker();
    Random random=new Random();



    @FindBy(xpath = "//Input[contains(@placeholder, 'e.g. Consumer Newsletter')]")
    public WebElement listNameBox;

    @FindBy (xpath = "//td/*[@class='o_checkbox']")
    public List <WebElement> checkboxesList;

    @FindBy (xpath = "//span[@class='o_stat_text']")
    public WebElement recipientsButton;

    @FindBy(xpath = "//Input[contains(@placeholder, 'e.g. John Smith')]")
    public WebElement customerNameBox;

    @FindBy(xpath = "//td/input[@name='email']")
    public WebElement emailBox;

    @FindBy (xpath = "//span[@class='o_pager_limit']")
    public WebElement counter;

    @FindBy (xpath = "//td[@class='o_data_cell o_required_modifier']")
    public List <WebElement> mailingListList;

    @FindBy (xpath = "//h1/span")
    public WebElement createdName;








    public void getFakerListName(){

        listNameBox.sendKeys(faker.ancient().hero());
    }


    public void getRandomMailingList(){

        int randomMailingList = random.nextInt(mailingListList.size());
        mailingListList.get(randomMailingList).click();
    }

    public void fillTheForm() {

        customerNameBox.sendKeys(faker.name().fullName());
        emailBox.sendKeys(faker.internet().emailAddress());

    }


    public static String beforeSize;
    public static String afterSize;
    public static String name;



}








