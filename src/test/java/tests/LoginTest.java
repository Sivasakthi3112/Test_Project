package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldAreEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be disabled");
    }

    @Test
    public void testPasswordMaskedbutton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("test123");
        String typeBefore = loginPage.getPasswordFieldType();
        loginPage.clickEyeIcon();
        String typeAfter = loginPage.getPasswordFieldType();

        Assert.assertEquals(typeBefore, "password", "Password should be masked by default");
        Assert.assertEquals(typeAfter, "text", "Password should be visible after clicking eye icon");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("wrong@janitri.in");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        Thread.sleep(2000); // Use WebDriverWait in real scenarios
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"), "Error message not shown");
    }
}
