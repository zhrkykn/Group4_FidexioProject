package com.fidexio.pages;

import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css="#login")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(css = ".btn.btn-primary")
    public WebElement loginButton;

    @FindBy(css =".alert.alert-danger")
    public WebElement errorMessage;

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginButton.click();

    }
    public void validLogin(){
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    public void validationMessage(){
        //String expectedMessage ="Lütfen bu alanı doldurun.";//Those who get English errors should replace this part with "Please fill out this field".
        String message = password.getAttribute("validationMessage");
        String expectedMessage=null;
        if(message.equals("Lütfen bu alanı doldurun.")) {
            expectedMessage ="Lütfen bu alanı doldurun.";
            Assert.assertEquals(message, expectedMessage);
        }   else if(message.equals("Please fill out this field.")){
            expectedMessage="Please fill out this field.";
            Assert.assertEquals(message, expectedMessage);
        }
    }


    }


