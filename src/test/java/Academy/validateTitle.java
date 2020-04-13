package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;
import pageObjects.LandingPage;

public class validateTitle extends base{
	
public static Logger log = LogManager.getLogger(validateTitle.class.getName());
	
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
		Assert.assertEquals(lp.gettitle().getText(), "FEATURED COURSES");
	//	log.info("successfully validated Tesxt message");
		 System.out.println("Test completed");
		 System.out.println("Added one more line");
	}
	
	@AfterTest
	public void closebrowser()
	{
	  driver.close();
	driver=null;
	}
	
	
}
