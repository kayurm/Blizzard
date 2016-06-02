package com.smartcontact.pages;

import com.smartcontact.ExtendedWevDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by The on 28.04.2016.
 */
public class ContactPage extends  BasePage{

    @FindBy(id="FirstName") private WebElement firstNameField;

    @FindBy (id="LastName") private WebElement lastNameField;

    @FindBy (id="Email") private WebElement emailField;

    @FindBy (id="BusinessPhone") private WebElement businessPhoneField;

    @FindBy (id="save-contact-button") private WebElement saveButton;

    @FindBy (id="create-contact-cancel-button") private WebElement cancelButton;

    @FindBy (id="close-discard-changes-discard-button") private WebElement discardChangesButton;

    @FindBy (xpath="//div[contains(@invalid,'createEditContact.FirstName.$error.required')]")
    private WebElement requiredFirstNameValidationMessage;

    @FindBy (xpath="//div[contains(@invalid,'createEditContact.LastName.$error.required')]")
    private WebElement requiredLastNameValidationMessage;

    @FindBy (xpath="//div[contains(@invalid,'createEditContact.$error.requiredFields')]")
    private WebElement requiredEmailOrPhoneValidationMessage;

    @FindBy(xpath = ".//*[@name='createEditContact']//div[@class='smc-Form-Row smc-Form-Width-Small']")
    private WebElement validationContainer;

    //constructor
    public ContactPage (ExtendedWevDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void typeFirstName (String firstName){
        focus(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    public void typeLastName (String lastName){
        this.lastNameField.sendKeys(lastName);
    }

    public void typeEmail (String email){
        this.emailField.sendKeys(email);
    }

    public void typeBusinessPhone (String businessPhone){
        this.businessPhoneField.sendKeys(businessPhone);
    }

    public void clickSave (){
        focus(saveButton);
        saveButton.click();
    }

    public String getToolTipSaveButton() {
        return getToolTip(saveButton);
    }
    public String getToolTipCancelButton() {
        return getToolTip(cancelButton);
    }

    public void clickCancel (){
        cancelButton.click();
    }

    public void clickDiscardChanges(){
        discardChangesButton.click();
    }

    public String getRequiredFirstNameValidationMessage(){

        return requiredFirstNameValidationMessage.getText();
    }

    public String getRequiredLastNameValidationMessage(){
        return requiredLastNameValidationMessage.getText();
    }

    public String getRequiredEmailOrPhoneValidationMessage(){
        return requiredEmailOrPhoneValidationMessage.getText();
    }

    public boolean checkFirstNameFieldIsDisplayed (){
       return isDisplayed(firstNameField);
    }

    public boolean isValidationsDisplayed() {
        return isDisplayed(validationContainer);
    }

    public List<WebElement> validationList() {
        List<WebElement> resultList = new ArrayList<WebElement>();
        waitUntilElementAppearVisible(validationContainer);
        for(WebElement element : validationContainer.findElements(By.className("smc-Error"))){
            if (isQDisplayed(element))
                resultList.add(element);
        }
        return  resultList;
    }




}
