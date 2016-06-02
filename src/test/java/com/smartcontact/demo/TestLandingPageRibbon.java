package com.smartcontact.demo;


import com.smartcontact.BaseTest;
import com.smartcontact.pages.ContactPage;
import com.smartcontact.pages.LandingPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by The on 19.04.2016.
 */
public class TestLandingPageRibbon extends BaseTest{

    private ArrayList expectedList = new ArrayList();

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
    public void countTest() throws InterruptedException {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.clickContact();

        ContactPage contactPage = new ContactPage(getDriver());

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        //jse.executeScript("arguments[0].focus()", getWrappedElement());
        jse.executeScript("window.scrollBy(0,-250)", "");

        contactPage.clickSave();

        System.out.println(contactPage.validationList().size());
        System.out.println(contactPage.validationList().get(0).getText());
        Thread.sleep(1000);


    }

}
