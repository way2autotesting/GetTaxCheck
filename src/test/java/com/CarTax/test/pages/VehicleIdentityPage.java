package com.CarTax.test.pages;

import com.CarTax.framework.Utilities.NotePadUtil;
import com.CarTax.framework.base.BasePage;
import com.CarTax.framework.base.LocalDriverContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ibi on 20/06/2020.
 */
public class VehicleIdentityPage extends BasePage {

    //todo: WebElement region
    @FindBy(how = How.ID, using = "vrm-input")
    private WebElement enterRegistration;


    //todo: Navigation region
    public boolean CheckTitlePage() {

        System.out.println("title is " + LocalDriverContext.getRemoteWebDriver().getTitle());
        return LocalDriverContext.getRemoteWebDriver().getTitle().contains("Car Tax Check | Free Car Check");
    }

    //todo:----
    public String GetColourOfTheVehicle() {

        WebElement colour = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='m']/div/div[3]/div[1]/div/span/div[2]/dl[4]/dd")));

        return colour.getText();
    }

    public boolean ValidateVehicleColourExist() {

        NotePadUtil np = new NotePadUtil();
        if (GetColourOfTheVehicle().contains(np.ReadFile())) {
            return true;
        }
        return false;
    }

    //todo:----
    public String GetYearOfTheVehicle() {

        WebElement year = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='m']/div/div[3]/div[1]/div/span/div[2]/dl[5]/dd")));

        return year.getText();
    }

    public boolean ValidateVehicleYearExist() {

        NotePadUtil np = new NotePadUtil();
        if (GetYearOfTheVehicle().contains(np.ReadFile())) {
            return true;
        }
        return false;
    }

    //todo:----
    public String GetModelOfTheVehicle() {

        WebElement model = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='m']/div/div[3]/div[1]/div/span/div[2]/dl[3]/dd")));

        return model.getText();
    }

    public boolean ValidateVehicleModelExist() {

        NotePadUtil np = new NotePadUtil();
        if (GetModelOfTheVehicle().contains(np.ReadFile())) {
            return true;
        }
        return false;
    }

    //todo:----
    public String GetMakeOfTheVehicle() {

        WebElement make = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='m']/div/div[3]/div[1]/div/span/div[2]/dl[2]/dd")));

        return make.getText();
    }

    public boolean ValidateVehicleMakeExist() {

        NotePadUtil np = new NotePadUtil();
        if (GetMakeOfTheVehicle().contains(np.ReadFile())) {
            return true;
        }
        return false;
    }

    //todo:----
    public String GetRegOfTheVehicle() {

        WebElement reg = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='m']/div/div[3]/div[1]/div/span/div[2]/dl[1]/dd")));

        return reg.getText();
    }

    public boolean ValidateVehicleRegExist() {

        NotePadUtil np = new NotePadUtil();
        if (GetRegOfTheVehicle().contains(np.ReadFile())) {
            return true;
        }
        return false;
    }


    public void ValidateAllContentInEachLine() {

        try {
            FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\com\\CarTax\\test\\data\\car_output.txt");
            BufferedReader br = new BufferedReader(fr);
            String i = "";

            while ((i.contains(br.readLine()))) {

                Assert.assertTrue(br.readLine().contains(GetMakeOfTheVehicle()));
                Assert.assertTrue(br.readLine().contains(GetModelOfTheVehicle()));
                Assert.assertTrue(br.readLine().contains(GetColourOfTheVehicle()));
                Assert.assertTrue(br.readLine().contains(GetYearOfTheVehicle()));
            }

        } catch (IOException e) {
            System.out.println("Error in saveToFile method");
        }
    }
}
