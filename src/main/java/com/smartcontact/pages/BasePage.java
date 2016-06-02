package com.smartcontact.pages;

import com.smartcontact.ExtendedWevDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexanderch on 05/24/2016.
 */
public class BasePage {
    private ExtendedWevDriver driver;
    private Wait<WebDriver> wait; //explicit wait

    private final int timeOutInSeconds = 60;
    private final int sleepInMillis = 500;

    public BasePage(ExtendedWevDriver driver) {
        this.driver = driver;
        // @param timeOutInSeconds The timeout in seconds when an expectation is called
        // @param sleepInMillis The duration in milliseconds to sleep between polls.
        wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
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

    public boolean isDisplayed(WebElement element) {
        try {
            if(element.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    public boolean isQDisplayed(WebElement element) {
        driver.turnImplicitlyWaitOff();
        try {
            if(element.isDisplayed()) {
                driver.turnImplicitlyWaitOn();
                return true;
            }
        } catch (Exception e) {
            driver.turnImplicitlyWaitOn();
            return false;
        }
        driver.turnImplicitlyWaitOn();
        return false;
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

    public void focus(WebElement element) {
        driver.focus(element);
    }

    public String getToolTip(WebElement element) {
        return element.getAttribute("title").toString();
    }
}
