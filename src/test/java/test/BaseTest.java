package test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseTest {

    protected static RequestSpecification reqSpec;
    protected static ResponseSpecification resSpec;

    @BeforeSuite
    public void setUp() {
    reqSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost:3000")
            .setBasePath("posts")
            .setContentType(ContentType.JSON).build();
    resSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .build();
        RequestLoggingFilter reqLogFilter = new RequestLoggingFilter();
        ResponseLoggingFilter resLogFilter = new ResponseLoggingFilter();
        RestAssured.filters(reqLogFilter,resLogFilter);

    }

    @AfterSuite
    public void tearDown() throws IOException {
    File dbFile = new File(System.getProperty("user.home")+"/Desktop/db.json");
        Files.deleteIfExists(dbFile.toPath());
        File file = new File("src/test/resources/dbCopy.json");
        Files.copy(file.toPath(), Path.of(System.getProperty("user.home")+"/Desktop/db.json"));

    }
}
