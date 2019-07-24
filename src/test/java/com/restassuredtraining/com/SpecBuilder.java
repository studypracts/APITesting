package com.restassuredtraining.com;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	
	RequestSpecBuilder reqSpecBuilder;
	RequestSpecification reqSpecification;
	
	ResponseSpecBuilder respSpecBuilder;
	ResponseSpecification respSpecification;
	
	@BeforeClass
	public void preRequisite() throws IOException{
		
		Properties prop = new Properties();
		String filePath="D:\\CybPro\\eclipsLuna\\RestAssuredRavi\\RESTassuredTraining\\src\\test\\resource\\env.properties";
		
		FileInputStream fis = new FileInputStream(filePath);
		
		prop.load(fis);
				
		RestAssured.baseURI=prop.getProperty("host");
		RestAssured.basePath=prop.getProperty("resource");
		
		reqSpecBuilder =  new RequestSpecBuilder();
		reqSpecBuilder.addQueryParam("q", "Pune");
		reqSpecBuilder.addQueryParam("appid", prop.getProperty("key"));
		
		reqSpecification=reqSpecBuilder.build();
		
		respSpecBuilder = new ResponseSpecBuilder();
		
		
		respSpecBuilder.expectStatusCode(200);
		respSpecBuilder.expectContentType(ContentType.JSON);
		respSpecBuilder.expectHeader("server", "openresty");
		respSpecBuilder.expectHeader("connection", "keep-alive");
		respSpecBuilder.expectHeader("access-control-allow-origin", "*");
		
		respSpecification=respSpecBuilder.build();
					
	}

	@Test
	public void specificationBuilder1(){
				
		RestAssured.given()
		.spec(reqSpecification)
		.when()
		.get("/weather")
		.then()
		.assertThat()
		.spec(respSpecification)
		.log().all();
		
		System.out.println("specificationBuilder1-completed...");
		
	}
	
	@Test
	public void specificationBuilder2(){
				
		RestAssured.given()
		.spec(reqSpecification)
		.when()
		.get("/weather")
		.then()
		.assertThat()
		.spec(respSpecification).log().all();
		System.out.println("specificationBuilder2-completed...");
		
		}
}
