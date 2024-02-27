package test;

import model.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdatePostTest extends BaseTest{

    @Test
    public void updatePost() {
        Post post = new Post("nowy tytuł", "nowy autor");


        Post createdPost =
                given()
                        .spec(reqSpec)
                        .pathParam("postId", "3")
                        .body(post).
                when()
                        .put("{postId}").
                then()
                        .spec(resSpec)
                        .extract().body().as(Post.class);
        Assert.assertEquals(createdPost, post);



    }

}
