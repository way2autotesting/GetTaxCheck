package com.CarTax.test.pages;

import com.CarTax.framework.base.BasePage;
import com.CarTax.framework.base.LocalDriverContext;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.CarTax.framework.Utilities.ReadFileToString.ExtractRegistrationNumberFromTheFile;

/**
 * Created by Ibi on 01/11/2020.
 */
public class FreeCarCheckHomePage extends BasePage {

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

    public void InputVehicleReg(String regNumber) throws IOException {

        enterRegistration.sendKeys(ExtractRegistrationNumberFromTheFile(regNumber).trim());
    }

    public VehicleIdentityPage ClickFreeCarCheckButton() {

        enterRegistration.sendKeys(Keys.ENTER);
        return GetInstance(VehicleIdentityPage.class);
    }


    public String FileReader() throws IOException {

        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\com\\CarTax\\test\\data\\car_output.txt");
        BufferedReader br = new BufferedReader(fr);

        System.out.println("FileReader 1 is : "+br.readLine());

        String fullText = br.readLine();
        String[] parts = fullText.split(",");
        String part1 = parts[0];
        System.out.println("part 1 is : "+part1);

        //br.close();

        return part1;
    }
}
