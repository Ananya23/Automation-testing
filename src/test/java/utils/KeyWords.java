package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class KeyWords {
		WebDriver driver ;
		public KeyWords (WebDriver idriver)
		{
			driver=idriver;
		}
		public void getURL(String url)
		{
			driver.get(url);
		}
		public void click(String locator)
		{
			/*String locatortype= locator.split(":=")[0];
			String locatorvalue=locator.split(":=")[1];
			if(locatortype.equalsIgnoreCase("id"))
				driver.findElement(By.id(locatorvalue)).click();
			else if(locatortype.equalsIgnoreCase("name"))
				driver.findElement(By.name(locatorvalue)).click();
			else if(locatortype.equalsIgnoreCase("link"))
				driver.findElement(By.linkText(locatorvalue)).click();
			else if(locatortype.equalsIgnoreCase("css"))
				driver.findElement(By.cssSelector(locatorvalue)).click();
			else if(locatortype.equalsIgnoreCase("xpath"))
				driver.findElement(By.xpath(locatorvalue)).click();
			else
				System.out.println("Invalid Locator Type");*/
			locateWebElement(locator).click();
			
		}
		public void type(String locator, String data)
		{
			/*String locatortype= locator.split(":=")[0];
			String locatorvalue=locator.split(":=")[1];
			if(locatortype.equalsIgnoreCase("id"))
				driver.findElement(By.id(locatorvalue)).sendKeys(data);
			else if(locatortype.equalsIgnoreCase("name"))
				driver.findElement(By.name(locatorvalue)).sendKeys(data);
			else if(locatortype.equalsIgnoreCase("link"))
				driver.findElement(By.linkText(locatorvalue)).sendKeys(data);
			else if(locatortype.equalsIgnoreCase("css"))
				driver.findElement(By.cssSelector(locatorvalue)).sendKeys(data);
			else if(locatortype.equalsIgnoreCase("xpath"))
				driver.findElement(By.xpath(locatorvalue)).sendKeys(data);
			else
				System.out.println("Invalid Locator Type");	*/
			locateWebElement(locator).sendKeys(data);
			
		}
		public void getSnap(String locationWithFileName) throws IOException
		{
			TakesScreenshot snap=(TakesScreenshot)driver; 
			File src = snap.getScreenshotAs(OutputType.FILE);
			
			Date d=new Date();
			String newdate=	d.toString().replaceAll(":", "").replaceAll(" ", "");	
			
			try
			{
				FileHandler.copy(src, new File(locationWithFileName+newdate+".png"));
			}
			catch (Exception E)
			{
				System.out.println("Error with Screenshot");
			}
		}
		public WebElement locateWebElement(String locator)
		
		{	WebElement E = null;
			String locatortype= locator.split(":=")[0];
			String locatorvalue=locator.split(":=")[1];
			
			if(locatortype.equalsIgnoreCase("id"))
				E= driver.findElement(By.id(locatorvalue));
			else if(locatortype.equalsIgnoreCase("name"))
				E= driver.findElement(By.name(locatorvalue));
			else if(locatortype.equalsIgnoreCase("link"))
				E= driver.findElement(By.linkText(locatorvalue));
			else if(locatortype.equalsIgnoreCase("css"))
				E= driver.findElement(By.cssSelector(locatorvalue));
			else if(locatortype.equalsIgnoreCase("xpath"))
				E= driver.findElement(By.xpath(locatorvalue));
			else
				System.out.println("Invalid Locator Type");
			return E;	
		}
		
		public void dropDown(String locator, String data)
		{
			Select s = new Select(locateWebElement(locator));
			s.selectByVisibleText(data);
		}
		

}
