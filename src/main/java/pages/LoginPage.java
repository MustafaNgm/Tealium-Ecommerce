package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (css = "\"a[title='Log Out']\"")
	WebElement Logoutbtn ;
	
	@FindBy (name =  "login[username]")
	WebElement emailField ;
	
	@FindBy(id = "pass")
	WebElement PasswordField; 
	
	public @FindBy(id= "send2")
	WebElement LoginBtn ;
	
	@FindBy(id = "remember_mejQeg4DmyBo")
	WebElement RememberMeCheckBox ;
	
	@FindBy(css = "a.f-left")
	WebElement ForgotPassword ;
	
	@FindBy(xpath = "//a[@href='https://ecommerce.tealiumdemo.com/customer/account/login/']")
	WebElement LoginPage ;
	
	public void Login(String email , String password) {
		setText(emailField, email);
		setText(PasswordField, password);
//		clickbtn(RememberMeCheckBox);
		clickbtn(LoginBtn);
	}
}
