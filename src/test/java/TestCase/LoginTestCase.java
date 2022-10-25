package TestCase;

import org.testng.annotations.Test;

import Base.BaseTest;

import org.testng.annotations.BeforeClass;
import org.json.JSONObject;
import org.json.JSONTokener;
import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.time.Duration;
import pages.HomePage;

public class LoginTestCase extends BaseTest{
	
	InputStream data;
	JSONObject testData;
	
	
	// Importing JSON file from the resource folder and creating a JSON Object
		@BeforeClass
	public void json() throws Exception  {
		 
		try { 
			String dataFileName = "testData/login.json";
			data = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(data);
			testData = new JSONObject(tokener);
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if(data != null) {
				data.close();
			}
		}
	}		

	//TestCase for invalidUsername and Valid Password
	@Test(priority=1)
	public void invalidUsernameValidPasswordLoginTest() {
		HomePage homePage = new HomePage(driver);
		homePage.enterUsername(testData.getJSONObject("invalidUsername_ValidPassword").getString("username")).
				enterPassword(testData.getJSONObject("invalidUsername_ValidPassword").getString("password")).
				clickLoginBtn();		//using builder pattern
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));		
		String actual = homePage.invalidLoginMsg();
        String expected = "Invalid username/password";
        assertEquals(expected,actual);
	}
	
	//Test Case for Valid Username and Invalid Password
	@Test(priority=2)
	public void validUsernameInvalidPasswordLoginTest() {
		HomePage homePage = new HomePage(driver);
		homePage.enterUsername(testData.getJSONObject("validUsername_InvalidPassword").getString("username")).
				enterPassword(testData.getJSONObject("validUsername_InvalidPassword").getString("password")).
				clickLoginBtn();		//using builder pattern	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));		
		String actual = homePage.invalidLoginMsg();
        String expected = "Invalid username/password";
        assertEquals(expected,actual);
	}
	
	//Test Case for Invalid Username and Invalid Password
	@Test(priority=3)
	public void invalidUsernameInvalidPasswordLoginTest() {
		HomePage homePage = new HomePage(driver);
		homePage.enterUsername(testData.getJSONObject("invalidUsername_InvalidPassword").getString("username")).
				enterPassword(testData.getJSONObject("invalidUsername_InvalidPassword").getString("password")).
				clickLoginBtn();		//using builder pattern	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));		
		String actual = homePage.invalidLoginMsg();
        String expected = "Invalid username/password";
        assertEquals(expected,actual);
	}
	
	//Test Case for Valid Username and Valid Password
	@Test(priority=4)
	public void ValidloginTest(){
//		HomePage homePage = new HomePage(driver).load();
		HomePage homePage = new HomePage(driver);
		homePage.enterUsername(testData.getJSONObject("validUsername_ValidPassword").getString("username")).
				enterPassword(testData.getJSONObject("validUsername_ValidPassword").getString("password")).
				clickLoginBtn();		//using builder pattern
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		String actual = homePage.getLogoutText();
        String expected = "Logout";
        assertEquals(expected,actual);
		homePage.clickLogoutButton();
	}
}
