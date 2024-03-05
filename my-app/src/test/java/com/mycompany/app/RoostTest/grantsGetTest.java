// ********RoostGPT********
/*
Test generated by RoostGPT for test ZBIO-4912-Rest-Assured-Test using AI Type Open AI and AI Model gpt-4

Test generated for /grants_get for http method type GET in rest-assured framework

RoostTestHash=692c6b853f


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

public class grantsGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/mycompany/app/RoostTest/grantsGetTest.csv");
    }

  
    @Test  
    public void grantsGet_Test() {
        this.setUp();
        for (Map<String, String> map : envList) {
          RestAssured.baseURI = map.get("BASE_URL");  
  
                Response response = given()
				.header("Token", map.get("API_KEY"))
                .when()
                .get("/grants")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
      
              if (response.jsonPath().get("total") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("total"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("grants") != null) {      
                for (int i = 0; i < response.jsonPath().getList("grants").size(); i++) {      
              if (response.jsonPath().get("grants["+ i +"].id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("grants["+ i +"].token") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("grants["+ i +"].token"), matchesPattern("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].token"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("grants["+ i +"].createdAt") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].createdAt"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("grants["+ i +"].updatedAt") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].updatedAt"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("grants["+ i +"].account") != null) {      
              if (response.jsonPath().get("grants["+ i +"].account.id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].account.id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("grants["+ i +"].account.name") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("grants["+ i +"].account.name"), matchesPattern("^[\p{L} .'-]{1,100}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].account.name"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("grants["+ i +"].account.image") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].account.image"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("grants["+ i +"].account.email") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("grants["+ i +"].account.email"), matchesPattern("^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].account.email"), instanceOf(String.class));MatcherAssert.assertThat(
                  response.jsonPath().getString("grants["+ i +"].account.email"),
                  Matchers.matchesPattern("^[^\s@]+@[^\s@]+\.[^\s@]+$")
                ); 
  
          }
  
          }
      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("grants"), instanceOf(List.class));
  
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
