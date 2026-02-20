package com.api.base;

import java.util.HashMap;

import com.api.models.request.TransactionDepositeRequest;

import io.restassured.response.Response;

public class TransactionService extends BaseService{
	
	private static final String BASE_PATH = "/api/transactions/";
	
	public Response amountDeposite(String token, TransactionDepositeRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH + "deposit");
	}
	
	public Response getTransactionHistory(String token, String accountNumber, int page, int size) {
		setAuthToken(token);
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("accountNumber", accountNumber);
		payload.put("page", page);
		payload.put("size", size);
		return getRequestQueryParams(payload, BASE_PATH + "history");
	}

}
