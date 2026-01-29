package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class LogInAPITest {

	@Test(description = "Verify is api is working or not")
	public void loginTest() {

		Response response = given()
							.baseUri("http://64.227.160.186:8080")
							.header("Content-Type", "application/json")
							.body("{\"username\": \"\",\"password\": \"\"}")
							.post("/api/auth/login");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(response.asPrettyString());

	}

}
