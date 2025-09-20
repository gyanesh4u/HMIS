package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtil;

public class RegisterationPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private final By selectPrefix = By.id("s2id_prefix");
	private final By selectTitle = By.cssSelector("div[id='select2-drop'] input[type='text']");
	private final By firstname = By.id("fName");
	private final By lastname = By.id("lName");
	private final By selectGender = By.cssSelector("div[id='s2id_gender'] span[class='select2-chosen']");
	private final By selectGenderOption = By.cssSelector("div[id='select2-drop'] input[type='text']");
	private final By mobileNumber = By.id("mobile");
	private final By yrs = By.id("year");
	private final By mth = By.id("month");
	private final By d = By.id("days");
	private final By selectDepartment = By
			.xpath("//div[@id='s2id_department']//span[@class='select2-chosen'][normalize-space()='--Select--']");
	private final By selectDepartmentOption = By.cssSelector("div[id='select2-drop'] input[type='text']");
	private final By doctorOption = By.xpath("//div[@id='s2id_doctorName']//span[@class='select2-chosen']");
	private final By selectDoctor = By.xpath("//div[@id='select2-drop']//input[@type='text']");
	private final By saveBtn = By.xpath("//button[@id='savebuton']");

	public RegisterationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getRegistertionPageTitle() {
		return driver.getTitle();
	}

	public void registerNewPatient(String title, String fname, String lname, String gender, String mobile, String years,
			String month, String day, String department, String doctor) {
		eleUtil.waitForElementVisible(selectPrefix, 10);
		eleUtil.doClick(selectPrefix);
		eleUtil.waitForElementsVisible(selectTitle, 20);
		eleUtil.selectFromSelect2(selectTitle, title);
		eleUtil.waitForElementVisible(firstname, 10);
		eleUtil.doSendKeys(firstname, fname);
		eleUtil.doSendKeys(lastname, lname);
		eleUtil.doClick(selectGender);
		eleUtil.selectFromSelect2(selectGenderOption, gender);
		eleUtil.doSendKeys(mobileNumber, mobile);
		eleUtil.doSendKeys(yrs, years);
		eleUtil.doSendKeys(mth, month);
		eleUtil.doSendKeys(d, day);
		eleUtil.doClick(selectDepartment);
		eleUtil.selectFromSelect2(selectDepartmentOption, department);
		eleUtil.doClick(doctorOption);
		eleUtil.selectFromSelect2(selectDoctor, doctor);
		eleUtil.doClick(saveBtn);
		eleUtil.dismissAlert(10);
	}
}
