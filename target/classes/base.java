package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("\\Users\\Lenovo\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);

		String browsername = prop.getProperty("browser");
		// Chrome
		// if (browsername =="chrome") // cannot use == if you are extracting value from
		// property
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\chromedriver_win32/chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) // Firefox
		{
			System.setProperty("webdriver.gecko.driver",
					"C:/Users/Lenovo/Downloads/geckodriver-v0.25.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	
 public void getScreenshot(String result) throws IOException
	{
		System.out.println("getscreenshot**********");
	   File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Selenium/"+result+"screenshot1.png"));
	
		
	}

}
