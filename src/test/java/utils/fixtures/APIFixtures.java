package utils.fixtures;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

import java.util.HashMap;
import java.util.Map;

public class APIFixtures {

    private APIRequestContext request;

    public APIRequestContext getRequest() {
        return request;
    }

    void disposeAPIRequestContext() {
        if (this.request != null) {
            this.request.dispose();
            this.request = null;
        }
    }

    void createAPIRequestContext(Playwright playwright) {
        Map<String, String> headers = new HashMap<>();
        // We set this header per GitHub guidelines.
        headers.put("Content-Type", "application/json");
        // Add authorization token to all requests.
        // Assuming personal access token available in the environment.
        headers.put("X-Requested-With", "XMLHttpRequest");

        this.request =  playwright.request().newContext(new APIRequest.NewContextOptions()
                // All requests we send go to this API endpoint.
                .setBaseURL("https://conduit.productionready.io")
                .setExtraHTTPHeaders(headers));
    }
}
