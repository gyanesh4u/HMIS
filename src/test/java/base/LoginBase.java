package base;

import org.testng.annotations.BeforeClass;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginBase extends BaseTest {
	//protected LoginPage loginPage;

	@Step("valid login test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("this test is performing login with valid credentials")
	@Owner("Gyanesh")
	@BeforeClass
	public void login() {
		// loginPage = new LoginPage(driver);
		dashBoardPage = loginPage.doLogin(df.getproperty("username"), df.getproperty("password"));
	}
}
