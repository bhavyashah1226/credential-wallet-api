// ********RoostGPT********
/*
Test generated by RoostGPT for test credential-wallet-artillery using AI Type Azure Open AI and AI Model roost-gpt4-32k

{
  background: 'Given the base URL is "http://localhost:8080"',
  rule: null,
  scenario: 'Delete authorization\r\n' +
    '    Given authorization ID\r\n' +
    '    When the client sends a DELETE request to "/authorizations/ID"\r\n' +
    '    Then the response status code should be 200 for a successful delete\r\n' +
    '    And the authorizations should not appear in GET request for "/authorizations"',
  title: 'Delete authorization'
}

*/

// ********RoostGPT********
package com.mycompany.app.RoostTest;

import org.junit.jupiter.api.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.io.FileUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;

import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;

class scenario_87771cdd6d_Test {

    private static final String API_HOST = System.getenv("API_HOST");
    private static final String payloadFile = "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "mycompany" + File.separator + "app" + File.separator + "RoostTest" + File.separator + "scenario-87771cdd6d-Test.csv";
    private String[] headers;
    private String[] payload;

    @BeforeEach
    public void beforeEach() {
        try (LineNumberReader reader = new LineNumberReader(new FileReader(payloadFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                // Skip Empty Lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Split Headers
                if (reader.getLineNumber() == 1) {
                    headers = line.split("\\^\\|\\^");
                } else {
                    payload = line.split("\\^\\|\\^");
                }
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @DisplayName("Delete authorization")
    void testDeleteAuthorization() {
     
        // Deleting the authorization
        Response response = RestAssured
            .given()
                .header("Token", headers[2])
            .when()
                .delete(API_HOST + payload[1])

        // Validate the response
        response.then()
            .assertThat()
            .statusCode(200)
            .body("api-version", equalTo("1.0.0"));

        // Checking the authorizations after delete
        Response authorizations = RestAssured
            .given()
                .header("Token", headers[2])
            .when()
                .get(API_HOST + "/authorizations")

        // Validate the response
        authorizations.then()
            .assertThat()
            .statusCode(200)
            .body("api-version", equalTo("1.0.0"))
            .body("authorizations", not(hasItem("id")));
    }
}
