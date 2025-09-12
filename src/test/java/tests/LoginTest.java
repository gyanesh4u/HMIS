package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class LoginTest extends BaseTest {
	@Step("login test..")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(df.getproperty("username"), df.getproperty("password"));
	}

	@Test(priority = 1)
	public void titleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HMIS LOGIN");
	}

	@Test(priority = 2)
	public void logoTest() {
		Assert.assertTrue(loginPage.logoIsDisplayed());
	}
}
