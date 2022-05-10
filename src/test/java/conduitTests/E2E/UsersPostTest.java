package conduitTests.E2E;

import POM.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import fixtures.FixtureWithUserTokenInfoRoot;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UsersPostTest extends FixtureWithUserTokenInfoRoot {

    @Test
    @DisplayName("User is displayed with new post link")
    void UserIsDisplayedWithNewPostLink() {
        HomePage homePage = new HomePage(page).navigate();
        assertThat(homePage.newPOSTLink).isVisible();
    }

    @Test
    @DisplayName("User can create a new post")
    void UserPostDisplaysPublishArticleButton() {
        HomePage homePage = new HomePage(page).navigate();
        // Implement here

    }
}
