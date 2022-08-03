package conduitTests.E2E;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import POM.HomePage;
import POM.SignInPage;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
import fixtures.TestFixtures;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SignInTest extends TestFixtures {


    //@ParameterizedTest
    @Test
    //@CsvSource({"interview@start.com,password"})
    public void shouldSignIn() {
        String email="interview@start.com";
        String password="password";
        new SignInPage(page).navigate().signIn(email, password);
        assertThat(new HomePage(page).userProfileLink).isVisible();
    }
}