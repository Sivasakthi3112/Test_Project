package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userIdInput = By.name("email");
    By passwordInput = By.name("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By eyeIcon = By.cssSelector("svg[data-testid='VisibilityIcon']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(userIdInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public void clickEyeIcon() {
        driver.findElement(eyeIcon).click();
    }

    public String getPasswordFieldType() {
        return driver.findElement(passwordInput).getAttribute("type");
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector(".MuiAlert-message")).getText();
    }
}
