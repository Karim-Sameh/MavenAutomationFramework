package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Page Object representing the Tasks page
public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@data-testid='welcome']")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement plusButton;

    @FindBy(xpath = "//div[@data-testid='todo-item']")
    private WebElement todoItem;

    @FindBy(xpath = "//button[@data-testid='delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//h4[@data-testid='no-todos']")
    private WebElement noTodosText;

    @Step("Load the Todo webpage")
    public TodoPage load() {
        driver.get(ConfigUtils.getInstance().getBaseURL() + EndPoint.PAGE_TODO_ENDPOINT);
        return this;
    }

    @Step
    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    @Step
    public NewTodoPage clickOnPlusButton() {
        plusButton.click();
        return new NewTodoPage(driver);
    }

    @Step
    public String getNewTodoText() {
        return todoItem.getText();
    }

    @Step
    public TodoPage clickOnDeleteButton() {
        deleteButton.click();
        return this;
    }

    @Step
    public boolean isNoTodosTextDisplayed() {
        return noTodosText.isDisplayed();
    }

}
