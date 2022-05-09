package utils.fixtures;

import POM.HomePage;
import com.microsoft.playwright.*;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFixtures extends ConduitAPI {

    // Shared between all tests in the class.
    public Playwright playwright;
    public Browser browser;

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions() // or firefox, webkit
                .setHeadless(false)
                .setSlowMo(100));
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
