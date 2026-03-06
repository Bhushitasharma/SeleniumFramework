package com.bhushitasharma.base;

import com.bhushitasharma.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAll {

    @BeforeMethod
    public void setup(){
        DriverManager.init();
    }
    @AfterMethod
    public void tear(){
       DriverManager.down();
    }
}
