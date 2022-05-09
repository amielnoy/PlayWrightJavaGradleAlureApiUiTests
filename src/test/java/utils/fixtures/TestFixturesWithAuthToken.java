package utils.fixtures;

import com.microsoft.playwright.Browser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFixturesWithAuthToken extends TestFixtures {

    @Override
    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));
        page = context.newPage();
    }

}
