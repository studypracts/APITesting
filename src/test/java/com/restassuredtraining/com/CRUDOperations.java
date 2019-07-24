package com.restassuredtraining.com;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CRUDOperations {
	
	@Test
	public void post(){
		
		String body = "{\"id\": 20092018,\"category\": {\"id\": 19092018,\"name\": \"string\"},\"name\": \"My Bird\",\"photoUrls\": [  \"http://www.google.com\"],\"tags\": [  {\"id\": 0,\"name\": \"string\"}],\"status\": \"available\"}";				
			RestAssured.baseURI="https://petstore.swagger.io";
		
		Response postResp = RestAssured.given().header("Accept", "application/json")
		.header("Content-Type", "application/json")
		.body(body)
		.when()
		.post("/v2/pet");
		
		postResp.then().assertThat().statusCode(200);
		
		
	}

}
