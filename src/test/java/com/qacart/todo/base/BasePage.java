package com.qacart.todo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Parent class for all page objects
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
