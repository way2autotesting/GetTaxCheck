package com.CarTax.test.steps;

import com.CarTax.framework.Utilities.LogUtil;
import com.CarTax.framework.Utilities.NotePadUtil;
import com.CarTax.framework.base.DriverContext;
import com.CarTax.framework.base.FrameworkInitialize;
import com.CarTax.framework.base.LocalDriverContext;
import com.CarTax.framework.config.ConfigReader;
import com.CarTax.framework.config.Settings;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

/**
 * Created by Ibi on 01/11/2020.
 */
public class TestInitialize extends FrameworkInitialize{

    @Before
    public void Initialize(Scenario scenario) throws IOException {

        //ToDo: Initialize Config
        ConfigReader.PopulateSettings();

        //ToDo: Logging
        Settings.logs = new LogUtil();
        Settings.logs.CreateLogFile();
        Settings.logs.Write("Framework Initialize");
        System.out.println("Framework Initialize");


        //ToDo: Browser Initialized
        InitializeBrowser(Settings.BrowserType);
        Settings.logs.Write("Browser Initialized");
        System.out.println("Browser Initialized");

        //ToDo: Navigate to url
        DriverContext.GoToUrl(Settings.AUT);
        Settings.logs.Write("Navigated to URL " + Settings.AUT);
        System.out.println("Navigated to URL " + Settings.AUT);

        //ToDo: Maximize Window
        DriverContext.Maximize();
        Settings.logs.Write("Maximize window");
        System.out.println("Maximize window");

        //ToDo: Implicitly WaitForPage
        DriverContext.ImplicitlyWait();

        try {
            //NotePadUtil util = new NotePadUtil(System.getProperty("user.dir") +"\\src\\test\\java\\com\\CarTax\\test\\\data\\car_output.txt");
            //todo: OR

            System.out.println("Locate text file path");
        } catch (Exception e) {
            Settings.logs.Write("Unable to locate text file path");
        }
    }

    @After
    public void TearDownTest(Scenario scenario) {

        //ToDo: Logging
        Settings.logs = new LogUtil();

        if (scenario.isFailed()) {
            Settings.logs.Write(scenario.getName());
            Settings.logs.Write("ie. scenario Not KO : --> capture !");

            System.out.println(scenario.getName());
            System.out.println("ie. scenario Not KO : --> capture !");

            //ToDo: Take screenshot
            Settings.logs.Write("Take screenshot");
            try {
                final byte[] screenshot = ((TakesScreenshot) LocalDriverContext.getRemoteWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (scenario.getStatus() == "pass") {

            Settings.logs.Write(scenario.getName());
            Settings.logs.Write("ie. scenario KO : --> capture !");

            System.out.println(scenario.getName());
            System.out.println("ie. scenario KO : --> capture !");
        }


        //ToDo: Closing browser
        Settings.logs.Write("Closing browser");
        System.out.println("Closing browser");
        if (LocalDriverContext.getRemoteWebDriver() != null) {

            //ToDo: Take screenshot
            Settings.logs.Write("Take screenshot");
            try {
                final byte[] screenshot = ((TakesScreenshot) LocalDriverContext.getRemoteWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }

            //todo: quite and c;ose browser after each scenarios
            LocalDriverContext.getRemoteWebDriver().close();
            LocalDriverContext.getRemoteWebDriver().quit();
        }
    }
}
