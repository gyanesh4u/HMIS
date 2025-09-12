package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import listeners.TestAllureListener;
@Listeners(TestAllureListener.class)
public class LoginTest extends BaseTest {
	@Step("login test..")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
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

	@DataProvider
	public Object[][] invalidLoginCredentials() {
		return new Object[][] { 
			{ "testselelettttt@gmail.com", "test@123" }, 
			{ "march2024@open.com", "test@123" },
			{ "march2024@@open.com", "test@@123" },
			{ "", "test@123" }, 
			{ "", "" } };

	}
	@Test(priority = 3,dataProvider = "invalidLoginCredentials")
	public void invalidLoginTest(String invalidUsername,String invalidPassword) {
		loginPage.doLogin(invalidUsername,invalidPassword);
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
	}
}
