package utils;
import utils.HelperFunctions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Baseclass {
 public WebDriver driver;
 public Properties prop;
  @BeforeTest
  public void beforeTest() throws FileNotFoundException, IOException {
	  prop = new Properties();
	  prop.load(new FileInputStream(".\\settings.property"));
	  driver= HelperFunctions.startBrowser(prop.getProperty("browserName"));
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
	  
  }

}
