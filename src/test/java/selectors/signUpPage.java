package selectors;

import org.openqa.selenium.By;

public interface signUpPage {
	
	By newSignUpTest_sel = By.xpath("//div[@class='signup-form']/h2");
	By name_sel = By.xpath("//input[@name=\"name\"]");
	By email_sel = By.xpath("//form[@action='/signup']//input[@name=\"email\"]");
	By signUpSubmit_sel = By.xpath("//button[@data-qa='signup-button']");

}
