package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class PopularMakePage extends BasePage{

	//Assigning the elements of Popular Make Page into variables
	private final By txt_comment = By.xpath("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/fieldset/textarea");
	private final By btn_Vote = By.xpath("//button[contains(@class,'btn btn-success')]"); //here relative xpath is used for vote button   
	private final By alertMsg = By.xpath("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/p");
	private final By btnModel = By.xpath("//a[normalize-space()='Guilia Quadrifoglio']");
	
	public PopularMakePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// returning the action of clicking on a model
	public PopularMakePage clickModel() {
		driver.findElement(btnModel).sendKeys(Keys.RETURN);
		return this;
	}

	// returning the action of entering a comment
	public PopularMakePage enterComment(String comment) {
		driver.findElement(txt_comment).clear();
		driver.findElement(txt_comment).sendKeys(comment);
		return this;
	}
	
	// returning the action of clicking on vote btn
	public PopularMakePage clickVoteButton() {
		driver.findElement(btn_Vote).sendKeys(Keys.RETURN);
		return this;
	}
	
	//getting the alert message displayed
	public String getAlertMessage(){
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        Boolean result = driver.findElement(alertMsg).isDisplayed();

        String alertMessage = null;
        if(result){
            alertMessage = driver.findElement(alertMsg).getText();
        }
         return alertMessage;
     } 
}
