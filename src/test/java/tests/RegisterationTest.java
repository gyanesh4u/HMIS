package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.LoginBase;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class RegisterationTest extends LoginBase {
	/**
	 * @author gyaneshkamal This class is used to perform registration of new
	 *         patient Used faker library to generate test data DataProvider is used
	 *         to provide test data Allure annotations are used to generate allure
	 *         report Assert is used to verify the title of the page after
	 *         registration
	 */
	Faker faker = new Faker();

	@Severity(SeverityLevel.CRITICAL)
	@Description("this test is performing registration of new patient")
	@Owner("Gyanesh")
	@Step("register new patient test")
	@Test(priority = 1, dataProvider = "getRegisterData")
	public void registerNewPatientTest(String title, String fname, String lname, String gender, String mobile,
			String years, String month, String day, String department) {
		dashBoardPage.goToRegistrationPage();
		regPage.registerNewPatient(title, fname, lname, gender, mobile, years, month, day, department);
		System.out.println(title + " " + fname + " " + lname + " | " + gender + " | " + mobile + " | Age: " + years
				+ " | DOB: " + month + "-" + day + " | Dept: " + department);
		title = regPage.getRegistertionPageTitle();
		Assert.assertEquals(title, "Billing");

	}

	@DataProvider(name = "getRegisterData")
	public Object[][] getRegisterData() {
		// return new Object[][] { { "Mr.", "Tom", "Jerry", "Male", "9876543210", "35",
		// "05", "15", "OPD" } };
		Object[][] data = new Object[1][9];

		for (int i = 0; i < 1; i++) {
			String title = faker.options().option("Mr.", "Ms.", "Mrs.");
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String gender = faker.options().option("Male", "Female");
			String phone = faker.number().digits(10); // random 10-digit phone number
			String age = String.valueOf(faker.number().numberBetween(18, 60)); // random age 18-60
			String month = String.format("%02d", faker.number().numberBetween(1, 12)); // 01-12
			String day = String.format("%02d", faker.number().numberBetween(1, 28)); // 01-28
			String department = faker.options().option("OPD", "IPD", "Emergency");

			data[i][0] = title;
			data[i][1] = firstName;
			data[i][2] = lastName;
			data[i][3] = gender;
			data[i][4] = phone;
			data[i][5] = age;
			data[i][6] = month;
			data[i][7] = day;
			data[i][8] = department;
		}
		return data;
	}
}