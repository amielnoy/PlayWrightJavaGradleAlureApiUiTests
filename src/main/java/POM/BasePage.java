package POM;

import com.microsoft.playwright.Page;
import utils.config.IConfig;

public class BasePage implements IConfig {
	protected final static String BaseURL = APP_URL;
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
