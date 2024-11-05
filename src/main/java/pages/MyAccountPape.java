package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPape extends PageBase{

	public MyAccountPape(WebDriver driver) {
		super(driver);
	}

	public @FindBy (xpath = "//li[@class='last']/a[@title='Log Out']")
	WebElement LogoutElement ;
	public void logout() {
		clickbtn(LogoutElement);
	}
}
