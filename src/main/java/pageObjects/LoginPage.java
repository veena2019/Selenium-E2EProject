package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public static WebDriver driver ;
	
	By email = By.id("user_email");
	By password = By.cssSelector("input[type='password']");
			
	By login = By.cssSelector("input[type='submit']");		
		
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getpass()
	{
		return driver.findElement(password);
	}
	
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
}
