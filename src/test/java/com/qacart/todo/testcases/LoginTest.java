package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login using e-mail and password")
    @Description("Login by inserting the e-mail and password, and navigating to the Todo page")
    @Test(description = "Test the login functionality")
    public void loginTest() {
        // Initialize LoginPage and perform login
        LoginPage loginPage = new LoginPage(getDriver());
        boolean actualResult =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomeMessageDisplayed();
        // Assert that the welcome message is displayed after login
        Assert.assertTrue(actualResult);

    }

}
