package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class GetPostTest extends BaseTest {

    @Test
    public void getPost() {

        given()
                .pathParam("postId", "1")
                .spec(reqSpec).
        when()
                .get("{postId}").
        then().
                spec(resSpec)
                .assertThat().body("title", equalTo("Updated post"))
                .assertThat().body("author", equalTo("Jane"));


    }
}
