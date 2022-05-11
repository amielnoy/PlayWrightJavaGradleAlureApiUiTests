package conduitTests.needRefactoring;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BadExamples {

    static Playwright playwright;
    static Browser browser;

    static BrowserContext context;

    static Page page;

    @Test
    void logInTest() {
        playwright = Playwright.create();

        // Browser config setup and launches it
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions() // or firefox, webkit
                .setHeadless(false)
                .setSlowMo(50));

        // Creates a new browser context. It won't share cookies/cache with other browser contexts.
        context = browser.newContext();

        //Creates a new page in the browser context.
        page = context.newPage();

        // Actions on browser page
        page.navigate("https://superlative-fox-61a6f8.netlify.app");
        page.locator("[href='/login']").click();
        page.locator("input").first().type("interview@start.com");
        page.locator("input").nth(1).type("password");
        page.locator("button").click();
        assertThat(page.locator("[type=\"submit\"]")).not().isVisible();

    }

    @Test
    void checkMyFavoriteArticle(){
        page.locator("[href=\"/@John Doeee\"]").click();
        page.locator("[href=\"/@John Doeee/favorites\"]").click();
        assertThat(page.locator(".article-preview")).containsText("No articles are here... yet.");
        context.close();
        playwright.close();
    }
}
