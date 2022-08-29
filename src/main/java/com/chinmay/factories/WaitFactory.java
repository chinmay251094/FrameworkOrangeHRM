package com.chinmay.factories;

import com.chinmay.constants.FrameworkConstants;
import com.chinmay.driver.DriverManager;
import com.chinmay.enums.WaitTill;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public final class WaitFactory {

    private WaitFactory() {
    }

    public static WebElement performExplicitWait(WaitTill waitTill, By by) {
        WebElement webElement = null;

        if (waitTill == WaitTill.CLICKABLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitTime())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitTill == WaitTill.PRESENCE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitTime())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitTill == WaitTill.VISIBLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitTime())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitTill == WaitTill.NONE) {
            webElement = DriverManager.getDriver().findElement(by);
        }
        return webElement;
    }

    public static List<WebElement> performExplicitWaitForElements(WaitTill waitTill, List<WebElement> ele) {
        List<WebElement> webElement = null;

        if (waitTill == WaitTill.VISIBLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitTime())
                    .until(ExpectedConditions.visibilityOfAllElements(ele));
        }

        return webElement;
    }
}
