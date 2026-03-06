package com.bhushitasharma.pages.pageObjectModel.Project_1_vwo.IMPROVED;

import com.bhushitasharma.base.CommonToAllPage;
import com.bhushitasharma.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // // Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    //Step 2 -PAGE Action

    public String LoginToVWOLoginInvalidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        presenceOfElement(error_message);
        return getText(error_message);

    }

    public void LoginToVWOLoginvalidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
//        custom_wait();



    }
}


