package selectors;

import org.openqa.selenium.By;

public interface basePage {
	
	By homeTab_sel = By.xpath("//ul[@class='nav navbar-nav']/li[1]/a");
	By signUpLoginBtn_sel = By.xpath("//ul[@class='nav navbar-nav']/li/a[@href='/login']");
	By contactUs_sel = By.xpath("//a[@href='/contact_us']");
	
}
