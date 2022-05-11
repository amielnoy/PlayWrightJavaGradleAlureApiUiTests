package conduitTests.needRefactoring;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogInBadExample {

    @Test
    void LogInTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions() // or firefox, webkit
                .setHeadless(false)
                .setSlowMo(50));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://superlative-fox-61a6f8.netlify.app");
        page.locator("[href='/login']").click();
        page.locator("input").first().type("interview@start.com");
        page.locator("input").nth(1).type("password");
        page.locator("button").click();
        assertThat(page.locator("[type=\"submit\"]")).not().isVisible();
        context.close();
        playwright.close();
    }
}
