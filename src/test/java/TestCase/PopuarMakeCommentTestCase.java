package TestCase;


import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.time.Duration;

import org.json.JSONObject;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.Jsondata;
import pages.HomePage;
import pages.PopularMakePage;
import pages.RegisterPage;

public class PopuarMakeCommentTestCase extends BaseTest{
	
	HomePage homePage;
	RegisterPage regPage;
	PopularMakePage popPage;
	
	String actual,expected;
	
	InputStream data;
	JSONObject testData;
	
	Jsondata js = new Jsondata();
	@Test
	public void newUserRegisterTest() throws Exception {
		testData = js.json("testData/Register.json");
		homePage = new HomePage(driver);
		homePage.clickRegisterBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		regPage = new RegisterPage(driver);
		String username = regPage.randomUsername();
		regPage.enterUsername(username).
				enterFirstname(testData.getJSONObject("NewUser").getString("firstname")).
				enterLastname(testData.getJSONObject("NewUser").getString("lastname")).
				enterPassword(testData.getJSONObject("NewUser").getString("password")).
				enterPasswordConfirm(testData.getJSONObject("NewUser").getString("passwordConfirm")).
				clickRegisterButton();
		
		actual = regPage.getAlertMessage();
        expected = "Registration is successful";
        assertEquals(expected,actual);
        
        //Login the new user
        homePage.enterUsername(username).
				enterPassword(testData.getJSONObject("NewUser").getString("password")).
				clickLoginBtn();
        actual = homePage.getLogoutText();
        expected = "Logout";
        assertEquals(expected,actual);
        homePage.clickNavBarlogo();
        homePage.clickPopularMake();
        
        popPage = new PopularMakePage(driver);
        popPage.clickModel().enterComment("Test Comment").clickVoteButton();
        actual = popPage.getAlertMessage();
        expected = "Thank you for your vote!";
        assertEquals(expected,actual);
        
		homePage.clickLogoutButton();
	}
	
	@Test
	public void testReComment() throws Exception{
		testData = js.json("testData/login.json");
		homePage = new HomePage(driver);
		homePage.enterUsername(testData.getJSONObject("validUsername_ValidPassword").getString("username")).
				enterPassword(testData.getJSONObject("validUsername_ValidPassword").getString("password")).
				clickLoginBtn();		//using builder pattern
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		homePage.clickPopularMake();
		popPage = new PopularMakePage(driver);
        popPage.clickModel();
        actual = popPage.getAlertMessage();
        expected = "Thank you for your vote!";
        assertEquals(expected,actual);

        homePage.clickLogoutButton();
	}
	

}
