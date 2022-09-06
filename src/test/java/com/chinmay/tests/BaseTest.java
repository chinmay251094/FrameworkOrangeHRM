package com.chinmay.tests;

import com.chinmay.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {
    @BeforeMethod
    protected void setUp(Object[] data) throws Exception {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"), map.get("url"), map.get("mode"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
