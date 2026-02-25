package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AccountService;
import com.api.base.AuthService;
import com.api.models.request.AccountCreateRequest;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AccountCreateTest {
	
	@Test(description = "Verify that account is successfully create or not")
	public void accountCreateTesst() {
		
		AuthService authservice = new AuthService();		
		Response response =  authservice.login(new LoginRequest("Api Testing", "apitesting@gmail.com"));		
		LoginResponse loginResponse =response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		
		AccountService accountService = new AccountService();
		response = accountService.accountCreate(loginResponse.getToken(), new AccountCreateRequest("CURRENT", "SOUTH_BRANCH"));
		System.out.println(response.asPrettyString());
		
	}
	
	
}
