package utils.fixtures;

import POM.HomePage;
import com.microsoft.playwright.*;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFixtures extends APIFixtures {

    // Shared between all tests in the class.
    public Playwright playwright;
    public Browser browser;
    public APIFixtures apiFixtures;
    public APIRequestContext request;

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions() // or firefox, webkit
                .setHeadless(false)
                .setSlowMo(100));
        apiFixtures = new APIFixtures();
        apiFixtures.createAPIRequestContext(playwright);
        request = apiFixtures.getRequest();
    }

    @AfterAll
    void closeBrowser() {
        playwright.close();
        apiFixtures.disposeAPIRequestContext();
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
