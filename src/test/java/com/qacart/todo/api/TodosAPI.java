package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Todo;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TodosAPI {

    // Adds a new task item via API
    public void addTodo(String token) {

        Todo todo = new Todo(false , "Learn Selenium");
        Response response =
                given()
                    .baseUri(ConfigUtils.getInstance().getBaseURL())
                    .header("Content-Type", "application/json")
                    .body(todo)
                    .auth()
                    .oauth2(token)
                .when()
                    .post(EndPoint.API_TODOS_ENDPOINT)
                .then()
                    .log().all().extract().response();

        if(response.statusCode() != 201) {
            throw  new RuntimeException("Something went wrong with the request.");
        }

    }

}