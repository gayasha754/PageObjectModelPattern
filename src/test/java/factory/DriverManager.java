package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	public WebDriver initializeChromeDiver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver initializeFirefoxDiver() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
}
