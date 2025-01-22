package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Page Object for the Login page
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailInput; // Locator for the email input field

    @FindBy(id = "password")
    private WebElement passwordInput; // Locator for the password input field

    @FindBy(id = "submit")
    private WebElement submitButton; // Locator for the login button

    // Navigate to the login page URL
    @Step("Load the login webpage")
    public LoginPage load() {
        driver.get(ConfigUtils.getInstance().getBaseURL());
        return this;
    }

    @Step("Login using email and password")
    public TodoPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new TodoPage(driver);
    }

}
