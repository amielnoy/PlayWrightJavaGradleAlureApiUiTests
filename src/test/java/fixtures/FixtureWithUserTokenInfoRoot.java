package fixtures;

import com.google.gson.Gson;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.api.*;
import models.Auth.User;
import models.Auth.UserManagement;
import utils.config.IConfig;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FixtureWithUserTokenInfoRoot extends TestFixtures implements IConfig {

    // This fixture logs in with existing User
    private String localStorage;
    private String getState(String jwtToken) {

        return "{\"cookies\":[],\"origins\":[{\"origin\":\"" +
                APP_URL +
                "\",\"localStorage\":[{\"name\":\"jwt\",\"value\":\"" + jwtToken + "\"}]}]}";
    }

    @BeforeEach
    void createContextAndPage() {
        if (localStorage == null) {
            String email = "interview@start.com";
            String password = "password";
            UserManagement userManagement1 = new UserManagement(new User(email, password));
            APIResponse newIssue = getRequest().post("/api/users/login",
                    RequestOptions.create().setData(userManagement1));
            UserManagement json = new Gson().fromJson(newIssue.text(), UserManagement.class);
            String token = json.getUser().getToken();
            localStorage = getState(token);
        }
        context = browser.newContext(new Browser.NewContextOptions().setStorageState(localStorage));
        page = context.newPage();
    }

}