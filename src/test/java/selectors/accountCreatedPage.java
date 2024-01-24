package selectors;

import org.openqa.selenium.By;

public interface accountCreatedPage {
	
	By accountCreatedLabel_sel =By.xpath("//h2[@data-qa='account-created']/b");
	By continueBtn_sel = By.xpath("//a[text()='Continue']");

}
