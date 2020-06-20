package com.CarTax.framework.base;

import com.CarTax.framework.config.Settings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

/**
 * Created by Ibi on 19/06/2020.
 */
public class FrameworkInitialize {

    public static void InitializeBrowser(BrowserType browserType) {
        RemoteWebDriver driver = null;
        System.out.println("\nTests are running in : " + browserType + "\n");
        Settings.logs.Write("Tests are running in : " + browserType );

        switch (browserType) {
            case Chrome: {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/browser/chromedriver.exe");
                DesiredCapabilities caps = new DesiredCapabilities().chrome();

                HashMap<String, Object> chromePreferences = new HashMap<>();
                chromePreferences.put("profile.password_manager_enabled", false);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--test-type");
                options.addArguments("chrome.switches", "--disable-extensions");
                options.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling");
                options.addArguments("--no-default-browser-check");
                options.setExperimentalOption("prefs", chromePreferences);
                driver = new ChromeDriver(options);//cap

                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                Settings.logs.Write("Starting Chrome browser");
                System.out.println("Starting Chrome browser");
                break;
            }
            case Firefox: {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\browser\\geckodriver.exe");
                DesiredCapabilities caps = new DesiredCapabilities().firefox();
                caps.setBrowserName("firefox");
                driver = new FirefoxDriver(caps);

                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                Settings.logs.Write("Starting Firefox browser");
                System.out.println("Starting Firefox browser");
                break;
            }
            case IE: {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability(CapabilityType.VERSION, "10");
                caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                caps.setCapability(
                        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                        true);
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.merge(caps);
                options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
                options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/browser/IEDriverServer.exe");
                driver = new InternetExplorerDriver(options);

                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                Settings.logs.Write("Starting IE browser");
                System.out.println("Starting IE browser");
                break;
            }
        }
    }
}
