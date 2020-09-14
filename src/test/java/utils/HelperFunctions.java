package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HelperFunctions {

	
		public static WebDriver startBrowser(String browser)
		{
			if(browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				//return new ChromeDriver();
				ChromeOptions op = new ChromeOptions(); //for blocking notif
				op.addArguments("--disable-notifications");
				return new 	ChromeDriver(op);
				
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
				return new FirefoxDriver();
			}
			else {
				return null;
			}
		}
	}


