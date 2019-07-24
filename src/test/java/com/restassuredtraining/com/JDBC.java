package com.restassuredtraining.com;

import static org.hamcrest.Matchers.equalTo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JDBC {
	
	@Test
	public void validateDB() throws Exception{
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world", "root", "cybage@123");
		Statement st = conn.createStatement();
		
		String query= "select name from city where name = 'Dallas'";
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()){
			System.out.println(rs.getString("name"));
			String cityFronDB = rs.getString("name");
			
			RestAssured.baseURI="http://www.thomas-bayer.com";
			Response resp = RestAssured.given()
			.when()
			.get("/sqlrest/CUSTOMER/10");
			
			String cityFromWS = resp.then().extract().path("CUSTOMER.CITY");
			//assertThat().body("CUSTOMER.CITY", equalTo("Dallas"));
			if(cityFronDB.equals(cityFromWS)){
				System.out.println("DB Validation Passed");
				}
			else{
				System.out.println("DB Validation Failed");
			}
		}
		
		
		
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
