package Day10;

import org.testng.annotations.Test;
import POM.LoginPage;
import utils.HelperFunctions;
import org.testng.annotations.BeforeTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class DataBase {
	WebDriver driver;
  @Test
  public void DatabasePara() throws ClassNotFoundException, SQLException {
	  Class.forName("oracle.jdbc.driver.OracleDriver");// to load the driver in the memory
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
      System.out.println("Connection Successful");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select * from LOGIN");
      
      while (rs.next()) {
    	  String username = rs.getString(1);
    	  String password = rs.getString(2);
    	  
          System.out.println(rs.getString(1) + " " + rs.getString(2)); 
          PreparedStatement prep = conn.prepareStatement("update login set STATUS=? where UN=? ");
          driver.get("http://opensource-demo.orangehrmlive.com/");
          LoginPage lp = new LoginPage(driver);
          lp.doLogin(username,password ); 
          //lp.clickLogin();
          
          try {
        	  
        	  Thread.sleep(3000);
        	  driver.findElement(By.id("welcome")).click();
        	  Thread.sleep(2000);
        	  driver.findElement(By.linkText("Logout")).click();
        	  System.out.println("Login Done");
        	  prep.setString(1,"Pass");
          }
          catch(Exception E)
          {
        	  System.out.println("Login Failed");
        	  prep.setString(1,"Fail");
          }
          prep.setString(2,username);
          prep.executeUpdate();
      }
      rs.close();
  }  
  
  @BeforeTest
  public void beforeTest() {
	  driver = HelperFunctions.startBrowser("chrome");
  }
  														  							
  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
		driver.quit();
  }

}
