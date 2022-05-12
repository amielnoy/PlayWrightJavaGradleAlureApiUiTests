package conduitTests.APITests;

import fixtures.APIFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.auth.UserService;

public class TagsAPITest extends APIFixtures {

    @Test
    @DisplayName("Get tags for the user")
    void tagsShouldBeDistinct() {
        String token = new UserService().getAuthToken(getRequest());
        // Test here

    }
}
