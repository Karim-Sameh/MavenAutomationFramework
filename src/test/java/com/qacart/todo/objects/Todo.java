package com.qacart.todo.objects;

// Represents an item with its properties
public class Todo {

    private boolean isCompleted;
    private String item;

    public Todo(boolean isCompleted, String item) {
        this.isCompleted = isCompleted;
        this.item = item;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }
    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

}