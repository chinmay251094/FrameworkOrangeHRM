package com.chinmay.factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser, String mode) throws MalformedURLException {
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            if (mode.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (mode.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.FIREFOX);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else if (browser.isEmpty()) {
            if (mode.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        return driver;
    }
}
