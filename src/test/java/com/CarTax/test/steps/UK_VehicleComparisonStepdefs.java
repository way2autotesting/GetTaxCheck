package com.CarTax.test.steps;

import com.CarTax.framework.base.Base;
import com.CarTax.framework.base.DriverContext;
import com.CarTax.framework.config.Settings;
import com.CarTax.test.pages.FreeCarCheckHomePage;
import com.CarTax.test.pages.VehicleIdentityPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


import java.io.IOException;

/**
 * Created by Ibi on 01/11/2020.
 */
public class UK_VehicleComparisonStepdefs extends Base {

    @Given("^I navigate to UK site to check my car valuation$")
    public void iNavigateToUKSiteToCheckMyCarValuation() {

        CurrentPage = GetInstance(FreeCarCheckHomePage.class);
        DriverContext.WaitForPageToLoad();
        Assert.assertTrue(CurrentPage.As(FreeCarCheckHomePage.class).CheckTitlePage());
        Settings.logs.Write("I navigate to UK site to check my car valuation");
        System.out.println("I navigate to UK site to check my car valuation");
    }

    @And("^I read the registration number from an input file$")
    public void iReadTheRegistrationNumberFromAnInputFile()  {

        //no code
        Settings.logs.Write("I read the registration number from an input file");
        System.out.println("I read the registration number from an input file");
    }

    @When("^I extract the registration containing \"([^\"]*)\" based on pattern onto the UK site$")
    public void iExtractTheRegistrationContainingBasedOnPatternOntoTheUKSite(String regN) throws IOException {

        CurrentPage.As(FreeCarCheckHomePage.class).InputVehicleReg(regN);
        Settings.logs.Write("I extract the registration and input to web page");
        System.out.println("I extract the registration and input to web page");
    }

    @And("^I click the button Free Car Check$")
    public void iClickTheButtonFreeCarCheck()  {

        CurrentPage = CurrentPage.As(FreeCarCheckHomePage.class).ClickFreeCarCheckButton();
        Settings.logs.Write("I click the button Free Car Check");
        System.out.println("I click the button Free Car Check");
    }

    @Then("^I am able to navigate to the vehicle Identity page$")
    public void iAmAbleToNavigateToTheVehicleIdentityPage()  {

        DriverContext.WaitForPageToLoad();
        Assert.assertTrue(CurrentPage.As(VehicleIdentityPage.class).CheckTitlePage());
        Settings.logs.Write("Landed on vehicle Identity page");
        System.out.println("Landed on vehicle Identity page");
    }

    @And("^I can compare the vehicle registration \"([^\"]*)\"displayed in the site with the text file car output$")
    public void iCanCompareTheVehicleRegistrationDisplayedInTheSiteWithTheTextFileCarOutput(String reg) throws IOException {

        CurrentPage.As(VehicleIdentityPage.class).ReadOutputFile2(reg);
        Settings.logs.Write("Comparing the vehicle registration");
        System.out.println("Comparing the vehicle registration");
    }
}
