package izmailov.selenium1;

import framework.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestEmailFirefox {

	protected WebDriver webDriver;
	protected String baseUrl;

	@BeforeMethod
	public void setup() throws Exception {
		webDriver = new FirefoxDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		baseUrl = "https://mail.google.com";
	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (webDriver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}

	@Test
	public void Test() throws IOException, InterruptedException {
		GmailTest.findEmailFromSender(webDriver, baseUrl);
	}
}
