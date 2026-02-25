package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AccountService;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAccountDetailsTest {
	
	@Test(description = "Verify that Account Details Fetched Successfully")
	public void getAccountDetailsTest() {
		
		AuthService authservice = new AuthService();		
		Response response =  authservice.login(new LoginRequest("Api Testing", "apitesting@gmail.com"));		
		LoginResponse loginResponse =response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		
		//code for getting the Account Details
		AccountService accountService = new AccountService();
		response = accountService.getAccountDetails(loginResponse.getToken(), "2042258090");
		System.out.println(response.asPrettyString());
		
		
		//Code for Getting the Account user Details
		response = accountService.getAccountUser(loginResponse.getToken());
		
        // Convert response to JsonPath
        JsonPath jsonPath = response.jsonPath();

        // Extract the second object (index 1)
        String secondAccount = jsonPath.getString("[1]");
        String accountNumber = jsonPath.getString("[1].accountNumber");
        String accountType = jsonPath.getString("[1].accountType");
        Double balance = jsonPath.getDouble("[1].balance");

        System.out.println("Second Account: " + secondAccount);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);

		
	}

}
