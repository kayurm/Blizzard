package com.smartcontact.pages;

import com.smartcontact.BaseTest;
import com.smartcontact.ExtendedWevDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by The on 17.04.2016.
 */
public class LandingPage extends BasePage{

    @FindBy (xpath = ".//*[@class='ms-CommandBarItem-linkWrapper']//*[contains(text(),'New')]/../i")
    private WebElement newButton;


    //@FindBys({@FindBy (xpath = ".//*[contains(@class,'is-open')]//*[contains(text(),'Contact')]/../.."), @FindBy(className = "ng-binding" )})
    @FindBy (xpath = ".//*[contains(@class,'ms-CommandBar-overflowMenu')]//a[contains(@class,'ng-binding')]")
    private List<WebElement> newObjectList;

    @FindBy (xpath = ".//*[contains(@class,'ms-CommandBar-overflowMenu')]//*[contains(text(),'Contact')]")
    private WebElement contactButton;

    //constructor
    public LandingPage(ExtendedWevDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //method
    public void newDropdownListClick(){
        waitUntilElementAppearVisible(newButton);
        newButton.click();
    }

    public List<WebElement> getNewObjectList() throws InterruptedException {

        newDropdownListClick();
        return newObjectList;
    }

    //TODO change this logic GET(0) recall it
/*    public void clickContact() throws InterruptedException{
        getNewObjectList().get(0).click();

    }*/

    public void clickContact(){
        newDropdownListClick();
        waitUntilElementAppearVisible(contactButton);
        contactButton.click();

    }
}
