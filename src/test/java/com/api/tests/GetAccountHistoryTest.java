package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.TransactionService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class GetAccountHistoryTest {

	@Test(description = "Verify that account history is getting or not")

	public void getAccountHistory() {

		AuthService authservice = new AuthService();
		Response response = authservice.login(new LoginRequest("Api Testing", "apitesting@gmail.com"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		TransactionService transactionService = new TransactionService();
		response = transactionService.getTransactionHistory(loginResponse.getToken(), "1605614959", 0, 10);
		//System.out.println(response.asPrettyString());

	}

}
