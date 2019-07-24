package com.restassuredtraining.com;
import static io.restassured.RestAssured.*;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class GetRequest {

	@Test
	public void getRequest(){
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet/22222";
		
		Response resp = RestAssured.given()
		.when()
		.get();
		
		System.out.println("Respons is ----------\n"+resp.prettyPrint());
		
		resp.then().assertThat().statusCode(300);
	}
}


















