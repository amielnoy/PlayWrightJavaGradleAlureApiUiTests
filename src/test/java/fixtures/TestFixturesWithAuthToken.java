package fixtures;

import POM.HomePage;
import POM.SignInPage;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import utils.BrowserManager;
import utils.Enums.BrowserTypeEnum;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFixturesWithAuthToken extends TestFixtures{

    private String localStorage;

    @BeforeEach
    void createContextAndPage() {
        Path path = Paths.get("appState.json");
        if (localStorage == null){
            context = browser.newContext();
            page = context.newPage();
            new HomePage(page).navigate();
            new SignInPage(page).navigate().signIn("interview@start.com", "password");
            assertThat(new HomePage(page).userProfileLink).isVisible();
            localStorage = context.storageState(new BrowserContext.StorageStateOptions().setPath(path));
        } else {
            context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(path));
            page = context.newPage();
            new HomePage(page).navigate();
        }
    }

}