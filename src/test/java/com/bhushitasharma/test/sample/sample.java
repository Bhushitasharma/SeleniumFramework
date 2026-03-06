package com.bhushitasharma.test.sample;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sample {
    public static void main(String[] args){
        System.out.println("Hello");
    }

    public static class TestSample {

        @Description(" Verify sample 1")
        @Test
        public void testsample1(){
            Assert.assertTrue(true);
        }
        @Description(" Verify sample 1")
        @Test
        public void testsample2(){
            Assert.assertTrue(true);
        }

    }
}
