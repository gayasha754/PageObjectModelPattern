package Base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import factory.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	//initializing the web driver
	protected WebDriver driver;
	
	public static Properties prop = new Properties(); //creating an object from the properties file
	public static FileReader fr; //creating an object from the file reader

	
	//setting up the driver before executing the test class
	@BeforeClass
	public void setUp() throws IOException {
	
		
		//check the browser type
		if(driver == null) {
			fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");				
			prop.load(fr); //config
		
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			//download chrome driver and store it in the location.
			WebDriverManager.chromedriver().setup();
			
			//create object of WebDriver
			driver = new DriverManager().initializeChromeDiver();
			driver.get(prop.getProperty("testURL"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			
			//download chrome driver and store it in the location.
			WebDriverManager.firefoxdriver().setup();
			
			//create object of WebDriver
			driver = new DriverManager().initializeFirefoxDiver();
			driver.get(prop.getProperty("testURL"));
		}
	}
	
	
	//Quitting the driver after executing the test class
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
	
}
