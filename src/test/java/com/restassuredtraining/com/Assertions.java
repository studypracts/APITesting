package com.restassuredtraining.com;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
public class Assertions {
	
	//Assert status code
	@Test(priority=1)
	public void statusCode(){
		RestAssured.baseURI="http://api.openweathermap.org";
		Response resp = RestAssured.given().queryParam("q", "pune")
		.queryParam("appid", "d2d1f28fcb8df8073a1d14f89b70f305")
		.when()
		.get("/data/2.5/weather");
		
		
		resp.then().assertThat().statusCode(200);
		int statusCode = resp.then().extract().statusCode();
		
		System.out.println("Status Code is "+statusCode);
		
		resp.then().assertThat().contentType("application/json");
		
	}
	
	
	
	//Assert JSONPath
	@Test(priority=2)
	public void jsonPathAssetion(){
	RestAssured.baseURI="http://services.groupkt.com";
	Response resp = RestAssured.given()
	.when()
	.get("/country/get/all");
	
	resp.then().assertThat().body("RestResponse.result[0].name", equalTo("Afghanistan"));
	
	resp.then().body("RestResponse.result.name", hasItems("Afghanistan", "India"));
	}
	
	
	
	//Assert X-path
	//@Test
	
	public void xPathAssertion(){
		
		RestAssured.baseURI="http://www.thomas-bayer.com";
		Response resp = RestAssured.given()
		.when()
		.get("/sqlrest/CUSTOMER/10");
		
		resp.then().assertThat().body("CUSTOMER.CITY", equalTo("Dallas"));

	}
	
	
	
	
	//Read Headers
	@Test(priority=3)
	public void readHeaders(){
		
		RestAssured.baseURI= "https://jsonplaceholder.typicode.com";
		Response resp = RestAssured.given().when()
		.get("/photos/100");
		
		resp.then().assertThat().header("pragma", "no-cache");
		
		String headerValue = resp.then().extract().header("pragma");
		
		System.out.println("Header value is "+ headerValue);
		
		Headers headers = resp.then().extract().headers();
		
		for(Header h : headers){
			System.out.println(h.getName()+":"+h.getValue());
		}
	}

	
	
	
	//Read Cookie
		@Test(priority=4)
		public void readCookie(){
			RestAssured.baseURI= "https://jsonplaceholder.typicode.com";
			Response resp = RestAssured.given().when()
			.get("/photos/100");
			
			String cookieValue = resp.then().extract().cookie("__cfduid");
			
			System.out.println("Cookie Value is "+ cookieValue);
			
			String pattern = "[a-z0-9]+$";
			System.out.println("Cookie Pattern match status is "+cookieValue.matches(pattern));
		}
		
		
		
		
		//Response time
		@Test(priority=5)
		public void getTime(){
		RestAssured.baseURI= "https://jsonplaceholder.typicode.com";
		Response resp = RestAssured.given().when()
		.get("/photos/100");
		
		long timeTaken = resp.getTimeIn(TimeUnit.MILLISECONDS);
		
		System.out.println(timeTaken);
		}
		
		
		
		
		//Validate JSON Schema
		@Test(priority=6)
		public void validateSchme(){
			
			RestAssured.baseURI="https://jsonplaceholder.typicode.com";
			Response resp = RestAssured.given().when()
			.get("/photos/100");
			
			resp.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\RestAssuredTraining\\RESTassuredTraining\\target\\JsonSchema.json"));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	













