package automationExerciseTest;

import java.io.IOException;

import org.testng.annotations.Test;

import base.baseTest;

public class TC03_loginWithIncorrectEmailPassword extends baseTest {
	
	@Test
	public static void loginWithIncorrectEmailPassword() throws IOException {
		
		baseTest.verifyOnHomePage();
		baseTest.goToSignUpLoginPage();
		baseTest.verifyLogInToYouAccount();
		baseTest.login("invalidEmail","invalidPassword");
		baseTest.verifyIncorrectEmailPassword();
		
	}

}
