package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.WebDriverConfig;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        WebDriverConfig driverConfig = new WebDriverConfig();
        driver = driverConfig.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    @Parameters({"url", "email", "password"})
    public void testLogin(String url, String username, String password) {
        driver.get(url);
        loginPage.login(username, password);
        driver.quit();
    }
}
