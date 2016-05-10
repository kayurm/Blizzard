package com.smartcontact.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by The on 17.04.2016.
 */
public class LandingPage {

    private WebDriver driver;

    @FindBy (xpath = ".//*[@class='ms-CommandBarItem-linkWrapper']//*[contains(text(),'New')]/../i")
    private WebElement newButton;


    //@FindBys({@FindBy (xpath = ".//*[contains(@class,'is-open')]//*[contains(text(),'Contact')]/../.."), @FindBy(className = "ng-binding" )})
    @FindBy (xpath = ".//*[contains(@class,'ms-CommandBar-overflowMenu')]//a[contains(@class,'ng-binding')]")
    private List<WebElement> newObjectList;

    //constructor
    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //method
    public void newDropdownListClick(){
        newButton.click();
    }

    public List<WebElement> getNewObjectList() throws InterruptedException {

        newDropdownListClick();
        Thread.sleep(1000);
        return newObjectList;
    }

    public void clickContact() throws InterruptedException{
        getNewObjectList().get(0).click();
    }
}
