package POM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
	public final Locator signInLink;
	public final Locator signUpLink;
	public final Locator userProfileLink;
	final static String pageUrl = BaseURL;

	public HomePage(Page page) {
		super(page, pageUrl);
		this.signInLink = page.locator("[href='/login']");
		this.signUpLink = page.locator("[href='/register']");
		this.userProfileLink = page.locator(".user-pic");
	}	
}
