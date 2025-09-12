package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private final By userName = By.name("username");
	private final By passWord = By.name("pass");
	private final By loginBtn = By.id("btnLogin");
	private final By logo = By.xpath("//img[@src='images/Hospital/logo.png']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	@Step("getting login page title....")
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		// System.out.println("login page title: "+ title);
		// log.info("login page title: " + title);
		return title;
	}

	@Step("login with correct username: {0} and password: {1}")
	public void doLogin(String appUsername, String appPassword) {
		// log.info("application credentials: " + appUsername + " : " + "*********");
		eleUtil.waitForElementVisible(userName, 10).sendKeys(appUsername);
		eleUtil.doSendKeys(passWord, appPassword);
		eleUtil.doClick(loginBtn);
		// return new AccountsPage(driver);
	}

	@Step("logo test for login")
	public boolean logoIsDisplayed() {
		return eleUtil.isElementDisplayed(logo);
	}
}
