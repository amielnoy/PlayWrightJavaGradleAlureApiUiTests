package POM;

import com.microsoft.playwright.Page;
import utils.ConfigManager;

public class BasePage {
	protected final static String BaseURL = ConfigManager.ConfigLauncher().getProperty("app.baseUrl");
	protected final Page page;
	protected final String pageUrl;
	
	public BasePage(Page page, String pageUrl) {
		this.page = page;
		this.pageUrl = pageUrl;
	}
	
	public <T extends BasePage> T navigate() {
		page.navigate(this.pageUrl);
		return (T) this;
	}
	
}
