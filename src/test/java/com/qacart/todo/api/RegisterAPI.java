package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import java.util.List;
import static io.restassured.RestAssured.given;

public class RegisterAPI {

    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userID;
    private String firstName;

    public String getToken() {
        return this.accessToken;
    }
    public List<Cookie> getCookies() {
        return this.restAssuredCookies;
    }
    public String getUserID() {
        return this.userID;
    }
    public String getFirstName() {
        return this.firstName;
    }

    // Registers a user via API and retrieves response details
    public void register() {

        User user = UserUtils.generateRandomUser();
        Response response =
                given()
                    .baseUri(ConfigUtils.getInstance().getBaseURL())
                    .header("Content-Type", "application/json")
                    .body(user)
                    .log().all()
                .when()
                    .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                    .log().all()
                    .extract().response();

        if(response.statusCode() != 201) {
            throw  new RuntimeException("Something went wrong with the request.");
        }

        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userID = response.path("userID");
        firstName = response.path("firstName");

    }

}
