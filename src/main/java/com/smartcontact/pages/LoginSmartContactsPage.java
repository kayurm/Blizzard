package com.smartcontact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by The on 17.04.2016.
 */
public class LoginSmartContactsPage {
    private WebDriver driver;

    //TODO!!!!!!!!!!!!!!!!!!!!!
    @FindBy (className ="ms-Button-label")
    private WebElement initialLoginButton;

    @FindBy (id = "cred_userid_inputtext")
    private WebElement userNameInputField;

    @FindBy (id = "cred_password_inputtext")
    private WebElement passwordInputField;

    @FindBy (id = "cred_sign_in_button")
    private WebElement signInSubmitButton;

    //constructor
    public LoginSmartContactsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //methods
    public void clickInitialLogIn (){
        initialLoginButton.click();
    }

    public void typeUserNameField (String userName){
        userNameInputField.sendKeys(userName);
    }

    public void typePasswordField (String password){
        passwordInputField.sendKeys(password);
    }

    public void clickSubmit (){
        signInSubmitButton.click();
    }

}
