package com.chinmay.pagelayers;

import com.chinmay.enums.WaitTill;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public final class LoginPage extends BasePage {
    private final By txtUserName = By.xpath("//input[@name='username']");
    private final By txtPassword = By.xpath("//input[@name='password' and @type='password']");
    private final By btnLogin = By.xpath("//button[@type='submit' and normalize-space()='Login']");

    public LoginPage setUsername(String value) throws Exception {
        sendKeys(txtUserName, value, WaitTill.PRESENCE, "Username edit-box");
        return this;
    }

    public LoginPage setPassword(String value) throws Exception {
        sendKeys(txtPassword, value, WaitTill.NONE, "Password edit-box");
        return this;
    }

    public DashboardPage clickSubmit() throws Exception {
        click(btnLogin, WaitTill.NONE, "Submit button");
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        return new DashboardPage();
    }
}
