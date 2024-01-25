package selectors;

import org.openqa.selenium.By;

public interface loggedInAsUserNamePage {
	
	By loggedInAsUserName_sel = By.xpath("//ul[@class='nav navbar-nav']/li[10]/a");
	By logout_sel = By.xpath("//div[@class='shop-menu pull-right']//li//a[@href='/logout']");

}
