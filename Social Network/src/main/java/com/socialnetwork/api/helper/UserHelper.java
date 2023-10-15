package com.socialnetwork.api.helper;
import com.socialnetwork.api.common.Constants;
import com.socialnetwork.api.dto.Comments;
import com.socialnetwork.api.dto.Posts;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserHelper {

    public static Response getAllUsers(){

        Response response =  RestAssured.get(Constants.GET_USERS)
                .andReturn();

                return response;
    }

    public static Response getUserData(Map<String,String> queryParams){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .queryParams(queryParams)
                .get(Constants.GET_USERS);
        return response;
    }

    public static Response createPost(Posts createPostRequest, Map<String,String> headers){

       return RestAssured.given()
                .log().all()
                .baseUri(Constants.CREATE_POST)
                .contentType(ContentType.JSON)
                .body(createPostRequest)
                .post()
                .then().log().all().extract().response();

    }

    public static Response addComment(Comments createCommentRequest,Map<String,String> headers){

          return RestAssured.given()
                .log().all()
                .baseUri(Constants.CREATE_COMMENT)
                .contentType(ContentType.JSON)
                .body(createCommentRequest)
                .post()
                .then().log().all().extract().response();
    }
}
