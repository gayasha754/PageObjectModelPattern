package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class HomePage extends BasePage{
	
	//Assigning the elements of Home Page into variables
	private final By txtUsername = By.xpath("//input[@placeholder='Login']");
	private final By txtPassword = By.xpath("//input[@name='password']");
	private final By btnLogin =  By.xpath("//button[normalize-space()='Login']");
	private final By errorMsg = By.xpath("//span[@class='label label-warning']");
	private final By btnLogout = By.xpath("//a[normalize-space()='Logout']");
	private final By btnRegister = By.xpath("//a[normalize-space()='Register']");
	private final By btnPopularMakeLink = By.xpath("//div[@class='row']//div[1]//div[1]//a[1]");
	
	private final By logo = By.xpath("//a[normalize-space()='Buggy Rating']");
	
	//overridden method of initializing the webDriver
	public HomePage(WebDriver driver) {
		super(driver);
	}

//	public HomePage load() {
//		load("/");
//		return this;
//	}
	
	//returning the action of entering the username
	public HomePage enterUsername(String username) {
		driver.findElement(txtUsername).clear();
		driver.findElement(txtUsername).sendKeys(username);
		return this;
	}
	
	//returning the action of entering the password
	public HomePage enterPassword(String password) {
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(password);
		return this;
	}
	
	//returning the action of clicking Login Btn
	public HomePage clickLoginBtn() {
		driver.findElement(btnLogin).sendKeys(Keys.RETURN);
		return this;
	}
	
	//getting the text of the Logout button in order to do the assertion of invalidLogin
	public String getLogoutText() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		Boolean result = driver.findElement(btnLogout).isDisplayed();
        String alertMessage = null;
       
        if(result){
            alertMessage = driver.findElement(btnLogout).getText();
        }
        return alertMessage;	
	}
	
	//getting the error message text 
	public String invalidLoginMsg() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		Boolean result = driver.findElement(errorMsg).isDisplayed();
        String alertMessage = null;
       
        if(result){
            alertMessage = driver.findElement(errorMsg).getText();
        }
        return alertMessage;	
	}
	
	//returning the action of clicking Logout btn
	public HomePage clickLogoutButton(){
		driver.findElement(btnLogout).sendKeys(Keys.RETURN);
		return this;
	}
	
	//returning the action of clicking Ragister btn
	public RegisterPage clickRegisterBtn() {
		driver.findElement(btnRegister).sendKeys(Keys.RETURN);
		return new RegisterPage(driver);
	}
	
	//returning the action of clicking on popular make image
	public HomePage clickPopularMake() {
		driver.findElement(btnPopularMakeLink).sendKeys(Keys.RETURN);
		return this;
	}
	
	//returning the action of clicking Logo 
	public HomePage clickNavBarlogo() {
		driver.findElement(logo).sendKeys(Keys.RETURN);
		return this;
	}
	
	
	
}
