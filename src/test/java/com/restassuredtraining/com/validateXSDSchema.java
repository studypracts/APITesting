package com.restassuredtraining.com;


	import static io.restassured.RestAssured.*;
	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
import io.restassured.internal.matcher.xml.XmlXsdMatcher;
import io.restassured.module.jsv.JsonSchemaValidator;
	import io.restassured.response.Response;

	public class validateXSDSchema {
		
		@Test
		public void assertJSONSchema(){
			RestAssured.baseURI="http://www.thomas-bayer.com";
			
			Response resp = RestAssured.given().when()
			.get("/sqlrest/CUSTOMER/10");
			
			resp.then().assertThat().body(XmlXsdMatcher.matchesXsdInClasspath("XsdSchema.xsd"));
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
