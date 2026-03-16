package com.bhushitasharma.pages.pageObjectModel.Project_1_vwo;

import com.bhushitasharma.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // // Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    //Step 2 -PAGE Action

    public String LoginToVWOLoginInvalidCreds(String user, String pwd) {
        driver.get(PropertiesReader.readKey("qa_url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String error_msg_text = driver.findElement(error_message).getText();
        return error_msg_text;

    }

    public void LoginToVWOLoginvalidCreds(String user, String pwd) {
        driver.get(PropertiesReader.readKey("qa_url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}
