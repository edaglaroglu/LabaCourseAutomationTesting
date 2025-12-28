package odevOnSekiz;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PetstoreTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void createPetAndGet() {

        String petBody = """
                {
                  "id": 8008,
                  "name": "TinyMiny",
                  "status": "available",
                  "category": {
                    "id": 1,
                    "name": "cats"
                  },
                  "tags": [
                    {
                      "id": 10,
                      "name": "cute"
                    }
                  ],
                  "photoUrls": [
                    "https://file.com/cat.png"
                  ]
                }
                """;


        Response postResponse =
                given()
                        .contentType(ContentType.JSON)
                        .body(petBody)
                        .when()
                        .post("/pet")
                        .then()
                        .statusCode(200)
                        .body("name", equalTo("TinyMiny"))
                        .body("status", equalTo("available"))
                        .extract().response();

        int petId = postResponse.path("id");

        given()
                .pathParam("petId", petId)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("id", equalTo((int) petId))
                .body("name", equalTo("TinyMiny"))
                .body("status", equalTo("available"));
    }
}
