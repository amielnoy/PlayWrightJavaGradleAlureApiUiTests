package GoogleSiteTests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class TestSearchForAddleSong {
    @Test
    public void AddleTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // Open new page
            Page page = context.newPage();
            // Go to https://www.google.com/?gws_rd=ssl
            page.navigate("https://www.google.com/?gws_rd=ssl");
            // Go to https://www.google.com/search?q=hello&oq=hello&aqs=chrome..69i57.4654j0j4&sourceid=chrome&ie=UTF-8
            page.navigate("https://www.google.com/search?q=hello&oq=hello&aqs=chrome..69i57.4654j0j4&sourceid=chrome&ie=UTF-8");
            // Click text=Adele - Hello - YouTube
            page.locator("text=Adele - Hello - YouTube").click();
            assertThat(page).hasURL("https://www.youtube.com/watch?v=YQHsXMglC9A");
            //Page SleepPage = context.newPage();
            //SleepPage.pause();
            page.waitForTimeout(200000);
        }
    }
}


