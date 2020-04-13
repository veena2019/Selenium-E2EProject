package Academy;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;



public class HomePage extends base {
	
public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
	//	log.info("Driver Initialised");	  
	}
	
	@Test(dataProvider = "getData")
	public void basepagenavigation(String username, String pass, String text) throws IOException, InterruptedException
	{
			
		driver.get(prop.getProperty("url"));
	    log.info("NAvigated to Home page");
		
		LandingPage lp1 = new LandingPage(driver);
		
		lp1.getLogin().click();
		
		LoginPage lp2 = new LoginPage(driver);
		lp2.getEmail().sendKeys(username);
		lp2.getpass().sendKeys(pass);
		System.out.println(text);
		System.out.println("Test modified");
		
		lp2.getlogin().click();
	}


	  @DataProvider
	  public  Object[][] getData()
	  {
		  Object[][] data = new Object[2][3]; // no of test data set is row..and columns are how many values for each set
		  
		  data[0][0] = "nonrestricteduser@qw.com";
		  data[0][1] = "123456";
		  data[0][2] = "Non Restricted user";
		  
		  data[1][0] = "restricteduser@qw.com";
		  data[1][1] = "456788";
		  data[1][2] = "Restricted user";
		  
		  return data;
	  }
	  
	  @AfterTest
		public void closebrowser()
		{
		  driver.close();
		 // driver=null;
		 
		}
}
