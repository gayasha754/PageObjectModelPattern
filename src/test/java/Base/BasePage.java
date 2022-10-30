package Base;

import org.openqa.selenium.WebDriver;

public class BasePage {

	//initializing the webDriver
	protected WebDriver driver;

	
	//declare the web driver
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
//	public void load(String endPoint) {
//		driver.get("https://buggy.justtestit.org" + endPoint);
//	}
//	
	
}
