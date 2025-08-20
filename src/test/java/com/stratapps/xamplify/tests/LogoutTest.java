package com.stratapps.xamplify.tests;


import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
       
    	    LogoutPage logoutPage = new LogoutPage(driver);
    	    logoutPage.logout();
    	}
}
