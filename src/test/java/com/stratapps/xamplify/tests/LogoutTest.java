package com.stratapps.xamplify.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsVendor();

        if (!loginPage.isWelcomeDisplayed()) {
            throw new SkipException("Vendor login failed — skipping VendorLogoutTest");
        }
    }

    @Test
    public void verifyVendorLogout() {
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        Assert.assertTrue(
            driver.getCurrentUrl().toLowerCase().contains("login"),
            "Vendor logout failed: Login page not displayed"
        );
    }
}
