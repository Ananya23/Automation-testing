package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public By e_userName= By.name("txtUsername");
	public By e_password= By.name("txtPassword");
	public By e_loginButton= By.id("btnLogin");
	public By e_forget= By.linkText("Forgot your password?");
	
	public void setUserName(String user)
	{
		driver.findElement(e_userName).sendKeys(user);
	}
	public void setPassword(String pass)
	{
		driver.findElement(e_password).sendKeys(pass);
	}
	
	public void clickLogin()
	{
		driver.findElement(e_loginButton).click();
	}
	public ForgetAccountPage clickForget()
	{
		driver.findElement(e_forget).click();
		return new ForgetAccountPage(driver);
	}
	public WelcomePage doLogin(String user,String pass)
	{
		setUserName(user);
		setPassword(pass);
		return new WelcomePage(driver);
	}
}
