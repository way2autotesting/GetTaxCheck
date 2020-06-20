package com.CarTax.test.pages;

import com.CarTax.framework.base.BasePage;
import com.CarTax.framework.base.LocalDriverContext;
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
 * Created by Ibi on 19/06/2020.
 */
public class FreeCarCheckPage extends BasePage {

    //todo: WebElement region
    @FindBy(how = How.ID, using = "vrm-input")
    private WebElement enterRegistration;

    @FindBy(how = How.XPATH, using = "//*[contains(@value, 'Free Car Check')]")
    private WebElement freeCarCheck;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement pageTitleText;


    //todo: Navigation region
    public boolean CheckTitlePage() {

        System.out.println("Title pgae display is " + LocalDriverContext.getRemoteWebDriver().getTitle());
        return LocalDriverContext.getRemoteWebDriver().getTitle().equals("Car Tax Check | Free Car Check");
    }

    public boolean CheckTitlePage2() {

        return pageTitleText.getText().equals("Free Car Check");
    }

    public void InputVehicleReg() throws IOException {

        enterRegistration.sendKeys(FileReader());
    }

    public VehicleIdentityPage ClickFreeCarCheckButton() {

        WebElement freeCarCheck = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='hyd-70pnnvjzqhw']/form/button")));
        freeCarCheck.click();
        return GetInstance(VehicleIdentityPage.class);
    }


    public String FileReader() throws IOException {


        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\com\\CarTax\\test\\data\\car_output.txt");
        BufferedReader br = new BufferedReader(fr);
        System.out.println("FileReader 1 is : "+br);

        String fullText = br.readLine();
        String[] parts = fullText.split(",");
        String part1 = parts[0];
        System.out.println("part 1 is : "+part1);


        return part1;
    }
}
