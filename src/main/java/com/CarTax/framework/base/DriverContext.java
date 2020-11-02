package com.CarTax.framework.base;

import com.CarTax.framework.config.Settings;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ibi on 01/11/2020.
 */
public class DriverContext {

    public static void GoToUrl(String url) {

        LocalDriverContext.getRemoteWebDriver().get(url);
    }

    public static void Maximize() {

        LocalDriverContext.getRemoteWebDriver().manage().window().maximize();
    }

    public static void ImplicitlyWait() {

        LocalDriverContext.getRemoteWebDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    public static void WaitForPageToLoad() {

        //todo: replace "Driver" to "LocalDriverContext.getRemoteWebDriver()" and replace "WebDriverWait" to var
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 60);
        JavascriptExecutor jsExecutor = LocalDriverContext.getRemoteWebDriver();

        ExpectedCondition<Boolean> jsLoad = webDriver -> LocalDriverContext.getRemoteWebDriver()
                .executeScript("return document.readyState").toString().equals("complete"); //ToDo: Tp check if page is fully loaded

        //Get JS Ready
        boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");

        if (!jsReady)
            wait.until(jsLoad);
        else
            Settings.logs.Write("Page is ready !");
    }

    public static void WaitForElementToBeClickable(WebElement locator) {

        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        WaitForPageToLoad();
        Settings.logs.Write("Wait for element to be clickable");
    }
}
