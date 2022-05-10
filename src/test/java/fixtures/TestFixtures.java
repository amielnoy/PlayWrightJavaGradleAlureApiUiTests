package fixtures;

import POM.HomePage;
import com.microsoft.playwright.*;

import org.junit.jupiter.api.*;
import utils.BrowserManager;
import utils.Enums.BrowserTypeEnum;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFixtures extends APIFixtures {

    // Shared between all tests in the class.
    public Playwright playwright;
    public Browser browser;

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        BrowserManager browserManager = new BrowserManager();
        browser = browserManager.launchBrowser(playwright, BrowserTypeEnum.CHROMIUM, false, 10);
    }

    @AfterAll
    void closeBrowser() {
        playwright.close();
    }


    // New instance for each test method.
    public BrowserContext context;
    public Page page;

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        new HomePage(page).navigate();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

}
