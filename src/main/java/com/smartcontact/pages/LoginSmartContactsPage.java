package com.smartcontact.pages;

import com.smartcontact.ExtendedWevDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by The on 17.04.2016.
 */
public class LoginSmartContactsPage extends BasePage {

    @FindBy (className ="ms-Button-label") private WebElement initialLoginButton;

    @FindBy (id = "cred_userid_inputtext") private WebElement userNameInputField;

    @FindBy (id = "cred_password_inputtext") private WebElement passwordInputField;

    @FindBy (id = "cred_sign_in_button") private WebElement signInSubmitButton;

    //constructor
    public LoginSmartContactsPage (ExtendedWevDriver driver){
        super(driver);
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
