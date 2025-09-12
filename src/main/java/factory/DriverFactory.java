package factory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;

	public static String highlightEle;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is init the driver on the basis of browser...
	 * 
	 * @param browserName
	 * @return it returns driver
	 */
	public WebDriver initDriver(Properties prop) {

		String browserName = prop.getProperty("browser");
		// System.out.println("browser name : " + browserName);
		Reporter.log("browser name : " + browserName+"...", true);

		highlightEle = prop.getProperty("highlight");

		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			tlDriver.set(new ChromeDriver());
			break;
		case "firefox":
			tlDriver.set(new FirefoxDriver());
			break;
		case "edge":
			tlDriver.set(new EdgeDriver());
			break;
		case "safari":
			tlDriver.set(new SafariDriver());
			break;
		default:
			Reporter.log("Invalid browser" + browserName, true);

		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}

	/**
	 * this is used to get the local copy of the driver any time..
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * This method is init the prop with properties file...
	 * 
	 * @return
	 */

	// mvn clean install -Denv="qa"
	// mvn clean install
	// mvn clean install
	// -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml
	// -Denv="dev"

	public Properties initProp() {
		prop = new Properties();
		FileInputStream file = null;

		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config/config.properties");
			prop.load(file);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return prop;
	}

	public String getproperty(String key) {
		Reporter.log("reading from property file "+key+"...",true);

		return prop.getProperty(key);
	}

	public static File getScreenshotFile() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp dir
		return srcFile;
	}
}
