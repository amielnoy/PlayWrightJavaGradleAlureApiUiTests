package conduit;

import POM.HomePage;
import POM.SignInPage;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.fixtures.TestFixtures;

import java.util.HashMap;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APITest extends TestFixtures {

    @ParameterizedTest
    @CsvSource({"interview@start.com,password"})
    void signInAPI(String email, String password) {
        Map<String, String> data = new HashMap<>();
        data.put("email", email);
        data.put("password", password);
        Map<String, Map<String, String>> data2 = new HashMap<>();
        data2.put("user", data);
        APIResponse newIssue = request.post("/api/users/login",
                RequestOptions.create().setData(data2));
        System.out.println(newIssue.text());
        assertTrue(newIssue.ok());
    }
}
