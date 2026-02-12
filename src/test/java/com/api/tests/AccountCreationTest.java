package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description = "Verify is api create the record or not")
	public void SignUpTest() {
		
		SignUpRequest signuprequest = new SignUpRequest.Builder()
									.email("pik@gmail.com")
									.username("piku452871")
									.password("piku12345")
									.firstName("Piku")
									.lastName("K")
									.mobileNumber("1234567890")
									.build();
		
		AuthService authservice = new AuthService();
			
		Response response = authservice.signUp(signuprequest);
		
		System.out.println(response.asPrettyString());
		
		
	}	

}
