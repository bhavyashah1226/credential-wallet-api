// ********RoostGPT********
/*
Test generated by RoostGPT for test ZBIO-4912-Rest-Assured-Test using AI Type Open AI and AI Model gpt-4

Test generated for /accounts_post for http method type POST in rest-assured framework

RoostTestHash=53e96f9805


*/

// ********RoostGPT********
package com.mycompany.app.RoostTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
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
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.Arrays;

public class accountsPostTest {

	List<Map<String, String>> envList = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		TestdataLoader dataloader = new TestdataLoader();
		String[] envVarsList = { "" };
		envList = dataloader.load("src\\test\\java\\com\\mycompany\\app\\RoostTest\\accountsPostTest.csv", envVarsList);
	}

	@Test
	public void accountsPost_Test() throws JSONException {
		this.setUp();
		Integer testNumber = 1;
		for (Map<String, String> testData : envList) {
			RestAssured.baseURI = (testData.get("BASE_URL") != null && !testData.get("BASE_URL").isEmpty())
					? testData.get("BASE_URL") : "https://virtserver.swaggerhub.com/credentialregister/wallet/1.0.0";

			Response responseObj = given()
				.header("commit-hash", testData.get("commit-hash") != null ? testData.get("commit-hash") : "")
				.contentType(ContentType.JSON)
				.body("{\n" + "  \"email\": \"" + (testData.get("email") != null ? testData.get("email") : "") + "\n"
						+ "}")
				.when()
				.post("/accounts")
				.then()
				.extract()
				.response();
			JsonPath response;
			String contentType = responseObj.getContentType();

			System.out.printf("Test Case %d: accountsPost_Test \n", testNumber++);
			System.out.println("Request: POST /accounts");
			System.out.println("Status Code: " + responseObj.statusCode());
			if (testData.get("statusCode") != null) {
				MatcherAssert.assertThat(responseObj.statusCode(),
						equalTo(Integer.parseInt(testData.get("statusCode"))));
			}
			else {
				List<Integer> expectedStatusCodes = Arrays.asList(201, 400);
				MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
			}

			switch (responseObj.statusCode()) {

				case 400:

					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

			}

			if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
				String xmlResponse = responseObj.asString();
				JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
				JSONObject jsonData = jsonResponse.getJSONObject("xml");
				String jsonString = jsonData.toString();
				response = new JsonPath(jsonString);

			}
			else if (contentType.contains("application/json")) {
				response = responseObj.jsonPath();
			}
			else {
				System.out.println("Response content type found: " + contentType
						+ ", but RoostGPT currently only supports the following response content types: application/json,text/xml,application/xml");
				continue;
			}

			if (responseObj.statusCode() == 201) {
				System.out.println("Description: successful operation");
			}
			if (responseObj.statusCode() == 400) {
				System.out.println("Description: Bad Request");

				if (response.get("error") != null) {
					MatcherAssert.assertThat(response.get("error"), instanceOf(String.class));
				}

				if (response.get("description") != null) {
					MatcherAssert.assertThat(response.get("description"), instanceOf(String.class));
				}

				if (response.get("error") != null) {
					MatcherAssert.assertThat(response.getString("error"), matchesPattern("^validation/.*$"));

					MatcherAssert.assertThat(response.get("error"), instanceOf(String.class));
				}

				if (response.get("description") != null) {
					MatcherAssert.assertThat(response.get("description"), instanceOf(String.class));
				}

				if (response.get("value") != null) {
					MatcherAssert.assertThat(response.get("value"), instanceOf(undefined.class));
				}

				if (response.get("field") != null) {
					MatcherAssert.assertThat(response.get("field"), instanceOf(String.class));
				}

				if (response.get("schema_field") != null) {
					MatcherAssert.assertThat(response.get("schema_field"), instanceOf(String.class));
				}
			}

		}
	}

}
