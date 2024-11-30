package steps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.BuildUrlUtils.buildGetUrl;
import static utils.BuildUrlUtils.buildPostUrl;

public class RestAssuredSteps {

    /**
     * Perform a GET request, validate the status code, and return the Rest Assured response object.
     *
     * @param endpoint      The API endpoint.
     */

    public static Response sendGetRequest(String endpoint) {
        Response response = RestAssured
                .given()
                .when()
                .get(buildGetUrl(endpoint));

        assertEquals(HttpStatus.SC_OK, response.statusCode(),
                "Expected status code does not match the actual status code.");

        return response;
    }

    /**
     * Perform a POST request, validate the status code, and return the Rest Assured response object.
     *
     * @param endpoint      The API endpoint.
     */

    public static String sendPostRequest(String endpoint, Object bodyData) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .body(bodyData)
                .post(buildPostUrl(endpoint));

        response.then().log().all();

        assertEquals(HttpStatus.SC_OK, response.statusCode(),
                "Expected status code does not match the actual status code.");

        return response.getBody().asString();
    }
}