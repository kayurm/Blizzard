package com.smartcontact;

import com.smartcontact.pages.LoginSmartContactsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by alexanderch on 04/21/2016.
 */
public class BaseTest {

    private ExtendedWevDriver driver;
    private String startUrl;
    private String password;
    private String email1;
    private long timeoutWait;

    @BeforeClass
    public void setUp(ITestContext context) throws InterruptedException {

        //here we added ITestContext context
        password = context.getCurrentXmlTest().getParameter("password");
        email1 = context.getCurrentXmlTest().getParameter("email1");
        startUrl = context.getCurrentXmlTest().getParameter("startUrl");
        timeoutWait =  Long.parseLong(context.getCurrentXmlTest().getParameter("implicitlyWait.ms"));

        driver = new ExtendedWevDriver(timeoutWait);
        driver.get(startUrl);

        LoginSmartContactsPage loginSmartContactsPage = new LoginSmartContactsPage(driver);

        loginSmartContactsPage.clickInitialLogIn();
        loginSmartContactsPage.typeUserNameField(email1);
        loginSmartContactsPage.typePasswordField(password);
        Thread.sleep(1000);
        loginSmartContactsPage.clickSubmit();

        Thread.sleep(20000);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    public String getStartUrl() {
        return startUrl;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail1() {
        return email1;
    }

    public ExtendedWevDriver getDriver() {
        return driver;
    }

}
