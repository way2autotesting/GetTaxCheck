package com.CarTax.test.pages;

import com.CarTax.framework.base.BasePage;
import com.CarTax.framework.base.DriverContext;
import com.CarTax.framework.base.LocalDriverContext;
import com.CarTax.framework.config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Ibi on 19/06/2020.
 */
public class CarDetailsPage extends BasePage {

    //todo: WebElement region
    @FindBy(how = How.TAG_NAME, using = "hi")
    private WebElement titlePage;

    @FindBy(how = How.CSS, using = "#wbac-app-container > div > div > vehicle-questions > div > section.primary-section.questions-section.ng-trigger.ng-trigger-vehicleQuestionsTransitions > div > div.container > div > div.col-12.col-lg-3.d-none.d-sm-block.order-2.order-lg-3 > div > vehicle-details > div.d-none.d-lg-block.vehicle-details > div.d-table > div:nth-child(1) > div.d-table-cell.value")
    private WebElement make;


    //todo: Navigation region
    public boolean CheckTitlePage() {

        System.out.println("title is " + LocalDriverContext.getRemoteWebDriver().getTitle());
        return LocalDriverContext.getRemoteWebDriver().getTitle().equals("Buy My Car | Fast Online Quote | webuyanycar.com");
    }

    public String GetMakeOfTheVehicle() {

        WebElement make = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='wbac-app-container']/div/div/vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[1]/div[2]")));
        System.out.println("index 0th is " + make.getText());
        return make.getText();
    }

    public String GetModelOfTheVehicle() {

        WebElement model = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='wbac-app-container']/div/div/vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[2]/div[2]")));
        System.out.println("index 1th is " + model.getText());
        return model.getText();
    }

    public String GetColourOfTheVehicle() {

        WebElement colour = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='wbac-app-container']/div/div/vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[4]/div[2]")));
        System.out.println("index 2th is " + colour.getText());
        return colour.getText();
    }

    public String GetYearOfTheVehicle() {

        WebElement year = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id=\"wbac-app-container\"]/div/div/vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[3]/div[2]")));
        System.out.println("index 2th is " + year.getText());
        return year.getText();
    }

    public FreeCarCheckPage NavigateToFreeCarCheckWebsite(){

        if(LocalDriverContext.getRemoteWebDriver() != null){

            LocalDriverContext.getRemoteWebDriver().navigate().to(Settings.FreeCarCheck);
            DriverContext.AcceptingAlert();
        }
        return GetInstance(FreeCarCheckPage.class);
    }

    //// TODO: 20/06/2020
    public void WriteToFile(String reg){

        try {
            File f = new File(System.getProperty("user.dir") +"\\src\\test\\java\\com\\CarTax\\test\\data\\car_output.txt");
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bWrite = new BufferedWriter(fw);

            bWrite.write(reg);
            bWrite.write(",");
            bWrite.write(GetMakeOfTheVehicle());
            bWrite.write(",");
            bWrite.write(GetModelOfTheVehicle());
            bWrite.write(",");
            bWrite.write(GetColourOfTheVehicle());
            bWrite.write(",");
            bWrite.write(GetYearOfTheVehicle());

            bWrite.newLine();
            bWrite.close();
        } catch (IOException e){
            System.out.println("Error in saveToFile method");
        }
    }
}
