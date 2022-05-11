package utils.config;

import utils.config.ConfigManager;

public interface IConfig {
    String APP_URL = ConfigManager.ConfigLauncher().getProperty("app.baseUrl");
    String API_SERVER = ConfigManager.ConfigLauncher().getProperty("api.server");
    String HEADLESS_BROWSER = ConfigManager.ConfigLauncher().getProperty("test.browser.headless");
}
