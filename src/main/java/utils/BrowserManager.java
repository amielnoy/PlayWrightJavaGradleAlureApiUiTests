package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import utils.Enums.BrowserTypeEnum;

public class BrowserManager {
    public Browser launchBrowser(Playwright playwright, BrowserTypeEnum browserTypeEnum, Boolean isHeadless, double slowMoTime){
        switch (browserTypeEnum){
            case FIREFOX:
                return playwright.firefox().launch(new BrowserType.LaunchOptions() // or firefox, webkit
                        .setHeadless(isHeadless)
                        .setSlowMo(slowMoTime));
            case CHROMIUM:
                return playwright.chromium().launch(new BrowserType.LaunchOptions() // or firefox, webkit
                        .setHeadless(isHeadless)
                        .setSlowMo(slowMoTime));
            default:
                return playwright.webkit().launch(new BrowserType.LaunchOptions() // or firefox, webkit
                        .setHeadless(isHeadless)
                        .setSlowMo(slowMoTime));
        }
    }
}
