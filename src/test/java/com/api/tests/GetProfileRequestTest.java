package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test
	public void getProfileInfoTest() {
		
		AuthService authservice = new AuthService();
		//Serialization			
		Response response = authservice.login(new LoginRequest("Api Testing","apitesting@gmail.com"));	
		//Deserialization
		LoginResponse loginResponse =  response.as(LoginResponse.class);
		
		UserManagementService userManagementService = new UserManagementService();
	    Response userprofileinfo = userManagementService.getProfile(loginResponse.getToken());
	    
	    //Deserialization
	    UserProfileResponse profileinfo = userprofileinfo.as(UserProfileResponse.class);	 
	   
	    System.out.println("FistName : " + profileinfo.getFirstName());
	    System.out.println("LastName : " + profileinfo.getLastName());
		
		
	}
}
