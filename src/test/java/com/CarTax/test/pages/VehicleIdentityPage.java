package com.CarTax.test.pages;

import com.CarTax.framework.Utilities.NotePadUtil;
import com.CarTax.framework.base.BasePage;
import com.CarTax.framework.base.DriverContext;
import com.CarTax.framework.base.LocalDriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Ibi on 01/11/2020.
 */
public class VehicleIdentityPage extends BasePage {

    //todo: WebElement region
    @FindBy(how = How.ID, using = "vrm-input")
    private WebElement enterRegistration;


    //todo: Navigation region
    public boolean CheckTitlePage() {

        System.out.println("title is " + LocalDriverContext.getRemoteWebDriver().getTitle().trim());
        return LocalDriverContext.getRemoteWebDriver().getTitle().trim().contains("Car Tax Check | Free");
    }

    public void ReadOutputFile2(String reg) throws IOException {

        int lineNum = 0;

        for (String line: Files.readAllLines(Paths.get(System.getProperty("user.dir") + "\\src\\test\\java\\com\\CarTax\\test\\data\\car_output.txt"))) {
            //lineNum++;
            String[] pair = line.split(",");
            System.out.println("print each line as : " + pair[lineNum]);
            if (pair.length != 2 && reg.contains(pair[lineNum])) {

                System.out.println("Print colour from web page is : "+GetColourOfTheVehicle());
                System.out.println("Print colour from note pad is : "+pair[lineNum+3].trim());
                Assert.assertTrue(GetColourOfTheVehicle().equalsIgnoreCase(pair[lineNum+3].trim()));

                System.out.println("Print year from web page is :"+GetYearOfTheVehicle());
                System.out.println("Print year from note pad is :"+pair[lineNum+4].trim());
                Assert.assertTrue(GetYearOfTheVehicle().contains((pair[lineNum]+4)));

                System.out.println("Print model from web page is : "+GetModelOfTheVehicle());
                System.out.println("Print model from note pad is : "+pair[lineNum+2].trim());
                Assert.assertTrue(GetModelOfTheVehicle().equalsIgnoreCase((pair[lineNum]+2).trim()));

                System.out.println("Print make from web page is : "+GetMakeOfTheVehicle());
                System.out.println("Print make from note pad is : "+pair[lineNum+1].trim());
                Assert.assertTrue(GetMakeOfTheVehicle().equalsIgnoreCase((pair[lineNum]+1).trim()));

                System.out.println("Print registration from web page is : "+GetRegOfTheVehicle());
                System.out.println("Print make from note pad is : "+pair[lineNum].trim());
                Assert.assertTrue(GetRegOfTheVehicle().equalsIgnoreCase((pair[lineNum]).trim()));

                continue;
            }
        }
    }

    //todo:---- vehicle colour validation
    public String GetColourOfTheVehicle() {

        WebElement colour = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("#m > div.jsx-79705764 > div:nth-child(4) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(4) > dd")));

        return colour.getText().trim();
    }

    //todo:---- vehicle year validation
    public String GetYearOfTheVehicle() {

        WebElement year = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("#m > div.jsx-79705764 > div:nth-child(4) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(5) > dd")));

        return year.getText().trim();
    }

    //todo:---- vehicle model validation
    public String GetModelOfTheVehicle() {

        WebElement model = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("#m > div.jsx-79705764 > div:nth-child(4) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(3) > dd")));

        return model.getText().trim();
    }

    //todo:---- vehicle make validation
    public String GetMakeOfTheVehicle() {

        WebElement make = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("#m > div.jsx-79705764 > div:nth-child(4) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(2) > dd")));

        return make.getText().trim();
    }

    //todo:---- vehicle registration validation
    public String GetRegOfTheVehicle() {

        WebElement reg = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("#m > div.jsx-79705764 > div:nth-child(4) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(1) > dd")));

        return reg.getText().trim();
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
