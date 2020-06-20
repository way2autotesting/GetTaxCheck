package com.CarTax.test.steps;

import com.CarTax.framework.Utilities.NotePadUtil;
import com.CarTax.framework.base.Base;
import com.CarTax.framework.base.DriverContext;
import com.CarTax.framework.config.Settings;
import com.CarTax.test.pages.CarDetailsPage;
import com.CarTax.test.pages.FreeCarCheckPage;
import com.CarTax.test.pages.VehicleIdentityPage;
import com.CarTax.test.pages.WebuyanycarHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;

/**
 * Created by Ibi on 19/06/2020.
 */
public class FreeVehicleCheckStepdefs extends Base {

    @Given("^I have landed on a Free Car Check website$")
    public void FreeVehicleCheckStepdefs()  {

        CurrentPage = GetInstance(FreeCarCheckPage.class);
        Assert.assertTrue(CurrentPage.As(FreeCarCheckPage.class).CheckTitlePage());
        Assert.assertTrue(CurrentPage.As(FreeCarCheckPage.class).CheckTitlePage2());
        Settings.logs.Write("User landed on Free Car Check page");
        System.out.println("User landed on Free Car Check page");
    }


    @Given("^I have landed on webuyanycar website$")
    public void iHaveLandedOnWebuyanycarWebsite() throws Throwable {

        CurrentPage = GetInstance(WebuyanycarHomePage.class);
        DriverContext.WaitForPageToLoad();
        Assert.assertTrue(CurrentPage.As(WebuyanycarHomePage.class).CheckTitlePage());
        Settings.logs.Write("User landed on Free Car Check page");
        System.out.println("User landed on Free Car Check page");
    }

    @When("^I enter vehicle registration number \"([^\"]*)\" to get quote$")
    public void iEnterVehicleRegistrationNumberToGetQuote(String regNo)  {

        CurrentPage.As(WebuyanycarHomePage.class).InputRegistrationNumber(regNo);
        Settings.logs.Write("User enter vehicle registration number");
        System.out.println("User enter vehicle registration number");
    }

    @And("^I tab on the green button GO$")
    public void iTabOnTheGreenButtonGO()  {

        CurrentPage = CurrentPage.As(WebuyanycarHomePage.class).ClickTheGreenButtonGO();
        Settings.logs.Write("Enter the GO button");
        System.out.println("Enter the GO button");
    }

    @Then("^I land in Car Details page$")
    public void iLandInCarDetailsPage()  {

        DriverContext.WaitForPageToLoad();
        Assert.assertTrue(CurrentPage.As(CarDetailsPage.class).CheckTitlePage());
        Settings.logs.Write("User land in car details page");
        System.out.println("User land in car details page");
    }

    @Then("^I extract the vehicle registration \"([^\"]*)\" into my notepad$")
    public void iExtractTheVehicleRegistrationIntoMyNotepad(String regNo)  {

        CurrentPage.As(CarDetailsPage.class).WriteToFile(regNo);



/*
        NotePadUtil.SaveToFile(regNo);
        NotePadUtil.SaveToFile(CurrentPage.As(CarDetailsPage.class).GetMakeOfTheVehicle());
        NotePadUtil.SaveToFile(CurrentPage.As(CarDetailsPage.class).GetModelOfTheVehicle());
        NotePadUtil.SaveToFile(CurrentPage.As(CarDetailsPage.class).GetColourOfTheVehicle());
        NotePadUtil.SaveToFile(CurrentPage.As(CarDetailsPage.class).GetYearOfTheVehicle());
        Settings.logs.Write("User extract information into notepad");
        System.out.println("User extract information into notepad");*/

    }

//    @And("^I navigate to cartaxcheck website to perform Free Car Check$")
//    public void iNavigateToCartaxcheckWebsiteToPerformFreeCarCheck() throws Throwable {
//
//        CurrentPage = CurrentPage.As(CarDetailsPage.class).NavigateToFreeCarCheckWebsite();
//        DriverContext.WaitForPageToLoad();
//        Assert.assertTrue(CurrentPage.As(FreeCarCheckPage.class).CheckTitlePage());
//        Assert.assertTrue(CurrentPage.As(FreeCarCheckPage.class).CheckTitlePage2());
//        Settings.logs.Write("User navigate on Free Car Check page");
//        System.out.println("User navigate on Free Car Check page");
//    }

    @Given("^I have landed to Cartaccheck website to perform Free Car Check$")
    public void iHaveLandedToCartaccheckWebsiteToPerformFreeCarCheck()  {

        //CurrentPage = CurrentPage.As(CarDetailsPage.class).NavigateToFreeCarCheckWebsite();
        CurrentPage = CurrentPage.As(WebuyanycarHomePage.class).NavigateToFreeCarCheckWebsite();
        DriverContext.WaitForPageToLoad();
        Assert.assertTrue(CurrentPage.As(FreeCarCheckPage.class).CheckTitlePage());
        Assert.assertTrue(CurrentPage.As(FreeCarCheckPage.class).CheckTitlePage2());
        Settings.logs.Write("User navigate on Free Car Check page");
        System.out.println("User navigate on Free Car Check page");
    }

    @When("^I enter Vehicle registration number from our save file$")
    public void iEnterVehicleRegistrationNumberFromOurSaveFile() throws IOException {

        CurrentPage.As(FreeCarCheckPage.class).InputVehicleReg();
    }

    @And("^I tab the blue button to get free car check$")
    public void iTabTheBlueButtonToGetFreeCarCheck()  {

        CurrentPage = CurrentPage.As(FreeCarCheckPage.class).ClickFreeCarCheckButton();
        DriverContext.WaitForPageToLoad();
    }

    @Then("^I land in Vehicle Identity page$")
    public void iLandInVehicleIdentityPage()  {

        Assert.assertTrue(CurrentPage.As(VehicleIdentityPage.class).CheckTitlePage());
    }

    @And("^I validate all the vehicle details within this page$")
    public void iValidateAllTheVehicleDetailsWithinThisPage()  {

        Assert.assertTrue(CurrentPage.As(VehicleIdentityPage.class).ValidateVehicleColourExist());
        Assert.assertTrue(CurrentPage.As(VehicleIdentityPage.class).ValidateVehicleMakeExist());
        Assert.assertTrue(CurrentPage.As(VehicleIdentityPage.class).ValidateVehicleModelExist());
        Assert.assertTrue(CurrentPage.As(VehicleIdentityPage.class).ValidateVehicleRegExist());
        Assert.assertTrue(CurrentPage.As(VehicleIdentityPage.class).ValidateVehicleYearExist());


        //CurrentPage.As(VehicleIdentityPage.class).ValidateAllContentInEachLine(reg);
    }
}
