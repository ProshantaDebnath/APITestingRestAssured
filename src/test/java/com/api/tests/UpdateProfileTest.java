package com.api.tests;

import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileUpdateRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test(description = "Verify update the exsiting record or not")
	public void updateProfileTest() {
		
		AuthService authservice = new AuthService();
		Response response =  authservice.login(new LoginRequest("Api Testing", "apitesting@gmail.com"));		
		LoginResponse loginResponse =response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("------------------------------------------------");
		
		UserManagementService userManagementService = new UserManagementService();
		response = userManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		System.out.println("------------------------------------------------");
		
		
		ProfileUpdateRequest profileUpdateRequest = new ProfileUpdateRequest.Builder()
													.firstName("RestAssuredAPI")
													.lastName("TestingRestAssured")
													.email("restassured@gmail.com")
													.mobileNumber("1234567890")
													.Build();
		
		response = userManagementService.updateProfile(loginResponse.getToken(), profileUpdateRequest);
		System.out.println(response.asPrettyString());
		
		
	}
}
