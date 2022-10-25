package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class HomePage extends BasePage{
	
	private final By txtUsername = By.xpath("//input[@placeholder='Login']");
	private final By txtPassword = By.xpath("//input[@name='password']");
	private final By btnLogin =  By.xpath("//button[normalize-space()='Login']");
	private final By errorMsg = By.xpath("//span[@class='label label-warning']");
	private final By btnLogout = By.xpath("//a[normalize-space()='Logout']");
	private final By btnRegister = By.xpath("//a[normalize-space()='Register']");
	private final By btnPopularMakeLink = By.xpath("//div[@class='row']//div[1]//div[1]//a[1]");
	
	private final By logo = By.xpath("//a[normalize-space()='Buggy Rating']");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

//	public HomePage load() {
//		load("/");
//		return this;
//	}
	
	public HomePage enterUsername(String username) {
		driver.findElement(txtUsername).clear();
		driver.findElement(txtUsername).sendKeys(username);
		return this;
	}
		
	public HomePage enterPassword(String password) {
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(password);
		return this;
	}
	
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
	
	public HomePage clickLogoutButton(){
		driver.findElement(btnLogout).sendKeys(Keys.RETURN);
		return this;
	}
	
	public RegisterPage clickRegisterBtn() {
		driver.findElement(btnRegister).sendKeys(Keys.RETURN);
		return new RegisterPage(driver);
	}
	public HomePage clickPopularMake() {
		driver.findElement(btnPopularMakeLink).sendKeys(Keys.RETURN);
		return this;
	}
	
	public HomePage clickNavBarlogo() {
		driver.findElement(logo).sendKeys(Keys.RETURN);
		return this;
	}
	
	
	
}
