package com.CarTax.framework.base;

/**
 * Created by Ibi on 19/06/2020.
 */
public abstract class BasePage extends Base{

    public <TPage extends BasePage> TPage As(Class<TPage> pageInstance)
    {
        try
        {
            return (TPage)this;
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }

        return null;
    }
}
