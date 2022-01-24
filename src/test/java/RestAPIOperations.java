import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAPIOperations {

    @Test
    public void getAllUser() {
        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(20))
                .log().body();
    }
    @Test
    public void createUser() {
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7af240fb7b557b1314869bc519303f4e79eb90f287818ef0c9b01eef8e85f17a")
                .body("{\n"+
                        "  \"name\": \"ABC XYZ\", \n" +
                " \"gender\": \"male\", \n" +
                " \"email\": \"tenali.ramakrishna117@gmail.com\",\n"  +
                " \"status\": \"active\"\n"+
    "}")
        .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("ABC XYZ"));
    }
}
