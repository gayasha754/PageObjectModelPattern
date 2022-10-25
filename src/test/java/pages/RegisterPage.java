package pages;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class RegisterPage extends BasePage{

	private final By txtUsername = By.xpath("//input[@id='username']");
	private final By TextInFirstname = By.id("firstName");
	private final By TextInLastname = By.id("lastName");
	private final By TextInPassword = By.id("password");
	private final By TextInPasswordConfirm = By.id("confirmPassword");
	private final By RegisterButton = By.xpath("//button[contains(@class,'btn btn-default')]");
	private final By alertMsg = By.xpath("/html/body/my-app/div/main/my-register/div/div/form/div[6]");
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public RegisterPage enterUsername(String username) {
		driver.findElement(txtUsername).clear();
		driver.findElement(txtUsername).sendKeys(username);
		return this;
	}
	
	public RegisterPage enterFirstname(String firstname) {
		driver.findElement(TextInFirstname).clear();
		driver.findElement(TextInFirstname).sendKeys(firstname);
		return this;
	}
	public RegisterPage enterLastname(String lastname) {
		driver.findElement(TextInLastname).clear();
		driver.findElement(TextInLastname).sendKeys(lastname);
		return this;
	}
	public RegisterPage enterPassword(String password) {
		driver.findElement(TextInPassword).clear();
		driver.findElement(TextInPassword).sendKeys(password);
		return this;
	}
	public RegisterPage enterPasswordConfirm(String passwordConfirm) {
		driver.findElement(TextInPasswordConfirm).clear();
		driver.findElement(TextInPasswordConfirm).sendKeys(passwordConfirm);
		return this;
	}
	public RegisterPage clickRegisterButton() {
		driver.findElement(RegisterButton).sendKeys(Keys.RETURN);
		return this;
	}

	public String getAlertMessage(){
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        Boolean result = driver.findElement(alertMsg).isDisplayed();

        String alertMessage = null;
        if(result){
            alertMessage = driver.findElement(alertMsg).getText();
        }
         return alertMessage;
     } 

	public String randomUsername(){
        
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        String username = generatedString + "@gmail.com";
        return username;
    }
}
