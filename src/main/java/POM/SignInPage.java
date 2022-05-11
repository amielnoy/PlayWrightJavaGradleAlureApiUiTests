package POM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignInPage extends BasePage {
	public final Locator EmailInput;
	public final Locator PasswordInput;
	public final Locator SignInButton;
	final static String pageUrl = BaseURL + "/login";

	public SignInPage(Page page) {
		super(page, pageUrl);
		this.EmailInput = page.locator("[placeholder=\"Email\"]");
		this.PasswordInput = page.locator("[placeholder=\"Password\"]");
		this.SignInButton = page.locator("[type=\"submit\"]");
	}
	
	public void signIn(String email, String password) {
		EmailInput.type(email);
		PasswordInput.type(password);
		SignInButton.click();
	}

	@Override
	public SignInPage navigate() {
		new HomePage(page).signInLink.click();
		return this;
	}

}
