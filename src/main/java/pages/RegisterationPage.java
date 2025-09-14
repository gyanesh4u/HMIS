package pages;

import org.openqa.selenium.WebDriver;

import utils.ElementUtil;

public class RegisterationPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public RegisterationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	public String getRegistertionPageTitle() {
		return driver.getTitle();
	}
}
