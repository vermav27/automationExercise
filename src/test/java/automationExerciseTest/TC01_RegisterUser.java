package automationExerciseTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import base.baseTest;

public class TC01_RegisterUser extends baseTest {
	
	@Test
	public static void registerUser() {
		
		String name =  "testmail" + RandomStringUtils.randomAlphanumeric(5) ;
		String email = name + "@mail.com";
		String password = RandomStringUtils.randomAlphanumeric(8);
		String accountDetail = "{\r\n"
				+ "  \"firstName\" : \"tester\",\r\n"
				+ "  \"lastName\" : \"test\",\r\n"
				+ "  \"company\" : \"testingcompany\",\r\n"
				+ "  \"address1\" : \"add1\",\r\n"
				+ "  \"address2\" : \"add2\",\r\n"
				+ "  \"country\" : \"Canada\",\r\n"
				+ "  \"state\" : \"teststate\",\r\n"
				+ "  \"city\" : \"testcity\",\r\n"
				+ "  \"zipCode\" : \"110001\",\r\n"
				+ "  \"mobile\" : \"9090909090\"\r\n"
				+ "}";
		baseTest.verifyOnHomePage();
		baseTest.goToSignUpLoginPage();
		baseTest.verifyNewSignUpMessage();
		baseTest.registerUser(name,email,password,accountDetail);
		baseTest.verifyAccountCreation();
		baseTest.continueAndVerifyLoginAsUserName(name);
	}

}
