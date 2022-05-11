package conduitTests.APITests;

import com.microsoft.playwright.APIResponse;
import models.Auth.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import fixtures.APIFixtures;
import services.Auth.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class API_LogInTest extends APIFixtures {
    @ParameterizedTest
    @CsvSource({"invalid@start.com,invalid,403", "interview@start.com,password,200"})
    @DisplayName("Sign in API validation")
    void signInAPI(String email, String password, int responseCode) {
        APIResponse loginResponse = new UserService().logInUser(getRequest(), new User(email, password));
        assertEquals(loginResponse.status(), responseCode);
    }

    @ParameterizedTest
    @CsvSource({"interview@start.com,password"})
    @DisplayName("Get current user API test - happy path")
    void currentUser(String email, String password) {
        String token = new UserService().getAuthToken(getRequest(), new User(email, password));
        APIResponse getCurrentUserResponse = new UserService().getCurrentUser(getRequest(), token);
        assertEquals(getCurrentUserResponse.status(), 200);
    }
}
