package tests;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.JsonDataReader;
import pages.HomePage;
import pages.MyAccountPape;
import pages.RegisterPage;
import java.util.List;

public class TestUserRegister2 extends TestBase{

	RegisterPage RegisterPageObject ; 
	HomePage HomeObject ;
	MyAccountPape AccountPageObject ; 

	@DataProvider(name = "userDataProvider")
	public Object[][] userDataProvider() throws IOException, ParseException {
		JsonDataReader jsonReader = new JsonDataReader();
		List<Object[]> data = jsonReader.JsonReader();
		return data.toArray(new Object[0][]);

	}
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

	@Test(priority = 2, dataProvider = "userDataProvider", dependsOnMethods = {"OpenRegisterPage"})
	public void Register (String firstname, String middlename, String lastname, String email, String password) throws IOException, ParseException, InterruptedException {
		RegisterPageObject = new RegisterPage(driver);
		AccountPageObject = new MyAccountPape(driver);

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(RegisterPageObject.RegisterButtonElement)); 

		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("scrollBy(0,140)");

		
		RegisterPageObject.RegisterWithValidData(firstname, middlename, lastname, email, password, password);


		Thread.sleep(2000);
		
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait9.until(ExpectedConditions.visibilityOf(HomeObject.AccountListElement));		
		HomeObject.OpenAccountList();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.visibilityOf(AccountPageObject.LogoutElement));
		AccountPageObject.logout();

		WebDriverWait waitAfterLogout = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitAfterLogout.until(ExpectedConditions.visibilityOf(HomeObject.AccountListElement));
		HomeObject.OpenAccountList();

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait4.until(ExpectedConditions.visibilityOf(HomeObject.RegisterLinkElement));
		HomeObject.OpenRegisterPage();
	}
}

