package com.CarTax.test.pages;

import com.CarTax.framework.base.BasePage;
import com.CarTax.framework.base.DriverContext;
import com.CarTax.framework.base.LocalDriverContext;
import com.CarTax.framework.config.Settings;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Ibi on 19/06/2020.
 */
public class WebuyanycarHomePage extends BasePage {

    //todo: WebElement region
    @FindBy(how = How.ID, using = "vehicleReg")
    private WebElement enterVehicleRegistration;

    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement goButton;




    //todo: Navigation region
    public boolean CheckTitlePage(){

        System.out.println("Title pgae display is " + LocalDriverContext.getRemoteWebDriver().getTitle());
        return LocalDriverContext.getRemoteWebDriver().getTitle().equals("Buy My Car | Fast Online Quote | webuyanycar.com");
    }

    public void InputRegistrationNumber(String regNo){

        enterVehicleRegistration.clear();
        enterVehicleRegistration.sendKeys(regNo);
    }

    public CarDetailsPage ClickTheGreenButtonGO(){

        //goButton.click();
        enterVehicleRegistration.sendKeys(Keys.ENTER);
        return GetInstance(CarDetailsPage.class);
    }

    public FreeCarCheckPage NavigateToFreeCarCheckWebsite(){

        if(LocalDriverContext.getRemoteWebDriver() != null){

            LocalDriverContext.getRemoteWebDriver().navigate().to(Settings.FreeCarCheck);
            //DriverContext.AcceptingAlert();
        }
        return GetInstance(FreeCarCheckPage.class);
    }
}
