package Day10;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.asserts.*;

import utils.HelperFunctions;

public class GoogleTest {
	WebDriver driver;
	ExtentReports ex;
	@Test(description = "Title test of Google ")
    public void titleTest() throws Exception {
        ex = new ExtentReports();
        ex.attachReporter(new ExtentHtmlReporter("src/test/resources/reports/Google.html"));
        ExtentTest tc1 = ex.createTest("Google Title Test");
        tc1.info("Title Test Started");
        tc1.info("Opening URL");
        driver.get("http://google.com");
        tc1.info("Comparing Extected Title with Actual Title");
        try {
            Assert.assertEquals(driver.getTitle(), "Google");
            tc1.pass("Google title is successful");
        } catch (AssertionError A) {
            tc1.fail("Title not Matching " + A.getMessage());// For Failing Extent Report
//            String path = new KeyWords(driver).getSnap(System.getProperty("user.dir")+"\\src\\test\\resources\\screenShot\\google");
            Assert.fail(A.getMessage());// For Failing testNg Report
        }
    }

@Test(enabled = true, dependsOnMethods = "titleTest", description = "Search Test")
    public void searchTest1() {
        WebDriverWait wt = new WebDriverWait(driver, 10);
        ExtentTest tc2 = ex.createTest("Search Test");
        tc2.info("Waiting for name seacch Object with name 'qq'");
        try {
            WebElement search = wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            tc2.info("After Waiting Typing txt");
            search.sendKeys("Maven");
            search.sendKeys(Keys.ENTER);
            tc2.info("Searching");
            //Assert.assertEquals(driver.getTitle().contains("Maven"), true);
            wt.until(ExpectedConditions.titleContains("Maven"));
            tc2.pass("Search Test get Pass");
        } catch (Exception E) {
            tc2.fail(E.getMessage());
            Assert.fail(E.getMessage());
        }    
    }

@BeforeTest
    public void beforeTest() {
        /*
         * System.setProperty("webdriver.chrome.driver",
         * "src/test/resources/drivers/chromedriver.exe"); driver = new ChromeDriver();
         */
        driver = HelperFunctions.startBrowser("chrome");
    }
    @AfterTest
    public void afterTest() throws Exception {
        Thread.sleep(3000);
        driver.quit();
        ex.flush(); // For Exporting Report to C/D drive
    }

}
