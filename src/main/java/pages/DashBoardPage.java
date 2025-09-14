package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtil;

public class DashBoardPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private final By logoutLink = By.xpath("//a[.=' Log Out']");
	private final By adminLink = By.xpath("//span[.='admin']");

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getDashBoardPageTitle() {
		return driver.getTitle();
	}

	public LoginPage doLogout() {
		eleUtil.waitForElementVisible(adminLink, 10);
		eleUtil.doClick(adminLink);
		eleUtil.doClick(logoutLink);
		return new LoginPage(driver);
	}
}
