package automationExerciseTest;

import org.testng.annotations.Test;

import base.baseTest;

public class TC07_verifyTestCasesPage extends baseTest{
	
	@Test
	public static void verifyTestCasePage() {
		
		baseTest.verifyOnHomePage();
		baseTest.goToTestCases();
		baseTest.verifyUserOnTestCasePAge();
		
	}

}
