package automationExerciseTest;

import java.io.IOException;

import org.testng.annotations.Test;

import base.baseTest;

public class TC02_loginWithCorrectEmailPassword extends baseTest{
	
	@Test
	public static void loginWithCorrectEmailPassword() throws IOException {
		
		baseTest.verifyOnHomePage();
		baseTest.goToSignUpLoginPage();
		baseTest.verifyLogInToYouAccount();
		baseTest.login("validEmail","validPassword");
		String username = baseTest.getUserName();
		baseTest.verifyLoginAsUserName(username);
		
	}

}
