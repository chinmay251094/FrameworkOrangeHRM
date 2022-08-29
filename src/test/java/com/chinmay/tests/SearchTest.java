package com.chinmay.tests;

import com.chinmay.driver.DriverManager;
import com.chinmay.pagelayers.LoginPage;
import com.chinmay.utils.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class SearchTest extends BaseTest {
    private SearchTest() {
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void test1(Map<String, String > data) throws Exception {
        new LoginPage().setUsername(data.get("uname")).setPassword(data.get("pwd")).clickSubmit();

        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
        Assertions.assertThat(DriverManager.getDriver().getCurrentUrl()).isEqualTo(expected);
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void testlogout(Map<String, String > data) throws Exception {
        new LoginPage().setUsername(data.get("uname")).setPassword(data.get("pwd")).clickSubmit()
                .clickProfile().clickLogout();

        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assertions.assertThat(DriverManager.getDriver().getCurrentUrl()).isEqualTo(expected);
    }
}
