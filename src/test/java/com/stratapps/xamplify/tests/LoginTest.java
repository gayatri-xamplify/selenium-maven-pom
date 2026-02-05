package com.stratapps.xamplify.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginSuccessful() {
        // Login is already done by BaseTest using role parameter

        Assert.assertTrue(
            driver.getCurrentUrl().toLowerCase().contains("dashboard"),
            "Login failed: Dashboard not displayed"
        );
    }
}
