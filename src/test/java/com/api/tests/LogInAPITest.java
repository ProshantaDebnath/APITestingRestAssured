package com.api.tests;

import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;

import io.restassured.response.Response;



public class LogInAPITest {

	@Test(description = "Verify is api is working or not")
	public void loginTest() {
	
	//creating the pojo object then pass it over AuthServices
	LoginRequest loginRequest = new LoginRequest("","");

	AuthService authservice = new AuthService();
	
	Response response = authservice.login(loginRequest);
	
	System.out.println(response.asPrettyString());
	
	}

}
