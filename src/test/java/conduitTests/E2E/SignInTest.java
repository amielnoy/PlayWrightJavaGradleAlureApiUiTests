package conduitTests.E2E;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import POM.HomePage;
import POM.SignInPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import fixtures.TestFixtures;

public class SignInTest extends TestFixtures {

    @ParameterizedTest
    @CsvSource({"interview@start.com,password"})
    void shouldSignIn(String email, String password) {
        new SignInPage(page).navigate().signIn(email, password);
        assertThat(new HomePage(page).userProfileLink).isVisible();
    }

    @ParameterizedTest
    @CsvSource({"interview2@start.com,password"})
    void shouldNotSignIn(String email, String password) {
        new SignInPage(page).navigate().signIn(email, password);
        assertThat(new HomePage(page).userProfileLink).not().isVisible();
    }
}