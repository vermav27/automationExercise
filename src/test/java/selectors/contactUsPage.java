package selectors;

import org.openqa.selenium.By;

public interface contactUsPage {
	
	By contactus_getInTouch_sel = By.xpath("//div[@class='contact-form']//h2");
	By contactus_email_sel = By.xpath("//input[@name='email']");
	By contactus_name_sel = By.xpath("//input[@name='name']");
	By contactus_subject_sel = By.xpath("//input[@name='subject']");
	By contactus_message_sel = By.xpath("//textarea[@name='message']");
	By contactus_submit_sel = By.xpath("//input[@name='submit']");
	By contactus_chooseFile_sel = By.xpath("//input[@name='upload_file']");
	By contactus_successMessage_sel = By.xpath("//div[@class='status alert alert-success']");
	By contactus_homeBtn_sel = By.xpath("//div[@id='form-section']//span");
	
}
