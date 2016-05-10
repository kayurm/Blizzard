package com.smartcontact.demo;


import com.smartcontact.BaseTest;
import com.smartcontact.pages.ContactPage;
import com.smartcontact.pages.LandingPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by The on 19.04.2016.
 */
public class TestLoginAndLanding extends BaseTest{

    private ArrayList expectedList = new ArrayList();

@BeforeMethod

    @Test
    public void newDropdownListCheck() throws InterruptedException {
        ArrayList actualList = new ArrayList();

        LandingPage landingPage = new LandingPage(getDriver());

        for (WebElement element1 : landingPage.getNewObjectList()){
            actualList.add(element1.getAttribute("innerText"));
        }

        //filling in of Expected list
        expectedList.add("Contact");
        expectedList.add("Company");
        expectedList.add("Email");
        expectedList.add("Meeting");
        expectedList.add("Task");

        Assert.assertEquals(actualList, expectedList);
    }


    @Test
    public void createNewContactTest() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.clickContact();

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

}
