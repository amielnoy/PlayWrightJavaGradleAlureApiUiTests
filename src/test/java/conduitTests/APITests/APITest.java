package conduitTests.APITests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import users.User;
import users.UsersManagement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import fixtures.ConduitAPI;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APITest extends ConduitAPI {

    @ParameterizedTest
    @CsvSource({"interview@start.com,password"})
    void signInAPI(String email, String password) {
        UsersManagement user1 = new UsersManagement(new User(email, password));
        APIResponse newIssue = getRequest().post("/api/users/login",
                RequestOptions.create().setData(user1));
        System.out.println(newIssue.text());
        assertTrue(newIssue.ok());
    }
}
