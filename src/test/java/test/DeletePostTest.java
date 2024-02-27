package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeletePostTest extends BaseTest {

    @Test
    public void deletePost() {

        given()
                .pathParam("postId", "6")
                .spec(reqSpec).
        when()
                .delete("{postId}").
        then().
                spec(resSpec);



    }
}
