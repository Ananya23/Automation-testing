package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetAccountPage {
	
	   
		private WebDriver driver;
		public ForgetAccountPage(WebDriver driver) {
		this.driver=driver;
			
		}
		
		public By e_username=By.id("securityAuthentication_userName");
		public By e_restButtuon=By.id("btnSearchValues");
		public By e_cancelButton=By.id("btnCancel");
		
		
		
		public void setUserName(String user) {
			driver.findElement(e_username).sendKeys(user);
		}
		
		public void clickReset() {
			driver.findElement(e_restButtuon).click();;
		}
		
		public LoginPage clickCancel() {
			driver.findElement(e_cancelButton).click();
			return new LoginPage(driver);
		}
		
		
		public void doReset(String user,String pass) {
			setUserName(user);
			clickReset();
			
		}

	}
	
		
	


