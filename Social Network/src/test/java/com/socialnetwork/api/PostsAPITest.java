package com.socialnetwork.api;

import com.socialnetwork.api.dto.Posts;
import com.socialnetwork.api.helper.UserHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostsAPITest {

    Posts post = new Posts();

    public Posts addPost(int id,int userId, String title, String body){
        post.setId(id);
        post.setUserId(userId);
        post.setTitle(title);
        post.setBody(body);
        return post;
    }

    @Test(description="Validate the post is created successfully")
    public void testCreationOfPosts(){

        Map<String, String> headers = new HashMap<>();
        headers.put(" "," ");
        post = addPost(111,45432,"title","body");
        Response response = UserHelper.createPost(post,headers);
        Assert.assertEquals(response.getStatusCode(),201,"Status code should be 201");

        Posts postsResponse = response.as(Posts.class);

        Assert.assertNotNull(postsResponse.getId(),"Id should not be null");
        Assert.assertNotNull(postsResponse.getUserId(),"userId should not be null");
        Assert.assertNotNull(postsResponse.getBody(),"body should not be null");
        Assert.assertNotNull(postsResponse.getTitle(),"title should not be null");

    }



}
