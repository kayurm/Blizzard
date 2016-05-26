package com.smartcontact.pages;

import com.smartcontact.ExtendedWevDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by The on 28.04.2016.
 */
public class ContactPage extends  BasePage{

    @FindBy(id="FirstName")
    private WebElement firstNameField;

    @FindBy (id="LastName")
    private WebElement lastName;

    @FindBy (id="Email")
    private WebElement email;

    @FindBy (id="BusinessPhone")
    private WebElement businessPhone;

    @FindBy (id="save-contact-button")
    private WebElement saveButton;

    @FindBy (id="create-contact-cancel-button")
    private WebElement cancelButton;

    @FindBy (id="close-discard-changes-discard-button")
    private WebElement discardChangesButton;

    @FindBy (xpath="//div[contains(@invalid,'createEditContact.FirstName.$error.required')]")
    private WebElement requiredFirstNameMessage;
    //div[contains(@class,'ms-Panel-contentInner')]//
    // (xpath="//div[contains(Text(),'First name is required')]")

    @FindBy (xpath="//div[contains(@invalid,'createEditContact.LastName.$error.required')]")
    private WebElement requiredLastNameMessage;

    @FindBy (xpath="//div[contains(@invalid,'createEditContact.$error.requiredFields')]")
    private WebElement requiredEmailOrPhone;

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
        this.lastName.sendKeys(lastName);
    }

    public void typeEmail (String email){
        this.email.sendKeys(email);
    }

    public void typeBusinessPhone (String businessPhone){
        this.businessPhone.sendKeys(businessPhone);
    }

    public void clickSave (){
        focus(saveButton);
        saveButton.click();
    }

    public String getToolTipSaveButton() {
        return getToolTip(saveButton);
    }

    public void clickCancel (){
        cancelButton.click();
    }

    public void clickDiscardChanges(){
        discardChangesButton.click();
    }

    public String getRequiredFirstNameMessage(){

        return requiredFirstNameMessage.getText();
    }

    public String getRequiredLastNameMessage(){
        return requiredLastNameMessage.getText();
    }

    public String getRequiredEmailOrPhone(){
        return requiredEmailOrPhone.getText();
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
