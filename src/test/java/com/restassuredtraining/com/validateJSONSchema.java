package com.restassuredtraining.com;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class validateJSONSchema {
	
	@Test
	public void assertJSONSchema(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response resp = RestAssured.given().when()
		.get("/photos/100");
		
		resp.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchema.json"));
		
	}

}
