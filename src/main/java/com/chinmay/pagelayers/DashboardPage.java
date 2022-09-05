package com.chinmay.pagelayers;

import com.chinmay.enums.WaitTill;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class DashboardPage extends BasePage {
    private final By profile = By.xpath("//li[@class='oxd-userdropdown']");
    private final By optionsProfile = By.xpath("//ul[@class='oxd-dropdown-menu']/li/a");

    public DashboardPage clickProfile() throws Exception {
        new WebDriverWait(fetchDriver(), 10).until(ExpectedConditions.elementToBeClickable(profile));
        click(profile, WaitTill.CLICKABLE, "Profile icon");
        return this;
    }

    public LoginPage clickLogout() throws Exception {
        selectOptions(fetchElements(optionsProfile), "Logout");
        return new LoginPage();
    }
}
