package com.smartcontact.demo;

import com.smartcontact.BaseTest;
import com.smartcontact.pages.ContactPage;
import com.smartcontact.pages.LandingPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by The on 01.06.2016.
 */
public class TestNewContact extends BaseTest{

    @BeforeMethod
    public void clickNewContact () throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.clickContact();

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        //jse.executeScript("arguments[0].focus()", getWrappedElement());
        jse.executeScript("window.scrollBy(0,-250)", "");
    }

    @Test
    public void createNewContactDiscardTest() throws InterruptedException {

        ContactPage contactPage = new ContactPage(getDriver());

        contactPage.typeFirstName("Pedro");
        contactPage.typeLastName("Gonzalez");
        contactPage.typeEmail("pedro" + System.nanoTime() + "@local.com");
        contactPage.typeBusinessPhone("12345678");
        Thread.sleep(1000);
        //contactPage.clickSave();

        contactPage.clickCancel();
        Thread.sleep(1000);
        //если кликнуть кансел то доп.попап с подтверждением
        contactPage.clickDiscardChanges();
    }

    @Test
    public void emptyContactSaveCheck() throws InterruptedException {

        ContactPage contactPage = new ContactPage(getDriver());
        contactPage.clickSave();
        Thread.sleep(1000);
        Assert.assertEquals(contactPage.getRequiredFirstNameValidationMessage(),"First name is required");
        Assert.assertEquals(contactPage.getRequiredLastNameValidationMessage(),"Last name is required");
        Assert.assertEquals(contactPage.getRequiredEmailOrPhoneValidationMessage(),"Either email or phone should be specified.");

        Assert.assertTrue(contactPage.checkFirstNameFieldIsDisplayed());

        contactPage.clickCancel();
    }
    @Test
    public void newContactFormTooltipsCheck (){
        ContactPage contactPage = new ContactPage(getDriver());
        Assert.assertEquals(contactPage.getToolTipSaveButton(),"Save");
        Assert.assertEquals(contactPage.getToolTipCancelButton(),"Close this window");

    }
}
