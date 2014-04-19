package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final String emailXpath = "//input[@id='Username']";
    private final String passwordXpath = "//input[@id='Password']";
    private final String loginButtonXpath = "//input[@type='submit']";

    @FindBy(xpath = emailXpath)
    private WebElement email;


    @FindBy(xpath = passwordXpath)
    private WebElement password;


    @FindBy(xpath = loginButtonXpath)
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public void login(String email, String password) {
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginButton().click();
    }
}
