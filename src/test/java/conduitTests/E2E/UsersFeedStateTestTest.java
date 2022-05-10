package conduitTests.E2E;

import POM.HomePage;
import org.junit.jupiter.api.Test;
import fixtures.TestFixturesWithAuthToken;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UsersFeedStateTestTest extends TestFixturesWithAuthToken {

    @Test
    void shouldBeSignedIn() {
        HomePage homePage = new HomePage(page).navigate();
        assertThat(homePage.userProfileLink).isVisible();
    }

    @Test
    void shouldBeSignedIn2() {
        HomePage homePage = new HomePage(page).navigate();
        assertThat(homePage.userProfileLink).isVisible();
    }
}
