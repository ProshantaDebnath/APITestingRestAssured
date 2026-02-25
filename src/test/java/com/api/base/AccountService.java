package com.api.base;

import java.util.HashMap;

import com.api.models.request.AccountCreateRequest;

import io.restassured.response.Response;

public class AccountService extends BaseService{
	
	private static final String BASE_PATH = "/api/";
	
	public Response accountCreate(String token, AccountCreateRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH + "accounts");
	}
	
	public Response getAccountDetails(String token, String accountNumber) {
		setAuthToken(token);
		HashMap<String, String> payload = new HashMap<>();
		payload.put("accountNumber", accountNumber);
		return getRequestpathParam(payload, BASE_PATH + "accounts/{accountNumber}");
	}
	
	public Response getAccountUser(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH + "accounts/user");
	}

}
