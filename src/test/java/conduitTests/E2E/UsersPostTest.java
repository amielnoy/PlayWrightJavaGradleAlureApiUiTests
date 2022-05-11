package conduitTests.E2E;

import POM.HomePage;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import models.Auth.User;
import models.Auth.UserManagement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import fixtures.FixtureWithUserTokenInfoRoot;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static services.Auth.UserService.AUTH_LOGIN_ENDPOINT;

public class UsersPostTest extends FixtureWithUserTokenInfoRoot {

    @Test
    @DisplayName("User is displayed with new post link")
    void userIsDisplayedWithNewPostLink() {
        HomePage homePage = new HomePage(page).navigate();
        assertThat(homePage.newPOSTLink).isVisible();
    }

    @Test
    @DisplayName("User can create a new post")
    void createNewPost() {
        HomePage homePage = new HomePage(page).navigate();
        // Implement here

    }
}
