package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.utils.JsonReader;
import org.json.JSONObject;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.*;

public class RegisterApiSteps {

    Response response;

    @Given("Register API tersedia")
    public void registerApiTersedia() {

        RestAssured.baseURI = "https://api.rizqifauzan.com";

        RestAssured.requestSpecification = given()
                .header("User-Agent", "Mozilla/5.0")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json");
    }

    @When("User register menggunakan data dari {string}")
    public void registerMenggunakanJson(String fileName) throws Exception {

        List<Map<String, String>> datas =
                JsonReader.readJson("src/test/resources/" + fileName);

        Map<String, String> data = datas.get(0);

        String email = "yuta" + System.currentTimeMillis() + "@example.com";

        JSONObject body = new JSONObject();
        body.put("nama", data.get("nama"));
        body.put("email", email);
        body.put("password", data.get("password"));

        System.out.println("===== REQUEST BODY =====");
        System.out.println(body.toString(2));

        response = RestAssured.given()
                .log().all()
                .body(body.toString())
                .post("/api/auth/register");

        response.then().log().all();
    }

    @Then("Response status code adalah {int}")
    public void responseStatusCode(int status) {

        System.out.println("Expected : " + status);
        System.out.println("Actual   : " + response.statusCode());
        System.out.println("Response : " + response.getBody().asPrettyString());

        assertEquals(status, response.statusCode());
    }

    @Then("Response success bernilai true")
    public void responseSuccessTrue() {

        assertTrue(response.jsonPath().getBoolean("success"));
    }

    @Then("Response status code error")
    public void responseStatusCodeError() {

        assertTrue(response.statusCode() >= 400 &&
                response.statusCode() < 600);
    }

    @Then("Response success bernilai false")
    public void responseSuccessFalse() {

        assertFalse(response.jsonPath().getBoolean("success"));
    }

    @Then("Response sesuai JSON Schema")
    public void validateSchema() {

        response.then().assertThat().body(
                matchesJsonSchema(
                        new File("src/test/resources/jsonSchema/ValidateRegisterSchema.json")
                )
        );
    }
}