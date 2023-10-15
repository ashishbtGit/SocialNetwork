package com.socialnetwork.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialnetwork.api.dto.User;
import com.socialnetwork.api.helper.UserHelper;
import com.socialnetwork.api.utils.RestLogger;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UsersAPITest {

    UserHelper userHelper = new UserHelper();

    ObjectMapper objectMapper = new ObjectMapper() ;

    @Test(description="Validate users are fetched successfully")
    public void getAllUsersTest() throws JsonProcessingException {

      Response response = UserHelper.getAllUsers();

        String jsonBody = response.body().asString();
        List<User> users = objectMapper.readValue(jsonBody, new TypeReference<>() {});

        for(User data: users){
            Assert.assertNotNull(data.getName(),"user list fetched successfully");
        }

    }

    @Test(description = "Validate user is fetched successfully by valid user id")
    public void getUserById(){
        PropertyConfigurator.configure("log4j.properties");
        RestLogger.startTestCase("getUserById");

        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("id", String.valueOf(4));

        Response response = UserHelper.getUserData(queryParams);
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("body"+response.jsonPath().get("name"));

        Assert.assertNotNull(response.jsonPath().get("id"));
    }

    @Test(description = "Validate user is fetched successfully by valid name")
    public void getUserByName() throws JsonProcessingException {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", "Ervin Howell");

        Response response = UserHelper.getUserData(queryParams);
        Assert.assertEquals(response.getStatusCode(),200);

        String jsonBody = response.body().asString();
        List<User> users = objectMapper.readValue(jsonBody, new TypeReference<>() {});


        for(User data: users){
            Assert.assertEquals(data.getName(),"Ervin Howell","user found successfully");
        }
    }

    @Test(description = "Validate user is fetched successfully by valid email")
    public void getUserByEmail() throws JsonProcessingException {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("email", "Nathan@yesenia.net");

        Response response = UserHelper.getUserData(queryParams);
        Assert.assertEquals(response.getStatusCode(),200);

        String jsonBody = response.body().asString();
        List<User> users = objectMapper.readValue(jsonBody, new TypeReference<>() {});


        for(User data: users){
            Assert.assertEquals(data.getEmail(),"Nathan@yesenia.net","user found successfully");
        }
    }


    @Test(description = "Validate user is fetched successfully by valid username")
    public void getUserByUserName() throws JsonProcessingException {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("username", "Samantha");

        Response response = UserHelper.getUserData(queryParams);
        Assert.assertEquals(response.getStatusCode(),200);

        String jsonBody = response.body().asString();
        List<User> users = objectMapper.readValue(jsonBody, new TypeReference<>() {});


        for(User data: users){
            Assert.assertEquals(data.getUsername(),"Samantha","user found successfully");
        }
    }



    @Test(description = "Validate user is fetched successfully by valid phone number")
    public void getUserByPhoneNumber() throws JsonProcessingException {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("phone", "(254)954-1289");

        Response response = UserHelper.getUserData(queryParams);
        Assert.assertEquals(response.getStatusCode(),200);

        String jsonBody = response.body().asString();
        List<User> users = objectMapper.readValue(jsonBody, new TypeReference<>() {});


        for(User data: users){
            Assert.assertEquals(data.getPhone(),"(254)954-1289","user found successfully");
        }
    }


    @Test(description = "Validate user is not fetched by invalid name")
    public void getUserByInvalidName() throws JsonProcessingException {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", "af32323");

        Response response = UserHelper.getUserData(queryParams);
        Assert.assertEquals(response.getStatusCode(),200);

        String jsonBody = response.body().asString();
        List<User> users = objectMapper.readValue(jsonBody, new TypeReference<>() {});

        Assert.assertEquals(users.size(),0,"User not found for the given name");

    }

    @Test(description = "Validate user is not fetched by invalid phone number")
    public void getUserByInvalidPhoneNumber() throws JsonProcessingException {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("phone", "000######");

        Response response = UserHelper.getUserData(queryParams);
        Assert.assertEquals(response.getStatusCode(),200);

        String jsonBody = response.body().asString();
        List<User> users = objectMapper.readValue(jsonBody, new TypeReference<>() {});

        Assert.assertEquals(users.size(),0,"User not found for the given phone number");
    }

    @Test(description = "Validate user is not fetched by invalid username")
    public void getUserByInvalidUserName() throws JsonProcessingException {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("username", "sdgz$$#@");

        Response response = UserHelper.getUserData(queryParams);
        Assert.assertEquals(response.getStatusCode(),200);

        String jsonBody = response.body().asString();
        List<User> users = objectMapper.readValue(jsonBody, new TypeReference<>() {});

        Assert.assertEquals(users.size(),0,"User not found for the given username");
    }

    @Test(description = "Validate user is not fetched by invalid email")
    public void getUserByInvalidEmail() throws JsonProcessingException {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("email", "2345@gmail.com");

        Response response = UserHelper.getUserData(queryParams);
        Assert.assertEquals(response.getStatusCode(),200);

        String jsonBody = response.body().asString();
        List<User> users = objectMapper.readValue(jsonBody, new TypeReference<>() {});

        Assert.assertEquals(users.size(),0,"User not found for the given email");
    }

}

