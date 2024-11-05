package tests;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import data.JsonDataReader;
import pages.HomePage;
import pages.RegisterPage;

public class TestUserRegister extends TestBase{

	RegisterPage RegisterPageObject ; 
	HomePage HomeObject ;


	@Test (priority = 1)
	public void OpenRegisterPage() throws InterruptedException {
		HomeObject = new HomePage(driver);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(HomeObject.AccountListElement));
		HomeObject.OpenAccountList();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(HomeObject.RegisterLinkElement));
		HomeObject.OpenRegisterPage();
	}

	@Test( priority = 2 , dependsOnMethods = {"OpenRegisterPage"} )
	public void Register () throws IOException, ParseException, InterruptedException {
		RegisterPageObject = new RegisterPage(driver);
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(RegisterPageObject.RegisterButtonElement)); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("scrollBy(0,140)");
		
		JsonDataReader Jsonreader = new JsonDataReader();
		Jsonreader.JsonReader();
		
		RegisterPageObject.RegisterWithValidData(Jsonreader.firstname, Jsonreader.middlename, Jsonreader.lastname, Jsonreader.email, Jsonreader.password, Jsonreader.password);
		Thread.sleep(3000);
	}

	@Test (priority = 3 , dependsOnMethods = {"Register"})
	public void checkOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(HomeObject.AccountListElement));		
		HomeObject.OpenAccountList();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(HomeObject.CheckoutButtonElement));
		HomeObject.Checkout();
		
		wait.until(ExpectedConditions.visibilityOf(HomeObject.AccountListElement));		
		HomeObject.OpenAccountList();
		
		wait2.until(ExpectedConditions.visibilityOf(HomeObject.CheckoutButtonElement));
		HomeObject.Checkout();
		

	}
}

