package com.stratapps.xamplify.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyVendorLogout() {
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        Assert.assertTrue(
            driver.getCurrentUrl().toLowerCase().contains("login"),
            "Logout failed: Login page not displayed"
        );
    }
}
