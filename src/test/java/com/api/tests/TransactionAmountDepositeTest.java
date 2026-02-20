package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.TransactionService;
import com.api.models.request.LoginRequest;
import com.api.models.request.TransactionDepositeRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class TransactionAmountDepositeTest {
	
	@Test(description = "Verify that transaction amount is successfully credited or not")
	
	public void transactionAmountDepositeTest() {
		
		AuthService authservice = new AuthService();		
		Response response =  authservice.login(new LoginRequest("Api Testing", "apitesting@gmail.com"));		
		LoginResponse loginResponse =response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		
		
		TransactionService transactionService = new TransactionService();
		response = transactionService.amountDeposite(loginResponse.getToken(), new TransactionDepositeRequest("1605614959", 100000, "2nd Deposite"));
		System.out.println(response.asPrettyString());		
	}

}
