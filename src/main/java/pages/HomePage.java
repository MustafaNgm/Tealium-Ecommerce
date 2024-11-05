package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public @FindBy (xpath  = "//span[@class='label'][normalize-space()='Account']")
	WebElement AccountListElement ;
	public void OpenAccountList() {
		clickbtn(AccountListElement);	
	}

	@FindBy ( xpath = "//a[@href='https://ecommerce.tealiumdemo.com/customer/account/']")
	WebElement MyAccountLinkElement ;
	public void OpenMyAccountPage () {
		clickbtn(MyAccountLinkElement);
	}

	public @FindBy (css = "a[title='Register']")
	WebElement RegisterLinkElement ;
	public void OpenRegisterPage() {
		clickbtn(RegisterLinkElement);
	}

	public @FindBy (xpath = "//a[@href='https://ecommerce.tealiumdemo.com/customer/account/login/']")
	WebElement LoginLinkElement ;
	public void OpenLoginPage() {
		clickbtn(LoginLinkElement);
	}

	@FindBy (css = "a.skip-link.skip-cart.skip-active")
	WebElement CartElement ;
	public void OpenCart() {
		clickbtn(CartElement);
	}

	public @FindBy (css = "li a.top-link-checkout[title='Checkout']")
	 WebElement CheckoutButtonElement;
	public void Checkout() {
		clickbtn(CheckoutButtonElement);
	}

	@FindBy (css = "a.remove")
	WebElement RemoveItemElement ; 
	public void RemoveItem() {
		clickbtn(RemoveItemElement);
	}

	@FindBy (css = "a.level0.has-children")
	WebElement WomanFilterElement ;
	public void WomanFilter() {
		clickbtn(WomanFilterElement);
	}
}
