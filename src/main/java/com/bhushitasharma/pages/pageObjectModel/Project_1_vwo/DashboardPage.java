package com.bhushitasharma.pages.pageObjectModel.Project_1_vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver =driver;
    }

    By Username0nDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    public String loggedInUserName(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(Username0nDashboard).getText();
    }
}
