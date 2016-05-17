package com.smartcontact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by alexanderch on 05/05/2016.
 */
public class ExtendedWevDriver implements WebDriver {
    private WebDriver driver;
    private long implicitlyWait;

    public ExtendedWevDriver(long implicitlyWait) {
        this.implicitlyWait = implicitlyWait;
        FirefoxProfile profile = new FirefoxProfile();

//        profile.setEnableNativeEvents(true);
//        profile.setAssumeUntrustedCertificateIssuer(true);
//        profile.setAcceptUntrustedCertificates(true);


        driver = new FirefoxDriver(profile);
        this.manage().timeouts().implicitlyWait(getImplicitlyWait(), TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    public void turnImplicitlyWaitOff() {
        this.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    public void turnImplicitlyWaitOn() {
        this.manage().timeouts().implicitlyWait(getImplicitlyWait(), TimeUnit.MILLISECONDS);
    }

    public long getImplicitlyWait() {
        return implicitlyWait;
    }

    public void setImplicitlyWait(long implicitlyWait) {
        this.implicitlyWait = implicitlyWait;
    }

    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

}
