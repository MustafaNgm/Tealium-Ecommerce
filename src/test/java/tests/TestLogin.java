package tests;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;

public class TestLogin extends TestBase{

	HomePage HomeObject ; 
	LoginPage LoginPageObject ; 
	
	@Test (priority = 1 )
	public void OpenLoginPage () {
		HomeObject = new HomePage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(HomeObject.AccountListElement));
		HomeObject.OpenAccountList();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(HomeObject.LoginLinkElement));
		HomeObject.OpenLoginPage();
		
		
	}
	@Test (priority = 2 , dependsOnMethods = {"OpenLoginPage"} , dataProvider = "userdata")
	public void Login() throws IOException, ParseException  {
		JsonDataReader Jsonreader = new JsonDataReader();
		Jsonreader.JsonReader();
		
		LoginPageObject = new LoginPage(driver);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(LoginPageObject.LoginBtn));
		LoginPageObject.Login(Jsonreader.email, Jsonreader.password);
	}
}
