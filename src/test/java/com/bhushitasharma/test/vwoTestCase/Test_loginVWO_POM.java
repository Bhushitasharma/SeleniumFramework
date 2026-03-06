package com.bhushitasharma.test.vwoTestCase;

import com.bhushitasharma.pages.pageObjectModel.Project_1_vwo.DashboardPage;
import com.bhushitasharma.pages.pageObjectModel.Project_1_vwo.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;



public class Test_loginVWO_POM {
    @Owner("Bhushita")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegative(){
        WebDriver driver = new ChromeDriver();

        LoginPage loginPageVWO = new LoginPage(driver);
        String error_msg = loginPageVWO.LoginToVWOLoginInvalidCreds("admin@gmail.com" , "123");

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg , "Your email, password, IP address or location did not match");

    }

    @Owner("Bhushita")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginPositive(){
        WebDriver driver = new ChromeDriver();

        LoginPage loginPageVWO = new LoginPage(driver);
        loginPageVWO.LoginToVWOLoginvalidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");
        DashboardPage dashboardPage = new DashboardPage(driver);
        String usernameLoggedIn = dashboardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn , "Aman");


    }

}
