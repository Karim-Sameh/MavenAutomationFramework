package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterAPI;
import com.qacart.todo.api.TodosAPI;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Description("Login by inserting the e-mail and password, and navigating to the Todo page")
    @Test(description = "Test creating a new todo")
    public void newTodoTest() {
        // Register a new user via API
        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();

        // Navigate to NewTodoPage and inject cookies for authentication
        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerAPI.getCookies());

        // Add a new Task and verify the text matches
        String actualResult = newTodoPage
                .load()
                .createNewTodo("Learn Selenium")
                .getNewTodoText();
        Assert.assertEquals(actualResult, "Learn Selenium");

    }

    @Story("Delete Todo")
    @Test(description = "Test deleting a new todo")
    public void deleteTodoTest() {
        // Register a new user via API
        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();

        // Add a Task using the API
        TodosAPI todosAPI = new TodosAPI();
        todosAPI.addTodo(registerAPI.getToken());

        // Navigate to TodoPage and inject cookies for authentication
        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerAPI.getCookies());

        // Delete the Task and verify the "No Todos" message is displayed
        boolean noTodos = todoPage
                .load()
                .clickOnDeleteButton()
                .isNoTodosTextDisplayed();
        Assert.assertTrue(noTodos);

    }

}
