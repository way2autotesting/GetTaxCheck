package com.CarTax.framework.base;

import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ibi on 19/06/2020.
 */
public class Base {

    public static BasePage CurrentPage;

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page)
    {
        Object obj = PageFactory.initElements(LocalDriverContext.getRemoteWebDriver(),page);
        return page.cast(obj);
    }
}
