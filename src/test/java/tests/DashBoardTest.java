package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.LoginBase;
import io.qameta.allure.Step;

public class DashBoardTest extends LoginBase {
	@Step("dashboard page title test")
	@Test(priority = 1)
	public void dashBoardPageTitleTest() {
		String title = dashBoardPage.getDashBoardPageTitle();
		System.out.println("dashboard page title is: " + title);
		Assert.assertEquals(title, "Dashboard");
	}
	@Test(priority=2)
	public void doLogoutTest() {
		dashBoardPage.doLogout();
		String title=loginPage.getLoginPageTitle();
		System.out.println("after logout login page title is: "+title);
		Assert.assertEquals(title, "HMIS LOGIN", "login page title matched");
	}

}
