package com.socialnetwork.api;

import com.socialnetwork.api.dto.Comments;
import com.socialnetwork.api.helper.UserHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CommentsAPITest {

    Comments comments = new Comments();

    public Comments addComments(int id, int postId, String name, String body, String email){
        comments.setId(id);
        comments.setPostId(postId);
        comments.setName(name);
        comments.setBody(body);
        comments.setEmail(email);
        return comments;
    }

    @Test(description="Validate the comment is added successfully")
    public void testCommentsCreation(){

        Map<String, String> headers = new HashMap<>();
        headers.put(" "," ");
        comments = addComments(111,45432,"title","body","test@gmail.com");
        Response response = UserHelper.addComment(comments,headers);
        Assert.assertEquals(response.getStatusCode(),201,"Status code should be 200");

        Comments commentsResponse = response.as(Comments.class);

        Assert.assertNotNull(commentsResponse.getId(),"Id should not be null");
        Assert.assertNotNull(commentsResponse.getPostId(),"post Id should not be null");
        Assert.assertEquals(commentsResponse.getName(),"title");
        Assert.assertEquals(commentsResponse.getBody(),"body");
        Assert.assertEquals(commentsResponse.getEmail(),"test@gmail.com");


    }

}
