package com.bhushitasharma.test.vwoTestCase;

import com.bhushitasharma.base.CommonToAll;
import com.bhushitasharma.base.CommonToAllPage;
import com.bhushitasharma.driver.DriverManager;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class vwo_Login_POM_PropertyReader_DM  extends CommonToAll {



    private static final Logger logger = LogManager.getLogger(vwo_Login_POM_PropertyReader_DM.class);


        @Owner("Bhushita")
        @Description("Verify that invalid creds give error message")
        @Test
        public void testLoginNegative(){
            logger.info("Starting the Testcases Page Object Model");

            LoginPage loginPageVWO = new LoginPage(DriverManager.getDriver());
            String error_msg = loginPageVWO.LoginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

            logger.info("End of the testLoginNegativeVWO !");

            assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
            Assert.assertEquals(error_msg , PropertiesReader.readKey("error_message"));

        }

        @Owner("Bhushita")
        @Description("Verify that valid creds ")
        @Test
        public void testLoginPositive(){
            logger.info("Starting the Testcases |  Verify that valid creds dashboard page is loaded");


            LoginPage loginPageVWO = new LoginPage(DriverManager.getDriver());
            loginPageVWO.LoginToVWOLoginvalidCreds(PropertiesReader.readKey("Valid_username"),PropertiesReader.readKey("Valid_password"));
            DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
            String usernameLoggedIn = dashboardPage.loggedInUserName();

            assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
            Assert.assertEquals(usernameLoggedIn , PropertiesReader.readKey("expected_username"));


        }

    }




