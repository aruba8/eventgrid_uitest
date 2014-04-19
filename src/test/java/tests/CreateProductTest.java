package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.WebDriverConfig;

public class CreateProductTest {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;

    @BeforeClass
    @Parameters({"url", "email", "password"})
    public void setUp(String url, String username, String password) {
        WebDriverConfig driverConfig = new WebDriverConfig();
        driver = driverConfig.getDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        driver.get(url);
        loginPage.login(username, password);
    }

    @AfterClass
    public void tierDown() {
        driver.quit();
    }

    @Test
    @Parameters({"img"})
    public void testCreateProduct(String imgPath) {
        mainPage.goToAddCategory();
        mainPage.addCategory("CATEGORY");
        mainPage.addSubCategory("s1");
        mainPage.addSubCategory("s2");
        mainPage.createCategory();

        //Assert that category created
        Assert.assertEquals(mainPage.getFirstCreatedCategoryName(), "CATEGORY");

        mainPage.openProducts();
        mainPage.openAddProductForm();
        mainPage.fillProductCreationForm("P1", "short descr", "100", "SSSSWAQ", imgPath);
        mainPage.saveProduct();

        //Assert that product created
        Assert.assertEquals(mainPage.getCreatedProductName(), "P1");

    }

}
