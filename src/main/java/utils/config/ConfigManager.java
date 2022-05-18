package utils.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//Singleton class
public class ConfigManager {
    private static ConfigManager configInstance = null;
    private Properties appProps;
    private ConfigManager() {
        String appConfigPath;
        final String test_env = System.getenv("TEST_CONDUIT_ENV");
        if (test_env != null && test_env.equals("CI")){
            appConfigPath = "config.ci.properties";
        } else {
            appConfigPath = "config.properties";
        }

        appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (FileNotFoundException e){
            System.out.println("File not found exception is:"+ e.getMessage());
        } catch (IOException ioException){
            System.out.println("IOException is:"+ ioException.getMessage());
        }
    }

    // Method
    // Static method to create instance of Singleton class
    public static ConfigManager ConfigLauncher()
    {
        // To ensure only one instance is created
        if (configInstance == null) {
            configInstance = new ConfigManager();
        }
        return configInstance;
    }

    public String getProperty(String key){
        return appProps.getProperty(key);
    }

}
