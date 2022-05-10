package conduitTests.APITests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import models.Auth.User;
import models.Auth.UserManagement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import fixtures.APIFixtures;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static services.Auth.UserService.AUTH_LOGIN_ENDPOINT;

public class API_LogInTest extends APIFixtures {

    @ParameterizedTest
    @CsvSource({"invalid@start.com,invalid", "invalid@a.com,abcxyz"})
    @DisplayName("User can not sign in with invalid email/password")
    void InvalidSignInAPI(String email, String password) {
        UserManagement userManagement = new UserManagement(new User(email, password));
        APIResponse loginResponse = getRequest().post(AUTH_LOGIN_ENDPOINT,
                RequestOptions.create().setData(userManagement));
        assertEquals(loginResponse.status(), 403);
    }

    @Test
    @DisplayName("User can sign in with valid email and password")
    void signInAPI() {
        // Implement here
    }
}
