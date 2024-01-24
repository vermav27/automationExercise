package selectors;

import org.openqa.selenium.By;

public interface newUserForm {
	
	By enterAccountInformation_sel = By.xpath("//div[@class='login-form']//h2[@class='title text-center']/b");
	By title_mr_sel = By.xpath("//input[@id='id_gender1']");
	By password_sel = By.xpath("//input[@id='password']");
	By day_sel = By.xpath("//select[@id='days']");
	By month_sel = By.xpath("//select[@id='months']");
	By year_sel = By.xpath("//select[@id='years']");
	By signUpLetter_sel = By.xpath("//input[@id='newsletter']");
	By firstName_sel = By.xpath("//input[@id='first_name']");
	By lastName_sel = By.xpath("//input[@id='last_name']");
	By company_sel = By.xpath("//input[@id='company']");
	By address1_sel = By.xpath("//input[@id='address1']");
	By address2_sel = By.xpath("//input[@id='address2']");
	By country_sel = By.xpath("//select[@id='country']");
	By state_sel = By.xpath("//input[@id='state']");
	By city_sel = By.xpath("//input[@id='city']");
	By zipCode_sel = By.xpath("//input[@id='zipcode']");
	By mobile_sel = By.xpath("//input[@id='mobile_number']");
	By createAccount_sel = By.xpath("//button[@type='submit' and @data-qa='create-account']");
	

}
