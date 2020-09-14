package POM;
import utils.Baseclass;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMRunner extends Baseclass{
	ForgetAccountPage fp;
	LoginPage lp;
  @Test(description="Checking forget account")
  public void forgetTest() {
	  driver.get("https://opensource-demo.orangehrmlive.com/");  
	  lp=new LoginPage(driver);
	  fp=lp.clickForget();
	  Assert.assertEquals(driver.findElement(fp.e_restButtuon).isDisplayed(), true);
  }
  
  @Test(dependsOnMethods="forgetTest",description="Clicking on cancel button")
  public void cancelButtonTest()
  {
	  LoginPage lp2=fp.clickCancel();
		 //fp=lp.clickForget();	  
	  Assert.assertEquals(driver.findElement(lp2.e_userName).isDisplayed(), true);
  }
  @Test(dependsOnMethods="cancelButtonTest", description="checking login functionality")
  	public void LoginTest()
  	{
	  WelcomePage wl = lp.doLogin("admin", "admin123");
	  try {
		  	Assert.assertEquals(driver.findElement(wl.e_user).isDisplayed(),true);
	  }
	  catch(NoSuchElementException N )//import selenium's exception
	  {
		  Assert.fail("unable to login with given credential");
	  }
  	}
}
