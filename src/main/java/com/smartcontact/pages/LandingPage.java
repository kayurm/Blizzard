package com.smartcontact.pages;

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
public class LandingPage {

    private ExtendedWevDriver driver;
    private Wait<WebDriver> wait;
    private final String newObjectListLocator = ".//*[contains(@class,'ms-CommandBar-overflowMenu')]//a[contains(@class,'ng-binding')]";

    private final int timeOutInSeconds = 60;
    private final int sleepInMillis = 500;

    @FindBy (xpath = ".//*[@class='ms-CommandBarItem-linkWrapper']//*[contains(text(),'New')]/../i")
    private WebElement newButton;


    //@FindBys({@FindBy (xpath = ".//*[contains(@class,'is-open')]//*[contains(text(),'Contact')]/../.."), @FindBy(className = "ng-binding" )})
    @FindBy (xpath = newObjectListLocator)
    private List<WebElement> newObjectList;

    //constructor
    public LandingPage(ExtendedWevDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        // @param timeOutInSeconds The timeout in seconds when an expectation is called
        // @param sleepInMillis The duration in milliseconds to sleep between polls.
        wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
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
    public void clickContact() throws InterruptedException{
        getNewObjectList().get(0).click();

    }



    public WebElement waitUntilElementAppearVisible(WebElement webElement) {
        driver.turnImplicitlyWaitOff();
        WebElement result;
        try {
            result = wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException timeException) {
            driver.turnImplicitlyWaitOn();
            throw new TimeoutException(timeException.getMessage() +
                    "\nTimeOut while waitUntilElementAppearVisible " +
                    webElement.toString(), timeException.getCause());
        }
        driver.turnImplicitlyWaitOn();
        return result;
    }

    public WebElement waitUntilElementAppearVisible(By by) {
        driver.turnImplicitlyWaitOff();
        WebElement result;
        try {
            result = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException timeException) {
            driver.turnImplicitlyWaitOn();
            throw new TimeoutException(timeException.getMessage() +
                    "\nTimeOut while waitUntilElementAppearVisible " +
                    by.toString(), timeException.getCause());
        }
        driver.turnImplicitlyWaitOn();
        return result;
    }


}
