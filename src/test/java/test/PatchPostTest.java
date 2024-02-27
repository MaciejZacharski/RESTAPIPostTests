package test;

import model.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchPostTest extends BaseTest{

    @Test
    public void updatePatchPost() {
        Post post = new Post("nowy tytuł");


        Post createdPost =
                given()
                        .spec(reqSpec)
                        .pathParam("postId", "5")
                        .body(post).
                when()
                        .patch("{postId}").
                then()
                        .spec(resSpec)
                        .extract().body().as(Post.class);
        Assert.assertEquals(createdPost.getTitle(), "nowy tytuł");
        Assert.assertEquals(createdPost.getAuthor(), "Marcus");



    }

}
