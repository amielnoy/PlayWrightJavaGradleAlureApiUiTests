package conduitTests.APITests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import fixtures.APIFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.auth.UserService;

public class API_TagsTest extends APIFixtures {

    @Test
    @DisplayName("Get tags for the user")
    void tagsShouldBeDistinct() {
        String token = new UserService().getAuthToken(getRequest());
        APIResponse response = getRequest().get("/api/tags",
                RequestOptions.create().setHeader("Authorization", "Token "+token));
        String responseText = response.text();

    }
}
