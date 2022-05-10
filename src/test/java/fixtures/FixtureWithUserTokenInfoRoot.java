package fixtures;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import models.Auth.User;
import services.Auth.UserService;
import utils.config.IConfig;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FixtureWithUserTokenInfoRoot extends TestFixtures implements IConfig {

    // This fixture logs in with new User
    private String localStorage;

    @BeforeEach
    void createContextAndPage() {
        if (localStorage == null) {
            User newUser = new UserService().createNewRandomUser(getRequest());
            String token = newUser.getToken();
            localStorage = getState(token);
        }
        context = browser.newContext(new Browser.NewContextOptions().setStorageState(localStorage));
        page = context.newPage();
    }

    private String getState(String jwtToken) {

        return "{\"cookies\":[],\"origins\":[{\"origin\":\"" +
                APP_URL +
                "\",\"localStorage\":[{\"name\":\"jwt\",\"value\":\"" + jwtToken + "\"}]}]}";
    }

}