package automationExerciseTest;

import java.io.IOException;

import org.testng.annotations.Test;

import base.baseTest;

public class TC05_registerUserWithExistingEmail extends baseTest {
	
	@Test
	public static void registerUserWithExistingEmail() throws IOException {
		
		baseTest.verifyOnHomePage();
		baseTest.goToSignUpLoginPage();
		baseTest.verifyNewSignUpMessage();
		baseTest.registerUserWithExistingEmailName("validUsername","validEmail");
		baseTest.verifyEmailAlreadyExisting();
		
	}

}
