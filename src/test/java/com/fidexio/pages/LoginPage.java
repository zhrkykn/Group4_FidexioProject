package com.fidexio.pages;

import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

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



}