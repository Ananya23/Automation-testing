package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
	private WebDriver driver;
	public WelcomePage(WebDriver driver) {
		this.driver=driver;
		
	}
	By e_user=By.id("welcome"); //check once the website goes live
	By e_username=By.name("txtUsername");
	By e_password=By.name("txtPassword");
	By e_loginButton=By.name("btnLogin");
	By e_forget=By.linkText("Forgot your password?");
	
	public void setUserName(String user) {
		driver.findElement(e_username).sendKeys(user);
	}
	
	public void setPassword(String pass) {
		driver.findElement(e_password).sendKeys(pass);
	}
	
	public void clickLogin() {
		driver.findElement(e_loginButton).click();
	}
	
	public ForgetAccountPage clickForget() {
		driver.findElement(e_forget).click();
		return new ForgetAccountPage(driver);
	}
	
	public void doLogin(String user,String pass) {
		setUserName(user);
		setPassword(pass);
		clickLogin();
		
	}

}


