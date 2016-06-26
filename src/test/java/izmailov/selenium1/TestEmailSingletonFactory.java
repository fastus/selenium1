package izmailov.selenium1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.driver.WebDriverFactory;

public class TestEmailSingletonFactory {

	protected WebDriver webDriver;
	protected String baseUrl;

	@BeforeMethod
	@Parameters({ "browserName" })
	public void setup(String browserName) throws Exception {
		webDriver = WebDriverFactory.getInstance(browserName);
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
