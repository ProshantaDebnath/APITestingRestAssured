package com.api.tests;

import org.testng.annotations.Test;
import com.api.base.AuthService;
import io.restassured.response.Response;

public class ForgotPasswordTest {

		@Test(description = "Verify is forgot password is working or not")
		public void forgettPasswordTest() {
				
			AuthService authservice = new AuthService();
			Response response = authservice.forgotPassword("apitesting@gmail.com");
			System.out.println(response.asPrettyString());
		
		}
}
