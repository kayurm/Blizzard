package com.smartcontact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by The on 28.04.2016.
 */
public class ContactPage {
    private WebDriver driver;

    @FindBy(id="FirstName")
    private WebElement firstName;

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

    //constructor
    public ContactPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void typeFirstName (String firstName){
        this.firstName.sendKeys(firstName);
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
        saveButton.click();
    }

    public void clickCancel (){
        cancelButton.click();
    }

    public void clickDiscardChanges(){
        discardChangesButton.click();
    }

}
