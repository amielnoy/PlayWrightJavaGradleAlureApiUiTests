package conduit.E2E;

import POM.HomePage;
import org.junit.jupiter.api.Test;
import utils.fixtures.TestFixturesWithAuthToken;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UsersFeedStateTestTest extends TestFixturesWithAuthToken {

    @Test
    void shouldBeSignedIn() {
        HomePage homePage = new HomePage(page).navigate();
        assertThat(homePage.userProfileLink).isVisible();
    }
}
