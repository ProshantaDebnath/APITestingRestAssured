package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfilePasswordChangeRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class ChangeProfilePasswordTest {
	
	@Test(description = "Verify change profile password is working or not.")
	public void changeProfilePasswordTest() {
		
		AuthService authservice = new AuthService();
		Response response =  authservice.login(new LoginRequest("Api Testing", "apitesting@gmail.com"));		
		LoginResponse loginResponse =response.as(LoginResponse.class);

		UserManagementService userManagementService = new UserManagementService();
		
		ProfilePasswordChangeRequest changeProfilePassword = new ProfilePasswordChangeRequest.Builder()
															.currentPassword("apitesting@gmail.com")
															.newPassword("apitesting@gmail.com1")
															.confirmPassword("apitesting@gmail.com1")
															.Build();
		
		
		response = userManagementService.changePrfilePassword(loginResponse.getToken(), changeProfilePassword);
		System.out.println(response.asPrettyString());
		
			
	}

}
