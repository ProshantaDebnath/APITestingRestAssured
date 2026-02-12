package com.api.tests;

import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;



public class LogInAPITest {

	@Test(description = "Verify is api is working or not")
	public void loginTest() {
			
	//Converts a Java object → JSON/XML string = Serialization
	LoginRequest loginRequest = new LoginRequest("Api Testing","apitesting@gmail.com");
	
	AuthService authservice = new AuthService();	
	Response response = authservice.login(loginRequest);
	
	//Converts JSON/XML response → Java object (POJO) = Deserialization
	LoginResponse loginresonse = response.as(LoginResponse.class);
	
	System.out.println(loginresonse.getToken());
	
	System.out.println(response.asPrettyString());
	
	}

}
