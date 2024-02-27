package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPostsTest extends BaseTest {

    @Test
    public void getPost() {

        given()
                .spec(reqSpec).
        when()
                .get().
        then().
                spec(resSpec)
                .assertThat().body("title[0]", equalTo("Updated post"))
                .assertThat().body("author[0]", equalTo("Jane")).
        and()
                .assertThat().body("title[2]", equalTo("a title"))
                .assertThat().body("author[2]", equalTo("Mark"));

    }
}
