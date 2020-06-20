package com.CarTax.framework.base;

import org.openqa.selenium.WebDriver;

/**
 * Created by Ibi on 19/06/2020.
 */
public class Browser extends Base{

    private WebDriver _driver;

    public Browser(WebDriver driver) {

        _driver = driver;
    }

    public BrowserType Type;
}
