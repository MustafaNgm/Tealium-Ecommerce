package tests;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
public class TestBase extends AbstractTestNGCucumberTests{
	public static WebDriver driver ; 

	@BeforeClass
	@Parameters ({"browser"})
	public void startDriver (@Optional ("chrome") String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver ();		
		}
		{
			driver.manage().window().maximize();
			driver.navigate().to("https://ecommerce.tealiumdemo.com");
		}
	}

	@AfterClass
	public void stopDriver () {
		driver.quit();
	}

}
