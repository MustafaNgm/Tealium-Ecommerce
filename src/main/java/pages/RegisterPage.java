package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{

	public RegisterPage(WebDriver driver) {
	super(driver);	
	
	}

	@FindBy (id = "firstname")
	WebElement FirstNameElement ;
	
	@FindBy (id = "middlename")
	WebElement MiddleNameElement ;

	@FindBy ( id = "lastname")
	WebElement LastNameElement ;

	@FindBy (id = "email_address")
	WebElement EmailElement ;

	@FindBy (id = "password")
	WebElement PasswordElement ;	

	@FindBy (id = "confirmation")
	WebElement ConfirmationElement ;

	@FindBy (id = "is_subscribed")
	WebElement NewsLetterElement;

	@FindBy (id = "remember_meYimvGNgzZz")
	WebElement RememberMeElement ; 

	public @FindBy (xpath  = "//button[@title='Register']")
	WebElement RegisterButtonElement ;
	
	@FindBy (css = "a.back-link")
	WebElement backbtn ;
	
	public void RegisterWithValidData(String firstName , String MiddleName , String LastName , String Email , String Password ,String ConfirmPassword) {
			
		setText(FirstNameElement, firstName);
		setText(MiddleNameElement, MiddleName);
		setText(LastNameElement, LastName);
		setText(EmailElement, Email);
		setText(PasswordElement, Password);
		setText(ConfirmationElement, ConfirmPassword);
		clickbtn(NewsLetterElement);
//		clickbtn(RememberMeElement);
		clickbtn(RegisterButtonElement);
		
	}
}
