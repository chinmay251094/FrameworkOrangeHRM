package com.chinmay.tests;

import com.chinmay.annotations.FrameworkAnnotations;
import com.chinmay.driver.DriverManager;
import com.chinmay.enums.SDET;
import com.chinmay.enums.Groups;
import com.chinmay.pagelayers.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class SearchTest extends BaseTest {
    private SearchTest() {
    }

    @FrameworkAnnotations(author = SDET.KOMAL, category = Groups.LOGINPAGE)
    @Test
    public void test1(Map<String, String > data) throws Exception {
        new LoginPage().setUsername(data.get("uname")).setPassword(data.get("pwd")).clickSubmit();

        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
        Assertions.assertThat(DriverManager.getDriver().getCurrentUrl()).isEqualTo(expected);
    }

    @FrameworkAnnotations(author = SDET.CHINMAY, category = Groups.DASHBOARD)
    @Test
    public void testlogout(Map<String, String > data) throws Exception {
        new LoginPage().setUsername(data.get("uname")).setPassword(data.get("pwd")).clickSubmit()
                .clickProfile().clickLogout();

        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assertions.assertThat(DriverManager.getDriver().getCurrentUrl()).isEqualTo(expected);
    }
}
