package base;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import factory.DriverFactory;
import io.qameta.allure.Description;
import pages.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	protected Properties prop;
	public DriverFactory df;

	protected LoginPage loginPage;

	@Description("launch the browser: {0} and url")
	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(@Optional("chrome") String browserName) {
		df = new DriverFactory();
		prop = df.initProp();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}

		driver = df.initDriver(prop);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginPage = new LoginPage(driver);
		// commonsPage = new CommonsPage(driver);
	}

	@AfterMethod // will be running after each @test method
	public void attachScreenshot(ITestResult result) {

		if (!result.isSuccess()) {// only for failure test cases -- true
			// Allure.attachment(DriverFactory.getScreenshotFile(), "image/png");
			File src = df.getScreenshotFile();
			Reporter.log("taken screenshot and saving to snap",true);
			try {
				FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/snap/" + System.currentTimeMillis()
						+ result.getName() + ".png"));

			}

			catch (Exception e) {
			}
		}
	}

	@Description("closing the browser...")
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
