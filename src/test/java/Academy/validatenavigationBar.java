package Academy;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;
import pageObjects.LandingPage;

public class validatenavigationBar extends base{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void basepagenavigation() throws IOException
	{
			
		LandingPage lp = new LandingPage(driver);
		//compare expected text with actual text
		Assert.assertTrue(lp.gettool().isDisplayed());
		
	}
	
	@AfterTest
	public void closebrowser()
	{
	  driver.close();
	  driver=null;
	}

   
}
