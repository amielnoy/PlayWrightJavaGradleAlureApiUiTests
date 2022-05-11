package conduitTests.E2E;

import POM.HomePage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import fixtures.FixtureWithUserTokenInfoRoot;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UsersPostTest extends FixtureWithUserTokenInfoRoot {

    // FixtureWithUserTokenInfoRoot creates a new user and signs in with the newly created user,
    // take a look at the beforeEach hook

    @Test
    @DisplayName("User is displayed with new post link")
    void userIsDisplayedWithNewPostLink() {
        HomePage homePage = new HomePage(page).navigate();
        assertThat(homePage.newPOSTLink).isVisible();
    }

    @Test
    @DisplayName("User has no favourite article")
    void userFavouriteArticle() {
        new HomePage(page).<HomePage>navigate().userProfileLink.click();
        //page.locator("text=Favorited Articles"));
        //...
    }

    @Test
    @DisplayName("User can create a new post")
    void createNewPost() {
        HomePage homePage = new HomePage(page).navigate();
        // Implement here

    }
}
