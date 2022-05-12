package conduitTests.APITests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import models.Auth.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import fixtures.APIFixtures;
import services.auth.UserService;
import utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceAPITest extends APIFixtures {

    private String userName = new StringUtils().generateRandomString(10);
    private String email = userName+"@test.com";
    private String password = "password";
    @Test
    void createUser(){
        // test here
    }

    @Test
    @DisplayName("Get current user API test - happy path")
    void currentUser() {
        String token = new UserService().getAuthToken(getRequest(), new User(TEST_USER_NAME, TEST_PASSWORD));
        APIResponse getCurrentUserResponse = new UserService().getCurrentUser(getRequest(), token);
        assertEquals(getCurrentUserResponse.status(), 200);
    }

    // Check the other way of making the request (Test is signInAPI_2)
    @ParameterizedTest
    @CsvSource({"interview@start.com,password,200", "invalid@start.com,invalid,403"})
    @DisplayName("Sign in API with valid and invalid email and password")
    void signInAPI(String email, String password, int responseCode) {
        APIResponse loginResponse = new UserService().logInUser(getRequest(), new User(email, password));
        assertEquals(loginResponse.status(), responseCode);
    }
    //OR if you don't want to build POJO / models
    @ParameterizedTest
    @CsvSource({"invalid@start.com,invalid,403", "interview@start.com,password,200"})
    @DisplayName("Sign in API validation")
    void signInAPI_2(String email, String password, int responseCode) {
        // request body: {"user":{"email":"{{EMAIL}}", "password":"{{PASSWORD}}"}}
        Map<String, String> user = new HashMap<>();
        user.put("email", email);
        user.put("password", password);
        Map<String, Map> requestBody = new HashMap<>();
        requestBody.put("user", user);

        APIResponse loginResponse = getRequest().post(UserService.AUTH_LOGIN_ENDPOINT,
                RequestOptions.create().setData(requestBody));
        assertEquals(loginResponse.status(), responseCode);
    }
}
