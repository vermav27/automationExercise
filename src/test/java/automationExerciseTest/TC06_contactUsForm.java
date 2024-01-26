package automationExerciseTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import base.baseTest;

public class TC06_contactUsForm extends baseTest{
	
	@Test
	public static void contactUsForm() {
		
		baseTest.verifyOnHomePage();
		baseTest.goToContactUsForm();
		baseTest.verifyGetInTouchVisible();
		
		String name =  "testmail" + RandomStringUtils.randomAlphanumeric(5) ;
		String email = name + "@mail.com";
		String subject = name + "_subject";
		String message = "This is the demo message for " + subject + "having email as" + email + ". Thanks You By " + name;
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\uploadTestFile.txt";
		
		baseTest.enterContactUsFormDetailAndSubmit(name,email,subject,message,filePath);
		baseTest.acceptingAlert();
		baseTest.verifySuccessMessage();
		baseTest.goToHomePageFromContactUs();
		baseTest.verifyOnHomePage();
		
	}

}
