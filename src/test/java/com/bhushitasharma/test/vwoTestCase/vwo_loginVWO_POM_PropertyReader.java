package com.bhushitasharma.test.vwoTestCase;

import com.bhushitasharma.pages.pageObjectModel.Project_1_vwo.DashboardPage;
import com.bhushitasharma.pages.pageObjectModel.Project_1_vwo.LoginPage;
import com.bhushitasharma.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class vwo_loginVWO_POM_PropertyReader {

        @Owner("Bhushita")
        @Description("Verify that invalid creds give error message")
        @Test
        public void testLoginNegative(){
            WebDriver driver = new ChromeDriver();

            LoginPage loginPageVWO = new LoginPage(driver);
            String error_msg = loginPageVWO.LoginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username" ), PropertiesReader.readKey("invalid_password"));

            assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
            Assert.assertEquals(error_msg , PropertiesReader.readKey("error_message"));

        }

        @Owner("Bhushita")
        @Description("Verify that valid creds ")
        @Test
        public void testLoginPositive(){
            WebDriver driver = new ChromeDriver();

            LoginPage loginPageVWO = new LoginPage(driver);
            loginPageVWO.LoginToVWOLoginvalidCreds(PropertiesReader.readKey("Valid_username"),PropertiesReader.readKey("Valid_password"));
            DashboardPage dashboardPage = new DashboardPage(driver);
            String usernameLoggedIn = dashboardPage.loggedInUserName();

            assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
            Assert.assertEquals(usernameLoggedIn , PropertiesReader.readKey("expected_username"));


        }

    }


