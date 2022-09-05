package com.chinmay.driver;

import com.chinmay.enums.Config;
import com.chinmay.utils.ConfigReaderUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver {
    private Driver() {
    }

    public static void initDriver(String browser, String url) throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
                DriverManager.getDriver().manage().window().maximize();
                DriverManager.getDriver().get(url);
            } else if(browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
                DriverManager.getDriver().manage().window().maximize();
                DriverManager.getDriver().get(ConfigReaderUtils.get(Config.URL).toLowerCase());
            } else if(browser.isEmpty()) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
                DriverManager.getDriver().manage().window().maximize();
                DriverManager.getDriver().get(url);
            }
         }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
