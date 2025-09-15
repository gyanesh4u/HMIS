package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.LoginBase;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class RegisterationTest extends LoginBase {

	@Severity(SeverityLevel.CRITICAL)
	@Description("this test is performing registration of new patient")
	@Owner("Gyanesh")
	@Step("register new patient test")
	@Test(priority = 1, dataProvider = "getRegisterData")
	public void registerNewPatientTest(String title, String fname, String lname, String gender, String mobile,
			String years, String month, String day, String department) {
		dashBoardPage.goToRegistrationPage();
		regPage.registerNewPatient(title, fname, lname, gender, mobile, years, month, day, department);
		Assert.assertEquals(driver.getTitle(), "Billing");

	}

	   @DataProvider(name = "getRegisterData")
	    public Object[][] getRegisterData() {
	        return new Object[][] {
	            { "Mr.", "Tom", "Jerry", "Male", "9876543210", "35", "05", "15", "OPD" }
	        };
	    }
	}
