package com.restassuredtraining.com;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class basicAuth {
	
	@Test
	public void basicAuthorization(){
		
		RestAssured.baseURI="https://api.enterprise.apigee.com";
		Response resp = RestAssured.given()
		.auth().preemptive().basic("revell938@gmail.com", "Cybage@123")
		.when()
		.get("/v1/organizations/revell938-trial");
		
		resp.then().log().all();
		
		System.out.println("sepo -body --> ");
		resp.body().print();
		
		
		///v1/organizations/revell938-trial
	}

}
