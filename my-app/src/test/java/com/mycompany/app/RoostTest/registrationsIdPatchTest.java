// ********RoostGPT********
/*
Test generated by RoostGPT for test ZBIO-4912-Rest-Assured-Test using AI Type Open AI and AI Model gpt-4

Test generated for /registrations/{id}_patch for http method type PATCH in rest-assured framework

RoostTestHash=c1b0bbc56b


*/

// ********RoostGPT********
package com.mycompany.app.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class registrationsIdPatchTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/mycompany/app/RoostTest/registrations_idPatchTest.csv");
    }

  
    @Test  
    public void registrationsIdPatch_Test() {
        this.setUp();
        for (Map<String, String> map : envList) {
          RestAssured.baseURI = map.get("BASE_URL");  
  
                Response response = given()
				.pathParam("id", map.get("id") != null ? map.get("id") : "")
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"reference\": \"" + (map.get("reference") != null ? map.get("reference") : "") + "\",\n" +
					"  \"revoked\": \"" + (map.get("revoked") != null ? map.get("revoked") : "") + "\",\n" +
					"  \"suspendedUntil\": \"" + (map.get("suspendedUntil") != null ? map.get("suspendedUntil") : "") + "\",\n" +
					"  \"endDate\": \"" + (map.get("endDate") != null ? map.get("endDate") : "") + "\n" +
 				"}")
				.header("Token", map.get("API_KEY"))
                .when()
                .patch("/registrations/{id}")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
      
              if (response.jsonPath().get("id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("reference") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("reference"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("reference").length(), lessThanOrEqualTo(100));
  
          }
      
              if (response.jsonPath().get("startDate") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("startDate"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("endDate") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("endDate"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("status") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("credentialUrl") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("credentialUrl"), matchesPattern("^\w+:(\/?\/?)[^\s]+$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("credentialUrl"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("suspendedUntil") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("suspendedUntil"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("issuedAt") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("issuedAt"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("createdAt") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("createdAt"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("updatedAt") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("updatedAt"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("recipient") != null) {      
              if (response.jsonPath().get("recipient.id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("recipient.id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("recipient.name") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("recipient.name"), matchesPattern("^[\p{L} .'-]{1,100}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("recipient.name"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("recipient.type") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("recipient.type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("recipient.type"), anyOf(equalTo("branch"), equalTo("person"), equalTo("employee")));
  
          }
  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Bad Request");
      
              if (response.jsonPath().get("error") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("error") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("value") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(undefined.class));  
          }
      
              if (response.jsonPath().get("field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("schema_field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 401) {
					System.out.println("Description: Authentication Required");
      
              if (response.jsonPath().get("error") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("error") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("value") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(undefined.class));  
          }
      
              if (response.jsonPath().get("field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("schema_field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));  
          }
				}
  
            }  
    }
}
