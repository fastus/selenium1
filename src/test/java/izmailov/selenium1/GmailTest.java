package izmailov.selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


import java.io.IOException;
import java.util.List;

/**
 * Created by fastus on 6/27/16.
 */
public class GmailTest {

    public static void findEmailFromSender(WebDriver webDriver, String baseUrl) throws IOException, InterruptedException {
        Reporter.log("opening gmail...", true);
        webDriver.get(baseUrl + "/");

        WebElement emailField = webDriver.findElement(By.id("Email"));
        emailField.clear();
        Reporter.log("filling email field...", true);
        emailField.sendKeys("fastest956@gmail.com");
        Reporter.log("performing next click...", true);
        webDriver.findElement(By.id("next")).click();

        explicitWait(webDriver, By.id("Passwd"));
        WebElement pwdField = webDriver.findElement(By.id("Passwd"));
        Reporter.log("filling password field...", true);
        pwdField.sendKeys("123456789tt");
        Reporter.log("performing signing click...", true);
        webDriver.findElement(By.id("signIn")).click();
        /*
		 * class='yP' - messages that have been read (twice count!!!) class='zF'
		 * - messages that have not been read (twice count!!!) using xpath
		 * locator = //*[@class='yP' or @class='zF']
		 */
        List<WebElement> allEmails = webDriver.findElements(By.xpath("//*[@class='yP' or @class='zF']"));
        boolean testComplete = false;
        int emailCount = 0;
        for (WebElement temp : allEmails) {
            if (temp.getAttribute("email").equals("fastus1@gmail.com")) {
                emailCount++;
            }
        }
        testComplete = true;

        Reporter.log("In all " + allEmails.size() / 2 + " emails was found " + emailCount / 2
                + " emails from \"fastus1@gmail.com\"", true);

        Assert.assertTrue(testComplete);
    }

    public static WebElement explicitWait(WebDriver driver, final By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
