package com.restassuredtraining.com;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DataDrivenTest {

	@DataProvider(name="cityList")
	public String[] testData(){
		return new String[]{"Pune", "Mumbai", "Nagpur"};
	}
	
	
	@Test(dataProvider="cityList")
	public void dataDrivenTesting(String cityName){
	
		RestAssured.baseURI="http://api.openweathermap.org";
		RestAssured.basePath="/data/2.5";
		
		RestAssured.given()
		.queryParam("q", cityName)
		.queryParam("appid", "d2d1f28fcb8df8073a1d14f89b70f305")
		.when()
		.get("/weather")
		.then()
		.log()
		.all();
	}
	
}
