package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.LoginBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class DashBoardTest extends LoginBase {
	@Step("dashboard page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void dashBoardPageTitleTest() {
		String title = dashBoardPage.getDashBoardPageTitle();
		System.out.println("dashboard page title is: " + title);
		Assert.assertEquals(title, "Dashboard");
	}
	@Step("logout from application")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2,enabled=false)
	
	public void doLogoutTest() {
		dashBoardPage.doLogout();
		String title=loginPage.getLoginPageTitle();
		System.out.println("after logout login page title is: "+title);
		Assert.assertEquals(title, "HMIS LOGIN", "login page title matched");
	}
	@Step("go to registration page")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void goToRegistrationPageTest() {
		regPage=dashBoardPage.goToRegistrationPage();
		String title=regPage.getRegistertionPageTitle();
		System.out.println("registration page title is: "+title);
		Assert.assertEquals(title, "Registration", "registration page title matched");
	
}
}