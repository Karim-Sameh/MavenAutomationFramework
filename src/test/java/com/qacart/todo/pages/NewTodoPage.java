package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Page Object for creating new Tasks
public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-testid='new-todo']")
    private WebElement newTodoInput;

    @FindBy(xpath = "//button[@data-testid='submit-newTask']")
    private WebElement submitButton;

    @Step("Load the New Todo webpage")
    public NewTodoPage load() {
        driver.get(ConfigUtils.getInstance().getBaseURL() + EndPoint.PAGE_NEW_TODO_ENDPOINT);
        return this;
    }

    @Step
    public TodoPage createNewTodo(String todoName) {
        newTodoInput.sendKeys(todoName);
        submitButton.click();
        return new TodoPage(driver);
    }

}
