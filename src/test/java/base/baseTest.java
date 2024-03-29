package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import selectors.accountCreatedPage;
import selectors.basePage;
import selectors.contactUsPage;
import selectors.loggedInAsUserNamePage;
import selectors.newUserForm;
import selectors.signUpPage;
import selectors.testCasesPage;

public class baseTest implements basePage, signUpPage, newUserForm, accountCreatedPage, loggedInAsUserNamePage, contactUsPage, testCasesPage {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	
	@BeforeTest
	public static void openWebsite() throws IOException {
		if(driver==null) {
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties";
			FileInputStream file = new FileInputStream(path);
			prop.load(file);
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("baseUrl"));
			driver.manage().window().maximize();
		}
	}
	
	@AfterTest
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void login(String Email,String Password) throws IOException {
		
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties";
		FileInputStream file = new FileInputStream(path);
		prop.load(file);
		
		driver.findElement(login_email_sel).sendKeys(prop.getProperty(Email));
		driver.findElement(login_password_sel).sendKeys(prop.getProperty(Password));
		driver.findElement(login_submit_sel).click();
		
	}
	
	public static void registerUserWithExistingEmailName(String name,String email) throws IOException {
		
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties";
		FileInputStream file = new FileInputStream(path);
		prop.load(file);
		
		driver.findElement(name_sel).sendKeys(prop.getProperty(name));
		driver.findElement(email_sel).sendKeys(prop.getProperty(email));
		driver.findElement(signUpSubmit_sel).click();
		
	}
	
	public static void registerUser(String name,String email,String password,String accountDetail) {
		
		driver.findElement(name_sel).sendKeys(name);
		driver.findElement(email_sel).sendKeys(email);
		driver.findElement(signUpSubmit_sel).click();
		verifyEnterAccountInformationTag();
		driver.findElement(title_mr_sel).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement pwd = driver.findElement(password_sel);
		js.executeScript("arguments[0].scrollIntoView()",pwd);
		pwd.sendKeys(password);
		
		WebElement day =driver.findElement(day_sel);
		js.executeScript("arguments[0].scrollIntoView()",day);
		Select selDay = new Select(day);
		selDay.selectByValue("10");
		
		WebElement month = driver.findElement(month_sel);
		Select selMonth = new Select(month);
		selMonth.selectByValue("8");
		
		WebElement year = driver.findElement(year_sel);
		Select selYear = new Select(year);
		selYear.selectByValue("2000");
		
		WebElement signUpLetter = driver.findElement(signUpLetter_sel);
		js.executeScript("arguments[0].scrollIntoView()",signUpLetter);
		signUpLetter.click();
		
		JSONObject json = new JSONObject(accountDetail);
		WebElement firstName = driver.findElement(firstName_sel);
		js.executeScript("arguments[0].scrollIntoView()",firstName);
		firstName.sendKeys(json.getString("firstName"));
		
		WebElement lastName = driver.findElement(lastName_sel);
		js.executeScript("arguments[0].scrollIntoView()",lastName);
		lastName.sendKeys(json.getString("lastName"));
		
		WebElement company = driver.findElement(company_sel);
		js.executeScript("arguments[0].scrollIntoView()",company);
		company.sendKeys(json.getString("company"));
		
		WebElement address1 = driver.findElement(address1_sel);
		js.executeScript("arguments[0].scrollIntoView()",address1);
		address1.sendKeys(json.getString("address1"));
		
		WebElement address2 = driver.findElement(address2_sel);
		js.executeScript("arguments[0].scrollIntoView()",address2);
		address2.sendKeys(json.getString("address2"));
		
		WebElement country = driver.findElement(country_sel);
		js.executeScript("arguments[0].scrollIntoView()",country);
		Select cntry = new Select(country);
		cntry.selectByVisibleText(json.getString("country"));
		
		WebElement state = driver.findElement(state_sel);
		js.executeScript("arguments[0].scrollIntoView()",state);
		state.sendKeys(json.getString("state"));
		
		WebElement city = driver.findElement(city_sel);
		js.executeScript("arguments[0].scrollIntoView()",city);
		city.sendKeys(json.getString("city"));
		
		WebElement zipCode = driver.findElement(zipCode_sel);
		js.executeScript("arguments[0].scrollIntoView()",zipCode);
		zipCode.sendKeys(json.getString("zipCode"));
		
		WebElement mobile = driver.findElement(mobile_sel);
		js.executeScript("arguments[0].scrollIntoView()",mobile);
		mobile.sendKeys(json.getString("mobile"));
		
		WebElement create = driver.findElement(createAccount_sel);
		js.executeScript("arguments[0].scrollIntoView()",create);
		create.click();
		
	}
	
	public static void verifyAccountCreation(){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement accountCreation = driver.findElement(accountCreatedLabel_sel);
		wait.until(ExpectedConditions.visibilityOf(accountCreation));
		String label = accountCreation.getText();
		Assert.assertEquals(label,"ACCOUNT CREATED!");
		
	}
	
	public static void continueAndVerifyLoginAsUserName(String name){
		
		driver.findElement(continueBtn_sel).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loggedIn = driver.findElement(loggedInAsUserName_sel);
		wait.until(ExpectedConditions.visibilityOf(loggedIn));
		String actualLoggedInText = loggedIn.getText();
		String expectedLoggedInText = "Logged in as " + name;
		Assert.assertEquals(actualLoggedInText, expectedLoggedInText);
		
	}
	
	public static void verifyEnterAccountInformationTag() {
		String accountLabelText = driver.findElement(enterAccountInformation_sel).getText();
		Assert.assertEquals(accountLabelText,"ENTER ACCOUNT INFORMATION");
	}
	
	public static void verifyOnHomePage() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement homeTab = driver.findElement(homeTab_sel);
		
		wait.until(ExpectedConditions.visibilityOf(homeTab));
		
		String styleVal = homeTab.getAttribute("style");
		Boolean styleOrangeValue;
		if(styleVal.contains("orange")) {
			styleOrangeValue = true;
		}else {
			styleOrangeValue = false;
		}
		
		Assert.assertTrue(styleOrangeValue);
		
	}
	
	public static void goToSignUpLoginPage() {
		
		driver.findElement(signUpLoginBtn_sel).click();
		
	}
	
	public static void verifyNewSignUpMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement newSignUp = driver.findElement(newSignUpTest_sel);
		wait.until(ExpectedConditions.visibilityOf(newSignUp));
		String newSignUpText = newSignUp.getText();
		Assert.assertEquals(newSignUpText,"New User Signup!");
		
	}
	
	public static void verifyLogInToYouAccount() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement loginToAccount = driver.findElement(logInToYourAccount_sel);
		wait.until(ExpectedConditions.visibilityOf(loginToAccount));
		String loginToAccountText = loginToAccount.getText();
		Assert.assertEquals(loginToAccountText,"Login to your account");
		
	}
	
	public static String getUserName() throws IOException {
		
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties";
		FileInputStream file = new FileInputStream(path);
		prop.load(file);
		
		String user = prop.getProperty("validUsername");
		return user;
		
	}
	
	public static void verifyLoginAsUserName(String name){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loggedIn = driver.findElement(loggedInAsUserName_sel);
		wait.until(ExpectedConditions.visibilityOf(loggedIn));
		String actualLoggedInText = loggedIn.getText();
		String expectedLoggedInText = "Logged in as " + name;
		Assert.assertEquals(actualLoggedInText, expectedLoggedInText);
		
	}
	
	public static void verifyIncorrectEmailPassword() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement incorrectEmail = driver.findElement(emailPasswordIncorrect_sel);
		wait.until(ExpectedConditions.visibilityOf(incorrectEmail));
		String ActualIncorrectEmailMessage = incorrectEmail.getText();
		Assert.assertEquals(ActualIncorrectEmailMessage, "Your email or password is incorrect!");
		
	}
	
	public static void logout() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logout = driver.findElement(logout_sel);
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
		
	}
	
	public static void verifyEmailAlreadyExisting() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement emailExisting = driver.findElement(emailAlreadyExist_sel);
		wait.until(ExpectedConditions.visibilityOf(emailExisting));
		
		String actualEmaiExistingText = emailExisting.getText();
		Assert.assertEquals(actualEmaiExistingText, "Email Address already exist!");
		
	}
	
	public static void goToContactUsForm() {
		
		driver.findElement(contactUs_sel).click();
		
	}
	
	public static void verifyGetInTouchVisible() {
		
		WebElement getInTouchText_ele = driver.findElement(contactus_getInTouch_sel);
		String getInTouchText = getInTouchText_ele.getText();
		Assert.assertEquals(getInTouchText,"GET IN TOUCH");
		
	}
	
	public static void enterContactUsFormDetailAndSubmit(String name,String email,String subject,String message,String filePath) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement name_ele = driver.findElement(contactus_name_sel);
		WebElement email_ele = driver.findElement(contactus_email_sel);
		WebElement subject_ele = driver.findElement(contactus_subject_sel);
		WebElement message_ele = driver.findElement(contactus_message_sel);
		WebElement chooseFile_ele = driver.findElement(contactus_chooseFile_sel);
		WebElement submit_ele = driver.findElement(contactus_submit_sel);
		
		js.executeScript("arguments[0].scrollIntoView()",name_ele);
		name_ele.sendKeys(name);
		
		js.executeScript("arguments[0].scrollIntoView()",email_ele);
		email_ele.sendKeys(email);
		
		js.executeScript("arguments[0].scrollIntoView()",subject_ele);
		subject_ele.sendKeys(subject);
		
		js.executeScript("arguments[0].scrollIntoView()",message_ele);
		message_ele.sendKeys(message);
		
		js.executeScript("arguments[0].scrollIntoView()",chooseFile_ele);
		chooseFile_ele.sendKeys(filePath);
		
		js.executeScript("arguments[0].scrollIntoView()",submit_ele);
		submit_ele.click();
			
	}
	
	public static void acceptingAlert() {
		
		driver.switchTo( ).alert( ).accept();
		
	}
	
	public static void verifySuccessMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement successMessage_ele = driver.findElement(contactus_successMessage_sel);
		
		wait.until(ExpectedConditions.visibilityOf(successMessage_ele));
		String actualSuccessMessage = successMessage_ele.getText();
		Assert.assertEquals(actualSuccessMessage,"Success! Your details have been submitted successfully.");
		
	}
	
	public static void goToHomePageFromContactUs() {
		
		driver.findElement(contactus_homeBtn_sel).click();
	
	}
	
	public static void goToTestCases() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement testCasesTab = driver.findElement(testCases_sel);
		wait.until(ExpectedConditions.visibilityOf(testCasesTab));
		testCasesTab.click();
		
	}
	
	public static void verifyUserOnTestCasePAge() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement testCasesLabel = driver.findElement(testCaseLabel);
		wait.until(ExpectedConditions.visibilityOf(testCasesLabel));
		String testCasesLabel_text = testCasesLabel.getText();
		
		Assert.assertEquals(testCasesLabel_text, "TEST CASES");
		
	}
		

}
