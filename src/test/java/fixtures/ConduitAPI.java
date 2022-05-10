package fixtures;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConduitAPI {

    private Playwright playwright;
    private APIRequestContext request;

    public APIRequestContext getRequest() {
        return request;
    }

    void createPlaywright() {
        playwright = Playwright.create();
    }

    void createAPIRequestContext() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Requested-With", "XMLHttpRequest");

        this.request = playwright.request().newContext(new APIRequest.NewContextOptions()
                // All requests we send go to this API endpoint.
                .setBaseURL("https://conduit.productionready.io")
                .setExtraHTTPHeaders(headers));
    }

    @BeforeAll
    void beforeAll() {
        createPlaywright();
        createAPIRequestContext();
    }

    void disposeAPIRequestContext() {
        if (request != null) {
            request.dispose();
            request = null;
        }
    }

    void closePlaywright() {
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }

    @AfterAll
    void afterAll() {
        disposeAPIRequestContext();
        closePlaywright();
    }
}
