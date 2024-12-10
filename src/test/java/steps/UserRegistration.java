package steps;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyAccountPape;
import pages.RegisterPage;
import tests.TestBase;


public class UserRegistration extends TestBase{

	HomePage HomeObject ;
	RegisterPage RegisterObject ;
	MyAccountPape AccountPageObject ; 

	@Test
	@Given("user open the register page")
	public void user_open_the_register_page() {
		HomeObject = new HomePage(driver);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(HomeObject.AccountListElement));
		HomeObject.OpenAccountList();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(HomeObject.RegisterLinkElement));
		HomeObject.OpenRegisterPage();

	}

	@Test
	@When("user fills the fields {string} , {string} , {string} , {string} , {string}")
	public void user_fills_the_fields(String firstname, String middlename, String lastname, String email, String password) throws InterruptedException {

		RegisterObject = new RegisterPage(driver);

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(RegisterObject.RegisterButtonElement)); 


		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("scrollBy(0,140)");

		RegisterObject.RegisterWithValidData(firstname, middlename, lastname, email, password, password);
		Thread.sleep(3000);
		throw new io.cucumber.java.PendingException();

	}

	@Test
	@When("press on save button")
	public void press_on_save_button() {
		Assert.assertTrue(driver.getCurrentUrl().contains("/customer/account/index/"));
	}

	@Test
	@Then("the registration process was completed successfully , open register page again to register again with another data")
	public void the_registration_process_was_completed_successfully() throws InterruptedException {

		HomeObject = new HomePage(driver);
		AccountPageObject = new MyAccountPape(driver);

		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait9.until(ExpectedConditions.visibilityOf(HomeObject.AccountListElement));		
		HomeObject.OpenAccountList();
		Thread.sleep(3000);

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
