package selectors;

import org.openqa.selenium.By;

public interface signUpPage {
	
	By newSignUpTest_sel = By.xpath("//div[@class='signup-form']/h2");
	By name_sel = By.xpath("//input[@name=\"name\"]");
	By email_sel = By.xpath("//form[@action='/signup']//input[@name=\"email\"]");
	By signUpSubmit_sel = By.xpath("//button[@data-qa='signup-button']");
	By login_email_sel = By.xpath("//form[@action='/login']//input[@name='email']");
	By login_password_sel = By.xpath("//form[@action='/login']//input[@name='password']");
	By login_submit_sel = By.xpath("//form[@action='/login']//button[@type='submit']");
	By logInToYourAccount_sel = By.xpath("//div[@class='login-form']/h2");
	By emailPasswordIncorrect_sel = By.xpath("//form[@action='/login']/p");
	By emailAlreadyExist_sel = By.xpath("//form[@action='/signup']//p");
}
